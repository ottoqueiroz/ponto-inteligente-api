package com.ottoamaral.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottoamaral.pontointeligente.api.entities.Empresa;
import com.ottoamaral.pontointeligente.api.repositories.EmpresaRepository;
import com.ottoamaral.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepositpory;

	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		log.info("Buscando uma empresa por CNPJ {}", cnpj);

		// chamo o findByCnpj e adiciono dentro de um obj Optional.ofNullable
		// como ele pode ser nulo, eu quero criar um obj Optional que um recurso novo do
		// Java 8;
		// e ele é muito interessante para evitar prolemas de nullpointerexception
		// e ajuda a fazer uma verificação e é uma boa pratica para n ficar retornando
		// nulo toda hora.
		return Optional.ofNullable(empresaRepositpory.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa: {}", empresa);
		return this.empresaRepositpory.save(empresa);
	}

}
