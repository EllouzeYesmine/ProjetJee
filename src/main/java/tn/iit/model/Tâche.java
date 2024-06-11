package tn.iit.model;

public class Tâche {
	private String nom_enseignant;
	private int nombreCopies;
	private String dateReception;
	private String documentImprimer;

	public Tâche(String nom_enseignant, int nombreCopies, String dateReception, String documentImprimer) {
		this.nom_enseignant = nom_enseignant;
		this.nombreCopies = nombreCopies;
		this.dateReception = dateReception;
		this.documentImprimer = documentImprimer;
	}

	public String getNomEnseignant() {
		return nom_enseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nom_enseignant= nomEnseignant;
	}

	public int getNombreCopies() {
		return nombreCopies;
	}

	public void setNombreCopies(int nombreCopies) {
		this.nombreCopies = nombreCopies;
	}

	public String getDateReception() {
		return dateReception;
	}

	public void setDateReception(String dateReception) {
		this.dateReception = dateReception;
	}

	public String getDocumentImprimer() {
		return documentImprimer;
	}

	public void setDocumentImprimer(String documentImprimer) {
		this.documentImprimer = documentImprimer;
	}
}
