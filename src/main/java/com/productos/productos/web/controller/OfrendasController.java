package com.productos.productos.web.controller;

import com.productos.productos.web.model.Devocionales;
import com.productos.productos.web.model.OfrendasGE;
import com.productos.productos.web.service.IOfrendasGEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ofrendas")
public class OfrendasController {

    @Autowired
    private IOfrendasGEService service;

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("ofrendasGE") OfrendasGE ofrendasGE, Model model) throws Exception{
        LocalDate localDateTime = LocalDate.now();
        ofrendasGE.setFecha(localDateTime);
        service.registrar(ofrendasGE);
        List<OfrendasGE> onfrendasGElist= service.listar();
        model.addAttribute("onfrendasGElist", onfrendasGElist);
        return "redirect:/ofrendas/administracionOfrendasGE";
    }

    @GetMapping("/administracionOfrendasGE")
    public String administracionOfrendasGE(Model model) throws Exception{
        List<OfrendasGE> ofrendasGE= service.listar();
        BigDecimal totalIngreso=service.totalIngreso();
        BigDecimal totalEgreso=service.totalEgreso();
        totalIngreso=totalIngreso==null?new BigDecimal("0"):totalIngreso;
        totalEgreso=totalEgreso==null?new BigDecimal("0"):totalEgreso;
        BigDecimal ofrendaTotal=totalIngreso.subtract(totalEgreso);
        model.addAttribute("ofrendaGE", new OfrendasGE());
        model.addAttribute("onfrendasGElist", ofrendasGE);
        model.addAttribute("totalIngreso",totalIngreso);
        model.addAttribute("totalEgreso",totalEgreso);
        model.addAttribute("ofrendaTotal",ofrendaTotal);

        return "administracion-ofrendasGE";
    }

}
