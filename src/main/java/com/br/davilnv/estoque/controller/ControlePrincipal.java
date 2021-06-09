package com.br.davilnv.estoque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.br.davilnv.estoque.view.TelaMenu;
import com.br.davilnv.estoque.view.TelaPrincipal;

public class ControlePrincipal implements ActionListener{
	
	TelaMenu telaMenu;
	TelaPrincipal telaPrincipal;
	
	public ControlePrincipal(TelaMenu telaMenu, TelaPrincipal telaPrincipal) {
		super();
		this.telaMenu = telaMenu;
		this.telaPrincipal = telaPrincipal;
		
		telaMenu.getEntrarButton().addActionListener(this);
		
		telaPrincipal.getAdicionarItem().addActionListener(this);
		telaPrincipal.getPainelAdicionarComputador().getConfirmarAdicaoButton().addActionListener(this);;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaMenu.getEntrarButton()) {
			telaPrincipal.setVisible(true);
			telaMenu.setVisible(false);
		}
		
		if(e.getSource() == telaPrincipal.getAdicionarItem()) {
			telaPrincipal.getPainelAdicionarComputador().setVisible(true);
		}
		
		if(e.getSource() == telaPrincipal.getPainelAdicionarComputador().getConfirmarAdicaoButton()) {
			
		}
	}

}
