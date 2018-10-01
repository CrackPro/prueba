package models;

import java.util.*;
import javax.persistence.*;
import java.sql.*;
import java.sql.Connection;
import play.db.DB;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="PRUEBAVIVANCO")
public class Usuario extends Model{

    @Id
    @SequenceGenerator(name = "ID_GENERATOR", sequenceName = "USER_PK",allocationSize=1)
    @GeneratedValue(generator = "ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "IDPRUEBA")
    private Long idPrueba;

    @Required
    @Column(name="CHARN")
    private String charn;

    @Required
    @Column(name="NUMERO")
    private int numero;

    @Required
    @Column(name="FECHA")
    private String fecha;

    @Required
    @Column(name="DECIMALES")
    private int decimales;

    public Usuario(int id,String nombre, int telefono, String fecha, int salario){
        this.idPrueba=id;
        this.charn=nombre;
        this.numero= telefono;
        this.fecha = fecha;
        this.decimales = salario;
    }

    public void ahorro(int montoAhorro){
        this.decimales = decimales+montoAhorro;
    }

    public int getTelefono(){
        return this.numero;
    }

    public String getNombre(){
        return this.charn;
    }

    public String getFecha() {
        return this.fecha;
    }

    public int getSalario() {
        return decimales;
    }

    public static String registrarUsuario(String nombre, int telefono, String fecha, int salario){

            Conexion cone = new Conexion();
            String tabla = cone.getTabla();
            String inserts = "INSERT INTO "+tabla+"(CHARN, NUMERO, FECHA, DECIMALES) " + "VALUES"
                    + "('"+nombre+"','"+telefono+"','"+fecha+"', '"+salario+"')";
            cone.ejecutarQ(inserts);
            cone.cerrarConexion(cone.getConexion());

        return "Exito en el registro";
    }

    public static String borrarUsuario(int id){
        //Aqui va lo de borrado
        Conexion cone = new Conexion();
        String tabla = cone.getTabla();
            String queryDalete ="delete from "+tabla+" where IDPRUEBA='"+id+"' ";
        cone.ejecutarQ(queryDalete);
        cone.cerrarConexion(cone.getConexion());
        return "Exito en el registro";
    }

    //Metodo que busca los usuarios, se usa para iniciar buscarUsuarios
    public static List buscarUsuario(int id){
        //Aqui va lo de buscar
        List<Usuario> resultado = new ArrayList<Usuario>();

        Conexion cone = new Conexion();
        String tabla = cone.getTabla();
        String querySelect=null;

        //si id ==0, es cuando entra la pagina buscarUsuarios
        // id!=0 cuando se selecciona un usuario para mostrar
        if(id ==0){
            querySelect= "select IDPRUEBA, CHARN, NUMERO, FECHA, DECIMALES from "+tabla;
        }
        else{
            querySelect= "select IDPRUEBA, CHARN, NUMERO, FECHA, DECIMALES from "+tabla+"where IDPRUEBA ="+id;
        }

        ResultSet rs = cone.ejecutarS(querySelect);
        try {
            while (rs.next()) {
                resultado.add(new Usuario(rs.getInt("IDPRUEBA"), rs.getString("CHARN"), rs.getInt("NUMERO"), rs.getString("FECHA"), rs.getInt("DECIMALES")));
            }
        }
         catch (SQLException e) {
             System.out.println(e);
            }
        cone.cerrarConexion(cone.getConexion());
        return resultado;
    }

}