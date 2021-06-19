package io.fercha.prode.service;

import io.fercha.prode.dto.PronosticoRepository;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.entity.Pronostico;
import io.fercha.prode.entity.PronosticoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PronosticoService {

    @Autowired
    PronosticoRepository pronosticoRepository;

    public List<Pronostico> listar(Participante participante){
        return pronosticoRepository.findByParticipante(participante);
    }


    public void guardar(Pronostico pronostico) {
        pronosticoRepository.save(pronostico);
    }

    public void guardarPronosticos(PronosticoForm pronosticoForm) {
        pronosticoForm.getPronosticos().forEach(pronostico -> {
            final Pronostico one = pronosticoRepository.findById(pronostico.getId()).get();
            one.setGolesLocal(pronostico.getGolesLocal());
            one.setGolesVisitante(pronostico.getGolesVisitante());
            pronosticoRepository.save(one);
        });
    }
}
