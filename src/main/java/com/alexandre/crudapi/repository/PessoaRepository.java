package com.alexandre.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.crudapi.model.Pessoa;
import com.alexandre.crudapi.repository.pessoa.PessoaRepositoryQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {

}
