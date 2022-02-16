package com.projet.user.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projet.connection.DbConnection;
import com.projet.edt.EmploiDuTemps;
import com.projet.exception.UMSException;
import com.projet.module.Cours;
import com.projet.module.Session;

public class EnseignantDAO {
	
	public void validerModification(Session session) throws UMSException {
		try (Connection connection = DbConnection.getConnection()) {
			String query = "INSERT into session (valider,commentaire) values (?,?) where nomCours=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setBoolean(1,session.isValider());
			preparedStatement.setString(2,session.getCommentaire());

			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			throw new UMSException (e.getClass() + ":" + e.getMessage());
		}

	}
	// Il peut visualiser la situation d’un cours (les séances réalisées, le nombre d’heures realiser , 
	public List<Cours> listCours() throws UMSException {
		List<Cours> cours = new ArrayList<Cours>();

		try (Connection connection = DbConnection.getConnection()) {

			String query = "Select * From cours";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {


				cours.add(new Cours(rs.getInt("id_cours"),rs.getString("module"),
						rs.getInt("duree"),rs.getInt("heureDebut"),rs.getInt("heureFin"),rs.getString("etat"),rs.getString("nomEnseignant")));

			}
		} catch (Exception e) {

			throw new UMSException(e.getClass() + ":" + e.getMessage());

		}

		return cours;
	}
	// Il peut visualiser les emplois du temps passés, l’emploi du temps de la période en
	// cours et s’il est disponible celui de la période suivante

	public List<EmploiDuTemps> ListEDT() throws UMSException {
		List<EmploiDuTemps> emploiDuTemps = new ArrayList<EmploiDuTemps>();

		try (Connection connection = DbConnection.getConnection()) {

			String query = "Select * From emploidutemps";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				emploiDuTemps.add(new EmploiDuTemps(rs.getString("periode"),rs.getString("jour"),
						rs.getString("temps"),rs.getString("module"),rs.getString("enseignant")));

			}
		} catch (Exception e) {

			throw new UMSException(e.getClass() + ":" + e.getMessage());

		}

		return emploiDuTemps;
		
	}

	public Cours readEtat (Cours cours, Enseignant enseignant) throws UMSException {

		try (Connection connection = DbConnection.getConnection()) {
			if(cours.getNbreHeureFait() == cours.getNbreHeureTotal()) {
				String query = "Select nbreHeureFait * 5000 as etatPaiement From cours where id_cours= ? and nomEnseignant = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1,cours.getid_cours());
				ps.setString(2,enseignant.getNom());

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					return new Cours(rs.getString("nomEnseignant"),
							rs.getDouble("etatPaiemnt"),rs.getString("contenu"));
				}
			}
		} catch (Exception e) {

			throw new UMSException(e.getClass() + ":" + e.getMessage());
		}
		return cours;

	}
	
}
