/**
 * Program przerwazajacy numer PESEL na ladne dane
 *
 * @author  Przemyslaw
 * @version 1.0
 * @since   2018-10-7
 *
 */
public class Start {
    /**
     * Metoda main tworzy instancje klasy Aplikacja
     * wywoluje metode pobiez dane ktora oczekuje na podanie numeru pesel przez uzytkownia
     * @param args Nie uzywane
     * @return nic
     */
    public static void main(String[] args){
        Aplikacja aplikacja = new Aplikacja();
        aplikacja.pobierzNumer();
    }
}
