package com.genjava11.AerolineaAppi.controller;

import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.model.Vuelo;
import com.genjava11.AerolineaAppi.service.PasajeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }


    @GetMapping
    public List<Pasajero> obtenerTodos() {
        return pasajeroService.findAll();
    }


    @GetMapping("/{id}")
    public Pasajero obtenerPorId(@PathVariable Long id) {
        return pasajeroService.findById(id);
    }

    @PostMapping
    public Pasajero crear(@RequestBody Pasajero pasajero) {
        return pasajeroService.save(pasajero);
    }


    @PutMapping("/{id}")
    public Pasajero actualizar(@PathVariable Long id, @RequestBody Pasajero datos) {
        return pasajeroService.update(id, datos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pasajero> patchPasajero(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        Pasajero actualizado = pasajeroService.patch(id, campos);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pasajeroService.delete(id);
    }

}
