package io.fercha.prode.controller;

import io.fercha.prode.entity.Equipo;
import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Partido;
import io.fercha.prode.entity.Pronostico;
import io.fercha.prode.service.EquipoService;
import io.fercha.prode.service.ParticipanteService;
import io.fercha.prode.service.PartidoService;
import io.fercha.prode.service.PronosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;

@Controller
@RequestMapping("/partido")
public class PartidoController {

    @Autowired
    PartidoService partidoService;

    @Autowired
    EquipoService equipoService;

    @GetMapping("")
    public String listar(@Nullable @RequestParam(value = "fase") FaseEnum faseEnum, Model model){
        List<Partido> partidos = partidoService.getPartidos(faseEnum);
        model.addAttribute("partidos", partidos);
        return "partidoList";
    }

    @GetMapping("/nuevoPartido")
    public String agregarPartido(Partido partido, Model model){
        final List<Equipo> equipos = equipoService.listar();
        model.addAttribute("equipos", equipos);
        model.addAttribute("fases", FaseEnum.values());
        return "partido";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Partido partido, Errors errors){
        if(errors.hasErrors()) return "partido";
        partidoService.guardar(partido);
        return "redirect:/partido";
    }

    @GetMapping("/{id}")
    public String modificar(Partido partido, Model model){
        partido = partidoService.buscarPorId(partido.getId());
        model.addAttribute("partido", partido);
        final List<Equipo> equipos = equipoService.listar();
        model.addAttribute("equipos", equipos);
        model.addAttribute("fases", FaseEnum.values());
        return "partido";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Partido partido){
        partidoService.eliminar(partido);
        return "redirect:/partido";
    }

}
