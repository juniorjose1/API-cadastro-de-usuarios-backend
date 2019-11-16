package com.alexandre.crudapi.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.crudapi.dto.PessoaEstatisticaGrupo;
import com.alexandre.crudapi.dto.PessoaEstatisticaIdade;
import com.alexandre.crudapi.dto.PessoaEstatisticaSexo;
import com.alexandre.crudapi.dto.PessoaEstatisticaStatus;
import com.alexandre.crudapi.dto.PessoaEstatisticaTotal;
import com.alexandre.crudapi.event.RecursoCriadoEvent;
import com.alexandre.crudapi.model.Pessoa;
import com.alexandre.crudapi.repository.PessoaRepository;
import com.alexandre.crudapi.repository.filter.PessoaFilter;
import com.alexandre.crudapi.service.PessoaService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/estatisticas/por-status") 
	public List<PessoaEstatisticaStatus> porStatus(){
		return this.pessoaRepository.porStatus();		
	}
	
	@GetMapping("/estatisticas/total")
	public List<PessoaEstatisticaTotal> total(){
		return this.pessoaRepository.total();
	}
	
	@GetMapping("/estatisticas/por-grupo")
	public List<PessoaEstatisticaGrupo> porGrupo(){
		return this.pessoaRepository.porGrupo();
	}
	
	@GetMapping("/estatisticas/por-idade")
	public List<PessoaEstatisticaIdade> porIdade(){
		return this.pessoaRepository.porIdade();
	}
	
	@GetMapping("/estatisticas/por-sexo")
	public List<PessoaEstatisticaSexo> porSexo(){
		return this.pessoaRepository.porSexo();
	}
	
	@GetMapping("/relatorio")
	public ResponseEntity<byte[]> relatorio(PessoaFilter pessoaFilter) throws Exception{
		byte[] relatorio = pessoaService.relatorioPessoa(pessoaFilter);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
		headers.add("Content-Disposition", "attachment; filename=Lista_de_Usuarios.pdf");
		
		return ResponseEntity.ok()
				.headers(headers)
				.body(relatorio);
	}

	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> buscar(PessoaFilter pessoaFilter){
		return pessoaRepository.pesquisar(pessoaFilter);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> listar(@PathVariable Long id) {
		Optional<Pessoa> buscarPessoa = pessoaRepository.findById(id);

		return ResponseEntity.status(HttpStatus.OK).body(buscarPessoa.get());
	}

	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa cadastrarPessoa = pessoaRepository.save(pessoa);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, cadastrarPessoa.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(cadastrarPessoa);

	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarTudo() {
		pessoaRepository.deleteAll();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> alterar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		Optional<Pessoa> alterarPessoa = pessoaRepository.findById(id);
		BeanUtils.copyProperties(pessoa, alterarPessoa.get(), "id");
		pessoaRepository.save(alterarPessoa.get());
		return ResponseEntity.status(HttpStatus.OK).body(alterarPessoa.get());
	}

}
