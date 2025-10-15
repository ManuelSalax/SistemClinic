package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.sistemclinc.sistemclinc.Domain.model.Seguridad.Usuario;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByUsername(String username);
    List<Usuario> findAll();
    void deleteById(Long id);
}
