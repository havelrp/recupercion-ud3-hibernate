package model.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String nombre;
    private String contrasena;
    private String fecha_nacimiento;
    private int amigos;
    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL)
    private List<Publicacion> lpublicacion;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_grupo",
            joinColumns = @JoinColumn(name ="id"),
            inverseJoinColumns = @JoinColumn(name = "id_grupo")
    )
    private Set<Grupo> grupos = new HashSet<>();


    public Usuario(){}

    public Usuario(int id, String nombre, String contrasena, String fecha_nacimiento, int amigos){
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fecha_nacimiento = fecha_nacimiento;
        this.amigos = amigos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getAmigos() {
        return amigos;
    }

    public void setAmigos(int amigos) {
        this.amigos = amigos;
    }
    public List<Publicacion> getLpublicacion() {
        return lpublicacion;
    }

    public void setLpublicacion(List<Publicacion> lpublicacion) {
        this.lpublicacion = lpublicacion;
    }

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
}