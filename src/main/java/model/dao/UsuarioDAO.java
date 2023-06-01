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
        a = manager.merge(a);
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

    //Método para buscar por nombre
    public Usuario findUsuarioByNombre(String nombre){
        manager = emf.createEntityManager();
        try {
            Query query = manager.createQuery("FROM Usuario WHERE nombre = :nombre");
            query.setParameter("nombre", nombre);
            return (Usuario) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }

    //Método para buscar usuarios que realizaron una publicación
    public List<Usuario> listarAutores(){
        manager = emf.createEntityManager();
        String jpql = "SELECT u FROM Usuario u WHERE EXISTS (SELECT p FROM Publicacion p WHERE p.usuario = u)";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre());
        }
        manager.close();
        return usuarios;
    }

}
