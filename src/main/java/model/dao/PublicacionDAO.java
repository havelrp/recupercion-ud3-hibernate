package model.dao;

import jakarta.persistence.*;
import model.entities.Publicacion;

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
        publicacion = manager.merge(publicacion);
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

    public Publicacion findPublicacionbytitulo(String titulo){
        manager = emf.createEntityManager();
        try {
            Query query = manager.createQuery("FROM Publicacion WHERE titulo = :titulo");
            query.setParameter("titulo", titulo);
            return (Publicacion) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }

    public void buscarPalabraClave(String palabraClave){
        manager = emf.createEntityManager();
        String jpql = "SELECT p FROM Publicacion p WHERE p.contenido LIKE :palabraClave";
        TypedQuery<Publicacion> query = manager.createQuery(jpql, Publicacion.class);
        query.setParameter("palabraClave", "%" + palabraClave + "%");
        List<Publicacion> publicaciones = query.getResultList();
        for (Publicacion publicacion : publicaciones) {
            System.out.println(publicacion.getTitulo() + " " + publicacion.getContenido());
        }
    }
}
