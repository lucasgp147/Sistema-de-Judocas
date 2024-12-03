package test.java.org.fpij.jitakyoei.model.beans;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

public class AlunoBeansTest {

    private static Aluno aluno1;
    private static Aluno aluno2;
    private static Aluno aluno3;
    private static Aluno aluno4;
    private static Filiado filiado1;
    private static Filiado filiado2;
    private static Filiado filiado3;
    private static Entidade entidade;
    private static Professor professor;

    @Before
    public void setUp() {
        DatabaseManager.setEnviroment(DatabaseManager.TEST);
        filiado1 = new Filiado();
        filiado1.setId(1L);
        filiado1.setNome("João");

        filiado2 = new Filiado();
        filiado2.setId(2L);
        filiado2.setNome("Maria");

        filiado3 = new Filiado();
        filiado3.setNome("Zé");

        entidade = new Entidade();
        professor = new Professor();

        // ALunos
        aluno1 = new Aluno();
        aluno1.setFiliado(filiado1);
        aluno1.setEntidade(entidade);
        aluno1.setProfessor(professor);

        aluno2 = new Aluno();
        aluno2.setFiliado(filiado2);
        aluno2.setEntidade(entidade);
        aluno2.setProfessor(professor);

        aluno3 = new Aluno();
        aluno3.setFiliado(filiado3);
        aluno3.setEntidade(entidade);
        aluno3.setProfessor(professor);

        Filiado filiado4 = new Filiado();
        filiado2.setId(1L);
        filiado4.setNome("Zé");

        aluno4 = new Aluno();
        aluno4.setFiliado(filiado4);
        aluno4.setEntidade(entidade);
        aluno4.setProfessor(professor);
    }

    @Test
    public void testGetSetFiliado() {
        assertEquals(filiado1, aluno1.getFiliado());
        aluno1.setFiliado(filiado2);
        assertEquals(filiado2, aluno1.getFiliado());
    }

    @Test
    public void testGetSetEntidade() {
        assertEquals(entidade, aluno1.getEntidade());
        Entidade newEntidade = new Entidade();
        aluno1.setEntidade(newEntidade);
        assertEquals(newEntidade, aluno1.getEntidade());
    }

    @Test
    public void testGetSetProfessor() {
        assertEquals(professor, aluno1.getProfessor());
        Professor newProfessor = new Professor();
        aluno1.setProfessor(newProfessor);
        assertEquals(newProfessor, aluno1.getProfessor());
    }

    @Test
    public void testToString() {
        assertEquals(filiado1.toString(), aluno1.toString());
    }

    @Test
    public void testEquals() {
        Aluno alunoCopy = new Aluno();
        alunoCopy.setFiliado(filiado1);
    
        assertTrue(aluno1.equals(alunoCopy));
        assertFalse(aluno1.equals(null));
        assertFalse(aluno1.equals(aluno2));
        assertFalse(aluno1.equals(aluno3));
    }

    @Test
    public void testHashCode() {
        int expectedHashCode = 29 * 7 + (int)(long)1L;
        assertEquals(expectedHashCode, aluno1.hashCode());
        int expectedHashCode1 = 29 * 7 + 0;
        assertEquals(expectedHashCode1, aluno3.hashCode());
    }

    @Test
    public void testCopyProperties() {
        aluno1.copyProperties(aluno2);
        assertEquals(filiado2, aluno1.getFiliado());
        assertEquals(entidade, aluno1.getEntidade());
        assertEquals(professor, aluno1.getProfessor());
    }
}
