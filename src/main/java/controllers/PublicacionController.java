package controllers;

import model.dao.PublicacionDAO;
import model.entities.Publicacion;
import model.entities.Usuario;
import views.PublicacionView;


import java.util.List;

public class PublicacionController {
    private PublicacionView view;
    private PublicacionDAO publicacionDAO;


    public PublicacionController() {
        publicacionDAO = new PublicacionDAO();
        view = new PublicacionView();
    }

    public void create(Publicacion a) {
        publicacionDAO.create(a);
    }

    public void update(Publicacion a) {
        publicacionDAO.update(a);
    }

    public void remove(Publicacion a) {
        publicacionDAO.delete(a);
    }

    public void viewPublicaciones() {
        List<Publicacion> publicacion = publicacionDAO.find();
        view.viewAllPublicaciones(publicacion);
    }

    public void viewPulicacion(Publicacion publicacion) {
        view.viewPublicacion(publicacion);
    }

    public Publicacion viewPublicacionById(int id) {
        Publicacion publicacion = publicacionDAO.findId(id);
        view.viewPublicacion(publicacion);
        return publicacion;
    }
}
