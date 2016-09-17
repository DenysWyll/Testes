package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDao;

public class UC01CadastrarEmpresa {
	static Empresa empresa;
	static EmpresaDao empresaDao;
	/**
	 * estabelece as pré condições de teste
	 */

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDao = new EmpresaDao();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");

	}
	
	@Before
	public void excluiCNPJ(){
		empresaDao.exclui("89424232000180");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	/**
	 * verificar o comportamento do sistema na inserção de uma empresa
	 * com sucesso
	 */
	@Test
	public void CT01UC01CadastrarEmpresaComSucesso() {
		assertEquals(1, empresaDao.adiciona(empresa));
	}
	
	@Test(expected = RuntimeException.class)
	public void CT02UC01CadastrarEmpresaComCnpjInvalido() {
		empresaDao.adiciona(empresa);
		empresaDao.adiciona(empresa);
	}

}
