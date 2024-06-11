package tn.iit.model;

import java.util.Date;

public class DemandeTirage {
	private String matiere;
	private String groupe;
	private String document;
	private Date dateArrivee;
	private Date heureArrivee;
	private int nombreCopies;
	private int nombreEtudiantsDansGroupe;

	public DemandeTirage(String matiere, String groupe, String document, Date dateArrivee, Date heureArrivee,
			int nombreCopies, int nombreEtudiantsDansGroupe) {
		super();
		this.matiere = matiere;
		this.groupe = groupe;
		this.document = document;
		this.dateArrivee = dateArrivee;
		this.heureArrivee = heureArrivee;
		this.nombreCopies = nombreCopies;
		this.nombreEtudiantsDansGroupe = nombreEtudiantsDansGroupe;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public int getNombreCopies() {
		return nombreCopies;
	}

	public void setNombreCopies(int nombreCopies) {
		this.nombreCopies = nombreCopies;
	}

	public int getNombreEtudiantsDansGroupe() {
		return nombreEtudiantsDansGroupe;
	}

	public void setNombreEtudiantsDansGroupe(int nombreEtudiantsDansGroupe) {
		this.nombreEtudiantsDansGroupe = nombreEtudiantsDansGroupe;
	}

	public void envoyerDemandeImpression() {
		// Ici, vous mettriez le code pour envoyer la demande d'impression,

		System.out.println("Demande d'impression envoyee pour la matiere: " + matiere);
		System.out.println("Demande d'impression envoyee pour le groupe: " + groupe);
		System.out.println("Document: " + document);
		System.out.println("Date d'arrivee: " + dateArrivee);
		System.out.println("Heure d'arrivee: " + heureArrivee);
		System.out.println("Nombre de copies: " + nombreCopies);
		System.out.println("Nombre d'etudiants dans le groupe: " + nombreEtudiantsDansGroupe);
	}

}
