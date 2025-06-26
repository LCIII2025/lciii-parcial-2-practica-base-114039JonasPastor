package ar.edu.utn.frc.tup.lciii.dtos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CovidDto {
    public String estado;
    public Long totalCasos;
    public Long totalPositivos;
}
