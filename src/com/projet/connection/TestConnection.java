package com.projet.connection;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.projet.exception.UMSException;
import com.projet.user.entities.Utilisateur;


public class TestConnection {

	public static void testCreate() {

		Utilisateur user = new Utilisateur("login","password","falilou","nom","775415594","cissefalilou8@gmail.com","comptable");

		try {

			Administrateur admin = new Administrateur();
			admin.create(user);
			JOptionPane.showMessageDialog(null, "utilisation ajoutée avec succée","Ajout d un utilisateur",JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage(),"Ajout d'un utilisateur",JOptionPane.ERROR_MESSAGE);

		} 
	}


	public static void main(String[] args) throws SQLException, Exception {
		try {

			Administrateur admin = new Administrateur();
			String response = JOptionPane.showInputDialog("Veuillez entrez l'id de l'utilisateur svp");
			int id = Integer.parseInt(response);

			Utilisateur user = admin.read(id);
			if(user == null) {

				JOptionPane.showMessageDialog(null,"l'utilisateur " + id + "n existe pas en base de donnes"
						,"Modication d'un utilisateur",JOptionPane.INFORMATION_MESSAGE);

			} else {

				String login = JOptionPane.showInputDialog(null,"veuillez entrer le nouveau login svp");
				String password = JOptionPane.showInputDialog(null,"veuillez entrer le nouveau mot de passe svp");

				user.setLogin(login);
				user.setPassword(password);

				admin.update(user);

				JOptionPane.showMessageDialog(null,"l'utilisateur " + id + "est modifie avec succée"
						,"Modication d'un utilisateur",JOptionPane.INFORMATION_MESSAGE);
			}

		}catch(UMSException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(),"Modificateur d'un utilisateur",JOptionPane.ERROR_MESSAGE);

		}

	}

}
