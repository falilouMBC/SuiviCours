package com.projet.cheque;

public class Cheque {
	
	private int numCheque;
	private String nomEnseignant;
	private double montant;
	private String banque;
	
	
	
	
	
	public Cheque(int numCheque, String nomEnseignant, double montant, String banque) {
		super();
		this.numCheque = numCheque;
		this.nomEnseignant = nomEnseignant;
		this.montant = montant;
		this.banque = banque;
	}


	public Cheque(int numCheque, String nomEnseignant, double montant) {
		
		this.numCheque = numCheque;
		this.nomEnseignant = nomEnseignant;
		this.montant = montant;
	}


	public int getNumCheque() {
		return numCheque;
	}


	public void setNumCheque(int numCheque) {
		this.numCheque = numCheque;
	}


	public String getNomEnseignant() {
		return nomEnseignant;
	}


	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public String getBanque() {
		return banque;
	}


	public void setBanque(String banque) {
		this.banque = banque;
	}
	
}
