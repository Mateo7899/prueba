package com.crudunabmartes.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudunabmartes.app.entidades.Agenda;
import com.crudunabmartes.app.repositorio.RepositorioAgenda;

@Controller
public class AgendaControlador {

    private final RepositorioAgenda repo;

    public AgendaControlador(RepositorioAgenda repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Inicio");
        model.addAttribute("contenido", "home");
        return "base";
    }

    @GetMapping("/agregar")
    public String agregar(Model model) {
        model.addAttribute("agenda", new Agenda());
        model.addAttribute("titulo", "Nuevo contacto");
        model.addAttribute("contenido", "agregar");
        return "base";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Agenda a) {
        repo.save(a);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        model.addAttribute("titulo", "Listado");
        model.addAttribute("contenido", "listar");
        return "base";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("agenda", repo.findById(id).orElseThrow());
        model.addAttribute("titulo", "Editar contacto");
        model.addAttribute("contenido", "editar");
        return "base";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Agenda a) {
        repo.save(a);
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/listar";
    }

    @GetMapping("/estadisticas")
    public String estadisticas(Model model) {
        model.addAttribute("total", repo.count());
        model.addAttribute("titulo", "Estadísticas");
        model.addAttribute("contenido", "estadisticas");
        return "base";
    }

    @GetMapping("/acerca")
    public String acerca(Model model) {
        model.addAttribute("titulo", "Acerca de");
        model.addAttribute("contenido", "acerca");
        return "base";
    }
}
