package com.avaliacao.web.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.web.avaliacao.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByNome(String username);

}
