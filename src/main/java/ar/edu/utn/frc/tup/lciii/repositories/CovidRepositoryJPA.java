package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.dtos.CovidDto;
import ar.edu.utn.frc.tup.lciii.dtos.PorcentajeDto;
import ar.edu.utn.frc.tup.lciii.entities.CovidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CovidRepositoryJPA extends JpaRepository<CovidEntity, Long> {

    @Query("SELECT new ar.edu.utn.frc.tup.lciii.dtos.CovidDto(" +
            "c.nombreDelEstado, SUM(c.totalDeCasos), SUM(c.totalDePositivos)) " +
            "FROM CovidEntity c GROUP BY c.nombreDelEstado")
    List<CovidDto> obtenerTotalesPorEstado();

    @Query("SELECT new ar.edu.utn.frc.tup.lciii.dtos.PorcentajeDto(" +
            "c.nombreDelEstado, c.fecha, c.totalDeCasos, c.totalDePositivos) " +
            "FROM CovidEntity c WHERE c.nombreDelEstado = :estado AND c.fecha = :fecha")
    List<PorcentajeDto> obtenerPorcentajePorEstadoYFecha(
            @Param("estado") String estado,
            @Param("fecha") LocalDate fecha
    );
}
