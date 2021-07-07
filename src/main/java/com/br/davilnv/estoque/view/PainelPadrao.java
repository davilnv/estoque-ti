package com.br.davilnv.estoque.view;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PainelPadrao extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font fonte;
	
	public PainelPadrao(String titulo) {
		setSize(1336, 339);
		setBorder(BorderFactory.createTitledBorder(titulo));
		setLocation(15, 15);
		setLayout(null);
		
		fonte = new Font("Arial", Font.PLAIN, 12);

		setVisible(false);
	}

	public Font getFonte() {
		return fonte;
	}

}
