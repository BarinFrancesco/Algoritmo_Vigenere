/**
 * Classe che rappresenta un singolo carattere e gestisce la traslazione circolare
 * nell'intervallo dei caratteri ASCII stampabili (da 32 a 126).
 */
public class Lettera {
    private char carattere;

    public Lettera(char carattere) {
        this.carattere = carattere;
    }

    public char getCarattere() {
        return carattere;
    }

    /**
     * Verifica se il carattere rientra nell'intervallo stampabile (32 - 126).
     */
    public boolean eValido() {
        return carattere >= 32 && carattere <= 126;
    }

    /**
     * Trasla il carattere di un certo salto in base alla direzione.
     * @param salto valore intero dello spostamento (può essere negativo o maggiore di 94)
     * @param direzione '+' per la cifratura, '-' per la decifratura
     */
    public void trasla(int salto, char direzione) {
        if (!eValido()) {
            return; // Se il carattere è fuori dall'intervallo, resta invariato
        }

        int min = 32;
        int max = 126;
        int range = (max - min) + 1; // 95 caratteri totali

        // Convertiamo il carattere nel suo valore intero ASCII
        int codiceCorrente = (int) carattere;
        int nuovoCodice;

        if (direzione == '+') {
            nuovoCodice = codiceCorrente + salto;
        } else if (direzione == '-') {
            nuovoCodice = codiceCorrente - salto;
        } else {
            return; // Direzione non valida
        }

        // Gestione della circolarità (funziona correttamente anche con numeri negativi)
        int offset = (nuovoCodice - min) % range;
        if (offset < 0) {
            offset += range;
        }

        this.carattere = (char) (min + offset);
    }
}