package io.fercha.prode.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Equipo implements Serializable {

    private static final long serialVersionUID = 4629550477641145094L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    public Equipo(Long id, @NotEmpty String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Equipo() {
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
}
