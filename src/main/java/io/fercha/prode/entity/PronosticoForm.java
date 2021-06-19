package io.fercha.prode.entity;

import java.util.ArrayList;
import java.util.List;

public class PronosticoForm {
    private List<Pronostico> pronosticos = new ArrayList<Pronostico>();

    public PronosticoForm() {
    }

    public PronosticoForm(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public void addAll(List<Pronostico> pronosticos) {
        this.pronosticos.addAll(pronosticos);
    }
}
