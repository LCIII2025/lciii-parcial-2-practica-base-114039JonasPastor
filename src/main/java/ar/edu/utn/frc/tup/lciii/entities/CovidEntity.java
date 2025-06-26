package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "covids")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombreDelEstado;
    @Column
    private String sigla;
    @Column
    private LocalDate fecha;
    @Column
    private int totalDeCasos;
    @Column
    private int totalDePositivos;
    @Column
    private int totalDeHospitalizados;
}
