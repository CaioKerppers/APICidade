package com.example.cidades.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cidades.domain.model.Usuario;

public interface UsuarioRepository extends 
    JpaRepository<Usuario, Long> {
       
        Optional<Usuario> findByEmail(String email);
    
}
