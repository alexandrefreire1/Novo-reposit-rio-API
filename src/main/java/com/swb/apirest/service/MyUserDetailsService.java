package com.swb.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swb.apirest.models.Usuario;
import com.swb.apirest.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UserDetails loadUserByUsername(String nome) {
		Usuario user = usuarioRepository.findByUsername(nome);
		if(user==null) {
			throw new UsernameNotFoundException(nome);
		}
		return new MyUserPrincipal(user);
	}
}
