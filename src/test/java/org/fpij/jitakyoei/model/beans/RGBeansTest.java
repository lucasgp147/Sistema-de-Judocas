package test.java.org.fpij.jitakyoei.model.beans;

import main.java.org.fpij.jitakyoei.model.beans.Rg;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RGBeansTest {

    private Rg rg1;
    private Rg rg2;
    private Rg rg3;

    @Before
    public void setUp() {
        rg1 = new Rg("123456789", "SSP");
        rg2 = new Rg("123456789", "SSP");
        rg3 = new Rg("123456789", "SSP");
    }

    @Test
    public void testGetSetNumero() {
        assertEquals("123456789", rg1.getNumero());
        rg1.setNumero("987654321");
        assertEquals("987654321", rg1.getNumero());
    }

    @Test
    public void testGetSetOrgaoExpedidor() {
        assertEquals("SSP", rg1.getOrgaoExpedidor());
        rg1.setOrgaoExpedidor("SGP");
        assertEquals("SGP", rg1.getOrgaoExpedidor());
    }

    @Test
    public void testEquals() {
        assertTrue(rg1.equals(rg2));

        rg2.setNumero("987654321");
        assertFalse(rg1.equals(rg2));

        rg3.setOrgaoExpedidor("Nothing");
        assertFalse(rg1.equals(rg3));
        assertFalse(rg1.equals(null));
        assertFalse(rg1.equals("not a Rg"));
    }

    @Test
    public void testHashCode() {
        int expectedHashCode = rg1.getNumero().hashCode() + rg1.getOrgaoExpedidor().hashCode();
        assertEquals(expectedHashCode, rg1.hashCode());
    }

    @Test
    public void testConstructor() {
        Rg rg3 = new Rg("987654321", "SSP");
        assertEquals("987654321", rg3.getNumero());
        assertEquals("SSP", rg3.getOrgaoExpedidor());
    }
}
