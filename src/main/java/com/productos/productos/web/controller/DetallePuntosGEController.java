package com.productos.productos.web.controller;

import com.productos.productos.web.dto.DetallePuntosGEDTO;
import com.productos.productos.web.model.Cliente;
import com.productos.productos.web.model.DetallePuntosGE;
import com.productos.productos.web.model.Usuario;
import com.productos.productos.web.service.IDetallePuntosGEService;
import com.productos.productos.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/puntosGE")
public class DetallePuntosGEController {

    @Autowired
    private IUsuarioService service;
    @Autowired
    private IDetallePuntosGEService detallePuntosGEService;

    @GetMapping("/administracionPuntosGE")
    public String registroUsuario(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws Exception{
        model.addAttribute("name", name);
        List<Usuario> usuarios= service.listar();
        model.addAttribute("detallePuntosGE", new DetallePuntosGE());
        model.addAttribute("usuarios", usuarios);

        List<DetallePuntosGE> detallesPuntosGE=detallePuntosGEService.findByUser_name(usuarios.get(0).getUser_name());
        model.addAttribute("puntosGE", detallesPuntosGE);

        return "administracion-punstosGE";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("detallePuntosGE") DetallePuntosGEDTO detallePuntosGE, Model model) throws Exception{

        LocalDate localDateTime = LocalDate.now();
        Usuario usuario=service.findByUser_name(detallePuntosGE.getUsuario());

        DetallePuntosGE detallePuntosGE1 = new DetallePuntosGE();
        detallePuntosGE1.setPuntosGE(detallePuntosGE.getPuntosGE());
        detallePuntosGE1.setUsuario(usuario);
        detallePuntosGE1.setDecripcion(detallePuntosGE.getDecripcion());
        detallePuntosGE1.setFecha(localDateTime);
        detallePuntosGEService.registrar(detallePuntosGE1);
        List<Usuario> usuarios= service.listar();
        model.addAttribute("detallePuntosGE", new DetallePuntosGE());
        model.addAttribute("usuarios", usuarios);

        List<DetallePuntosGE> detallesPuntosGE=detallePuntosGEService.findByUser_name(detallePuntosGE.getUsuario());
        model.addAttribute("puntosGE", detallesPuntosGE);
        // localhost:8080/pacientes/2
        //URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_usuario()).toUri();
        return "administracion-punstosGE";
    }

    @PostMapping("/cargarDetallePuntosGE")
    public @ResponseBody  List<DetallePuntosGE> cargarDetallePuntosGE(@RequestParam(name = "usuario") String usuario, Model model) throws Exception {

        List<DetallePuntosGE> detallesPuntosGE=detallePuntosGEService.findByUser_name(usuario);
        model.addAttribute("puntosGE", detallesPuntosGE);
        // localhost:8080/pacientes/2
        //URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_usuario()).toUri();
        return detallesPuntosGE;
    }


    @GetMapping("/detalle/{id}")
    public String registrar(@PathVariable Integer id,Model model) throws Exception{
        Cliente cliente = new Cliente();
        cliente.setId_cliente(1);
        Usuario obj =service.listarPorId(id);
        model.addAttribute("name", id);
        model.addAttribute("usuario", obj);
        return "detallePuntosGE";
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
