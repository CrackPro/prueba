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
}