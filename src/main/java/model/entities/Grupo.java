package model.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;



import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "grupos")
public class Grupo {
    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = IDENTITY)
    private int id_grupo;
    private String nombre_grupo;
    private String descripcion;
    private int miembros;
    @ManyToMany(mappedBy = "grupos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Usuario> usuarios = new HashSet<>();

    public Grupo() {
    }

    public Grupo(int id_grupo, String nombre_grupo, String descripcion, int miembros) {
        this.id_grupo = id_grupo;
        this.nombre_grupo = nombre_grupo;
        this.descripcion = descripcion;
        this.miembros = miembros;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMiembros() {
        return miembros;
    }

    public void setMiembros(int miembros) {
        this.miembros = miembros;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}