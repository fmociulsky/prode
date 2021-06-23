package io.fercha.prode.controller;

import io.fercha.prode.entity.FaseEnum;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.security.Rol;
import io.fercha.prode.security.Usuario;
import io.fercha.prode.service.ParticipanteService;
import io.fercha.prode.service.RolService;
import io.fercha.prode.service.UsuarioService;
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
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/participante")
public class ParticipanteController {

    @Autowired
    ParticipanteService participanteService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/nuevoParticipante")
    public String agregarParticipante(Participante participante, Model model){
        model.addAttribute("fases", FaseEnum.values());
        return "participante";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Participante participante, Errors errors, @RequestParam("foto") @Nullable byte[] fileByte) throws IOException {
        if(errors.hasErrors()) return "participante";
        participante.setFoto(fileByte);
        if(participante.getId() == null){
            participante.setPassword(participante.getUsuario().getPassword());
            final Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            participante.getUsuario().getRoles().add(rol);
            usuarioService.guardar(participante.getUsuario());
        }else{
            final Participante participantePersisted = participanteService.buscarPorId(participante.getId());
            Usuario usuario = participantePersisted.getUsuario();
            usuario.setUsername(participante.getUsuario().getUsername());
            participante.setUsuario(usuario);
            participante.setPassword(participantePersisted.getPassword());
        }
        participanteService.guardar(participante);
        return "redirect:/participante";
    }

    @GetMapping("/{id}")
    public String modificar(Participante participante, Model model){
        participante = participanteService.buscarPorId(participante.getId());
        model.addAttribute("participante", participante);
        model.addAttribute("fases", FaseEnum.values());
        return "participante";
    }

    @GetMapping("")
    public String listar(Model model){
        final List<Participante> participantes = participanteService.listar();
        model.addAttribute("participantes", participantes);
        model.addAttribute("fases", FaseEnum.values());
        return "participanteList";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Participante participante){
        participanteService.eliminar(participante);
        return "redirect:/participante";
    }



}
