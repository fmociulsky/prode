package io.fercha.prode.dto;

import io.fercha.prode.entity.Participante;
import io.fercha.prode.entity.Partido;
import io.fercha.prode.entity.Pronostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {

    List<Pronostico> findByParticipante(Participante participante);
    List<Pronostico> findByPartido(Partido partido);
    List<Pronostico> findByPartidoAndParticipante(Partido partido, Participante participante);
}
