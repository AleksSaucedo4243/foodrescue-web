package com.foodrescue.foodrescue.service;

import com.foodrescue.foodrescue.model.entity.Beneficiario;
import com.foodrescue.foodrescue.repository.BeneficiarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    public Optional<Beneficiario> obtenerPorId(Long id) {
        return beneficiarioRepository.findById(id);
    }

    public Beneficiario guardarBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario actualizarBeneficiario(Long id, Beneficiario datosNuevos) {
        return beneficiarioRepository.findById(id).map(existente -> {
            existente.setNombre(datosNuevos.getNombre());
            existente.setDireccion(datosNuevos.getDireccion());
            existente.setTelefono(datosNuevos.getTelefono());
            existente.setTipo(datosNuevos.getTipo());
            return beneficiarioRepository.save(existente);
        }).orElse(null);
    }

    public void eliminarBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}