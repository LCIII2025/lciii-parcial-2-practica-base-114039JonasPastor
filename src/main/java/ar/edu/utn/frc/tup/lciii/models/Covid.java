package ar.edu.utn.frc.tup.lciii.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Covid {
    private String nombreDelEstado;
    private String sigla;
    private LocalDate fecha;
    private int totalDeCasos;
    private int totalDePositivos;
    private int totalDeHospitalizados;
}
