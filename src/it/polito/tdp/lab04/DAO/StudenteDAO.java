package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	private Studente s;
	
	public StudenteDAO(){
		
	}
	
	public Studente getStudente(String codice) { 		//public void getCorso(Corso corso)
		
		final String sql = "SELECT * "+
							"FROM studente "+
							"WHERE matricola=?";

		Studente result= null;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codice);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Studente s=new Studente(rs.getString("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("cds"));
				result=s;}
				
			
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException("Errore Db");
		}
		return result;	
		// TODO
	}

	public List<Corso> CercaCorsiStudente(String matricola){
		List<Corso> corsi = new LinkedList<Corso>();
		
		final String sql = "SELECT corso.codins,corso.crediti,corso.nome,corso.pd "+
							"FROM corso, iscrizione "+
							"WHERE corso.codins=iscrizione.codins AND iscrizione.matricola=?";

		
		try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, matricola);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			
			int x=Integer.parseInt(rs.getString("crediti"));
			int x1=Integer.parseInt(rs.getString("pd"));
		
			Corso s=new Corso(rs.getString("codins"),x,rs.getString("nome"),x1);
			corsi.add(s);}
			
		
		conn.close();
		
		} catch (SQLException e) {
		e.printStackTrace();
		//throw new RuntimeException("Errore Db");
		}
		return corsi;	

	}
	
	public boolean EsisteStudenteInCorso(Corso c, Studente s){
		boolean trovato=false;
		
		final String sql = "SELECT * "+
							"FROM iscrizione "+
							"WHERE matricola=? AND codins=?";
		
		try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, s.getMatricola());
		st.setString(2, c.getCodins());
		
		ResultSet rs = st.executeQuery();
		
		if(rs!=null) {
			trovato=true;
			}
			
		
		conn.close();
		
		} catch (SQLException e) {
		e.printStackTrace();
		//throw new RuntimeException("Errore Db");
		}
		return trovato;
	}
	
}
