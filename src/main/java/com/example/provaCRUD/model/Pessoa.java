package com.example.provaCRUD.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "emprego_id")
    private Emprego emprego;
}
