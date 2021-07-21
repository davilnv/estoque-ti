package com.br.davilnv.estoque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelBuscaComputador extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton buscarButton;
	private JTextField numeroField, nomeField;
	public boolean mudancaBusca = true;

	public PainelBuscaComputador(String titulo) {
		setSize(1336, 339);
		setBorder(BorderFactory.createTitledBorder(titulo));
		setLocation(15, 15);
		setLayout(null);
		
		numeroField = new JTextField();
		numeroField.setBounds(30, 66, 140, 20);
		nomeField = new JTextField();
		nomeField.setBounds(30, 66, 140, 20);

		buscarButton = new JButton("Buscar Computador");
		buscarButton.setBackground(Color.WHITE);
		buscarButton.setFont(new Font("Arial", Font.BOLD, 10));
		buscarButton.setBounds(30, 106, 140, 30);
		
		add(numeroField);
		add(nomeField);
		add(buscarButton);
		
		setVisible(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (mudancaBusca) {
			g.drawString("Nome do Computador:", 30, 50);
		} else {
			g.drawString("Número do Computador:", 30, 50);
		}
		
	}

	public JButton getBuscarButton() {
		return buscarButton;
	}

	public JTextField getNumeroField() {
		return numeroField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}
	
}
