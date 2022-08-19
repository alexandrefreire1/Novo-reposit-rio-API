package com.swb.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//Listar Usuários
	@GetMapping("/usuario")
	@ApiOperation(value="Retorna uma Lista de Usuários")
	public List<Usuario> listaUsuario(){
		return UsuarioRepository.findAll();
	}
	
	//Mostrar Usuário Específico
	@GetMapping("/usuario/{id}")
	@ApiOperation(value="Retorna um Usuário Específico")
	public Optional<Usuario> UnicoUsuario(@PathVariable(value="id") long id){
		return UsuarioRepository.findById(id);
	}
	
	//Salvar Novo Usuário
	@PostMapping("/usuario")
	@ApiOperation(value="Salva um Novo Usuário")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return UsuarioRepository.save(usuario);
	}
	
	//Deletar Usuário
	@DeleteMapping("/usuario")
	@ApiOperation(value="Deleta um Usuário")
	public void deletaUsuario(@RequestBody Usuario usuario) {
		UsuarioRepository.delete(usuario);
	}
	
	//Atualizar Usuário Existente
	@PutMapping("/usuario")
	@ApiOperation(value="Atualiza um Usuário Existente")
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return UsuarioRepository.save(usuario);
	}
	
	
}
