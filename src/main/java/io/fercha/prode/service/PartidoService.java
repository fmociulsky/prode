package io.fercha.prode.service;

import io.fercha.prode.dto.PartidoRepository;
import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    PartidoRepository partidoRepository;

    public List<Partido> getPartidos(FaseEnum fase){
        return partidoRepository.findByFase(fase);
    }
}
