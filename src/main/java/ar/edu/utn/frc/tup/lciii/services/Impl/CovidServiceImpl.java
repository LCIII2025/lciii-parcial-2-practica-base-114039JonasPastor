package ar.edu.utn.frc.tup.lciii.services.Impl;

import ar.edu.utn.frc.tup.lciii.dtos.CovidDto;
import ar.edu.utn.frc.tup.lciii.dtos.PorcentajeDto;
import ar.edu.utn.frc.tup.lciii.entities.CovidEntity;
import ar.edu.utn.frc.tup.lciii.models.Covid;
import ar.edu.utn.frc.tup.lciii.repositories.CovidRepositoryJPA;
import ar.edu.utn.frc.tup.lciii.services.CovidService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidServiceImpl implements CovidService {

    @Autowired
    private CovidRepositoryJPA repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CovidDto> getAll() {
        return repository.obtenerTotalesPorEstado();
    }

    @Override
    public List<PorcentajeDto> getPorcentaje(String estado, LocalDate fecha) {
        return repository.obtenerPorcentajePorEstadoYFecha(estado, fecha);
    }

    @Override
    public Covid postCaso(String estado, LocalDate fecha) {
        CovidEntity caso = new CovidEntity();
        caso.setNombreDelEstado(estado);
        caso.setFecha(fecha);
        repository.save(caso);
        return modelMapper.map(caso, Covid.class);
    }
}
