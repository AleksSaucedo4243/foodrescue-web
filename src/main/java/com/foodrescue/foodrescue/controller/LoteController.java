package com.foodrescue.foodrescue.controller;

import com.foodrescue.foodrescue.model.entity.Lote;
import com.foodrescue.foodrescue.service.LoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lotes")
public class LoteController {

    private final LoteService loteService;

    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    @GetMapping
    public List<Lote> listarLotes() {
        return loteService.listarLotes();
    }

    @GetMapping("/{id}")
    public Optional<Lote> obtenerPorId(@PathVariable Long id) {
        return loteService.obtenerPorId(id);
    }

    @PostMapping
    public Lote guardarLote(@RequestBody Lote lote) {
        return loteService.guardarLote(lote);
    }

    @PutMapping("/{id}")
    public Lote actualizarLote(@PathVariable Long id, @RequestBody Lote lote) {
        return loteService.actualizarLote(id, lote);
    }

    @DeleteMapping("/{id}")
    public void eliminarLote(@PathVariable Long id) {
        loteService.eliminarLote(id);
    }
}