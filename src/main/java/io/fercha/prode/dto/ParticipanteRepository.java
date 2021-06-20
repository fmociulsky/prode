package io.fercha.prode.dto;

import io.fercha.prode.entity.Participante;
import io.fercha.prode.security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    Participante findByUsuario(Usuario usuario);
}
