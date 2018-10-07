import java.util.Scanner;

/**
 * Klasa aplikacja odpwiada za pobieranie numeru PESEL i wyswietlanie skonwerowanych danych w czytelnej formie
 */
public class Aplikacja {
    /**
     * pole poprawny zawiera inforamcje o poprawnosci numeru PESEL
     * pole plec String zawierajacy informacje o plec
     * pole dataUrodzenia to String data urodzenia w czytelnej formie
     * pole kalkulator to instancja klasy Kalkulator
     */
    private boolean poprawny = false;
    private String plec = "";
    private String dataUrodzenia = "";
    private Kalkulator kalkulator = new Kalkulator();

    /**
     * Metoda  aktywnie czeka az uzytkownik poda numer PESEL
     * Wywoluje metode klasy Kalkulator sprawdzajaca poprawnosc numeru PESEL
     * Wywoluje metody klasy Kalkulator konwertujace numer PESEL
     * Wywoluje metode klasy Aplikacja wyswietlajaca date oraz plec posiadacza numeru PESEL
     */
    public void pobierzNumer() {
        System.out.println("Podaj numer pesel: ");
        Scanner scanner = new Scanner(System.in);
        String pesel = scanner.nextLine();

        try {
            this.poprawny = kalkulator.czyPoprawny(pesel);
        }
        catch(PESELException e) {
            System.out.printf("Blad: " + e);
        }
        finally {
            if(this.poprawny){
                this.plec = kalkulator.konwertujPlec();
                this.dataUrodzenia = kalkulator.konwertujDataUrodzenia();
                wyswietlDane();
            }
            else {
                System.out.printf("\nNumer PESEL jest nie poprawyny");
            }
        }
    }

    /**
     * Metoda wyswietla w czytelnej formie numer PESEL
     */
    public void wyswietlDane() {
        System.out.printf("Podana osoba to: " + this.plec + ", data urodzenia: " + this.dataUrodzenia);
    }
}
