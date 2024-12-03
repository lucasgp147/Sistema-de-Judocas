package test.java.org.fpij.jitakyoei.model.beans;

import main.java.org.fpij.jitakyoei.model.beans.ProfessorEntidade;
import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorEntidadeTest {

    private Professor professor1;
    private Professor professor2;
    private Entidade entidade1;
    private Entidade entidade2;
    private Entidade entidade3;
    private ProfessorEntidade professorEntidade1;
    private ProfessorEntidade professorEntidade2;
    private ProfessorEntidade professorEntidade3;

    @Before
    public void setUp() {
        Filiado filiado1 = new Filiado();
        filiado1.setId(1L);
        filiado1.setNome("João");

        Filiado filiado2 = new Filiado();
        filiado2.setId(2L);
        filiado2.setNome("Maria");

        professor1 = new Professor();
        professor1.setFiliado(filiado1);

        professor2 = new Professor();
        professor2.setFiliado(filiado2);

        entidade1 = new Entidade();
        entidade1.setNome("Entidade 1");

        entidade2 = new Entidade();
        entidade2.setNome("Entidade 2");

        entidade3 = new Entidade();
        entidade3.setNome("Entidade 3");


        professorEntidade1 = new ProfessorEntidade(professor1, entidade1);
        professorEntidade2 = new ProfessorEntidade(professor1, entidade1);
        professorEntidade3 = new ProfessorEntidade(professor2, entidade2);
    }

    @Test
    public void testGetSetProfessor() {
        assertEquals(professor1, professorEntidade1.getProfessor());
        professorEntidade1.setProfessor(professor2);
        assertEquals(professor2, professorEntidade1.getProfessor());
    }

    @Test
    public void testGetSetEntidade() {
        assertEquals(entidade1, professorEntidade1.getEntidade());
        professorEntidade1.setEntidade(entidade2);
        assertEquals(entidade2, professorEntidade1.getEntidade());
    }

    @Test
    public void testEquals() {
        assertTrue(professorEntidade1.equals(professorEntidade2));
        professorEntidade2.setEntidade(entidade3);
        assertFalse(professorEntidade1.equals(professorEntidade2));
        assertFalse(professorEntidade1.equals(professorEntidade3));
        assertFalse(professorEntidade1.equals(null));
        assertFalse(professorEntidade1.equals(""));
    }

    @Test
    public void testHashCode() {
        assertEquals(professorEntidade1.hashCode(), professorEntidade2.hashCode());
        assertNotEquals(professorEntidade1.hashCode(), professorEntidade3.hashCode());
    }
}
