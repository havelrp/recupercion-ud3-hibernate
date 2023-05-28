package views;

import model.entities.Grupo;
import model.entities.Usuario;

import java.util.List;

public class GrupoView {
    public void viewGrupo(Grupo grupo) {
        System.out.println("Id: "+grupo.getId_grupo()+" Nombre "+grupo.getNombre_grupo()+" Descripcion: "+grupo.getDescripcion()+" Numero de miembros: "+grupo.getMiembros());
    }

    public void viewAllGrupos(List<Grupo> grupo) {
        for (Grupo a : grupo) {
            viewGrupo(a);
        }
    }
}
