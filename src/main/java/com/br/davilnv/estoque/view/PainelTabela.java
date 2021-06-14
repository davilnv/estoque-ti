package com.br.davilnv.estoque.view;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PainelTabela extends JPanel{
	private Font fonte;
	
	public PainelTabela(String titulo) {
		setSize(1336, 339);
		setBorder(BorderFactory.createTitledBorder(titulo));
		setLocation(15, 364);
		setLayout(null);
		
		fonte = new Font("Arial", Font.PLAIN, 12);

		setVisible(false);
	}

	public Font getFonte() {
		return fonte;
	}
}
