package com.projetointegrador.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.app.rest.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
