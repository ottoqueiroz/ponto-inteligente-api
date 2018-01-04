package com.ottoamaral.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottoamaral.pontointeligente.api.entities.Funcionario;
import com.ottoamaral.pontointeligente.api.repositories.FuncionarioRepository;
import com.ottoamaral.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Funcionario persistir(Funcionario funcionario) {
		log.info("Persistindo funcionário: {}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando funcionário pelo CPF: {}", cpf);
		
		// retornamos com o Optional.ofNullable pq uma vez que esse resultado pode ser
		// nulo ou Optional.ofNullable permite criar um objeto Optional que possui um
		// funcionario ou objeto nulo para verificação posterior.
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando funcionário pelo Email: {}", email);
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		log.info("Buscando funcionário pelo Id: {}", id);
		return Optional.ofNullable(this.funcionarioRepository.findOne(id));
	}

}
