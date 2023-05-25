package views;

import model.entities.Usuario;

import java.util.List;

public class UsuarioView {
    public void viewUsuario(Usuario usuario) {
        System.out.print("Id: " + usuario.getId() + " Nombre:  "+usuario.getNombre()+" Contraseña "+usuario.getContrasena()+" Fecha de nacimiento:"+usuario.getFecha_nacimiento()+" Número de amigos "+usuario.getAmigos()+"\n");
    }

    public void viewAllUsuarios(List<Usuario> usuario) {
        for (Usuario a : usuario) {
            viewUsuario(a);
        }
    }
}
