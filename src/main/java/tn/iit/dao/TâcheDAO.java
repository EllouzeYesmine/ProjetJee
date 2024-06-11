package tn.iit.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import tn.iit.model.Tâche;
import utils.JDBUtils;

public class TâcheDAO {
    public static List<Tâche> getTaches() throws SQLException {
        List<Tâche> taches = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBUtils.getConnection();

            String query = "SELECT nom_enseignant, nombre_copies, date_reception, document_imprimer FROM taches";

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nomEnseignant = rs.getString("nom_enseignant");
                int nombreCopies = rs.getInt("nombre_copies");
                String dateReception = rs.getString("date_reception");
                String documentImprimer = rs.getString("document_imprimer");

                Tâche tache = new Tâche(nomEnseignant, nombreCopies, dateReception, documentImprimer);
                taches.add(tache);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return taches;
    }
}
