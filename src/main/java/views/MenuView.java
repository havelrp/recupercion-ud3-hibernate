package views;

import java.util.Scanner;

public class MenuView {
    Scanner sc = new Scanner(System.in);

    public int menuPrincipal(){
        System.out.println("1.- Opciones Usuario");
        System.out.println("2.- Opciones Publicacion");
        System.out.println("3.- Opciones Grupo");
        System.out.println("4.- Consultas");
        System.out.println("5.- Salir");
        System.out.println("6.- Opciones Comentario");
        int opm = sc.nextInt();
        return opm;
    }

    public int menuUsuario(){
        System.out.println("1.- Buscar Usuario");
        System.out.println("2.- Modificar Usuario");
        System.out.println("3.- Borrar Usuario");
        System.out.println("4.- Crear Usuario");
        int opu = sc.nextInt();
        return opu;
    }

    public int menuPublicacion(){
        System.out.println("1.- Buscar Publicacion");
        System.out.println("2.- Modificar Publicacion");
        System.out.println("3.- Borrar Publicacion");
        System.out.println("4.- Crear Publicacion");
        int opp = sc.nextInt();
        return opp;
    }

    public int menuGrupo(){
        System.out.println("1.- Buscar Grupo");
        System.out.println("2.- Modificar Grupo");
        System.out.println("3.- Borrar Grupo");
        System.out.println("4.- Crear Grupo");
        System.out.println("5.- Meter usuario en grupo");
        int opg = sc.nextInt();
        return opg;
    }

    public int menuConsultas(){
        System.out.println("1.- Consulta sobre usuarios");
        System.out.println("2.- Consulta sobre publicaciones");
        System.out.println("3.- Consulta sobre grupos");
        int opc = sc.nextInt();
        return opc;
    }

    public int menuComentarios(){
        System.out.println("1.- Crear comentario");
        System.out.println("2.- Listar comentarios");
        int opcom = sc.nextInt();
        return opcom;
    }

}
