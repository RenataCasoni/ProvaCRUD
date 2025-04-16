package com.example.provaCRUD.repository;

import com.example.provaCRUD.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}