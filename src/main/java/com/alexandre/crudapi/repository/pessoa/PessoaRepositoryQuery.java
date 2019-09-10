package com.alexandre.crudapi.repository.pessoa;

import java.util.List;

import com.alexandre.crudapi.model.Pessoa;
import com.alexandre.crudapi.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery {
	
	public List<Pessoa> filtrar(PessoaFilter pessoaFilter);

}
