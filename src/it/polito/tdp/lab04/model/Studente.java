package it.polito.tdp.lab04.model;

public class Studente {
	
	private String nome;
	private String cognome;
	private String matricola;
	private String CDS;
	
	public Studente(String matricola, String nome, String cognome, String cDS) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		CDS = cDS;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getCDS() {
		return CDS;
	}
	public void setCDS(String cDS) {
		CDS = cDS;
	}
	@Override
	public String toString() {
		return matricola+" "+nome+" "+cognome+" "+CDS;
	}
	
	
	
}
