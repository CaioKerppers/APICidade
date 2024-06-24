package com.example.cidades.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.cidades.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    // Encontra todas as cidades por estado
    List<Cidade> findByEstado(String estado);
    
    // Encontra todas as cidades por país
    List<Cidade> findByPais(String pais);
    
    // Encontra cidades por população maior que um determinado valor
    List<Cidade> findByPopulacaoGreaterThan(Long populacao);

    // Encontra cidades por língua
    List<Cidade> findByLingua(String lingua);
}
