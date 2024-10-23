package com.example.controle_financeiro.service;

import com.example.controle_financeiro.model.ContaBancaria;
import com.example.controle_financeiro.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancaria> listarTodos(){
        return contaBancariaRepository.findAll();
    }

    public Optional<ContaBancaria> buscarPorId(Long id){
        return contaBancariaRepository.findById((id));
    }

    public ContaBancaria salvar(ContaBancaria contaBancaria){
        return contaBancariaRepository.save(contaBancaria);
    }

    public Optional<ContaBancaria> atualizar(Long id, ContaBancaria contaBancaria){
        return contaBancariaRepository.findById(id)
                .map(existente -> {
                    existente.setNome(contaBancaria.getNome());
                    existente.setSaldo(contaBancaria.getSaldo());
                    return contaBancariaRepository.save(existente);
                });
    }

    public void deletarPorId(Long id){
        contaBancariaRepository.deleteById(id);
    }
}
