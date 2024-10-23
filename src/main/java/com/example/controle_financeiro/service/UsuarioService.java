package com.example.controle_financeiro.service;

import com.example.controle_financeiro.model.Usuario;
import com.example.controle_financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> atualizar(Long id, Usuario usuario){
        return usuarioRepository.findById(id)
                .map(existente -> {
                    existente.setNome(usuario.getNome());
                    existente.setEmail(usuario.getEmail());
                    existente.setSenha(usuario.getSenha());
                    existente.setPerfil(usuario.getPerfil());
                    return usuarioRepository.save(existente);
                });
    }

    public void deletarPorId(Long id){
        usuarioRepository.deleteById(id);
    }
}
