package com.genjava11.AerolineaAppi.controller;

import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.service.PasajeroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
