package com.foodrescue.foodrescue.service;

import com.foodrescue.foodrescue.model.entity.Donacion;
import com.foodrescue.foodrescue.repository.DonacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionService {

    private final DonacionRepository donacionRepository;

    public DonacionService(DonacionRepository donacionRepository) {
        this.donacionRepository = donacionRepository;
    }

    public List<Donacion> listarDonaciones() {
        return donacionRepository.findAll();
    }

    public Optional<Donacion> obtenerPorId(Long id) {
        return donacionRepository.findById(id);
    }

    public Donacion guardarDonacion(Donacion donacion) {
        return donacionRepository.save(donacion);
    }

    public Donacion actualizarDonacion(Long id, Donacion datosNuevos) {
        return donacionRepository.findById(id).map(donacionExistente -> {
            donacionExistente.setDescripcion(datosNuevos.getDescripcion());
            donacionExistente.setCantidad(datosNuevos.getCantidad());
            donacionExistente.setFechaVencimiento(datosNuevos.getFechaVencimiento());
            donacionExistente.setEstado(datosNuevos.getEstado());
            return donacionRepository.save(donacionExistente);
        }).orElse(null);
    }

    public void eliminarDonacion(Long id) {
        donacionRepository.deleteById(id);
    }
}