package model.dao;

import model.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
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

    }

    @Override
    public void delete(Usuario a) {

    }
}
