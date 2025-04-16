package com.example.provaCRUD.service;


import com.example.provaCRUD.dto.PessoaDTO;
import com.example.provaCRUD.model.Pessoa;
import com.example.provaCRUD.repository.EmpregoRepository;
import com.example.provaCRUD.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EmpregoRepository empregoRepository;

    @Transactional
    public PessoaDTO criar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setIdade(pessoaDTO.getIdade());

        if (pessoaDTO.getEmpregoId() != null) {
            empregoRepository.findById(pessoaDTO.getEmpregoId())
                    .ifPresent(pessoa::setEmprego);
        }

        Pessoa salvo = pessoaRepository.save(pessoa);
        return toDTO(salvo);
    }

    public List<PessoaDTO> listarTodos() {
        return pessoaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO buscarPorId(Long id) {
        return pessoaRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    @Transactional
    public PessoaDTO atualizar(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setIdade(pessoaDTO.getIdade());

        if (pessoaDTO.getEmpregoId() != null) {
            empregoRepository.findById(pessoaDTO.getEmpregoId())
                    .ifPresent(pessoa::setEmprego);
        } else {
            pessoa.setEmprego(null);
        }

        Pessoa atualizado = pessoaRepository.save(pessoa);
        return toDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    private PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setIdade(pessoa.getIdade());
        if (pessoa.getEmprego() != null) {
            dto.setEmpregoId(pessoa.getEmprego().getId());
        }
        return dto;
    }
}