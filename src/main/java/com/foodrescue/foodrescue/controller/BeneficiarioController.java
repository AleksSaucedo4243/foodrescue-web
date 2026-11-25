package com.foodrescue.foodrescue.controller;

import com.foodrescue.foodrescue.model.entity.Beneficiario;
import com.foodrescue.foodrescue.service.BeneficiarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping
    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioService.listarBeneficiarios();
    }

    @GetMapping("/{id}")
    public Optional<Beneficiario> obtenerPorId(@PathVariable Long id) {
        return beneficiarioService.obtenerPorId(id);
    }

    @PostMapping
    public Beneficiario guardarBeneficiario(@RequestBody Beneficiario beneficiario) {
        return beneficiarioService.guardarBeneficiario(beneficiario);
    }

    @PutMapping("/{id}")
    public Beneficiario actualizarBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        return beneficiarioService.actualizarBeneficiario(id, beneficiario);
    }

    @DeleteMapping("/{id}")
    public void eliminarBeneficiario(@PathVariable Long id) {
        beneficiarioService.eliminarBeneficiario(id);
    }
}