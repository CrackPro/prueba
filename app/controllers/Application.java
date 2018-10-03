package controllers;

//Se usa para pasar a de una List a un String
import com.google.gson.Gson;
//Los tres sig import, son usados para transformar el dataTime, ya que llega un String y lo pasamos
//a un Date
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.*;
import play.mvc.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
//import javax.swing.JOptionPane;

import models.*;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void registro() {
        render();
    }

    public static void baja() {
        render();
    }

    //Funcion donde se inicia la pagina buscar_usuarios
    //La list se llena con el metodo de buscarUsuario
    //Retorna una lista de objetos usuarios
    public static void buscarUsuarios() {
        int idU = 0;
        List<Usuarios> usuarios = Usuario.buscarUsuario(idU);
        render(usuarios);
    }

    public static void registroUsuario(String nombre, String telefono, String fecha, int salario, String nacimiento) throws ParseException {
        int temp1 = Integer.parseInt(telefono);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyy/MM/dd");
        String dateFirst = dtfOut.print(new DateTime(format.parse(nacimiento)));
        Date date = new Date(dateFirst + " 00:00:01");
        Usuario nuevo = new Usuario(nombre, temp1, fecha, salario, date);
        validation.valid(nuevo);
        if(validation.hasErrors()) {

        } else{
            nuevo.save(); // explicit save here
            render(nuevo);
        }


    }

    public static void borrarUsuario(String idB) {
        int tempId = Integer.parseInt(idB);
        Usuario.borrarUsuario(tempId);
        render("Application/baja.html");
        //JOptionPane.showMessageDialog(null , "usuario borradoS");
    }

    public static void armarCadena() {

        render();
        //JOptionPane.showMessageDialog(null , "usuario borradoS");
    }

    public static List mostrarUsuario(int id) {
        List<Usuario> resultado = Usuario.buscarUsuario(id);
        System.out.println(resultado);
        return resultado;
    }
    public static String mostrarUsuarios(int id) {
        String resultado = Usuario.pedirUsuario(id);
        System.out.println(resultado);
        return resultado;
    }



}