package views;

import model.entities.Usuario;

import java.util.List;

public class UsuarioView {
    public void viewUsuario(Usuario usuario) {
        System.out.println("Usuario data: " +usuario);
    }

    public void viewAllUsuarios(List<Usuario> usuario) {
        for (Usuario a : usuario) {
            System.out.println("Usuario data: "+ a);
        }
    }
}
