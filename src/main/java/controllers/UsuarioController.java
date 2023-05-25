package controllers;

import model.dao.UsuarioDAO;
import model.entities.Usuario;
import views.UsuarioView;

import java.util.List;

public class UsuarioController {

    private UsuarioView view;
    private UsuarioDAO usuarioDAO;


    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
        view = new UsuarioView();
    }

    public void create(Usuario a) {
        usuarioDAO.create(a);
    }

    public void update(Usuario a) {
        usuarioDAO.update(a);
    }

    public void remove(Usuario a) {
        usuarioDAO.delete(a);
    }

    public void viewUsuario() {
        List<Usuario> usuarios = usuarioDAO.find();
        view.viewAllUsuarios(usuarios);
    }

    public void viewUsuaro(Usuario usuario) {
        view.viewUsuario(usuario);
    }

    public Usuario viewUsuarioById(int id) {
        Usuario usuario = usuarioDAO.findId(id);
        view.viewUsuario(usuario);
        return usuario;
    }

    public Usuario viewUsuarioByNombre(String nombre) {
        Usuario usuario = usuarioDAO.findUsuarioByNombre(nombre);
        view.viewUsuario(usuario);
        return usuario;
    }
}
