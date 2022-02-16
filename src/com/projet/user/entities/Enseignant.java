package com.projet.user.entities;


public class Enseignant extends Utilisateur {
	private String etat;

	public Enseignant(String login, String password, String prenom, String nom, String email, String numero,
			String role,String etat) {
		super(login, password, prenom, nom, email, numero, role);
		this.etat = etat ;
	}

	public Enseignant(int id,String prenom, String nom, String email, String numero,
			String etat) {
		this.prenom = prenom ;
		this.nom = nom ;
		this.email = email ;
		this.numero = numero ;
		this.etat = etat ;
	}

	public Enseignant(int id, String login, String password, String prenom, String nom, String email, String numero,
			String role) {
		super(id, login, password, prenom, nom, email, numero, role);
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}