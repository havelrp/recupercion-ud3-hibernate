package controllers;

import com.sun.tools.javac.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.entities.Comentario;
import model.entities.Grupo;
import model.entities.Publicacion;
import model.entities.Usuario;
import views.MenuView;


import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Scanner sci = new Scanner(System.in);
    MenuView mwp = new MenuView();
    UsuarioController usuarioController = new UsuarioController();
    PublicacionController publicacionController = new PublicacionController();
    GrupoController grupoController = new GrupoController();
    ComentarioController comentarioController = new ComentarioController();


    public void accionPrincipal(){
        int opm = mwp.menuPrincipal();
        switch (opm){
            case 1:
                accionUsuario();
                break;
            case 2:
                accionPublicacion();
                break;
            case 3:
                accionGrupo();
                break;
            case 4:
                accionConsultas();
                break;
            case 5:
                System.out.println("Gracias por usar el programa");
                break;
            case 6:
                accionComentario();
        }
    }

    public void accionUsuario(){
        int opu = mwp.menuUsuario();
        switch (opu){
            case 1:
                usuarioController.viewUsuario();
                accionPrincipal();
                break;

            case 2:
                System.out.println("Ingrese el nombre del usuario a modificar");
                String nombre = sc.nextLine();
                Usuario usuario_mod= usuarioController.viewUsuarioByNombre(nombre);
                System.out.println("Ingrese el nuevo nombre del usuario");
                String nombre_mod= sc.nextLine();
                usuario_mod.setNombre(nombre_mod);
                System.out.println("Ingrese la fecha de nacimiento del usuario");
                String fecha_nacimiento_mod= sc.nextLine();
                usuario_mod.setFecha_nacimiento(fecha_nacimiento_mod);
                System.out.println("Ingrese la contraseña del usuario");
                String contrasena_mod= sc.nextLine();
                usuario_mod.setContrasena(contrasena_mod);
                System.out.println("Ingrese el nº de amigos del usuario");
                int amigos_mod= sci.nextInt();
                usuario_mod.setAmigos(amigos_mod);

                usuarioController.update(usuario_mod);
                accionPrincipal();
                break;
            case 3:
                System.out.println("Ingrese el nombre del usuario a borrar");
                nombre = sc.nextLine();
                Usuario usuario_rmv= usuarioController.viewUsuarioByNombre(nombre);
                usuarioController.remove(usuario_rmv);
                accionPrincipal();
                break;
            case 4:
                Usuario usuario = new Usuario();
                System.out.println("Ingrese el nombre del usuario");
                nombre = sc.nextLine();
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
                accionPrincipal();
                break;
            case 5:
                accionPrincipal();
                break;
        }
    }

    public  void accionPublicacion(){
        int opp = mwp.menuPublicacion();
        switch (opp){
            case 1: //Ver publicaciones
                publicacionController.viewPublicaciones();
                accionPrincipal();
                break;
            case 2: //Modificar publicacion
                System.out.println("Ingrese el titulo de la publicacion a modificar");
                String titulo_mod = sc.nextLine();
                Publicacion publicacion_mod = publicacionController.viewPublicacionByTitulo(titulo_mod);


                System.out.println("Ingrese el nuevo titulo");
                titulo_mod = sc.nextLine();
                publicacion_mod.setTitulo(titulo_mod);
                System.out.println("Ingrese el nombre del autor");
                Usuario autor_mod = usuarioController.viewUsuarioByNombre(sc.nextLine());
                publicacion_mod.setUsuario(autor_mod);

                System.out.println("Ingrese el contenido de la publicacion");
                String contenido_mod= sc.nextLine();
                publicacion_mod.setContenido(contenido_mod);

                System.out.println("Ingrese fecha de publicacion");
                String fecha_mod = sc.nextLine();
                publicacion_mod.setFecha_publicacion(fecha_mod);

                publicacionController.update(publicacion_mod);
                accionPrincipal();
                break;

            case 3: //Eliminar publicacion
                System.out.println("Ingrese el titulo de la publicacion a borrar");
                String titulo_eliminar = sc.nextLine();
                Publicacion publicacion_eliminar = publicacionController.viewPublicacionByTitulo(titulo_eliminar);
                publicacionController.remove(publicacion_eliminar);
                accionPrincipal();
                break;

            case 4: //Crear publicacion
                Publicacion publicacion = new Publicacion();
                System.out.println("Ingrese el nombre del autor");
                Usuario autor = usuarioController.viewUsuarioByNombre(sc.nextLine());
                publicacion.setUsuario(autor);
                System.out.println("Ingrese el titulo de la publicacion");
                String titulo = sc.nextLine();
                publicacion.setTitulo(titulo);
                System.out.println("Ingrese el contenido de la publicacion");
                String contenido= sc.nextLine();
                publicacion.setContenido(contenido);
                System.out.println("Ingrese fecha de publicacion");
                String fecha = sc.nextLine();
                publicacion.setFecha_publicacion(fecha);

                publicacionController.create(publicacion);
                accionPrincipal();
                break;
            case 5:
                accionPrincipal();
                break;
        }
    }

    public  void accionGrupo() {
        int opg = mwp.menuGrupo();
        switch (opg) {
            case 1:
                grupoController.viewGrupos();
                accionPrincipal();
                break;
            case 2:
                System.out.println("Ingrese el nombre del grupo a modificar");
                String nombre_mod = sc.nextLine();
                Grupo grupo_mod = grupoController.viewGrupoByNombre(nombre_mod);
                System.out.println("Ingrese el nombre del grupo");
                nombre_mod = sc.nextLine();
                grupo_mod.setNombre_grupo(nombre_mod);
                System.out.println("Ingrese la descripcion del grupo");
                String descripcion_mod = sc.nextLine();
                grupo_mod.setDescripcion(descripcion_mod);
                System.out.println("Ingrese el número de miembros");
                int miembros_mod = sci.nextInt();
                grupo_mod.setMiembros(miembros_mod);

                grupoController.update(grupo_mod);
                accionPrincipal();
                break;

            case 3:
                System.out.println("Ingrese el nombre del grupo a borrar");
                String nombre_eliminar = sc.nextLine();
                Grupo grupo_eliminar = grupoController.viewGrupoByNombre(nombre_eliminar);
                grupoController.remove(grupo_eliminar);
                accionPrincipal();
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
                accionPrincipal();
                break;
            case 5:
                System.out.println("Ingrese el nombre del grupo");
                String nombre_grupo = sc.nextLine();
                Grupo meterGrupo = grupoController.viewGrupoByNombre(nombre_grupo);
                int id_grupo = meterGrupo.getId_grupo();

                System.out.println("Ingrese el nombre del usuario");
                String nombre_usuario = sc.nextLine();
                Usuario meterUsuario = usuarioController.viewUsuarioByNombre(nombre_usuario);
                int id_usuario = meterUsuario.getId();

                grupoController.meterUsuario(id_grupo ,id_usuario);
                accionPrincipal();
                break;
            case 6:
                accionPrincipal();
                break;
        }
    }
    public void accionConsultas(){
        int opc = mwp.menuConsultas();
        switch (opc){
            case 1:
                usuarioController.consultaUsuario();
                accionPrincipal();
                break;
            case 2:
                System.out.println("Ingrese la palabra clave que quiere buscar en las publicaciones");
                String palabra = sc.nextLine();
                publicacionController.consultaPublicacion(palabra);
                accionPrincipal();
                break;
            case 3:
                System.out.println("Ingrese el nombre de usuario del que quiere listar grupos ");
                String nombre = sc.nextLine();
                grupoController.consultaGrupo(nombre);
                accionPrincipal();
                break;
            case 4:
                accionPrincipal();
                break;
        }
    }


    public void accionComentario(){
        int opcom = mwp.menuComentarios();
        switch (opcom){
            case 1:
                Comentario comentario = new Comentario();
                System.out.println("Ingrese el comentario");
                String descripcion = sc.nextLine();
                comentario.setDescripcion(descripcion);
                System.out.println("Ingrese el autor");
                String autor = sc.nextLine();
                comentario.setAutor(autor);
                System.out.println("Ingrese la fecha del comentario");
                String fecha_comentario = sc.nextLine();
                comentario.setFecha_comentario(fecha_comentario);

                System.out.println("Ingrese la id de la publicacion");
                int id = sci.nextInt();
                Publicacion publicacion_com = publicacionController.viewPublicacionById(id);
                comentario.setPublicacion(publicacion_com);

                comentarioController.create(comentario);
                accionPrincipal();
                break;
            case 2:
                grupoController.viewGrupos();
                accionPrincipal();
                break;

            case 3:
                System.out.println("Ingrese la id de la publicacion");
                int id_mostrar = sci.nextInt();
                Publicacion publicacion_mostrar = publicacionController.viewPublicacionById(id_mostrar);
                publicacion_mostrar.getLcomentario();
                accionPrincipal();
                break;
        }
    }
}
