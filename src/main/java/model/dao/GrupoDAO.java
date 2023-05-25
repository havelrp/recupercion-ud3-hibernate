package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Grupo;
import model.entities.Usuario;

import java.util.List;

public class GrupoDAO implements InterfaceDAO<Grupo>{

    private EntityManagerFactory emf;
    private EntityManager manager;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public GrupoDAO() {
        initHibernate();
    }


    @Override
    public void create(Grupo grupo) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(grupo);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public List<Grupo> find() {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Grupo> grupos = manager.createQuery("FROM Grupo ").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return grupos;
    }

    @Override
    public void update(Grupo grupo) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(grupo);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Grupo grupo) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(grupo);
        manager.getTransaction().commit();
        manager.close();

    }
    //Método para buscar un grupo por su id
    public Grupo findId(int id){
        manager = emf.createEntityManager();
        try {
            return manager.find(Grupo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }

    //Método para buscar un grupo por su nombre
    public Grupo findGrupobyNombre(String name){
        manager = emf.createEntityManager();
        try {
            return manager.find(Grupo.class, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }
}
