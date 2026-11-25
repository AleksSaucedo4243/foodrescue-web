package com.foodrescue.foodrescue.service;

import com.foodrescue.foodrescue.model.entity.Lote;
import com.foodrescue.foodrescue.repository.LoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteService {

    private final LoteRepository loteRepository;

    public LoteService(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    public List<Lote> listarLotes() {
        return loteRepository.findAll();
    }

    public Optional<Lote> obtenerPorId(Long id) {
        return loteRepository.findById(id);
    }

    public Lote guardarLote(Lote lote) {
        return loteRepository.save(lote);
    }

    public Lote actualizarLote(Long id, Lote datosNuevos) {
        return loteRepository.findById(id).map(existente -> {
            existente.setCodigoLote(datosNuevos.getCodigoLote());
            existente.setProducto(datosNuevos.getProducto());
            existente.setCantidadCajas(datosNuevos.getCantidadCajas());
            existente.setFechaCaducidad(datosNuevos.getFechaCaducidad());
            existente.setUbicacionAlmacen(datosNuevos.getUbicacionAlmacen());
            return loteRepository.save(existente);
        }).orElse(null);
    }

    public void eliminarLote(Long id) {
        loteRepository.deleteById(id);
    }
}