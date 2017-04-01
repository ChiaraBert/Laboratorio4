package it.polito.tdp.lab04.model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	LinkedList<Corso> cor = new LinkedList<Corso>();
	
	
		
	public List<Corso> lista(){
		CorsoDAO cr = new CorsoDAO();
		List<Corso> cor = new LinkedList<Corso>();
		cor=cr.getTuttiICorsi();
		return cor;
		
	}
	
	public Studente CercaStudente(String codice){
		StudenteDAO er = new StudenteDAO();
		Studente s=er.getStudente(codice);
		return s;
	}
	
	public List<Corso> CercaCorsiDelloStudente(String matricola){
		StudenteDAO er = new StudenteDAO();
		List<Corso> corsi = new LinkedList<Corso>();
		corsi=er.CercaCorsiStudente(matricola);
		return corsi;
	}

	public List<Studente> cercaStudentiDalCorso(Corso c) {
		CorsoDAO cr = new CorsoDAO();
		List<Studente> s=new LinkedList<Studente>();
		s=cr.getStudentiIscrittiAlCorso(c);
		return s;
	}
	
	public boolean trovato(Corso c,String matricola){
		boolean t=false;
		StudenteDAO er= new StudenteDAO();
		t=er.EsisteStudenteInCorso(c, matricola);
		return t;
	}

	public boolean aggiungiStudente(Corso c, Studente s) {
		// TODO Auto-generated method stub
		boolean t=false;
		CorsoDAO cr = new CorsoDAO();
		t=cr.inscriviStudenteACorso(s, c);
		return t;
	}

	

	

}
