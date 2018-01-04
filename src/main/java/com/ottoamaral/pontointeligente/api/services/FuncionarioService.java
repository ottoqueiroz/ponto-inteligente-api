package com.ottoamaral.pontointeligente.api.services;

import java.util.Optional;

import com.ottoamaral.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {

	/**
	 * Persistir um funcionário na base de dados.
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	Funcionario persistir(Funcionario funcionario);

	/**
	 * Busca e retorna um funcionário dado um CPF.
	 * 
	 * @param cpf
	 * @return Optional <Funcionario>
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);

	/**
	 * Busca e retorna um funcionário dado um email.
	 * 
	 * @param email
	 * @return Optional <Funcionario>
	 */
	Optional<Funcionario> buscarPorEmail(String email);

	/**
	 * Busca e retorna um funcionário dado um ID.
	 * 
	 * @param id
	 * @return Optional <Funcionario>
	 */
	Optional<Funcionario> buscarPorId(Long id);

}
