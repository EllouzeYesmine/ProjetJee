<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Interface Enseignant</title>
<link rel="stylesheet" href="css/enseignantStyle.css">
</head>
<body>
	<header>
		<h1>Interface Enseignant</h1>
	</header>
	<main>
		<div class="container">
			<div class="data-entry">
				<form action="DemandeTirageServlet" method="post" enctype="multipart/form-data">
					<label for="matiere">Matière :</label> <select id="matiere"
						name="matiere">
						<option value="mathematiques">Mathématiques</option>
						<option value="physique">Physique</option>
						<option value="chimie">Chimie</option>
						
					</select> 
					<label for="groupe">Groupes :</label> <select id="groupe"
						name="groupe">
						<option value="G1">G1</option>
						<option value="G2">G2</option>
						<option value="G3">G3</option>
						
					</select>
					<label for="documentPDF">Document PDF à imprimer :</label> <input
						type="file" id="documentPDF" name="documentPDF"> 
						<label
						for="dateArrivee">Date de recuperartion :</label> <input type="date"
						id="dateArrivee" name="dateArrivee"> <label
						for="heureArrivee">Heure d'arrivée :</label> <input type="time"
						id="heureArrivee" name="heureArrivee"> <label
						for="nombreCopies">Nombre de copies :</label> <input type="number"
						id="nombreCopies" name="nombreCopies"> <label
						for="nombreEtudiantsDansGroupe">Nombre d'étudiants dans le
						groupe :</label> <input type="number" id="nombreEtudiantsDansGroupe"
						name="nombreEtudiantsDansGroupe"> 
						<input type="submit" value="Envoyer">
						
				</form>
			</div>
		</div>
	</main>
	<footer>
		<p>© 2024 Plateforme de Gestion d'Impression. Tous droits
			réservés.</p>
	</footer>
</body>
</html>
