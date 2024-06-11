package tn.iit.model;

public class Tâche {
	private Teacher enseignant;
	private int nombreCopies;
	private String dateReception;
	private String documentImprimer;

	public Tâche(Teacher enseignant, int nombreCopies, String dateReception, String documentImprimer) {
		this.enseignant = enseignant;
		this.nombreCopies = nombreCopies;
		this.dateReception = dateReception;
		this.documentImprimer = documentImprimer;
	}

	public String getNomEnseignant() {
		return enseignant.getUsername();
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.enseignant.setUsername(nomEnseignant);
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
