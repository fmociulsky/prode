package io.fercha.prode.controller;

import io.fercha.prode.entity.Equipo;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    @GetMapping("")
    public String listar(Model model){
        final List<Equipo> equipos = equipoService.listar();
        model.addAttribute("equipos", equipos);
        return "equipoList";
    }

    @GetMapping("/nuevoEquipo")
    public String agregarEquipo(Equipo equipo){
        return "equipo";
    }

    @PostMapping("/guardar")
    public String guardar(Equipo equipo, @RequestParam("image") byte[] fileByte) throws IOException {
        equipoService.guardar(equipo);
        return "redirect:/equipo";
    }

    @GetMapping("/{id}")
    public String modificar(Equipo equipo, Model model){
        equipo = equipoService.buscarPorId(equipo.getId());
        model.addAttribute("equipo", equipo);
        return "equipo";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Equipo equipo){
        equipoService.eliminar(equipo);
        return "redirect:/equipo";
    }
}
