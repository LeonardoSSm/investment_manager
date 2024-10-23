package com.example.controle_financeiro.repository;

import com.example.controle_financeiro.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
}
