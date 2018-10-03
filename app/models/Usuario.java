package models;

import java.util.*;
import javax.persistence.*;
import java.sql.*;
import java.sql.Connection;
import java.util.Date;

import com.google.gson.Gson;
import play.db.DB;
import play.db.jpa.*;
import play.db.jpa.Model;
import play.data.validation.*;

@Entity
@Table(name="PRUEBAVIVANCO")
public class Usuario extends GenericModel{



    @Id
    @SequenceGenerator(name = "ID_GENERATOR", sequenceName = "IDVIVANCO",allocationSize=1)
    @GeneratedValue(generator = "ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "IDPRUEBA")
    private int idPrueba;


    @Column(name="CHARN")
    private String charn;

    @Required
    @Column(name="NUMERO")
    private int numero;


    @Column(name="FECHA")
    private String fecha;

    @Required
    @Column(name="DECIMALES")
    private int decimales;

    @Column(name="NACIMIENTO")
    private Date nacimiento;

    @PersistenceContext
    static EntityManager em;

    public Usuario(String charn, int numero, String fecha, int decimales, Date nacimiento){

        this.charn=charn;
        this.numero= numero;
        this.fecha = fecha;
        this.decimales = decimales;
        this.nacimiento = nacimiento;
    }

    public String toString() {
        return charn;
    }

    public void ahorro(int montoAhorro){
        this.decimales = decimales+montoAhorro;
    }

    public int getTelefono(){
        return this.numero;
    }

    public String getCharn(){
        return this.charn;
    }

    public String getFecha() {
        return this.fecha;
    }

    public int getDecimales() {
        return this.decimales;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setCharn(String charn) {
        this.charn = charn;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDecimales(int decimales) {
        this.decimales = decimales;
    }
    public  String registrarUsuario(String nombre, int telefono, String fecha, int salario, Date nacimiento){



        return "Exito en el registro";
    }

    public static String borrarUsuario(int id){
        //Aqui va lo de borrado

        return "Exito en el registro";
    }

    //Metodo que busca los usuarios, se usa para iniciar buscarUsuarios
    public static List buscarUsuario(int id){
        //Aqui va lo de buscar
        List<Usuario> resultado = new ArrayList<Usuario>();

            resultado = Usuario.findAll();

        return resultado;
    }

    public static String pedirUsuario(int id){
        //Aqui va lo de buscar
        List<Usuario> resultado = new ArrayList<Usuario>();
        if(id ==0){
            resultado = Usuario.findAll();
        }
        else{
            //JPAQuery query=  Usuario.find("select idPrueba, charn from Usuario where idPrueba ="+id);
//            Query query= em.createQuery("+select idPrueba, charn from Usuario where idPrueba"+id);
//            resultado=  query.getResultList();
            resultado=  Usuario.find("idPrueba", id).fetch();


        }
        //Aqui mandamos solo uno
        //Usuario u= resultado.get(0);
        //System.out.println(u.getCharn());
       // Gson gS = new Gson();
        //String eJ = gS.toJson(u);
        //Tambien se le puede mandar la lista entera
        Gson gS = new Gson();
        String eJ= gS.toJson(resultado);
        return eJ;
    }

}