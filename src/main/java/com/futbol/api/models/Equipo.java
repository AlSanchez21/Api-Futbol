package com.futbol.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String nombre;
    
    @Column(nullable = false)
    private String pais;
    
    private int fundacion;
}
