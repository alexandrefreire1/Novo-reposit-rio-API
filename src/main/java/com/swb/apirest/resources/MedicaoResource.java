package com.swb.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swb.apirest.models.MedicaoAgua;
import com.swb.apirest.repository.MedicaoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Smart Water Box")
@CrossOrigin(origins="*")
public class MedicaoResource {

	@Autowired
	MedicaoRepository MedicaoRepository;
	
	@GetMapping("/agua/listar")
	@ApiOperation(value="Retorna uma Lista de Usuários")
	public List<MedicaoAgua> listaMedicao(){
		return MedicaoRepository.findAll();
	}
	
	@GetMapping("/agua/{id}")
	@ApiOperation(value="Retorna um dado Específico")
	public MedicaoAgua UnicoMedicao(@PathVariable(value="id") long id){
		return MedicaoRepository.findById(id);
	}
	
	@PostMapping("/agua/adicionar")
	@ApiOperation(value="Salva um dado novo")
	public MedicaoAgua salvaMedicao(@RequestBody MedicaoAgua medicaoAgua) {
		return MedicaoRepository.save(medicaoAgua);
	}
	
	@DeleteMapping("/agua/delete")
	@ApiOperation(value="Deletar dados")
	public void deletaMedicao(@RequestBody MedicaoAgua medicaoAgua) {
		MedicaoRepository.delete(medicaoAgua);
	}
	
	@PutMapping("/agua/atualizar")
	@ApiOperation(value="Atualizar um dado")
	public MedicaoAgua atualizaMedicao(@RequestBody MedicaoAgua medicaoAgua) {
		return MedicaoRepository.save(medicaoAgua);
	}
	
	
}
