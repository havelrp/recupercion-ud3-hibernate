package views;

import model.entities.Grupo;
import model.entities.Usuario;

import java.util.List;

public class GrupoView {
    public void viewGrupos(Grupo grupo) {
        System.out.println("Grupo data: " +grupo);
    }

    public void viewAllGrupo(List<Grupo> grupo) {
        for (Grupo a : grupo) {
            System.out.println("Grupo data: "+ a);
        }
    }
}
