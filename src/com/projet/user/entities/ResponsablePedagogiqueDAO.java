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

public class ResponsablePedagogiqueDAO {

	public void validerEtatpaiement(Cours cours ,Enseignant enseignant) throws UMSException {
		try (Connection connection = DbConnection.getConnection()){

			String query = "Insert into cours (valideretatpaiement) values (?) where nomEnseignant=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setBoolean(1,cours.isValiderEtatPaiement());
			preparedStatement.setString(2,enseignant.getNom());
			preparedStatement.execute();

		}catch(Exception e) {



			throw new UMSException (e.getClass() + ":" + e.getMessage());

		}
	}
	
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

	public List<Cours> listCours() throws UMSException {
		List<Cours> cours = new ArrayList<Cours>();

		try (Connection connection = DbConnection.getConnection()) {

			String query = "Select nomEnseignat, etat, etatPaiement From cours";
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				cours.add(new Cours(rs.getString("nomEnseignant"),rs.getString("etat"),
						rs.getInt("etatPaiement")));

			}
		} catch (Exception e) {

			throw new UMSException(e.getClass() + ":" + e.getMessage());

		}

		return cours;
	}
	
}
