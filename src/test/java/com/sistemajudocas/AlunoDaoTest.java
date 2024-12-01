package test.java.com.sistemajudocas;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;
import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import main.java.org.fpij.jitakyoei.model.dao.DAO;
import main.java.org.fpij.jitakyoei.model.dao.DAOImpl;

public class AlunoDaoTest {
	
	private static DAO<Aluno> alunoDao;
	private static Aluno aluno;
	private static Entidade entidade;
	private static Endereco endereco;
	private static Filiado f1;
	private static Filiado filiadoProf;
	private static Professor professor;
	
	@BeforeClass
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);
		f1 = new Filiado();
		f1.setNome("Aécio");
		f1.setCpf("036.464.453-27");
		f1.setDataNascimento(new Date());
		f1.setDataCadastro(new Date());
		f1.setId(1332L);
		
		endereco = new Endereco();
		endereco.setBairro("Dirceu");
		endereco.setCep("64078-213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");
		
		filiadoProf = new Filiado();
		filiadoProf.setNome("Professor");
		filiadoProf.setCpf("036.464.453-27");
		filiadoProf.setDataNascimento(new Date());
		filiadoProf.setDataCadastro(new Date());
		filiadoProf.setId(3332L);
		filiadoProf.setEndereco(endereco);
		
		professor = new Professor();
		professor.setFiliado(filiadoProf);
		
		entidade = new Entidade();
		entidade.setEndereco(endereco);
		entidade.setNome("Academia 1");
		entidade.setTelefone1("(086)1234-5432");
		
		aluno = new Aluno();
		aluno.setFiliado(f1);
		aluno.setProfessor(professor);
		aluno.setEntidade(entidade);
		
		alunoDao = new DAOImpl<Aluno>(Aluno.class);
	}

	public static void clearDatabase(){
		List<Aluno> all = alunoDao.list();
		for (Aluno each : all) {
			alunoDao.delete(each);
		}
		assertEquals(0, alunoDao.list().size());
	}
	
	
	@Test
	public void  testSalvarAlunoComAssociassoes() throws Exception{
		clearDatabase();
		
		alunoDao.save(aluno);
		assertEquals("036.464.453-27", alunoDao.get(aluno).getFiliado().getCpf());
		assertEquals("Aécio", alunoDao.get(aluno).getFiliado().getNome());
		assertEquals("Professor", alunoDao.get(aluno).getProfessor().getFiliado().getNome());
		assertEquals("Dirceu", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getBairro());
	}
	
	@Test
	public void updateAluno() throws Exception{
		clearDatabase();
		assertEquals(0, alunoDao.list().size());
		
		alunoDao.save(aluno);
		assertEquals(1, alunoDao.list().size());
		assertEquals("Aécio", aluno.getFiliado().getNome());
		
		Aluno a1 = alunoDao.get(aluno);
		a1.getFiliado().setNome("TesteUpdate");
		alunoDao.save(a1);
		
		Aluno a2 = alunoDao.get(a1);
		assertEquals("TesteUpdate", a2.getFiliado().getNome());
		assertEquals(1, alunoDao.list().size());
	}
	
	@Test
	public void testListarEAdicionarAlunos(){
		int qtd = alunoDao.list().size();
		
		// Creating a new Aluno and assigning a Filiado object to avoid NullPointerException
		Aluno newAluno1 = new Aluno();
		Filiado f1 = new Filiado();
		f1.setNome("Aluno 1");
		newAluno1.setFiliado(f1);
		alunoDao.save(newAluno1);
		assertEquals(qtd+1, alunoDao.list().size());
		
		// Repeat for other Aluno objects
		Aluno newAluno2 = new Aluno();
		Filiado f2 = new Filiado();
		f2.setNome("Aluno 2");
		newAluno2.setFiliado(f2);
		alunoDao.save(newAluno2);
		assertEquals(qtd+2, alunoDao.list().size());
		
		Aluno newAluno3 = new Aluno();
		Filiado f3 = new Filiado();
		f3.setNome("Aluno 3");
		newAluno3.setFiliado(f3);
		alunoDao.save(newAluno3);
		assertEquals(qtd+3, alunoDao.list().size());
		
		Aluno newAluno4 = new Aluno();
		Filiado f4 = new Filiado();
		f4.setNome("Aluno 4");
		newAluno4.setFiliado(f4);
		alunoDao.save(newAluno4);
		assertEquals(qtd+4, alunoDao.list().size());
		
		clearDatabase();
		assertEquals(0, alunoDao.list().size());
		
		Aluno newAluno5 = new Aluno();
		Filiado f5 = new Filiado();
		f5.setNome("Aluno 5");
		newAluno5.setFiliado(f5);
		alunoDao.save(newAluno5);
		assertEquals(1, alunoDao.list().size());
	}

	
	@Test
	public void testSearchAluno() throws Exception{
		clearDatabase();
		alunoDao.save(aluno);
		
		Filiado f = new Filiado();
		f.setNome("Aécio");
		Aluno a = new Aluno();
		a.setFiliado(f);
		
		List<Aluno> result = alunoDao.search(a);
		assertEquals(1, result.size());
		assertEquals("036.464.453-27", result.get(0).getFiliado().getCpf());
		
		clearDatabase();
		assertEquals(0, alunoDao.search(a).size());
	}
	
	@AfterClass
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}
	
}
