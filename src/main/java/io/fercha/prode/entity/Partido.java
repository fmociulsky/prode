package io.fercha.prode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToOne
    private Equipo local;
    @OneToOne
    private Equipo visitante;
    private int golesLocal;
    private int golesVisitante;
    private Date fecha;
    private FaseEnum fase;

    public Partido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public FaseEnum getFase() {
        return fase;
    }

    public void setFase(FaseEnum fase) {
        this.fase = fase;
    }
}
