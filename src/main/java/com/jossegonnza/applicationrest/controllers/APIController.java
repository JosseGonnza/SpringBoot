package com.jossegonnza.applicationrest.controllers;

import com.jossegonnza.applicationrest.dtos.Dato;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dato")
public class APIController {

    public List<Dato> listado = new LinkedList<>();
    public Long lastId = 0L;

    //Constructor para simular contenido
    public APIController() {
        this.listado.add(new Dato(1L, "Twitch"));
        this.lastId = 1L;
        this.listado.add(new Dato(2L, "YouTube"));
        this.lastId = 2L;
    }

    // GET /api/v1/dato/ -> Listado de datos
    @GetMapping("/")
    public List<Dato> index() {
        return this.listado;
    }

    // POST /api/v1/dato/ -> Listado de datos
    @PostMapping("/")
    public Dato create(@RequestBody Dato dato) {
        dato.setId(++this.lastId);
        this.listado.add(dato);
        return dato;
    }

    @GetMapping("/{id}")
    public Dato show(@PathVariable("id") Long id){
        return this.listado
                .stream()
                .filter(dato -> dato.getId().equals(id))
                .findFirst().orElse(new Dato());
    }

    @PatchMapping("/{id}")
    public Dato update(@PathVariable("id") Long id, @RequestBody Dato dato) {
        return this.listado
                .stream()
                .filter(datoDB -> datoDB.getId().equals(id))
                .findFirst()
                .map(datoDB -> {
                    datoDB.setCadena(dato.getCadena());
                    return datoDB;
                }).orElse(new Dato());
        //Al estar ya definido, necesitamos otro nombre para el dato con el que vamos a trabajar
    }

}
