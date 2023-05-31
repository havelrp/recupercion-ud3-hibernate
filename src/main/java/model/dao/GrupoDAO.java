package model.dao;

import jakarta.persistence.*;
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
    public Grupo findGrupobyNombre(String name_grupo){
        manager = emf.createEntityManager();
        try {
            Query query = manager.createQuery("FROM Grupo WHERE nombre_grupo = :nombre_grupo");
            query.setParameter("nombre_grupo", name_grupo);
            return (Grupo) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }

    public void listarUsuarios(String nombre){
        manager = emf.createEntityManager();
        try {
            String jpql = "SELECT g FROM Grupo g JOIN g.usuarios u WHERE u.nombre = :nombre_usuario";
            TypedQuery<Grupo> query = manager.createQuery(jpql, Grupo.class);
            query.setParameter("nombre_usuario", nombre);
            List<Grupo> grupos = query.getResultList();
            for (Grupo grupo : grupos) {
                System.out.println(grupo.getNombre_grupo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void meterUsuarioGrupo(int id_grupo, int id_usuario){
        manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Grupo grupo = manager.find(Grupo.class, id_grupo);
            Usuario usuario = manager.find(Usuario.class, id_usuario);


            usuario.getGrupos().size();

            usuario.getGrupos().add(grupo);
            grupo.getUsuarios().add(usuario);

            manager.merge(usuario);
            manager.merge(grupo);

            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}
