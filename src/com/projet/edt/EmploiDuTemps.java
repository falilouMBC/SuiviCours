package com.projet.edt;


public class EmploiDuTemps {

	private String periode ;
	private String jour;
	private String temps;
	private String module;
	private String nomEnseignant;

	public EmploiDuTemps(String periode,String jour, String temps, String module, String nomEnseignant) {

		this.jour = jour;
		this.temps = temps;
		this.module = module;
		this.nomEnseignant = nomEnseignant;
		this.periode = periode ;

	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}


	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}


	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}


}
