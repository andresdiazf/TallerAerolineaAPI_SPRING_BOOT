package com.genjava11.AerolineaAppi.controller;
import com.genjava11.AerolineaAppi.DTO.ReservaRequestDTO;
import com.genjava11.AerolineaAppi.DTO.ReservaResponseDTO;
import com.genjava11.AerolineaAppi.model.Reserva;
import com.genjava11.AerolineaAppi.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas)")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {this.reservaService = reservaService;    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerReservaPorId(@PathVariable Long id) {
        ReservaResponseDTO reserva =  reservaService.findById(id);
        if(reserva == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reserva);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(@Valid @RequestBody ReservaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO actualizado =  reservaService.update(id, dto);
        if(actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
