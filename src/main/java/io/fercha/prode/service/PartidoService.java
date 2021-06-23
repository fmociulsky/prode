package io.fercha.prode.service;

import io.fercha.prode.dto.ParticipanteRepository;
import io.fercha.prode.dto.PartidoRepository;
import io.fercha.prode.dto.PronosticoRepository;
import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.entity.Partido;
import io.fercha.prode.entity.Pronostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    PartidoRepository partidoRepository;

    @Autowired
    PronosticoRepository pronosticoRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    public List<Partido> getPartidos(FaseEnum fase){
        if(fase == null) return partidoRepository.findAll();
        return partidoRepository.findByFase(fase);
    }

    @Transactional
    public void guardar(Partido partido){
        final boolean isNuevo = partido.getId() == null;
        final Partido partidoSaved = partidoRepository.save(partido);
        final List<Participante> participantes = participanteRepository.findAll();
        if(isNuevo){
            participantes.forEach(participante -> {
                final Pronostico pronostico = new Pronostico(partidoSaved, participante);
                pronosticoRepository.save(pronostico);
            });
        }else{
            participantes.forEach(participante -> {
                final List<Pronostico> pronosticos = pronosticoRepository.findByPartidoAndParticipante(partido, participante);
                pronosticos.forEach(pronostico -> {
                    if(pronostico.getGolesLocal() != null && pronostico.getGolesVisitante() != null)
                        pronostico.actualizarPuntos(partido.getGolesLocal(), partido.getGolesVisitante());
                });
                pronosticoRepository.saveAll(pronosticos);
            });
        }
    }

    public Partido buscarPorId(Long id) {
        return partidoRepository.findById(id).orElseGet(null);
    }

    public void eliminar(Partido partido) {
        final List<Pronostico> pronosticos = pronosticoRepository.findByPartido(partido);
        pronosticoRepository.deleteAll(pronosticos);
        partidoRepository.delete(partido);

    }
}
