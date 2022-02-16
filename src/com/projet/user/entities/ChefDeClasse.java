package com.projet.user.entities;


public class ChefDeClasse extends Utilisateur {

	public ChefDeClasse(String login, String password, String prenom, String nom, String email, String numero,
			String role) 
	{
		super(login, password, prenom, nom, email, numero, role);

	}

	@Override
	public void Seconnecter(String login, String password) {

	}

	
}