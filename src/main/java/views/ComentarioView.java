package views;

import model.entities.Comentario;
import model.entities.Grupo;

import java.util.List;

public class ComentarioView {
    public void viewComentario(Comentario comentario) {
        System.out.println("Comentario data: " +comentario);
    }

    public void viewAllComentario(List<Comentario> comentario) {
        for (Comentario a : comentario) {
            System.out.println("Grupo data: "+ a);
        }
    }
}
