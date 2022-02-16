package com.projet.user.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projet.classe.Classe;
import com.projet.connection.DbConnection;
import com.projet.exception.UMSException;
import com.projet.module.Cours;
import com.projet.module.Session;

public class ChefDeClasseDAO {
	public void modifierSession(Session session , Classe classe) throws UMSException {
		try (Connection connection = DbConnection.getConnection()){

			String query = "Update session set heureDebut = ?, heureFin = ?,contenuEffectue = ?, nomCours = ? where nomCours = ? and responsable= ?"; 
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1,session.getHeureDebut());
			preparedStatement.setInt(2,session.getHeureFin());
			preparedStatement.setString(3,session.getcontenueEffectue());
			preparedStatement.setString(4,session.getnomCours());
			preparedStatement.setString(5,classe.getResponsable());
			preparedStatement.execute();

		}catch(Exception e) {

			throw new UMSException (e.getClass() + ":" + e.getMessage());

		}
	}
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
}
