package io.fercha.prode.service;

import io.fercha.prode.dto.RolRepository;
import io.fercha.prode.security.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public void save(Rol rol){
        rolRepository.save(rol);
    }

}
