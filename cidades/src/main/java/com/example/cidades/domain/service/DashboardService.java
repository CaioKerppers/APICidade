package com.example.cidades.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cidades.domain.dto.cidade.CidadeResponseDTO;
import com.example.cidades.domain.dto.dashboard.DashboardResponseDTO;

@Service
public class DashboardService {
    @Autowired
    private CidadeService cidadeService;

    public DashboardResponseDTO obterDadosCidades() {
        List<CidadeResponseDTO> cidades = cidadeService.obterTodasCidades();
        return new DashboardResponseDTO(cidades);
    }
}
