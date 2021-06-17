package io.fercha.prode.dto;

import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    List<Partido> findByFase(FaseEnum faseEnum);
}
