package com.foodrescue.foodrescue.controller;

import com.foodrescue.foodrescue.model.entity.Donacion;
import com.foodrescue.foodrescue.service.DonacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donaciones")
public class DonacionController {

    private final DonacionService donacionService;

    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping
    public List<Donacion> listarDonaciones() {
        return donacionService.listarDonaciones();
    }

    @GetMapping("/{id}")
    public Optional<Donacion> obtenerPorId(@PathVariable Long id) {
        return donacionService.obtenerPorId(id);
    }

    @PostMapping
    public Donacion guardarDonacion(@RequestBody Donacion donacion) {
        return donacionService.guardarDonacion(donacion);
    }

    @PutMapping("/{id}")
    public Donacion actualizarDonacion(@PathVariable Long id, @RequestBody Donacion donacion) {
        return donacionService.actualizarDonacion(id, donacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarDonacion(@PathVariable Long id) {
        donacionService.eliminarDonacion(id);
    }
}