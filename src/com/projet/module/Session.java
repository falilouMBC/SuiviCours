package com.projet.module;

public class Session {
	private boolean valider ;
	private String commentaire ;
	private int heureDebut;
	private int heureFin;
	private String contenueEffectue ;
	private String nomCours ;
	
	public Session(int heureDebut, int heureFin, String contenueEffectue, String nomCours) {
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.contenueEffectue = contenueEffectue;
		this.nomCours = nomCours;
	}
	
	public Session(boolean valider, String  commentaire) {
		this.valider = valider;
		this.commentaire = commentaire;
	}
	
	public int getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}
	public int getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}
	public String getcontenueEffectue() {
		return contenueEffectue;
	}
	public void setcontenueEffectue(String contenueEffectue) {
		this.contenueEffectue = contenueEffectue;
	}
	public String getnomCours() {
		return nomCours;
	}
	public void setnomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	public boolean isValider() {
		return valider;
	}
	public void setValider(boolean valider) {
		this.valider = valider;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
}
