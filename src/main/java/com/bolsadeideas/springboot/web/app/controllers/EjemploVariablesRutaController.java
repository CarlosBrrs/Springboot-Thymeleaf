package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String indexVariables (Model model) {
        model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
        return "variables/variablesIndex";
    }
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado por la ruta path variable es: ".concat(texto));
        return "variables/view";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String multipleVariables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado por la ruta path variable es: ".concat(texto)
                .concat(" y el número ingresado en el path es: ").concat(numero.toString()));
        return "variables/view";
    }

}
