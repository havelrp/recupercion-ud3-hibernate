package model.entities;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="publicacion")
public class Publicacion {
    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = IDENTITY)
    private int id_pub;
    private String contenido;
    private String fecha_publicacion;

    @ManyToOne
    @JoinColumn(name="id")
    private Usuario usuario;
    public Publicacion(){}

    public Publicacion(int id_pub,String contenido,Usuario usuario,String fecha_publicacion){
        this.id_pub =id_pub;
        this.contenido = contenido;
        this.usuario = usuario;
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId_pub() {
        return id_pub;
    }

    public void setId(int id_pub) {
        this.id_pub = id_pub;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
