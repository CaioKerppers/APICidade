package com.example.cidades.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cidades.domain.model.Cidade;
import com.example.cidades.domain.repository.CidadeRepository;
import com.example.cidades.domain.dto.cidade.CidadeRequestDTO;
import com.example.cidades.domain.dto.cidade.CidadeResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeResponseDTO> obterTodasCidades() {
        return cidadeRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public CidadeResponseDTO obterCidadePorId(Long id) {
        Optional<Cidade> cidadeOpt = cidadeRepository.findById(id);
        return cidadeOpt.map(this::converterParaDTO).orElse(null);
    }

    public CidadeResponseDTO cadastrarCidade(CidadeRequestDTO cidadeRequestDTO) {
        Cidade cidade = new Cidade();
        cidade.setNome(cidadeRequestDTO.getNome());
        cidade.setPais(cidadeRequestDTO.getPais());
        cidade.setEstado(cidadeRequestDTO.getEstado());
        cidade.setPopulacao(cidadeRequestDTO.getPopulacao());
        cidade.setLingua(cidadeRequestDTO.getLingua());
        cidade.setAnoDeCriacao(cidadeRequestDTO.getAnoDeCriacao());
        cidadeRepository.save(cidade);
        return converterParaDTO(cidade);
    }

    public CidadeResponseDTO atualizarCidade(Long id, CidadeRequestDTO cidadeRequestDTO) {
        Optional<Cidade> cidadeOpt = cidadeRepository.findById(id);
        if (cidadeOpt.isPresent()) {
            Cidade cidade = cidadeOpt.get();
            cidade.setNome(cidadeRequestDTO.getNome());
            cidade.setPais(cidadeRequestDTO.getPais());
            cidade.setEstado(cidadeRequestDTO.getEstado());
            cidade.setPopulacao(cidadeRequestDTO.getPopulacao());
            cidade.setLingua(cidadeRequestDTO.getLingua());
            cidade.setAnoDeCriacao(cidadeRequestDTO.getAnoDeCriacao());
            cidadeRepository.save(cidade);
            return converterParaDTO(cidade);
        }
        return null;
    }

    public void deletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }

    private CidadeResponseDTO converterParaDTO(Cidade cidade) {
        CidadeResponseDTO dto = new CidadeResponseDTO();
        dto.setId(cidade.getId());
        dto.setNome(cidade.getNome());
        dto.setPais(cidade.getPais());
        dto.setEstado(cidade.getEstado());
        dto.setPopulacao(cidade.getPopulacao());
        dto.setLingua(cidade.getLingua());
        dto.setAnoDeCriacao(cidade.getAnoDeCriacao());
        return dto;
    }
}
