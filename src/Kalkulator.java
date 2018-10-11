/**
 * Klasa odpowiada za weryfikacje i kowertowanie numeru PESEL na dane czytelne dla uzytkownia
 */
public class Kalkulator {
    /**
     * Pole peselArr to tablica Integerow z kolejnymi cyframi z numeru PESEL
     * Pole rok to Integer zawierajacy dwie ostatnie cyfry z roku
     * Pole miesiac to numer miesiaca
     * Pole dzien to numer dnia
     * Pole plec Integer definiujacy liczbo plec
     */
    private int peselArr[];
    public int rok;
    public int miesiac;
    public int dzien;
    public int plec;

    /**
     * Metoda czyPoprawny ustawia pola rok, miesiac, dzien, plec klasy Kalkulator
     * @param peselStr numer PESEL jako String
     * @return jesli podany numer PESEL jest poprawny zwraca true, w przeciwnym wypadku false
     * @throws PESELException rzuca wyjatek gdy PESEL ma za malo liczbny lub nie sklada sie z samych cyfr
     */
    public boolean czyPoprawny(String peselStr) throws PESELException {
        this.peselArr = new int[11];
        try {

            if(peselStr.length() > 11)
                return false;

            for(int i = 0; i < 11; i++) {
                String c = peselStr.substring(i, i+1);
                this.peselArr[i] = Integer.parseInt(c);
            }
            this.rok = this.peselArr[0]*10 + this.peselArr[1];
            this.miesiac = this.peselArr[2]*10 + this.peselArr[3];
            this.dzien = this.peselArr[4]*10 + this.peselArr[5];
            this.plec = this.peselArr[9];

            if(this.miesiac > 12 || this.miesiac == 0)
                return false;
            if(this.dzien > 31 || this.dzien == 0)
                return false;
        }
        catch (NullPointerException e) {
            throw new PESELException("Pusty PESEL");
        }
        catch (IndexOutOfBoundsException e) {
            throw new PESELException("PESEL powinien miec 11 znakow");
        }
        catch (NumberFormatException e) {
            throw new PESELException("PESEL powinien skladac sie z samych cyfr");
        }
        return true;
    }

    /**
     * @return Zwraca String okreslajacy plec posiadacza danego numeru PESEL
     */
    public String konwertujPlec() {
        return (this.plec %2 == 0) ? "Kobieta" : "Mezczyzna";
    }

    /**
     * @return Zwraca string okreslajacy date urodzenia posadacza danego numeru pesel
     */
    public String konwertujDataUrodzenia() {
        return ((this.dzien < 10) ? "0" : "") + this.dzien + "-" + ((this.miesiac < 10) ? "0" : "") + this.miesiac + "-" + "19" + this.rok;

    }
}
