package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
//import javax.swing.JOptionPane;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void registro(){
        render();
    }

    public static void baja(){
        render();
    }

    //Funcion donde se inicia la pagina buscar_usuarios
    //La list se llena con el metodo de buscarUsuario
    //Retorna una lista de objetos usuarios
    public static void buscarUsuarios(){
        int idU=0;
        List<Usuarios> usuarios = Usuario.buscarUsuario(idU);
        render(usuarios);
    }

    public static void registroUsuario(String nombre, String telefono, String fecha, int salario ){
        int temp1= Integer.parseInt(telefono);
        Usuario nuevo = new Usuario(1,nombre, temp1, fecha, salario);
        Usuario.registrarUsuario(nombre, temp1, fecha, salario);

        render(nuevo);
    }

    public static void borrarUsuario(String idB){
        int tempId = Integer.parseInt(idB);
        Usuario.borrarUsuario(tempId);
        render("Application/baja.html");
        //JOptionPane.showMessageDialog(null , "usuario borradoS");
    }
    public static void armarCadena(){

        render();
        //JOptionPane.showMessageDialog(null , "usuario borradoS");
    }

    public static List mostrarUsuario(int id){
        List<Usuario> resultado = new ArrayList<Usuario>();
       resultado= Usuario.buscarUsuario(id);
        return resultado;
    }
}