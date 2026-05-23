package com.genjava11.AerolineaAppi.controller;

import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.model.Vuelo;
import com.genjava11.AerolineaAppi.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Vuelo obtenerPorId(@PathVariable Long id) {
        return vueloService.findById(id);
    }

    @PostMapping
    public Vuelo crear(@RequestBody Vuelo vuelo) {
        return vueloService.save(vuelo);
    }

    @PutMapping("/{id}")
    public Vuelo actualizar(@PathVariable Long id, @RequestBody Vuelo datos) {
        return vueloService.update(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        vueloService.delete(id);
    }

}


