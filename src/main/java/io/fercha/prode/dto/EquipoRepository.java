package io.fercha.prode.dto;

import io.fercha.prode.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
