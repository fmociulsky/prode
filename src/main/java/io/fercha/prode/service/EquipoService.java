package io.fercha.prode.service;

import io.fercha.prode.dto.EquipoRepository;
import io.fercha.prode.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    EquipoRepository equipoRepository;

    public List<Equipo> listar(){
        return equipoRepository.findAll();
    }

    public void guardar(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    public Equipo buscarPorId(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public void eliminar(Equipo equipo) {
        equipoRepository.delete(equipo);
    }
}
