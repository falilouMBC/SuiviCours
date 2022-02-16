package com.projet.UI;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.projet.exception.UMSException;
import com.projet.metier.Metier;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentifier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField pwdField;
	private JTextField loginField;
	private JButton btnConnecter;

	public Authentifier() {
		addListeners();
		initConponents(); 
	}

	private void addListeners() {

		btnConnecter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				authentifier();

			}
		});

	}

	public void initConponents()
	{
		setSize(new Dimension(365, 150));
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel("Login");
		panel.add(lblNewLabel_1);

		loginField = new JTextField();
		panel.add(loginField);
		loginField.setColumns(10);

		JLabel lblNewLabel = new JLabel("password");
		panel.add(lblNewLabel);

		pwdField = new JPasswordField(10);
		panel.add(pwdField);
		pwdField.setColumns(10);

		btnConnecter = new JButton("Sign in");
		btnConnecter.setPreferredSize(new Dimension(95,23));
		panel.add(btnConnecter);
	}

	public void authentifier() {
		String login = loginField.getText();
		char[] pwdArray = pwdField.getPassword();
		String password = String.valueOf(pwdArray);
		try {
			boolean statut;
			statut = Metier.Seconnecter(login, password);
			if(statut == true) {
				JOptionPane.showMessageDialog(null,"Authentification","Vous etes authentifié",JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"Authentification","erreur authentification",JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (UMSException e1) {
			e1.printStackTrace();
		}
	}

	public void MontreToi() {
		this.setVisible(true);
	}

}
