package com.alexandre.crudapi.repository.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.alexandre.crudapi.dto.PessoaEstatisticaGrupo;
import com.alexandre.crudapi.dto.PessoaEstatisticaIdade;
import com.alexandre.crudapi.dto.PessoaEstatisticaSexo;
import com.alexandre.crudapi.dto.PessoaEstatisticaStatus;
import com.alexandre.crudapi.dto.PessoaEstatisticaTotal;
import com.alexandre.crudapi.model.Pessoa;
import com.alexandre.crudapi.model.Pessoa_;
import com.alexandre.crudapi.repository.filter.PessoaFilter;

public class PessoaRepositoryImpl implements PessoaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<PessoaEstatisticaStatus> porStatus() {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<PessoaEstatisticaStatus> criteriaQuery = criteriaBuilder.
				createQuery(PessoaEstatisticaStatus.class);
		
		Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
		
		criteriaQuery.select(criteriaBuilder.construct(PessoaEstatisticaStatus.class, 
				root.get(Pessoa_.status),
				criteriaBuilder.count(root.get(Pessoa_.STATUS))));
				
		criteriaQuery.groupBy(root.get(Pessoa_.status));
		
		TypedQuery<PessoaEstatisticaStatus> typedQuery = manager.createQuery(criteriaQuery);
		
			return typedQuery.getResultList();
	}
	
	@Override
	public List<PessoaEstatisticaTotal> total() {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<PessoaEstatisticaTotal> criteriaQuery = criteriaBuilder.
				createQuery(PessoaEstatisticaTotal.class);
		
		Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
		
		criteriaQuery.select(criteriaBuilder.construct(PessoaEstatisticaTotal.class,
				criteriaBuilder.count(root.get(Pessoa_.id))));
				
		
		TypedQuery<PessoaEstatisticaTotal> typedQuery = manager.createQuery(criteriaQuery);
		
			return typedQuery.getResultList();
	}
	
	@Override
	public List<PessoaEstatisticaGrupo> porGrupo() {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<PessoaEstatisticaGrupo> criteriaQuery = criteriaBuilder.
				createQuery(PessoaEstatisticaGrupo.class);
		
		Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
		
		criteriaQuery.select(criteriaBuilder.construct(PessoaEstatisticaGrupo.class, 
				root.get(Pessoa_.grupo),
				criteriaBuilder.count(root.get(Pessoa_.grupo))));
				
		criteriaQuery.groupBy(root.get(Pessoa_.grupo));
		
		TypedQuery<PessoaEstatisticaGrupo> typedQuery = manager.createQuery(criteriaQuery);
		
			return typedQuery.getResultList();
	}
	
	@Override
	public List<PessoaEstatisticaIdade> porIdade() {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
	CriteriaQuery<PessoaEstatisticaIdade> criteriaQuery = criteriaBuilder.
			createQuery(PessoaEstatisticaIdade.class);
	
	Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
	
	criteriaQuery.select(criteriaBuilder.construct(PessoaEstatisticaIdade.class, 
			root.get(Pessoa_.idade),
			criteriaBuilder.count(root.get(Pessoa_.idade))));
			
	criteriaQuery.groupBy(root.get(Pessoa_.idade));
	
	TypedQuery<PessoaEstatisticaIdade> typedQuery = manager.createQuery(criteriaQuery);
	
		return typedQuery.getResultList();
	}
	
	@Override
	public List<PessoaEstatisticaSexo> porSexo() {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
	CriteriaQuery<PessoaEstatisticaSexo> criteriaQuery = criteriaBuilder.
			createQuery(PessoaEstatisticaSexo.class);
	
	Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
	
	criteriaQuery.select(criteriaBuilder.construct(PessoaEstatisticaSexo.class, 
			root.get(Pessoa_.sexo),
			criteriaBuilder.count(root.get(Pessoa_.sexo))));
	
	criteriaQuery.groupBy(root.get(Pessoa_.sexo));
	
	TypedQuery<PessoaEstatisticaSexo> typedQuery = manager.createQuery(criteriaQuery);
	
		return typedQuery.getResultList();
	}
	
	public List<Pessoa> pesquisar(PessoaFilter pessoaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery criteria = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);

		Predicate[] predicates = criarRestricoes(pessoaFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Pessoa> query = manager.createQuery(criteria);
		return query.getResultList();
	}


	private Predicate[] criarRestricoes(PessoaFilter pessoaFilter, CriteriaBuilder builder, Root<Pessoa> root) {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(pessoaFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Pessoa_.NOME)),
					"%" + pessoaFilter.getNome().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pessoaFilter.getIdade())) {
			predicates.add(builder.like(builder.lower(root.get(Pessoa_.IDADE)), 
					"%" + pessoaFilter.getIdade().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pessoaFilter.getSexo())) {
			predicates.add(builder.like(builder.lower(root.get(Pessoa_.SEXO)), 
					"%" + pessoaFilter.getSexo().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pessoaFilter.getGrupo())) {
			predicates.add(builder.like(builder.lower(root.get(Pessoa_.GRUPO)), 
					"%" + pessoaFilter.getGrupo().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pessoaFilter.getStatus())) {
			predicates.add(builder.like(builder.lower(root.get(Pessoa_.STATUS)), 
					"%" + pessoaFilter.getStatus().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
