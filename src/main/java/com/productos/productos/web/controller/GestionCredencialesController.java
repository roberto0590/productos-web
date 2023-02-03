package com.productos.productos.web.controller;

import com.productos.productos.web.model.Cliente;
import com.productos.productos.web.model.Usuario;
import com.productos.productos.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Controller
@RequestMapping("/registro")
public class GestionCredencialesController {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/registroUsuario")
    public String registroUsuario(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("usuario", new Usuario());
        return "page-user-register";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("usuario") Usuario usuario) throws Exception{
        Cliente cliente = new Cliente();
        cliente.setId_cliente(1);
        usuario.setEstado(true);
        usuario.setCliente(cliente);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usuario.getClave());
        usuario.setClave(encodedPassword);

        Usuario obj = service.registrar(usuario);

        // localhost:8080/pacientes/2
        //URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_usuario()).toUri();
        return "redirect:/registro/registrar/"+obj.getId_usuario();
    }

    @GetMapping("/registrar/{id}")
    public String registrar(@PathVariable Integer id,Model model) throws Exception{
        Cliente cliente = new Cliente();
        cliente.setId_cliente(1);
        Usuario obj =service.listarPorId(id);
        model.addAttribute("name", id);
        model.addAttribute("usuario", obj);
        return "page-user-register-complete";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
