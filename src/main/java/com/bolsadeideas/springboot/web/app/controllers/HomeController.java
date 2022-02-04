package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*La diferencia entre redirect vs cargar una vista es que cuando se redirige reinicia la petición y todos
    los parametros que teniamos en el request se pierden (se reinician)
    Cargar una vista es pasar parametros y renderizar-cargar el HTML
    Cuando se redirige se reinicia y parte el proceso desde cero: Vuelve a ir al controlador, se ejecuta el metodo handler,
    se realizan las tareas que se tienen que hacer y se carga la vista
    Forward en vez de redirigir a otra ruta y reiniciar el request, lo que hace es que dentro del mismo request http va
    a ir al metodo handler que esta mapeado a esa ruta pero sin reiniciar y sin redirigir ni recargar la pagina, solamente
    por debajo*/

    //Al cargar el localhost:8080, va a redirigir a app/index
    @GetMapping("/")
    public String home() {
        return "redirect:/app/index";
    }

/*
    //Cargo el localhost:8080 y me va a enviar a Google
    //Puedo redirigir a otra pagina así:
    @GetMapping("/")
    public String home() {
        return "redirect:https://www.google.com";
    }*/

/*    //Con forward no me cambia la URL aunque si redirige a donde yo necesito
    //Forward se usa para rutas propias del proyecto, de Spring, de los controladores
    //No se puede hacer forward a rutas externas
    //Forward por debajo es ejecutar un request dispatcher del apiservlet y el metodo forward (RequestDispatcher.forward()
    @GetMapping("/")
    public String home() {
        return "forward:/app/index";
    }*/
}
