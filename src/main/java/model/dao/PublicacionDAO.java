package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Publicacion;
import model.entities.Usuario;

import java.util.List;

public class PublicacionDAO implements InterfaceDAO<Publicacion>{


    private EntityManagerFactory emf;
    private EntityManager manager;


    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public PublicacionDAO() {
        initHibernate();
    }

    @Override
    public void create(Publicacion publicacion) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(publicacion);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public List<Publicacion> find() {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Publicacion> publicaciones = manager.createQuery("FROM Publicacion ").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return publicaciones;

    }

    @Override
    public void update(Publicacion publicacion) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(publicacion);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void delete(Publicacion publicacion) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(publicacion);
        manager.getTransaction().commit();
        manager.close();

    }

    public Publicacion findId(int id){
        manager = emf.createEntityManager();
        try {
            return manager.find(Publicacion.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }
}
