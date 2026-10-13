import java.util.Scanner;
import static java.lang.System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        out.println("Cifrario di Frabar (vigenere)");

        // chiedere la lunghezza della chiave (maggiore di 0)
        int lungChiave = 0;
        while (true) {
            out.print("Inserisci la lunghezza della chiave (> 0): ");
            if (scanner.hasNextInt()) {
                lungChiave = scanner.nextInt();
                if (lungChiave > 0) {
                    break;
                }
            } else {
                scanner.next(); // pulisce l'input errato
            }
            out.println("Il numero deve essere un intero maggiore di 0.");
        }

        // inserimento manuale dei numeri della chiave
        int[] chiave = new int[lungChiave];
        out.println("Inserisci i " + lungChiave + " numeri della chiave:");
        for (int i = 0; i < lungChiave; i++) {
            while (true) {
                out.print("  Valore " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    chiave[i] = scanner.nextInt();
                    break;
                } else {
                    scanner.next();
                    out.println("il numero deve essere un intero valido.");
                }
            }
        }

        // scelta del operazione
        int operazione = 0;
        while (true) {
            out.print("Scegli l'operazione (1 = Cifratura, 2 = Decifratura): ");
            if (scanner.hasNextInt()) {
                operazione = scanner.nextInt();
                if (operazione == 1 || operazione == 2) {
                    break;
                }
            } else {
                scanner.next();
            }
            out.println("INserisci solo uno dei seguenti valori 1: per cifrare o 2: per decifrare.");
        }

        // pulisco il buffer
        scanner.nextLine();

        // input del testo
        System.out.print("Inserisci il testo: ");
        String testo = scanner.nextLine();

        // lancio l'algoritmo
        char direzione = (operazione == 1) ? '+' : '-';
        StringBuilder risultato = new StringBuilder();
        int indiceChiave = 0;

        for (int i = 0; i < testo.length(); i++) {
            Lettera lettera = new Lettera(testo.charAt(i));

            if (lettera.eValido()) {
                // sposta ogni carattere della suo valore
                int salto = chiave[indiceChiave % lungChiave];
                lettera.trasla(salto, direzione);

                // prosegue con l'array
                indiceChiave++;
            }

            risultato.append(lettera.getCarattere());
        }

        // Stampa il risultato
        String nomeOperazione = (operazione == 1) ? "Testo cifrato" : "Testo decifrato";
        out.println("\n--------------------------------------------------");
        out.println(nomeOperazione + ": " + risultato.toString());
        out.println("--------------------------------------------------");

        scanner.close();
    }
