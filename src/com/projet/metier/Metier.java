package com.projet.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.projet.connection.DbConnection;
import com.projet.exception.UMSException;


public class Metier {
	// essaie de la fonction se connecter
	
		public static  boolean Seconnecter(String login , String pwd) throws UMSException {
			try {
				Connection connection = DbConnection.getConnection();
				String query = "Select * From utilisateur ";
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					String login1 = rs.getString("login");
					String pwd1 = rs.getString("pwd");	
					if(login1.equals(login) && pwd1.equals(pwd)) {
						return true ;
					}
					return false ;
				}
			} catch (Exception e) {
				// TODO: handle exception
				throw new UMSException(e.getMessage());
			}
			return false;
		}
}
