package com.swb.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swb.apirest.models.Usuario;
import com.swb.apirest.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Smart Water Box")
@CrossOrigin(origins="*")
public class UsuarioResource {

	@Autowired
	UsuarioRepository UsuarioRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	//Listar Usuários
	@GetMapping("/usuario")
	@ApiOperation(value="Retorna uma Lista de Usuários")
	public ResponseEntity<List<Usuario>> listaUsuario(){
		return ResponseEntity.ok().body(UsuarioRepository.findAll());
	}
	
	//Mostrar Usuário Específico
	@GetMapping("/usuario/{id}")
	@ApiOperation(value="Retorna um Usuário Específico")
	public  ResponseEntity<Optional<Usuario>> UnicoUsuario(@PathVariable(value="id") long id){
		return ResponseEntity.ok().body(UsuarioRepository.findById(id));
	}
	
	//Salvar Novo Usuário
	@PostMapping("/usuario")
	@ApiOperation(value="Salva um Novo Usuário")
	public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
		Usuario user = new Usuario();
		user.setNome(usuario.getNome());
		user.setEmail(usuario.getEmail());
		user.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		return ResponseEntity.ok().body(UsuarioRepository.save(user));
	}
	
	//Deletar Usuário
	@DeleteMapping("/usuario")
	@ApiOperation(value="Deleta um Usuário")
	public ResponseEntity<Void> deletaUsuario(@RequestBody Usuario usuario) {
		UsuarioRepository.delete(usuario);
		return ResponseEntity.noContent().build();
	}
	
	//Atualizar Usuário Existente
	@PutMapping("/usuario")
	@ApiOperation(value="Atualiza um Usuário Existente")
	public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(UsuarioRepository.save(usuario));
	}


}
