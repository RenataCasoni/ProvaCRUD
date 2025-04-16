package com.example.provaCRUD.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Emprego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;

    @OneToMany(mappedBy = "emprego")
    private List<Pessoa> pessoas;
}