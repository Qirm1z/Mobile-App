package model;

import java.util.ArrayList;

public class MobileApp {

	private String nome, oS; //ho rinominato sistemaOperativo con oS per comodità personale
	private float prezzo, ricavoTotale;
	private ArrayList<Recensione> elencoRecensioni;

	public MobileApp(String nome, String oS, float prezzo) {
		this.nome = nome;
		this.oS = oS;
		this.prezzo = prezzo;
		this.elencoRecensioni = new ArrayList<>();
		this.ricavoTotale = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Il nome non può essere vuoto.");
		}
		this.nome = nome;
	}

	public String getoS() {
		return oS;
	}

	public void setoS(String oS) {
		if (oS == null || oS.trim().isEmpty()) {
			throw new IllegalArgumentException("Il sistema operativo non può essere vuoto.");
		}
		this.oS = oS;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		if (prezzo < 0) {
			throw new IllegalArgumentException("Il prezzo non può essere negativo.");
		}
		this.prezzo = prezzo;
	}

	public float getRicavoTotale() {
		return ricavoTotale;
	}

	public void setRicavoTotale(float ricavoTotale) {
		this.ricavoTotale = ricavoTotale;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

	public void setElencoRecensioni(ArrayList<Recensione> elencoRecensioni) {
		this.elencoRecensioni = elencoRecensioni;
	}

	// metodi
	public void download() {
		ricavoTotale += prezzo;
	}

	public void download(int numeroDownload) {
		if (numeroDownload < 1) {
			throw new IllegalArgumentException("Il numero di download deve essere positivo.");
		}
		ricavoTotale += prezzo * numeroDownload;
	}

	public void riceviRecensione(Recensione recensione) {
		if (recensione != null) {
			elencoRecensioni.add(recensione);
		} else {
			throw new IllegalArgumentException("La recensione non può essere null.");
		}
	}

	public float valutazioneMedia() {
		if (elencoRecensioni.isEmpty()) {
			return 0;
		}

		int sommaStelle = 0;
		for (Recensione recensione : elencoRecensioni) {
			sommaStelle += recensione.getNumeroStelle();
		}

		return (float) sommaStelle / elencoRecensioni.size();
	}

	@Override
	public String toString() {
		return "Mobile App:" + "[nome=" + nome + " | sistema operativo=" + oS + " | prezzo=" + prezzo
				+ " | elenco recensioni=" + elencoRecensioni + " | ricavo totale=" + ricavoTotale + "]";
	}

}
