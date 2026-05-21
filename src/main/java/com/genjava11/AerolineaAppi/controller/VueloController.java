package com.genjava11.AerolineaAppi.controller;

import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.model.Vuelo;
import com.genjava11.AerolineaAppi.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }
    @GetMapping
    public List<Vuelo> obtenerTodos() {
       return vueloService.findAll();
    }

}


