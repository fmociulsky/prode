package io.fercha.prode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Participante implements Serializable {

    private static final long serialVersionUID = 5816817476933047439L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    private String email;
    @Lob
    private byte[] foto;

    public Participante(String nombre, String apellido, String email, byte[] foto) {
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
