package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.CovidDto;
import ar.edu.utn.frc.tup.lciii.dtos.PorcentajeDto;
import ar.edu.utn.frc.tup.lciii.models.Covid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface CovidService {
    List<CovidDto> getAll();
    List<PorcentajeDto> getPorcentaje(String estado, LocalDate fecha);
    Covid postCaso(String estado, LocalDate fecha);
}
