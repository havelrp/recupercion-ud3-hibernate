package model.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = IDENTITY)
    private int id_comentario;
    @Column(length = 100)
    private String descripcion;
    @Column(length = 30)
    private String autor;
    private String fecha_comentario;

    @ManyToOne
    @JoinColumn(name = "id_pub")
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(int id_comentario, String descripcion, String autor, String fecha_comentario) {
        this.id_comentario = id_comentario;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fecha_comentario = fecha_comentario;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(String fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }


    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

}