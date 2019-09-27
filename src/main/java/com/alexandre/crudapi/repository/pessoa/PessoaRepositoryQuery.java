package com.alexandre.crudapi.repository.pessoa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexandre.crudapi.model.Pessoa;
import com.alexandre.crudapi.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery {
	
	public List<Pessoa> pesquisar(PessoaFilter pessoaFilter);

}
