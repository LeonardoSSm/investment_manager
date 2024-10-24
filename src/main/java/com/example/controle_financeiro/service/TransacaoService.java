package com.example.controle_financeiro.service;

import com.example.controle_financeiro.model.Transacao;
import com.example.controle_financeiro.repository.TransacaoRepository;
import com.example.controle_financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;


    public List<Transacao> listarTodos(){
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> buscarPorId(Long id){
        return transacaoRepository.findById(id);
    }

    public Transacao salvar(Transacao transacao){
        return transacaoRepository.save(transacao);
    }

    public Optional<Transacao> atualizar(Long id, Transacao transacao){
        return transacaoRepository.findById(id)
                .map(existente -> {
                    existente.setDescricao(transacao.getDescricao());
                    existente.setValor(transacao.getValor());
                    existente.setTipo(transacao.getTipo());
                    return transacaoRepository.save(existente);
                });
    }

    public void deletarPorId(Long id){
        transacaoRepository.deleteById(id);
    }
}
