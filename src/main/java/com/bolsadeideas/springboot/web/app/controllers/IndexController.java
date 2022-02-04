package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.User;
import org.springframework.beans.factory.annotation.Value;
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

    //Anotación value trae valores desde application.properties y los inserta en las variables con el fin de desacoplar
    @Value("${text.indexController.index.titulo}")
    private String textIndex;

    @Value("${text.indexController.profile.titulo}")
    private String textProfile;

    @Value("${text.indexController.list.titulo}")
    private String textList;

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    @RequestMapping(value = "/index")
//    ---RequestMapping es por defecton tipo GET. Se puede omitir o indicar en method
//    ---value es el parametro por defecto, asi que se puede omitir y dejar solo la ruta
//    ---con llaves, puedo mapear diferentes rutas

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", textIndex);
        return "index";
    }

    /*
        ---Para pasar datos del controlador a la vista podemos pasar como argumento la interfaz Model, ModelMap,
           Map(con put y especificando los tipos de las llaves y valores) o ModelAndView (con addObject)

        @GetMapping({"/index","/","/home"})
        public String index (ModelMap model) {
            model.addAttribute("titulo", "Me quiero morir desde metodo index con ModelMap");
            return "index";
        }

        @GetMapping({"/index","/","/home"})
        public String index (Map<String, Object> map) {
            map.put("titulo", "Me quiero morir desde metodo index con Map");
            return "index";
        }

            public ModelAndView index (ModelAndView mv) {
            mv.addObject("titulo", "Me quiero morir desde metodo index con ModelAndView");
            mv.setViewName("index");
            return index;
        }

     */
    @RequestMapping("/profile")
    public String profile(Model model) {
        User user = User.builder().name("Carlos").lastname("Barrios").email("carlos@mail.com").build();
        model.addAttribute("titulo", textProfile.concat(user.getName()));
        model.addAttribute("usuario", user);
        return "profile";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> usersList = Arrays.asList(
                User.builder().name("Merquiluz").lastname("Ortiz").email("mortiz@mail.com").build(),
                User.builder().name("Andrés").lastname("Jimenez").email("andres@mail.com").build(),
                User.builder().name("Maria").lastname("Ferrer").email("maria@mail.com").build());
        /*
        Se puede crear con new ArrayList y .add
        usersList.(User.builder().name("Merquiluz").lastname("Ortiz").email("mortiz@mail.com").build());
        usersList.add(User.builder().name("Andrés").lastname("Jimenez").email("andres@mail.com").build());
        usersList.add(User.builder().name("Maria").lastname("Ferrer").email("maria@mail.com").build());*/
        model.addAttribute("usuarios", usersList);
        model.addAttribute("titulo", textList);
        return "list";
    }

    //ModelAttribute sirve para usar la lista en cualquiera de los métodos del controlador y no en un método en específico
    //Se pasa por parametro la llave y el metodo retorna el valor. Lo puede llamar cualquier template directamente
    @ModelAttribute("usuarios")
    public List<User> fillList() {

        List<User> usersList = Arrays.asList(
                User.builder().name("Merquiluz").lastname("Ortiz").email("mortiz@mail.com").build(),
                User.builder().name("Andrés").lastname("Jimenez").email("andres@mail.com").build(),
                User.builder().name("Maria").lastname("Ferrer").email("maria@mail.com").build());

        return usersList;
    }

}
