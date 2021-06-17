package io.fercha.prode.controller;

import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Partido;
import io.fercha.prode.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/partido")
public class PartidoController {

    @Autowired
    PartidoService partidoService;

    @GetMapping("")
    public String listar(@RequestParam FaseEnum faseEnum, Model model){
        List<Partido> partidos = partidoService.getPartidos(faseEnum);
        model.addAttribute("partidos", partidos);
        return "partidoList";
    }

    @GetMapping("/nuevoPartido")
    public String agregarPartido(Partido partido, Model model){
        return "partido";
    }

    @PostMapping("/guardar")
    public String guardar(Partido partido){
        partidoService.guardar(partido);
        return "redirect:/partido";
    }

}
