
package models;

/**
 *
 * @author Ciriaco
 */
import java.sql.*;
import java.sql.Connection;
import javax.persistence.*;
import play.db.DB;

public class Conexion {

    private Connection conn=null;
    private String tabla="PRUEBAVIVANCO";
    private Statement stmt = null;

    public Conexion(){
        try {
             this.conn = DB.getConnection();
            this.stmt = conn.createStatement();

            System.out.println("Conexion a Base de Datos  . . . . .Ok");

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public Connection getConexion(){
        return conn;
    }

    public String getTabla(){
        return tabla;
    }

    public void cerrarConexion(Connection conn ){
        try {
            conn.close();
            System.out.println("Cerrando conexion  . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conn=null;
    }

    public void ejecutarQ(String inserts){
        try {
            this.stmt.executeUpdate(inserts);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }


}