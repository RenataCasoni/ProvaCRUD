package com.example.provaCRUD.controller;

import com.example.provaCRUD.dto.PessoaDTO;
import com.example.provaCRUD.service.PessoaService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTO criar(@Valid @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.criar(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listarTodos() {
        return pessoaService.listarTodos();
    }

    @GetMapping("/{id}")
    public PessoaDTO buscarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PessoaDTO atualizar(@PathVariable Long id, @Valid @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.atualizar(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
    }
}
