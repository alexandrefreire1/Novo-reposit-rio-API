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
	
	public UserDetails loadUserByUsername(String email) {
		Usuario user = usuarioRepository.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException(email);
		}
		return new MyUserPrincipal(user);
	}
}
