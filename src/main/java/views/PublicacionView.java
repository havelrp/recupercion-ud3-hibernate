package views;

import model.entities.Publicacion;
import model.entities.Usuario;

import java.util.List;

public class PublicacionView {
    public void viewPublicacion(Publicacion publicacion) {
        System.out.println("Publicacion data: " +publicacion);
    }

    public void viewAllPublicaciones(List<Publicacion> publicacion) {
        for (Publicacion a : publicacion) {
            System.out.println("Usuario data: "+ a);
        }
    }
}
