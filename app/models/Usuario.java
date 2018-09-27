package models;

import java.util.*;
import javax.persistence.*;
import java.sql.*;
import java.sql.Connection;
import play.db.DB;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Usuario extends Model{


    private String charn;
    @Required
    private int numero;

    private String fecha;
    @Required
    private int decimales;

    public Usuario(String nombre, int telefono, String fecha, int salario){
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
        //Aqui va ir la conexion
        Statement stmt = null;

        try {
            Connection conn = DB.getConnection();
            stmt = conn.createStatement();
            String inserts = "INSERT INTO PRUEBAVIVANCO"
                    + "(CHARN, NUMERO, FECHA, DECIMALES) " + "VALUES"
                    + "('"+nombre+"','"+telefono+"','"+fecha+"', '"+salario+"')";
            stmt.executeUpdate(inserts);
            conn.close();
        } catch (SQLException e) {

        }
        return "Exito en el registro";
    }

    public static String borrarUsuario(int id){
        //Aqui va lo de borrado
        Statement stmt = null;

        try {
            Connection conn = DB.getConnection();
            stmt = conn.createStatement();
            String queryDalete ="delete from PRUEBAVIVANCO where IDPRUEBA='"+id+"' ";
            stmt.executeUpdate(queryDalete);
            conn.close();

        } catch (SQLException e) {

        }
        return "Exito en el proceso";
    }
    public static String buscarUsuario(int id){
        //Aqui va lo de borrado
        Statement stmt = null;

        try {
            Connection conn = DB.getConnection();
            stmt = conn.createStatement();

            conn.close();
        } catch (SQLException e) {

        }
        return "Exito en el proceso";
    }

}