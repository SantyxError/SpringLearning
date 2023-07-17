package com.bolsaideas.springboot.web.app.controllers;

import models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola spring con model!");
        return "index";
    }


    @RequestMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Andrés");
        usuario.setApellido("Gómez");
        usuario.setEmail("andres@correo.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {


        model.addAttribute("titulo", "Listado de Usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarusuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Andrés", "Gómez", "andres@correo.com"),
                new Usuario("Carlos", "Gómez", "carlos@correo.com"),
                new Usuario("Enrique", "Gómez", "enrique@correo.com"),
                new Usuario("Tomás", "Gómez", "tomas@correo.com")
        );

        return usuarios;
    }
}