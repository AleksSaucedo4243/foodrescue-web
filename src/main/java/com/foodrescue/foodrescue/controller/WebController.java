package com.foodrescue.foodrescue.controller;

import com.foodrescue.foodrescue.model.entity.Beneficiario;
import com.foodrescue.foodrescue.model.entity.Donacion;
import com.foodrescue.foodrescue.model.entity.Lote;
import com.foodrescue.foodrescue.service.BeneficiarioService;
import com.foodrescue.foodrescue.service.DonacionService;
import com.foodrescue.foodrescue.service.LoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class WebController {

    private final DonacionService donacionService;
    private final BeneficiarioService beneficiarioService;
    private final LoteService loteService;

    public WebController(DonacionService donacionService,
                         BeneficiarioService beneficiarioService,
                         LoteService loteService) {
        this.donacionService = donacionService;
        this.beneficiarioService = beneficiarioService;
        this.loteService = loteService;
    }

    @GetMapping
    public String panelPrincipal(Model model) {
        model.addAttribute("donaciones", donacionService.listarDonaciones());
        model.addAttribute("beneficiarios", beneficiarioService.listarBeneficiarios());
        model.addAttribute("lotes", loteService.listarLotes());
        return "index";
    }

    @PostMapping("/donaciones/guardar")
    public String guardarDonacion(@ModelAttribute Donacion donacion) {
        donacionService.guardarDonacion(donacion);
        return "redirect:/web";
    }

    @GetMapping("/donaciones/eliminar/{id}")
    public String eliminarDonacion(@PathVariable Long id) {
        donacionService.eliminarDonacion(id);
        return "redirect:/web";
    }

    @PostMapping("/beneficiarios/guardar")
    public String guardarBeneficiario(@ModelAttribute Beneficiario beneficiario) {
        beneficiarioService.guardarBeneficiario(beneficiario);
        return "redirect:/web";
    }

    @GetMapping("/beneficiarios/eliminar/{id}")
    public String eliminarBeneficiario(@PathVariable Long id) {
        beneficiarioService.eliminarBeneficiario(id);
        return "redirect:/web";
    }

    @PostMapping("/lotes/guardar")
    public String guardarLote(@ModelAttribute Lote lote) {
        loteService.guardarLote(lote);
        return "redirect:/web";
    }

    @GetMapping("/lotes/eliminar/{id}")
    public String eliminarLote(@PathVariable Long id) {
        loteService.eliminarLote(id);
        return "redirect:/web";
    }
}