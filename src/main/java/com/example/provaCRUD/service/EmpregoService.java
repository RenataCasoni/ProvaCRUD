package com.example.provaCRUD.service;

import com.example.provaCRUD.dto.EmpregoDTO;
import com.example.provaCRUD.model.Emprego;
import com.example.provaCRUD.repository.EmpregoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpregoService {
    private final EmpregoRepository empregoRepository;

    public EmpregoDTO criar(EmpregoDTO empregoDTO) {
        Emprego emprego = new Emprego();
        emprego.setEndereco(empregoDTO.getEndereco());

        Emprego salvo = empregoRepository.save(emprego);
        return toDTO(salvo);
    }

    public List<EmpregoDTO> listarTodos() {
        return empregoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EmpregoDTO buscarPorId(Long id) {
        return empregoRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Emprego não encontrado"));
    }

    public EmpregoDTO atualizar(Long id, EmpregoDTO empregoDTO) {
        Emprego emprego = empregoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprego não encontrado"));

        emprego.setEndereco(empregoDTO.getEndereco());

        Emprego atualizado = empregoRepository.save(emprego);
        return toDTO(atualizado);
    }

    public void deletar(Long id) {
        empregoRepository.deleteById(id);
    }

    private EmpregoDTO toDTO(Emprego emprego) {
        EmpregoDTO dto = new EmpregoDTO();
        dto.setId(emprego.getId());
        dto.setEndereco(emprego.getEndereco());
        return dto;
    }
}

