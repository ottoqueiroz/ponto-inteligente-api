package com.ottoamaral.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ottoamaral.pontointeligente.api.entities.Empresa;

/**
 * 
 * recebe/extende o JpaRepository para tipo de entidade Empresa que possui o id
 * do tipo long.
 * 
 * findByCnpj = definimos um metodo customizado, assim como temos dentro da
 * entity Empresa o campo Cnpj, automaticamente gera-se uma query.
 * 
 * @Transactional(readOnly = true) = n precisa de transação, pois n precisamos
 *                         bloquear, melhorando a performance da aplicação.
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);
}
