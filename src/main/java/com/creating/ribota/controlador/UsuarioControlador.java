package com.creating.ribota.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
@Controller
public class UsuarioControlador {
    @GetMapping(value = "/form")
    public String crear(Map<String, Object> model) {
        model.put("titulo", "Formulario de Usuario");
        return "form";
    }
}
