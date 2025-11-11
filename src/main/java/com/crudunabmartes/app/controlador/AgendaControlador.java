package com.crudunabmartes.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudunabmartes.app.entidades.Agenda;
import com.crudunabmartes.app.repositorio.RepositorioAgenda;

@Controller
public class AgendaControlador {

    private final RepositorioAgenda repository;

    public AgendaControlador(RepositorioAgenda repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("agenda", new Agenda());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Agenda agenda) {
        repository.save(agenda);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("contactos", repository.findAll());
        return "listar";
    }
}