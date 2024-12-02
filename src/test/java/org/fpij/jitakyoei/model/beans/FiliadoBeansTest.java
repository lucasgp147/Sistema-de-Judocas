package test.java.org.fpij.jitakyoei.model.beans;

import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.model.beans.Rg;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FiliadoBeansTest {

    private static Filiado filiado1;
    private static Filiado filiado2;
    private static Filiado filiado3;
    private static Endereco endereco;
    private Rg rg;
    private static List<Faixa> faixas;

    @Before
    public void setUp() {
        filiado1 = new Filiado();
        filiado1.setId(1L);
        filiado1.setNome("João");
        filiado1.setRegistroCbj("12345");
        filiado1.setDataNascimento(new Date());
        filiado1.setDataCadastro(new Date());
        filiado1.setTelefone1("11111111");
        filiado1.setTelefone2("22222222");
        filiado1.setEmail("joao@example.com");
        filiado1.setCpf("12345678900");
        filiado1.setObservacoes("Observações de teste");

        endereco = new Endereco();
        filiado1.setEndereco(endereco);

        rg = new Rg("","");
        filiado1.setRg(rg);

        faixas = new ArrayList<>();
        faixas.add(new Faixa());
        filiado1.setFaixas(faixas);

        filiado2 = new Filiado();
        filiado2.setId(1L);
        filiado2.setNome("João");

        filiado3 = new Filiado();
        filiado3.setId(4L);
        filiado3.setNome("Vini");
    }

    @Test
    public void testGetSetId() {
        assertEquals((Long) 1L, filiado1.getId());
        filiado1.setId(2L);
        assertEquals((Long) 2L, filiado1.getId());
    }

    @Test
    public void testGetSetNome() {
        assertEquals("João", filiado1.getNome());
        filiado1.setNome("Maria");
        assertEquals("Maria", filiado1.getNome());
    }

    @Test
    public void testGetSetRegistroCbj() {
        assertEquals("12345", filiado1.getRegistroCbj());
        filiado1.setRegistroCbj("54321");
        assertEquals("54321", filiado1.getRegistroCbj());
    }

    @Test
    public void testGetSetDataNascimento() {
        Date novaData = new Date();
        filiado1.setDataNascimento(novaData);
        assertEquals(novaData, filiado1.getDataNascimento());
    }

    @Test
    public void testGetSetDataCadastro() {
        Date novaData = new Date();
        filiado1.setDataCadastro(novaData);
        assertEquals(novaData, filiado1.getDataCadastro());
    }

    @Test
    public void testGetSetTelefone1() {
        assertEquals("11111111", filiado1.getTelefone1());
        filiado1.setTelefone1("33333333");
        assertEquals("33333333", filiado1.getTelefone1());
    }

    @Test
    public void testGetSetTelefone2() {
        assertEquals("22222222", filiado1.getTelefone2());
        filiado1.setTelefone2("44444444");
        assertEquals("44444444", filiado1.getTelefone2());
    }

    @Test
    public void testGetSetEmail() {
        assertEquals("joao@example.com", filiado1.getEmail());
        filiado1.setEmail("maria@example.com");
        assertEquals("maria@example.com", filiado1.getEmail());
    }

    @Test
    public void testGetSetCpf() {
        assertEquals("12345678900", filiado1.getCpf());
        filiado1.setCpf("09876543210");
        assertEquals("09876543210", filiado1.getCpf());
    }

    @Test
    public void testGetSetObservacoes() {
        assertEquals("Observações de teste", filiado1.getObservacoes());
        filiado1.setObservacoes("Nova observação");
        assertEquals("Nova observação", filiado1.getObservacoes());
    }

    @Test
    public void testGetSetEndereco() {
        assertEquals(endereco, filiado1.getEndereco());
        Endereco novoEndereco = new Endereco();
        filiado1.setEndereco(novoEndereco);
        assertEquals(novoEndereco, filiado1.getEndereco());
    }

    @Test
    public void testGetSetRg() {
        assertEquals(rg, filiado1.getRg());
        Rg novoRg = new Rg("","");
        filiado1.setRg(novoRg);
        assertEquals(novoRg, filiado1.getRg());
    }

    @Test
    public void testGetSetFaixas() {
        assertEquals(faixas, filiado1.getFaixas());
        List<Faixa> novasFaixas = new ArrayList<>();
        filiado1.setFaixas(novasFaixas);
        assertEquals(novasFaixas, filiado1.getFaixas());
    }

    @Test
    public void testToString() {
        String expected = "Nome: João\n" +
                "RegistroCbj: 12345\n" +
                "DataNasc: " + filiado1.getDataNascimento() + "\n" +
                "E-mail: joao@example.com\n" +
                "CPF: 12345678900";
        assertEquals(expected, filiado1.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(filiado1.equals(filiado2));
        assertFalse(filiado1.equals(filiado3));
        assertFalse(filiado1.equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals((int) (long) 1L, filiado1.hashCode());
    }

    @Test
    public void testCopyProperties() {
        Filiado novoFiliado = new Filiado();
        novoFiliado.copyProperties(filiado1);
        assertEquals(filiado1.getId(), novoFiliado.getId());
        assertEquals(filiado1.getNome(), novoFiliado.getNome());
        assertEquals(filiado1.getRegistroCbj(), novoFiliado.getRegistroCbj());
        assertEquals(filiado1.getEndereco(), novoFiliado.getEndereco());
        assertEquals(filiado1.getRg(), novoFiliado.getRg());
        assertEquals(filiado1.getCpf(), novoFiliado.getCpf());
        assertEquals(filiado1.getObservacoes(), novoFiliado.getObservacoes());
        assertEquals(filiado1.getFaixas(), novoFiliado.getFaixas());
    }
}
