package it.polito.tdp.lab04.controller;

import java.util.Collections;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model m;
	List<Corso> corsi = new LinkedList<Corso>();
	
	@FXML
	private ComboBox<Corso> comboCorso;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnCercaNome;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	public void setModel(Model model){
		this.m=model;
		corsi = m.lista();
		comboCorso.getItems().addAll(corsi);
		}
	
	
	@FXML
	void doReset(ActionEvent event) {
		txtNome.clear();
		txtCognome.clear();
		txtMatricola.clear();
		txtResult.clear();
		comboCorso.setValue(null);
	}

	@FXML
	void doCercaNome(ActionEvent event) {
		
		Corso c= comboCorso.getValue();
		String codice = txtMatricola.getText();
    	
    	if(codice.length()>11){
    		txtResult.appendText("Matricola inesistente\n");	
        	return;    		
    	}
    	
    	Studente s=m.CercaStudente(codice);
    	
    	if(s==null){
    		txtResult.appendText("Studente "+codice+" non trovato\n");
    		return;
    	}
    	else {
    		txtNome.setText(s.getNome());
    		txtCognome.setText(s.getCognome());}
    	
    	
    	
    	
	}

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {
		List<Studente> studenti=new LinkedList<Studente>();
		String ris="";
		Corso c=comboCorso.getValue();
				
		if(c==null){
			txtResult.setText("Non hai selezionato un corso");
			return;
		}
		else 
			studenti=m.cercaStudentiDalCorso(c);
		
		for(Studente s: studenti)
			ris+=s.toString()+"\n";
		txtResult.setText(ris);
	}

	@FXML
	void doCercaCorsi(ActionEvent event) {
		List<Corso> c = new LinkedList<Corso>();
		String matricola=txtMatricola.getText();
		c=m.CercaCorsiDelloStudente(matricola);
		String ris="";
		for(Corso c1 : c){  
			ris+=c1.toString()+"\n";
		}
		txtResult.setText(ris);
	}

	@FXML
	void doIscrivi(ActionEvent event) {
		Corso c=comboCorso.getValue();
		String matricola=txtMatricola.getText();
	
	}
			

	@FXML
	void initialize() {
		

		assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	
		
	
	}
	
	
}
