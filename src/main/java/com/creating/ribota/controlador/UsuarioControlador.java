package com.creating.ribota.controlador;

import com.creating.ribota.modelo.Usuario;
import com.creating.ribota.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


//@RestController
//@RequestMapping(path = "api/v1/users")
@Controller
public class UsuarioControlador {

    //private IUsuarioServicio iUsuarioServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;
    /*public UsuarioControlador(IUsuarioServicio iUsuarioServicio) {
        this.iUsuarioServicio = iUsuarioServicio;
    }*/

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Formulario de Usuario");
        //model.addAttribute("usuarios", iUsuarioServicio.findAll());
        model.addAttribute("usuarios", usuarioServicio.getUsers());
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Formulario de UsuarioA");

        return "form";
    }

    //@RequestMapping(value = "/crear-usuario", method = RequestMethod.POST)
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String crearUsuario(Usuario usuario) {
        //iUsuarioServicio.save(usuario);
        Optional<Usuario> usuarioExistente = usuarioServicio.getUser(usuario.getId());
        if (usuarioExistente.isPresent()) {
            usuarioServicio.saveOrUpdate(usuario); // Actualiza el usuario existente
        } else {
            usuarioServicio.saveOrUpdate(usuario);
        }

        return "redirect:listar";
        //return ResponseEntity.ok("Usuario creado correctamente");
    }

    /*@GetMapping(value = "/form")
    public String crear(Map<String, Object> model) {
        model.put("titulo", "Formulario de UsuarioA");
        model.put("nombre", "testNombre");
        model.put("apellido", "testAp");
        return "form";
    }*/
}