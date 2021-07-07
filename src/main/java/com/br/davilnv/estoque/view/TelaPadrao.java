package com.br.davilnv.estoque.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TelaPadrao extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaPadrao(String titulo) {
		super(titulo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setExtendedState(MAXIMIZED_BOTH);
	}
}
