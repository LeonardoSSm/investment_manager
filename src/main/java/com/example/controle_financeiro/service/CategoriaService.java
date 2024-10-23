package com.example.controle_financeiro.service;

import com.example.controle_financeiro.model.Categoria;
import com.example.controle_financeiro.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id){
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> atualizar(Long id, Categoria categoria){
        return categoriaRepository.findById(id)
                .map(existente -> {
                    existente.setNome(categoria.getNome());
                    existente.setTipo(categoria.getTipo());
                    return categoriaRepository.save(existente);
                });
    }

    public void deletarPorId(Long id){
        categoriaRepository.deleteById(id);
    }
}
