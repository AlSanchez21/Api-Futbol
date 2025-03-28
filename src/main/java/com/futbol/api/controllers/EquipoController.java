package com.futbol.api.controllers;

import com.futbol.api.models.Equipo;
import com.futbol.api.repositories.EquipoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/equipos")
public class EquipoController {

    private final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    // Obtener todos los equipos
    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    // Obtener equipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear equipo
    @PostMapping
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    // Actualizar equipo
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipoDetails) {
        return equipoRepository.findById(id).map(equipo -> {
            equipo.setNombre(equipoDetails.getNombre());
            equipo.setPais(equipoDetails.getPais());
            equipo.setFundacion(equipoDetails.getFundacion());
            equipoRepository.save(equipo);
            return ResponseEntity.ok(equipo);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        if (equipoRepository.existsById(id)) {
            equipoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
