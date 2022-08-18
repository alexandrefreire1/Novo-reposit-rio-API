package com.swb.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swb.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
}
