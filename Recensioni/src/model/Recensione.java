package model;

import java.time.LocalDate;

public class Recensione {

	private LocalDate data;
	private String nomeUtente, testo;
	private int numeroStelle;

	public Recensione(LocalDate data, String nomeUtente, int numeroStelle, String testo) {
		this.data = data;
		this.nomeUtente = nomeUtente;
		setNumeroStelle(numeroStelle);
		this.testo = testo;

	}

	// getter e setter
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(int numeroStelle) {
		if (numeroStelle < 0 || numeroStelle > 5) {
			throw new IllegalArgumentException("La valutazione deve essere contenuta tra i parametri 1 e 5.");
		}
		this.numeroStelle = numeroStelle;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	// override per una rappresentazione visiva più leggibile
	@Override
	public String toString() {
		return "[data:" + data + " | utente: " + nomeUtente + "| stelle:" + numeroStelle + " | testo: " + testo + "]";
	}
	//prova visualizzazione recensione
	public static void main(String[] args) {
		Recensione rec = new Recensione(LocalDate.now(), "Qirm1z", 3, "Niente di che...");
		System.out.println(rec);
	}
}
