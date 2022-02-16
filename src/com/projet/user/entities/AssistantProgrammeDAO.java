package com.projet.user.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projet.classe.Classe;
import com.projet.connection.DbConnection;
import com.projet.edt.EmploiDuTemps;
import com.projet.exception.UMSException;
import com.projet.module.Cours;

public class AssistantProgrammeDAO {
	
	// Creer cours veut dire saisir emploi du temps dans ce cas
		public void creerCours(Cours cours) throws UMSException { 
			try (Connection connection = DbConnection.getConnection()) {
				String query = "INSERT into cours (contenu,duree,nbreHeureTotal,nbreHeureFait) values (?,?,?,?) ";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1,cours.getContenu());
				preparedStatement.setInt(2,cours.getDuree());
				preparedStatement.setInt(3,cours.getNbreHeureFait());
				preparedStatement.setInt(4,cours.getNbreHeureFait());
				preparedStatement.execute();
			} catch (Exception e) {
				// TODO: handle exception
				throw new UMSException (e.getClass() + ":" + e.getMessage());
			}
		}

		// modifier l'emploi du temps
		public void modifierEdt(Cours cours , EmploiDuTemps edt) throws UMSException {
			try (Connection connection = DbConnection.getConnection()){
				if(cours.isReport() || cours.isAnnule()) {
					String query = "Update emploidutemps set jour = ?, temps = ? where nomCours = ? and nomEnseignant = ?"; 
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1,edt.getJour());
					preparedStatement.setString(2,edt.getTemps());
					preparedStatement.setString(3,cours.getContenu());
					preparedStatement.setString(4,cours.getNomEnseignant());
					preparedStatement.execute();
				}

			}catch(Exception e) {

				throw new UMSException (e.getClass() + ":" + e.getMessage());

			}
		}
		// Creer une classe et y ajouter un enseignant
		public void creerClasse(Classe classe) throws UMSException {
			try (Connection connection = DbConnection.getConnection()) {
				String query = "INSERT into classe (nomClasse,salle,responsable) values (?,?,?,?) ";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1,classe.getNomClasse());
				preparedStatement.setString(2,classe.getSalle());
				preparedStatement.setString(3,classe.getResponsable());
				preparedStatement.execute();
			} catch (Exception e) {
				// TODO: handle exception
				throw new UMSException (e.getClass() + ":" + e.getMessage());
			}
		}
		// Cloturer un module si le nbre d'heure est terminer 
		public void cloturerModule(Cours module) throws UMSException {
			if(module.getNbreHeureFait()<module.getNbreHeureTotal()) {
				try (Connection connection = DbConnection.getConnection()) {
					String query = "INSERT into cours (etat) values (?) ";
					PreparedStatement preparedStatement = connection.prepareStatement(query);

					preparedStatement.setString(1,module.getEtat());
					preparedStatement.execute();
				} catch (Exception e) {
					// TODO: handle exception
					throw new UMSException (e.getClass() + ":" + e.getMessage());
				}
			}
		}
		// Visualiser les etats des enseignants 
		public List<Enseignant> List() throws UMSException
		{
			List<Enseignant> enseignant = new ArrayList<Enseignant>();

			try (Connection connection = DbConnection.getConnection()) {

				String query = "Select * From enseignant";
				PreparedStatement ps = connection.prepareStatement(query);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {


					enseignant.add(new Enseignant(rs.getInt("id"),rs.getString("prenom"),
							rs.getString("nom"),rs.getString("email"),rs.getString("numero"),rs.getString("etat")));

				}
			} catch (Exception e) {

				throw new UMSException(e.getClass() + ":" + e.getMessage());

			}

			return enseignant;
		}

		public void modifierInfPerso(AssistantProgramme assistant) throws UMSException {
			try (Connection connection = DbConnection.getConnection()){

				String query = "Update assistant_prog set login = ?, pwd = ?,nom = ?, prenom = ?,numero_tel = ?, email = ?, where id = ?"; 
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1,assistant.getLogin());
				preparedStatement.setString(2,assistant.getPassword());
				preparedStatement.setString(3,assistant.getPrenom());
				preparedStatement.setString(4,assistant.getNom());
				preparedStatement.setString(5,assistant.getNumero());
				preparedStatement.setString(6,assistant.getEmail());
				preparedStatement.setInt(8,assistant.getId());
				preparedStatement.execute();

			}catch(Exception e) {

				throw new UMSException (e.getClass() + ":" + e.getMessage());

			}
		}

		// Creer cours associer enseignant
		public void creerCoursAssocierEnseignant(Cours cours , Enseignant enseignant) throws UMSException  { 
			try (Connection connection = DbConnection.getConnection()) {
				String query = "INSERT into cours (contenu,duree,nbreHeureTotal,nbreHeureFait,nomEnseignant) values (?,?,?,?,?) ";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1,cours.getContenu());
				preparedStatement.setInt(2,cours.getDuree());
				preparedStatement.setInt(3,cours.getNbreHeureFait());
				preparedStatement.setInt(4,cours.getNbreHeureFait());
				preparedStatement.setString(5,cours.getNomEnseignant());

				preparedStatement.execute();
			} catch (Exception e) {
				// TODO: handle exception
				throw new UMSException (e.getClass() + ":" + e.getMessage());
			}
		}

	
}
