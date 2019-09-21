package com.alexandre.crudapi.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.crudapi.model.Pessoa;
import com.alexandre.crudapi.repository.PessoaRepository;
import com.alexandre.crudapi.repository.filter.PessoaFilter;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public byte[] relatorioPessoa(PessoaFilter pessoaFilter) throws Exception {
		List<Pessoa> dados = pessoaRepository.filtrar(pessoaFilter);
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/relatorios/pessoas.jasper");
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,
				new JRBeanCollectionDataSource(dados));
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

}
