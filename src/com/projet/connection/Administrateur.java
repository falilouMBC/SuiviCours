package com.projet.connection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.projet.exception.UMSException;
import com.projet.user.entities.Utilisateur;

public class Administrateur {
	
	public void create(Utilisateur utilisateur) throws SQLException, Exception
	{
		try (Connection connection = DbConnection.getConnection()){
			
			String query = "Insert into utilisateur (login,pwd,prenom,nom,numero_tel,email,statut) values (?,?,?,?,?,?,?)"; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,utilisateur.getLogin());
			preparedStatement.setString(2,utilisateur.getPassword());
			preparedStatement.setString(3,utilisateur.getPrenom());
			preparedStatement.setString(4,utilisateur.getNom());
			preparedStatement.setString(5,utilisateur.getNumero());
			preparedStatement.setString(6,utilisateur.getEmail());
		    preparedStatement.setString(7,utilisateur.getRole());
			preparedStatement.execute();
			
		}catch(Exception e) {
			
			throw new UMSException (e.getClass() + ":" + e.getMessage());
			
		}
	}
	
	public void delete (int id) throws  UMSException {
		
		try (Connection connection = DbConnection.getConnection()){
			
			String query = "Delete From utilisateur Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			} catch (Exception e) {
				
				throw new UMSException(e.getMessage());
				
			}

	}
	
	public void update (Utilisateur utilisateur) throws UMSException {
		try (Connection connection = DbConnection.getConnection()){
			
			String query = "Update utilisateur set login = ?, pwd = ?,nom = ?, prenom = ?,numero_tel = ?, email = ?, statut = ? where id = ?"; 
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,utilisateur.getLogin());
			preparedStatement.setString(2,utilisateur.getPassword());
			preparedStatement.setString(3,utilisateur.getPrenom());
			preparedStatement.setString(4,utilisateur.getNom());
			preparedStatement.setString(5,utilisateur.getNumero());
			preparedStatement.setString(6,utilisateur.getEmail());
			preparedStatement.setString(7,utilisateur.getRole());
			preparedStatement.setInt(8,utilisateur.getId());
			preparedStatement.execute();
			
		}catch(Exception e) {
			
			throw new UMSException (e.getClass() + ":" + e.getMessage());
			
		}
	}
	
	public Utilisateur read (int id) throws UMSException {
		
		try (Connection connection = DbConnection.getConnection()) {
			
			String query = "Select * From utilisateur where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				return new Utilisateur(id, rs.getString("login"),
						rs.getString("pwd"),rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),rs.getString("numero_tel"),rs.getString("statut"));
				
			}
		} catch (Exception e) {
			
			throw new UMSException(e.getClass() + ":" + e.getMessage());
			
		}
			
		return null;
		
	}
}