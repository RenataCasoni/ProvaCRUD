package com.example.provaCRUD.controller;


import com.example.provaCRUD.dto.EmpregoDTO;
import com.example.provaCRUD.service.EmpregoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empregos")
@RequiredArgsConstructor
public class EmpregoController {
    private final EmpregoService empregoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpregoDTO criar(@Valid @RequestBody EmpregoDTO empregoDTO) {
        return empregoService.criar(empregoDTO);
    }

    @GetMapping
    public List<EmpregoDTO> listarTodos() {
        return empregoService.listarTodos();
    }

    @GetMapping("/{id}")
    public EmpregoDTO buscarPorId(@PathVariable Long id) {
        return empregoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public EmpregoDTO atualizar(@PathVariable Long id, @Valid @RequestBody EmpregoDTO empregoDTO) {
        return empregoService.atualizar(id, empregoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        empregoService.deletar(id);
    }
}