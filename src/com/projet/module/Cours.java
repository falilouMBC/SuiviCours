package com.projet.module;

public class Cours {

	private String contenu;
	private int id_cours ;
	private int duree;
	private int nbreHeureTotal;
	private int nbreHeureFait;
	private String etat ;
	private String nomEnseignant ;
	private double etatPaiement ;
	private boolean validerEtatPaiement ;
	private boolean report;
	private boolean annule;

	public Cours(String contenu, int duree, int nbreHeureTotal, int nbreHeureFait, String etat , String nomEnseignant,double etatPaiement,boolean validerEtatPaiement) {
		this.validerEtatPaiement = validerEtatPaiement ;
		this.nomEnseignant = nomEnseignant;
		this.contenu = contenu;
		this.setDuree(duree);
		this.nbreHeureTotal = nbreHeureTotal;
		this.nbreHeureFait = nbreHeureFait;
		this.etat = etat ;
		this.etatPaiement=etatPaiement ;

	}
	public Cours(int id_cours, String contenu, int duree, int nbreHeureTotal, int nbreHeureFait, String etat , String nomEnseignant) {
		this.id_cours=id_cours ;
		this.nomEnseignant = nomEnseignant;
		this.contenu = contenu;
		this.setDuree(duree);
		this.nbreHeureTotal = nbreHeureTotal;
		this.nbreHeureFait = nbreHeureFait;
		this.etat = etat ;

	}
	public Cours(String nomEnseignant, double etatPaiement, String contenu) {
	this.nomEnseignant = nomEnseignant;
	this.etatPaiement = etatPaiement;
	this.contenu = contenu;
	}
	
	



	public Cours(String nomEnseignant,String etat, double etatPaiement) {
		
		this.nomEnseignant = nomEnseignant;
		this.etat = etat;
		this.etatPaiement = etatPaiement;
	
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		if(duree > 0)
			this.duree = duree;
	}

	public int getNbreHeureTotal() {
		return nbreHeureTotal;
	}

	public void setNbreHeureTotal(int nbreHeureTotal) {
		this.nbreHeureTotal = nbreHeureTotal;
	}

	public int getNbreHeureFait() {
		return nbreHeureFait;
	}

	public void setNbreHeureFait(int nbreHeureFait) {
		this.nbreHeureFait = nbreHeureFait;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public int getid_cours() {
		return id_cours;
	}
	public double getEtatPaiement() {
		return etatPaiement;
	}
	public void setEtatPaiement(double etatPaiement) {
		this.etatPaiement = etatPaiement;
	}
	
	public boolean isValiderEtatPaiement() {
		return validerEtatPaiement;
	}
	public void setValiderEtatPaiement(boolean validerEtatPaiement) {
		this.validerEtatPaiement = validerEtatPaiement;
	}
	public boolean isReport() {
		return report;
	}
	public void setReport(boolean report) {
		this.report = report;
	}
	public boolean isAnnule() {
		return annule;
	}
	public void setAnnule(boolean annule) {
		this.annule = annule;
	}
	

}



