package com.example.controle_financeiro.controller;

import com.example.controle_financeiro.model.ContaBancaria;
import com.example.controle_financeiro.repository.ContaBancariaRepository;
import com.example.controle_financeiro.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping
    public List<ContaBancaria> listarTodos(){
        return contaBancariaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> buscarPorId(@PathVariable Long id){
        return contaBancariaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContaBancaria salvar(@RequestBody ContaBancaria contaBancaria){
        return contaBancariaService.salvar(contaBancaria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaBancaria> atualizar(@PathVariable Long id, @RequestBody ContaBancaria contaBancaria){
        return contaBancariaService.atualizar(id, contaBancaria)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        contaBancariaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
