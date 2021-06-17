package io.fercha.prode.controller;

import io.fercha.prode.FileUploadUtil;
import io.fercha.prode.entity.Participante;
import io.fercha.prode.service.ParticipanteService;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    public String guardar(Participante participante, @RequestParam("image") byte[] fileByte) throws IOException {
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
        List<Participante> participantes = participanteService.getParticipantes();
        model.addAttribute("participantes", participantes);
        return "participanteList";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Participante participante){
        participanteService.eliminar(participante);
        return "redirect:/participante";
    }



}
