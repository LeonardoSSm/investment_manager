package com.example.controle_financeiro.repository;

import com.example.controle_financeiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
