import java.time.LocalDate;
import java.util.Scanner;

import model.MobileApp;
import model.Recensione;

public class Main {

	public static void main(String[] args) {

		boolean esci = false;

		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci il nome dell'app: ");
		String nome = sc.nextLine();

		System.out.print("Inserisci il sistema operativo: ");
		String oS = sc.nextLine();

		System.out.print("Inserisci il prezzo dell'app: ");
		float prezzo = sc.nextFloat();

		// creiamo l'oggetto
		MobileApp app = new MobileApp(nome, oS, prezzo);

		System.out.println("App creata con successo!");

		do {
			System.out.println(
					"Valutazione media: " + String.format("%.2f", app.valutazioneMedia()) + "\nRicavo totale: " + String.format("%.2f", app.getRicavoTotale()) + "€");
			System.out.println(
					"1.Download singolo\n2.Download multiplo\n3.Ricevi Recensione\n4.Visualizza recensioni\n5.Esci");
			int scelta = sc.nextInt();
			sc.nextLine();

			switch (scelta) {
			case 1: // download singolo
				app.download();
				break;
			case 2: // download multiplo
				System.out.print("Inserisci il numero di download da effettuare: ");
				int numDownload = sc.nextInt();
				sc.nextLine();
				app.download(numDownload);
				break;
			case 3: // ricevi recensione
				System.out.print("Nome utente: ");
				String nomeUtente = sc.nextLine();

				System.out.print("Numero di stelle (1-5): ");
				int numeroStelle = sc.nextInt();
				sc.nextLine(); // Consuma il newline rimasto dopo nextInt()

				System.out.print("Testo della recensione: ");
				String testo = sc.nextLine();

				Recensione rec = new Recensione(LocalDate.now(), nomeUtente, numeroStelle, testo);
				app.riceviRecensione(rec);
				break;
			case 4: // visualizza recensioni
				 System.out.println("\nRecensioni: ");
                 for (Recensione r : app.getElencoRecensioni()) {
                     System.out.println(r);
                 }
				break;
			case 5: // esci
				esci = true;
				break;
			default:
				System.out.println("Scelta non valida.");
			}
		} while (!esci);
		sc.close();
		System.out.println("La ringraziamo per il suo tempo.");
	}

}
