package views;

import model.entities.Publicacion;
import model.entities.Usuario;

import java.util.List;

public class PublicacionView {
    public void viewPublicacion(Publicacion publicacion) {
        System.out.println("Id: "+publicacion.getId_pub()+" Contenido: "+publicacion.getContenido()+" Fecha de publicación: "+publicacion.getFecha_publicacion()+"\n");
    }

    public void viewAllPublicaciones(List<Publicacion> publicacion) {
        for (Publicacion a : publicacion) {
            viewPublicacion(a);
        }
    }
}
