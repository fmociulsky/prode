package io.fercha.prode.service;

import io.fercha.prode.dto.ParticipanteRepository;
import io.fercha.prode.dto.PronosticoRepository;
import io.fercha.prode.dto.UsuarioRepository;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class ParticipanteService {


    @Autowired
    ParticipanteRepository participanteRepository;

    @Autowired
    PronosticoRepository pronosticoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    public List<Participante> listar(){
        final List<Participante> participantes = participanteRepository.findAll();
        participantes.forEach(participante -> {
            participante.setPuntos(pronosticoRepository.findByParticipante(participante).stream()
                    .mapToInt(p->p.getPuntos() == null ? 0 : p.getPuntos())
                    .sum());
        });
        participantes.sort((Participante s1, Participante s2)->s2.getPuntos().compareTo(s1.getPuntos()));
        return participantes;
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

    public Participante buscarPorUsuarioId(String username) {
        final Usuario usuario = usuarioRepository.findByUsername(username);
        return buscarPorUser(usuario);
    }
}
