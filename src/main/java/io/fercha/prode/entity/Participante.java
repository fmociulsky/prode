package io.fercha.prode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.File;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Participante {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String foto;

    public Participante(String nombre, String apellido, String email, String foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.foto = foto;
    }

    public Participante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
