package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Comentario;
import model.entities.Grupo;

import java.util.List;

public class ComentarioDAO implements  InterfaceDAO<Comentario>{

    private EntityManagerFactory emf;
    private EntityManager manager;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public ComentarioDAO() {
        initHibernate();
    }


    @Override
    public void create(Comentario comentario) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(comentario);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List find() {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Grupo> grupos = manager.createQuery("FROM Grupo ").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return grupos;
    }

    @Override
    public void update(Comentario comentario) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        comentario = manager.merge(comentario);
        manager.remove(comentario);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Comentario comentario) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(comentario);
        manager.getTransaction().commit();
        manager.close();
    }

    public Comentario findId(int id){
        manager = emf.createEntityManager();
        try {
            return manager.find(Comentario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }
}
