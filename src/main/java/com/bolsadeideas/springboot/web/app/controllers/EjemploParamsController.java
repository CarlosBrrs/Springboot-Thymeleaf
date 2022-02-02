package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    //Para pasar parametros del request mediante la URL por el método get
    //Se recibe en la URL así: localhost:8080/params/string?text=me%20quiero%20morir
    //---text es el nombre de la variable que se recibe en la firma

    @GetMapping("/string")
    public String param(@RequestParam(required = false, defaultValue = "valor por defecto") String text, Model model) {
        //Tambien se puede indicar en la anotación así: @RequestParam(name = "text"), required false envia null
        // a la variable si falta en la url, default envia un valor por defecto si falta en la URL

        model.addAttribute("resultado", "El texto enviado en la URL es: ".concat(text));
        return "params/view";       //Dentro de templates debe existir la carpeta params
    }

    @GetMapping("/")
    public String paramIndex() {
        return "params/paramIndex";
    }

    //Ejemplo con varios parámetros
    @GetMapping("/mix-params")
    public String mixParams(@RequestParam String myText, @RequestParam Integer number, Model model) {

        model.addAttribute("resultado", "El saludo enviado en la URL es: ".concat(myText).concat(" y el número es: ".concat(number.toString())));
        return "params/view";       //Dentro de templates debe existir la carpeta params
    }

    @GetMapping("/mix-params-servlet-request")
    public String mixParams(HttpServletRequest request, Model model) {
        //Los nombres de los parámetros son como se estan definiendo desde Thymeleaf
        String myText = request.getParameter("myText");
        Integer number = null;
        try {       //Se implementa try catch por si el parametro ingresado no es un numero
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }

        model.addAttribute("resultado", "El saludo enviado en la URL es: ".concat(myText).concat(" y el número es: ".concat(number.toString())));
        return "params/view";       //Dentro de templates debe existir la carpeta params
    }

}
