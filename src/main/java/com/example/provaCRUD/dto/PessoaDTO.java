package com.example.provaCRUD.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private Long empregoId;
}