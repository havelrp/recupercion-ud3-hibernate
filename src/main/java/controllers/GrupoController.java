package controllers;

import model.dao.GrupoDAO;
import model.entities.Grupo;
import model.entities.Usuario;
import views.GrupoView;
import views.UsuarioView;

import java.util.List;

public class GrupoController {
    private GrupoView view;
    private GrupoDAO grupoDAO;


    public GrupoController() {
        grupoDAO = new GrupoDAO();
        view = new GrupoView();
    }

    public void create(Grupo a) {
        grupoDAO.create(a);
    }

    public void update(Grupo a) {
        grupoDAO.update(a);
    }

    public void remove(Grupo a) {
        grupoDAO.delete(a);
    }

    public void viewGrupos() {
        List<Grupo> grupos = grupoDAO.find();
        view.viewAllGrupos(grupos);
    }

    public void viewGrupo(Grupo grupo) {
        view.viewGrupo(grupo);
    }

    public Grupo viewGrupoById(int id) {
        Grupo grupo = grupoDAO.findId(id);
        view.viewGrupo(grupo);
        return grupo;
    }

    public Grupo viewGrupoByNombre(String name_grupo) {
        Grupo grupo = grupoDAO.findGrupobyNombre(name_grupo);
        view.viewGrupo(grupo);
        return grupo;
    }

    public void consultaGrupo(String nombre_usuario) {
        grupoDAO.listarUsuarios(nombre_usuario);
    }

    public void meterUsuario(String grupo,Usuario usuario) {
        grupoDAO.meterUsuarioGrupo(grupo,usuario);
    }
}
