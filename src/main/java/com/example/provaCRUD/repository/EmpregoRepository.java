package com.example.provaCRUD.repository;

import com.example.provaCRUD.model.Emprego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregoRepository extends JpaRepository<Emprego, Long> {
}