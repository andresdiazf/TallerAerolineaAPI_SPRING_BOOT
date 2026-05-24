package com.genjava11.AerolineaAppi.controller;

import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.model.Vuelo;
import com.genjava11.AerolineaAppi.service.PasajeroService;
import com.genjava11.AerolineaAppi.service.VueloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {


    private final PasajeroService pasajeroService; // inversion de control IoC

    @Autowired // inyeccion dependencias
    public PasajeroController(PasajeroService pasajeroService) {this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerTodos(){return ResponseEntity.ok(pasajeroService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id) {
        Pasajero pasajero = pasajeroService.findById(id);
        if (pasajero == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pasajero);
    }

    @PostMapping
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pasajeroService.save(pasajero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizar(@PathVariable Long id,
                                            @Valid @RequestBody Pasajero datos) {
        Pasajero actualizado = pasajeroService.update(id, datos);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
