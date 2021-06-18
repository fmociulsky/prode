package io.fercha.prode.controller;

import io.fercha.prode.entity.Participante;
import io.fercha.prode.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/participante")
public class ParticipanteController {

    @Autowired
    ParticipanteService participanteService;

    @GetMapping("/nuevoParticipante")
    public String agregarParticipante(Participante participante){
        return "participante";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Participante participante, Errors errors, @RequestParam("foto") byte[] fileByte) throws IOException {
        if(errors.hasErrors()) return "participante";
        participante.setFoto(fileByte);
        participanteService.guardar(participante);
        return "redirect:/participante";
    }

    @GetMapping("/{id}")
    public String modificar(Participante participante, Model model){
        participante = participanteService.buscarPorId(participante.getId());
        model.addAttribute("participante", participante);
        return "participante";
    }

    @GetMapping("")
    public String listar(Model model){
        final List<Participante> participantes = participanteService.listar();
        model.addAttribute("participantes", participantes);
        return "participanteList";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Participante participante){
        participanteService.eliminar(participante);
        return "redirect:/participante";
    }



}
