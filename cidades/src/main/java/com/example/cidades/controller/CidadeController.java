package com.example.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidades.domain.dto.cidade.CidadeRequestDTO;
import com.example.cidades.domain.dto.cidade.CidadeResponseDTO;
import com.example.cidades.domain.service.CidadeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cidades")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<CidadeResponseDTO>> obterTodasCidades() {
        return ResponseEntity.ok(cidadeService.obterTodasCidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeResponseDTO> obterCidadePorId(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.obterCidadePorId(id));
    }

    @PostMapping
    public ResponseEntity<CidadeResponseDTO> cadastrarCidade(@RequestBody CidadeRequestDTO dto) {
        CidadeResponseDTO responseDTO = cidadeService.cadastrarCidade(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeResponseDTO> atualizarCidade(@PathVariable Long id, @RequestBody CidadeRequestDTO dto) {
        CidadeResponseDTO responseDTO = cidadeService.atualizarCidade(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCidade(@PathVariable Long id) {
        cidadeService.deletarCidade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
