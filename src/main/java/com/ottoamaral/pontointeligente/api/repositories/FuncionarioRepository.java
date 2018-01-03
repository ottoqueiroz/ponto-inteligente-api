package com.ottoamaral.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ottoamaral.pontointeligente.api.entities.Funcionario;

/**
 * Definimos 3 métodos customizados: findByCpf = temos esse atributo na entidade
 * funcionario; findByEmail = temos esse atributo na entidade funcionario;
 * findByCpfOrEmail = esse 'Or' é uma conversão do spring, criando-se um select
 * com cpf 'or' email;
 */
@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByCpf(String cpf);

	Funcionario findByEmail(String email);

	Funcionario findByCpfOrEmail(String cpf, String email);
}
