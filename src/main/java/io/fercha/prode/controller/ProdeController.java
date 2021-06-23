package io.fercha.prode.controller;

import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.entity.Partido;
import io.fercha.prode.security.Usuario;
import io.fercha.prode.service.ParticipanteService;
import io.fercha.prode.service.PartidoService;
import io.fercha.prode.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProdeController {

    @Autowired
    ParticipanteService participanteService;

    @Autowired
    PartidoService partidoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user){
        final List<Participante> participantes = participanteService.listar();
        model.addAttribute("participantes", participantes);
        model.addAttribute("fases", FaseEnum.values());
        return "index";
    }

}
