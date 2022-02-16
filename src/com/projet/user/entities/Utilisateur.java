package com.projet.user.entities;

public class Utilisateur {
	
	protected int id;
	protected String login;
	protected String password;
	protected String prenom;
	protected String nom;
	protected String email;
	protected String numero;
	protected String role;
	
	public Utilisateur(String login, String password,String prenom,String nom,String email,String numero,String role) {
		this.login = login;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.numero = numero;
		this.role = role;
	}
	
	
	
	
	
	public Utilisateur(int id, String prenom, String nom, String email, String numero) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.numero = numero;
	}





	public Utilisateur() {
		
	}





	public Utilisateur(int id, String login, String password, String prenom, String nom, String email, String numero,
			String role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.numero = numero;
		this.role = role;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", password=" + password + ", prenom=" + prenom + ", nom="
				+ nom + "]";
	}

	public void Seconnecter(String login, String password)
	{
		
	}
}
