package test.java.org.fpij.jitakyoei.model.beans;

import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfessorBeansTest {

    private Professor professor1;
    private Professor professor2;
    private Professor professor3;
    private Professor professor4; 
    private Filiado filiado1;
    private Filiado filiado2;
    private Filiado filiado3;
    private List<Entidade> entidades;

    @Before
    public void setUp() {
        filiado1 = new Filiado();
        filiado1.setId(1L);
        filiado1.setNome("João");

        filiado2 = new Filiado();
        filiado2.setId(2L);
        filiado2.setNome("Maria");

        filiado3 = new Filiado();
        filiado3.setNome("Vini");

        professor1 = new Professor();
        professor1.setFiliado(filiado1);

        professor2 = new Professor();
        professor2.setFiliado(filiado1);

        professor3 = new Professor();
        professor3.setFiliado(filiado2);

        professor4 = new Professor();
        professor4.setFiliado(filiado3);

        entidades = new ArrayList<>();
        entidades.add(new Entidade());
        professor1.setEntidades(entidades);
    }

    @Test
    public void testGetSetFiliado() {
        assertEquals(filiado1, professor1.getFiliado());
        professor1.setFiliado(filiado2);
        assertEquals(filiado2, professor1.getFiliado());
    }

    @Test
    public void testGetSetEntidades() {
        assertEquals(entidades, professor1.getEntidades());
        List<Entidade> novasEntidades = new ArrayList<>();
        professor1.setEntidades(novasEntidades);
        assertEquals(novasEntidades, professor1.getEntidades());
    }

    @Test
    public void testEquals() {
        assertTrue(professor1.equals(professor2));
        assertFalse(professor1.equals(professor3));
        assertFalse(professor1.equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(professor1.hashCode(), professor2.hashCode());
        assertNotEquals(professor1.hashCode(), professor3.hashCode());
        assertNotEquals(professor1.hashCode(), professor4.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("João", professor1.toString());
    }
}
