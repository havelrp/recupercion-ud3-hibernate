package model.dao;

import jakarta.persistence.*;
import model.entities.Usuario;

import java.util.List;

public class UsuarioDAO implements InterfaceDAO<Usuario>{

    private EntityManagerFactory emf;
    private EntityManager manager;


    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public UsuarioDAO() {
        initHibernate();
    }


    @Override
    public void create(Usuario a) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(a);
        manager.getTransaction().commit();
        manager.close();
    }


    @Override
    public List find() {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("FROM Usuario ");
        return query.getResultList();
    }

    @Override
    public void update(Usuario a) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(a);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Usuario a) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(a);
        manager.getTransaction().commit();
        manager.close();

    }

    //Método para buscar por id
    public Usuario findId(int id){
        manager = emf.createEntityManager();
        try {
            return manager.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }
}
