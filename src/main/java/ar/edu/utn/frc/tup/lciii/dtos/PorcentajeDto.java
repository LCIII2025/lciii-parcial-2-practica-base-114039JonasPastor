package ar.edu.utn.frc.tup.lciii.dtos;

import java.time.LocalDate;

public class PorcentajeDto {
    public LocalDate fecha;
    public String estado;
    public Integer  totalCasos;
    public Integer  totalPositivos;
    public Double porcentaje;

    public PorcentajeDto(String estado, LocalDate fecha, Integer  totalCasos, Integer  totalPositivos) {
        this.estado = estado;
        this.fecha = fecha;
        this.totalCasos = totalCasos;
        this.totalPositivos = totalPositivos;
        this.porcentaje = (totalCasos == 0) ? 0.0 : (totalPositivos * 100.0) / totalCasos;
    }
}
