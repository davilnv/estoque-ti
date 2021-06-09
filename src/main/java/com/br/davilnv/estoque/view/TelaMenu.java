package com.br.davilnv.estoque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaMenu extends TelaPadrao{
	
	private JLabel logoLabel;
	private JButton entrarButton;

	public TelaMenu(String titulo) {
		super(titulo);
		
		ImageIcon icone = new ImageIcon("res/logo.png");
		logoLabel = new JLabel(icone);
		logoLabel.setBounds(483, 200, 400, 177);
		entrarButton = new JButton("Entrar");
		entrarButton.setBackground(Color.WHITE);
		entrarButton.setFont(new Font("Arial", Font.BOLD, 14));
		entrarButton.setBounds(583, 407, 200, 30);
		

		
		add(logoLabel);
		add(entrarButton);

		setVisible(true);
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public JButton getEntrarButton() {
		return entrarButton;
	}
	
}
