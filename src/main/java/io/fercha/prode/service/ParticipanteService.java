package io.fercha.prode.service;

import io.fercha.prode.dto.ParticipanteRepository;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParticipanteService {


    @Autowired
    ParticipanteRepository participanteRepository;

    @Transactional(readOnly = true)
    public List<Participante> listar(){
        return participanteRepository.findAll();
    }

    @Transactional
    public void guardar(Participante participante) {
        participanteRepository.save(participante);
    }
    @Nullable
    public Participante buscarPorId(Long id) {
        return participanteRepository.findById(id).orElseGet(null);
    }

    public void eliminar(Participante participante) {
        participanteRepository.delete(participante);
    }

    public Participante buscarPorUser(Usuario usuario) {
        return participanteRepository.findByUsuario(usuario);
    }
}
