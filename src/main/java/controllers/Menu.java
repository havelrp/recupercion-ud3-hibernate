package controllers;

import com.sun.tools.javac.Main;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Grupo;
import model.entities.Publicacion;
import model.entities.Usuario;
import views.MenuView;


import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Scanner sci = new Scanner(System.in);
    MenuView mwp = new MenuView();
    UsuarioController usuarioController = new UsuarioController();
    PublicacionController publicacionController = new PublicacionController();
    GrupoController grupoController = new GrupoController();

    public void accionPrincipal(){
        int opm = mwp.menuPrincipal();
        switch (opm){
            case 1:
                accionUsuario();
                break;
            case 2:
                mwp.menuPublicacion();
                break;
            case 3:
                mwp.menuGrupo();
                break;
        }
    }

    public void accionUsuario(){
        int opu = mwp.menuUsuario();
        switch (opu){
            case 1:
                usuarioController.viewUsuario();
                break;

            case 2:
                System.out.println("Ingrese el id del usuario a modificar");
                int id = sci.nextInt();
                Usuario usuario_mod= usuarioController.viewUsuarioById(id);
                System.out.println("Ingrese el nombre del usuario");
                String nombre_mod= sc.nextLine();
                usuario_mod.setNombre(nombre_mod);
                System.out.println("Ingrese el apellido del usuario");
                String fecha_nacimiento_mod= sc.nextLine();
                usuario_mod.setFecha_nacimiento(fecha_nacimiento_mod);
                System.out.println("Ingrese la contraseña del usuario");
                String contrasena_mod= sc.nextLine();
                usuario_mod.setContrasena(contrasena_mod);
                System.out.println("Ingrese el correo del usuario");
                int amigos_mod= sci.nextInt();
                usuario_mod.setAmigos(amigos_mod);

                usuarioController.update(usuario_mod);
                break;
            case 3:
                System.out.println("Ingrese el id de la publicacion a eliminar");
                int eliminar = sci.nextInt();
                Usuario usuario_eliminar = usuarioController.viewUsuarioById(eliminar);
                usuarioController.remove(usuario_eliminar);
                break;
            case 4:
                Usuario usuario = new Usuario();
                System.out.println("Ingrese el nombre del usuario");
                String nombre = sc.nextLine();
                usuario.setNombre(nombre);
                System.out.println("Ingrese la fecha de nacimiento del usuario");
                String fecha_nacimiento = sc.nextLine();
                usuario.setFecha_nacimiento(fecha_nacimiento);
                System.out.println("Ingrese la contraseña del usuario");
                String contrasena = sc.nextLine();
                usuario.setContrasena(contrasena);
                System.out.println("Ingrese el numero de amigos del usuario");
                int amigos = sci.nextInt();
                usuario.setAmigos(amigos);
                usuarioController.create(usuario);
                break;
        }
    }

    public  void accionPublicacion(){
        int opp = mwp.menuPublicacion();
        switch (opp){
            case 1: //Ver publicaciones
                publicacionController.viewPublicaciones();
                break;
            case 2: //Modificar publicacion
                System.out.println("Ingrese el id de la publicacion a modificar");
                int id_mod = sci.nextInt();
                Publicacion publicacion_mod = publicacionController.viewPublicacionById(id_mod);

                System.out.println("Ingrese el id del autor");
                int id_autor_mod = sci.nextInt();
                Usuario autor_mod = usuarioController.viewUsuarioById(id_autor_mod);
                publicacion_mod.setUsuario(autor_mod);

                System.out.println("Ingrese el contenido de la publicacion");
                String contenido_mod= sc.nextLine();
                publicacion_mod.setContenido(contenido_mod);

                System.out.println("Ingrese fecha de publicacion");
                String fecha_mod = sc.nextLine();
                publicacion_mod.setFecha_publicacion(fecha_mod);

                publicacionController.update(publicacion_mod);
                break;

            case 3: //Eliminar publicacion
                System.out.println("Ingrese el id de la publicacion a eliminar");
                int eliminar = sci.nextInt();
                Publicacion publicacion_eliminar = publicacionController.viewPublicacionById(eliminar);
                publicacionController.remove(publicacion_eliminar);
                break;

            case 4: //Crear publicacion
                Publicacion publicacion = new Publicacion();
                System.out.println("Ingrese el id del autor");
                int id_autor = sci.nextInt();
                publicacion.setUsuario(usuarioController.viewUsuarioById(id_autor));
                System.out.println("Ingrese el contenido de la publicacion");
                String contenido= sc.nextLine();
                publicacion.setContenido(contenido);
                System.out.println("Ingrese fecha de publicacion");
                String fecha = sc.nextLine();
                publicacion.setFecha_publicacion(fecha);

                publicacionController.create(publicacion);
                break;
        }
    }

    public  void accionGrupo(){
        int opg = mwp.menuGrupo();
        switch (opg){
            case 1:
                grupoController.viewGrupos();
                break;
            case 2:
                System.out.println("Ingrese el id del grupo a modificar");
                int id = sci.nextInt();
                Grupo grupo_mod = grupoController.viewGrupoById(id);
                System.out.println("Ingrese el nombre del grupo");
                String nombre_mod = sc.nextLine();
                grupo_mod.setNombre_grupo(nombre_mod);
                System.out.println("Ingrese la descripcion del grupo");
                String descripcion_mod = sc.nextLine();
                grupo_mod.setDescripcion(descripcion_mod);
                System.out.println("Ingrese miembro");
                int miembros_mod = sci.nextInt();
                grupo_mod.setMiembros(miembros_mod);

                grupoController.update(grupo_mod);
                break;

            case 3:
                System.out.println("Ingrese el id del grupo a eliminar");
                int eliminar = sci.nextInt();
                Grupo grupo_eliminar = grupoController.viewGrupoById(eliminar);
                grupoController.remove(grupo_eliminar);
                break;
            case 4:
                Grupo grupo = new Grupo();
                System.out.println("Ingrese el nombre del grupo");
                String nombre = sc.nextLine();
                grupo.setNombre_grupo(nombre);
                System.out.println("Ingrese la descripcion del grupo");
                String descripcion = sc.nextLine();
                grupo.setDescripcion(descripcion);
                System.out.println("Ingrese miembro");
                int miembros = sci.nextInt();
                grupo.setMiembros(miembros);
                grupoController.create(grupo);
                break;
        }
    }
}
