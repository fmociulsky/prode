package io.fercha.prode.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Rol implements Serializable {

    private static final long serialVersionUID = -480619226711413347L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @NotEmpty
    private String nombre;

    public Rol() {
    }

    public Rol(Long idRol, @NotEmpty String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public Long getId() {
        return idRol;
    }

    public void setId(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
