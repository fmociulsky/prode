package io.fercha.prode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Pronostico implements Serializable {

    private static final long serialVersionUID = -6688219969299563587L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToOne
    private Partido partido;
    private String local;
    private String visitante;
    @OneToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    private Participante participante;
    private Integer golesLocal;
    private Integer golesVisitante;
    private Integer puntos;

    public Pronostico() {
    }

    public Pronostico(Long id, Partido partido, String local, String visitante, Participante participante, Integer golesLocal, Integer golesVisitante) {
        this.id = id;
        this.local = local;
        this.visitante = visitante;
        this.participante = participante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Pronostico(Partido partido, Participante participante) {
        this.partido = partido;
        local = partido.getLocal().getNombre();
        visitante = partido.getVisitante().getNombre();
        this.participante = participante;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
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

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public void actualizarPuntos(Integer golesLocalParam, Integer golesVisitanteParam) {
        final Boolean ganoLocal = golesLocalParam > golesVisitanteParam;
        final Boolean ganoVis = golesLocalParam < golesVisitanteParam;
        final Boolean empate = golesLocalParam.equals(golesVisitanteParam);

        final Boolean ganoLocalPron = getGolesLocal() > getGolesVisitante();
        final Boolean ganoVisitantePron = getGolesLocal() < getGolesVisitante();
        final Boolean empatePron = getGolesLocal().equals(getGolesVisitante());

        if(ganoLocal == ganoLocalPron && ganoVis == ganoVisitantePron && empate == empatePron){
            int puntosProno = ACIERTO;
            if(golesLocalParam.equals(getGolesLocal()) && golesVisitanteParam.equals(getGolesVisitante())){
                final FaseEnum fase = getPartido().getFase();
                if(fase==FaseEnum.OCTAVOS || fase==FaseEnum.CUARTOS || fase==FaseEnum.SEMIS || fase==FaseEnum.FINAL){
                    if(getGolesLocal() + golesVisitante >= 4) puntosProno += PTOS_5;
                    else puntosProno += PTOS_3;
                }else{
                    if(getGolesLocal() + golesVisitante >= 4) puntosProno += PTOS_4;
                    else puntosProno += PTOS_2;
                }
            }
            setPuntos(puntosProno);
        }else setPuntos(0);
    }

    private static int ACIERTO = 3;
    private static int PTOS_4 = 4;
    private static int PTOS_2 = 2;
    private static int PTOS_5 = 5;
    private static int PTOS_3 = 3;
}
