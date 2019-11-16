package com.alexandre.crudapi.repository.pessoa;

import java.util.List;

import com.alexandre.crudapi.dto.PessoaEstatisticaGrupo;
import com.alexandre.crudapi.dto.PessoaEstatisticaIdade;
import com.alexandre.crudapi.dto.PessoaEstatisticaSexo;
import com.alexandre.crudapi.dto.PessoaEstatisticaStatus;
import com.alexandre.crudapi.dto.PessoaEstatisticaTotal;
import com.alexandre.crudapi.model.Pessoa;
import com.alexandre.crudapi.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery {
	
	public List<PessoaEstatisticaStatus> porStatus();
	
	public List<PessoaEstatisticaTotal> total();
	
	public List<PessoaEstatisticaIdade> porIdade();
	
	public List<PessoaEstatisticaGrupo> porGrupo();
	
	public List<PessoaEstatisticaSexo> porSexo();
	
	public List<Pessoa> pesquisar(PessoaFilter pessoaFilter);

}
