package io.fercha.prode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Equipo implements Serializable {

    private static final long serialVersionUID = 4629550477641145094L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nombre;

    public Equipo() {
    }

    public Equipo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
