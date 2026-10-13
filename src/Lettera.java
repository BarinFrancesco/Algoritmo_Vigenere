//Classe per la gestione del carattere

public class Lettera {
    private char carattere;

    public Lettera(char carattere) {
        this.carattere = carattere;
    }

    public char getCarattere() {
        return carattere;
    }

    //controllo che sia uno di quelli validi
    public boolean eValido() {
        return carattere >= 32 && carattere <= 126;
    }

    //funzione che fa girare i caratteri
    public void trasla(int salto, char direzione) {
        if (!eValido()) {
            return; // Se il carattere è fuori dall'intervallo non lo sposto
        }

        int min = 32;
        int max = 126;
        int range = (max - min) + 1; // 95 caratteri totali

        // trasformo il char in numero
        int codiceCorrente = (int) carattere;
        int nuovoCodice;

        if (direzione == '+') {
            nuovoCodice = codiceCorrente + salto;
        } else if (direzione == '-') {
            nuovoCodice = codiceCorrente - salto;
        } else {
            return; // se non è + o - c'èun parametro sbagliato
        }

        // uso il modulo per garantire la circolarità
        int offset = (nuovoCodice - min) % range;
        if (offset < 0) {
            offset += range;
        }

        this.carattere = (char) (min + offset);
    }
}