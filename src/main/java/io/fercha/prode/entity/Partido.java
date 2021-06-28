package io.fercha.prode.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Partido implements Serializable {

    private static final long serialVersionUID = -3209156863483399085L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToOne
    private Equipo local;
    @OneToOne
    private Equipo visitante;
    private Integer golesLocal;
    private Integer golesVisitante;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date fecha;
    @NotNull
    private FaseEnum fase;
    @Column(name = "editable", nullable = false, columnDefinition="tinyint(1) default 1")
    private Boolean editable;

    public Partido(Long id, Equipo local, Equipo visitante, int golesLocal, int golesVisitante, Date fecha, FaseEnum fase, Boolean editable) {
        this.id = id;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.fecha = fecha;
        this.fase = fase;
        this.editable = editable;
    }

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

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
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

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
}
