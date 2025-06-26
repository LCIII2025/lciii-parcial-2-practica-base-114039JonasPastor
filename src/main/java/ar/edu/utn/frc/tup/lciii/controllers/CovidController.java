package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.CovidDto;
import ar.edu.utn.frc.tup.lciii.dtos.PorcentajeDto;
import ar.edu.utn.frc.tup.lciii.models.Covid;
import ar.edu.utn.frc.tup.lciii.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CovidController {

    @Autowired
    private CovidService covidService;

    @GetMapping("/covid")
    public ResponseEntity<List<CovidDto>> getAll(){
        return ResponseEntity.ok(covidService.getAll());
    }

    @GetMapping("/covid/{estado}/{fecha}")
    public ResponseEntity<List<PorcentajeDto>> getByEstadoYFecha(@PathVariable String estado, @PathVariable LocalDate fecha){
        return ResponseEntity.ok(covidService.getPorcentaje(estado,fecha));
    }

    @PostMapping("/covid/{estado}/{fecha}")
    public ResponseEntity<Covid> createCovid(@PathVariable String estado, @PathVariable LocalDate fecha){
        return ResponseEntity.ok(covidService.postCaso(estado, fecha));
    }
}
