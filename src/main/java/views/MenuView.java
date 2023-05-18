package views;

import java.util.Scanner;

public class MenuView {
    Scanner sc = new Scanner(System.in);

    public int menuPrincipal(){
        System.out.println("1.- Opciones Usuario");
        System.out.println("2.- Opciones Publicacion");
        System.out.println("3.- Opciones Grupo");
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
        int opg = sc.nextInt();
        return opg;
    }

}
