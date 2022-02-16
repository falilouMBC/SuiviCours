package com.projet.user.entities;


public class AssistantProgramme extends Utilisateur {

	public AssistantProgramme(String login, String password, String prenom, String nom, String email, String numero,
			String role) {
		super(login, password, prenom, nom, email, numero, role);

	}

	public AssistantProgramme() {

	}

	public AssistantProgramme(int id, String login, String password, String prenom, String nom, String email,
			String numero, String role) {
		super(id, login, password, prenom, nom, email, numero, role);

	}

}
