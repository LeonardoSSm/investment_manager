package com.example.controle_financeiro.repository;

import com.example.controle_financeiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Object> findByEmail(String email);
}
