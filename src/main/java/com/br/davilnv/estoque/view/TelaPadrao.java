package com.br.davilnv.estoque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class TelaPadrao extends JFrame{
	
	public TelaPadrao(String titulo) {
		super(titulo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		setExtendedState(MAXIMIZED_BOTH);
	}

}
