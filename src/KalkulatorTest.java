import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KalkulatorTest {
    private Kalkulator kalkulator;

    @Before
    public void setUp() {
        this.kalkulator = new Kalkulator();
    }


    @Test(expected = PESELException.class)
    public void czyPoprawnyWyjatek() throws PESELException {
        kalkulator.czyPoprawny("9601a423124");
    }

    @Test
    public void czyPoprawynyTrue() throws PESELException{
        assertEquals(true, kalkulator.czyPoprawny("00112212345"));
    }

    @Test
    public void czyPoprawynyFalse() throws PESELException{
        assertEquals(false, kalkulator.czyPoprawny("00223312345"));
    }

    @Test
    public void konwertujPlec() {
        kalkulator.plec = 0;
        assertEquals("Kobieta", kalkulator.konwertujPlec());

        kalkulator.plec = 1;
        assertEquals("Mezczyzna", kalkulator.konwertujPlec());
    }

    @Test
    public void konwertujDataUrodzenia() {
        kalkulator.rok = 33;
        kalkulator.miesiac = 11;
        kalkulator.dzien = 22;

        assertEquals("22-11-1933", kalkulator.konwertujDataUrodzenia());
    }
}