package controllers;

import model.dao.ComentarioDAO;
import model.dao.ComentarioDAO;
import model.entities.Comentario;
import model.entities.Grupo;
import views.ComentarioView;
import views.GrupoView;

import java.util.List;

public class ComentarioController {
    private ComentarioView view;
    private ComentarioDAO comentarioDAO;

    public ComentarioController() {
        comentarioDAO = new ComentarioDAO();
        view = new ComentarioView();
    }

    public void create(Comentario a) {
        comentarioDAO.create(a);
    }

    public void update(Comentario a) {
        comentarioDAO.update(a);
    }

    public void remove(Comentario a) {
        comentarioDAO.delete(a);
    }

    public void viewAllComentario() {
        List<Comentario> comentarios = comentarioDAO.find();
        view.viewAllComentario(comentarios);
    }

    public void viewComentario(Comentario comentario) {
        view.viewComentario(comentario);
    }

    public Comentario viewComentarioById(int id) {
        Comentario comentario = comentarioDAO.findId(id);
        view.viewComentario(comentario);
        return comentario;
    }
}
