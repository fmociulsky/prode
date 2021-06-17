package io.fercha.prode.service;

import io.fercha.prode.dto.ParticipanteRepository;
import io.fercha.prode.entity.Participante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParticipanteService {


    @Autowired
    ParticipanteRepository participanteRepository;

    @Transactional(readOnly = true)
    public List<Participante> getParticipantes(){
        return participanteRepository.findAll();
    }

    @Transactional
    public Participante guardar(Participante participante) {
        return participanteRepository.save(participante);
    }
    @Nullable
    public Participante buscarPorId(Long id) {
        return participanteRepository.findById(id).orElseGet(null);
    }

    public void eliminar(Participante participante) {
        participanteRepository.delete(participante);
    }
}
