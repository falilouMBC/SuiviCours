package com.projet.user.entities;


public class Comptable extends Utilisateur {

	public Comptable() {
		super();
		
	}

	public Comptable(int id, String login, String password, String prenom, String nom, String email, String numero,
			String role) {
		super(id, login, password, prenom, nom, email, numero, role);
		
	}

	public Comptable(int id, String prenom, String nom, String email, String numero) {
		super(id, prenom, nom, email, numero);
		
	}

	public Comptable(String login, String password, String prenom, String nom, String email, String numero,
			String role) {
		super(login, password, prenom, nom, email, numero, role);
		
	}
	
	
	
}