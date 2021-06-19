package io.fercha.prode.controller;

import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.entity.Partido;
import io.fercha.prode.entity.Pronostico;
import io.fercha.prode.entity.PronosticoForm;
import io.fercha.prode.service.ParticipanteService;
import io.fercha.prode.service.PartidoService;
import io.fercha.prode.service.PronosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pronostico")
public class PronosticoController {

    @Autowired
    PartidoService partidoService;

    @Autowired
    ParticipanteService participanteService;

    @Autowired
    PronosticoService pronosticoService;

    @GetMapping("")
    public String listar(FaseEnum faseEnum, Model model){
        PronosticoForm pronosticoForm = new PronosticoForm();
        final List<Partido> partidos = partidoService.getPartidos(faseEnum);
        //Esto se va a reemplazar por el usuario
        final Participante participante = participanteService.listar().get(0);
        final List<Pronostico> pronosticos = pronosticoService.listar(participante).stream().filter(pronostico ->
                partidos.stream().anyMatch(p-> p.getId().equals(pronostico.getPartido().getId())))
                .collect(Collectors.toList());
        pronosticoForm.addAll(pronosticos);
        model.addAttribute("form", pronosticoForm);
        model.addAttribute("fase", faseEnum);
        return "pronosticoList";
    }

    @PostMapping("/guardar")
    public String guardar(PronosticoForm pronosticoForm, Errors errors, @RequestParam FaseEnum faseEnum){
        if(errors.hasErrors()) return "partido";
        pronosticoService.guardarPronosticos(pronosticoForm);
        return "redirect:/pronostico?faseEnum="+faseEnum;
    }
}
