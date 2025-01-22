package com.jose.apiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jose.apiz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
