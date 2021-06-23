package io.fercha.prode.dto;

import io.fercha.prode.security.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
