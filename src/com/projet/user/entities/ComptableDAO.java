package com.projet.user.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projet.cheque.Cheque;
import com.projet.connection.DbConnection;
import com.projet.exception.UMSException;
import com.projet.module.Cours;

public class ComptableDAO {
	public List<Cours> listCours() throws UMSException {
		List<Cours> cours = new ArrayList<Cours>();

		try (Connection connection = DbConnection.getConnection()) {

			String query = "Select nomEnseignat, etat, etatPaiement From cours where valideretatpaiement = 1";
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
	
	public void EtablirCheque(Cheque cheque) throws UMSException {
		
		try (Connection connection = DbConnection.getConnection()){

			String query = "Insert into cheque (numCheque,nomEnseignant,banque, montant) values (?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1,cheque.getNumCheque());
			preparedStatement.setString(2,cheque.getNomEnseignant());
			preparedStatement.setDouble(3,cheque.getMontant());
			preparedStatement.setString(2,cheque.getBanque());
			preparedStatement.execute();

		}catch(Exception e) {

			throw new UMSException (e.getClass() + ":" + e.getMessage());

		}
	}
}
