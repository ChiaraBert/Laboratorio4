package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				int x=Integer.parseInt(rs.getString("crediti"));
				int x1=Integer.parseInt(rs.getString("pd"));

				Corso c = new Corso(rs.getString("codins"),x,rs.getString("nome"),x1);
						//String codins, int crediti, String nome, int pd
						// Crea un nuovo JAVA Bean Corso
				corsi.add(c);// Aggiungi il nuovo Corso alla lista
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso ?????
	 */
	public void getCorso(Corso corso) { 
		
		final String sql = "SELECT * FROM corso WHERE codins=?";

		Corso result= null;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, corso.getCodins());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				int x=Integer.parseInt(rs.getString("crediti"));
				int x1=Integer.parseInt(rs.getString("pd"));

				Corso c = new Corso(rs.getString("codins"),x,rs.getString("nome"),x1);}

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		
		final String sql = "SELECT studente.matricola,studente.nome,studente.cognome,studente.CDS "+
							"FROM studente,iscrizione "+
							"WHERE studente.matricola=iscrizione.matricola AND iscrizione.codins=?";

		List<Studente> studenti=new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, corso.getCodins());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
			Studente s=new Studente(rs.getString("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("cds"));
			studenti.add(s);
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return studenti;
		
		// TODO
	}
	
		
	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		return false;
	}
}
