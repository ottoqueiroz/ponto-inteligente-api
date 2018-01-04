package com.ottoamaral.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ottoamaral.pontointeligente.api.entities.Empresa;
import com.ottoamaral.pontointeligente.api.repositories.EmpresaRepository;

//Parecido com o repository, vamos adicionar 3 configurações de contexto do Spring
//sendo que uma dela, uso do Profile de Test

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	// Uso de Mock Objects que significam objetos falso e usaremos um para
	// representar uma EmpresaRepository, sendo que esta ja foi testada e funciona;
	// Assim, não precisando fazer uso da implementação física dela e usar um obj
	// falso;

	// Ao invés de ultilizar o @Autowired para obter uma instancia verdadeira do
	// obj;
	// Ultilizamos a anotação @MockBean que é do pacote do Mockito que é um
	// framework,
	// para mock de classes java

	@MockBean
	private EmpresaRepository empresaRepository;

	// @Autowired = obter uma instancia verdadeira do objeto
	@Autowired
	private EmpresaService empresaService;

	private static final String CNPJ = "51463645000100";

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}

	@Test
	public void testBuscarEmpresaPorCnpj() throws Exception {
		Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);

		assertTrue(empresa.isPresent());
	}

	@Test
	public void testPersistirEmpresa() throws Exception {
		Empresa empresa = this.empresaService.persistir(new Empresa());

		assertNotNull(empresa);
	}

}
