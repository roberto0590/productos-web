package com.productos.productos.web.controller;

import com.productos.productos.web.model.Devocionales;
import com.productos.productos.web.service.IDevocionalesService;
import com.productos.productos.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/devocionales")
public class DevocionalesController {

    @Autowired
    private IDevocionalesService service;

    @GetMapping("/estudio")
    public String principal(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws Exception {
        List<Devocionales> devocionales = service.listar();
        model.addAttribute("devocionales", devocionales);
        model.addAttribute("name", name);
        return "devocionales";
    }

    @GetMapping("/devocional")
    public String devocional(@RequestParam(name="id", required=false) int id, Model model) throws Exception {
        Devocionales devocional = service.listarPorId(id);
        model.addAttribute("devocional", devocional);
        return "devocional";
    }

}
