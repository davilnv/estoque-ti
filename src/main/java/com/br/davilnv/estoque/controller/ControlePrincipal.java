package com.br.davilnv.estoque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.davilnv.estoque.model.Computador;
import com.br.davilnv.estoque.model.SQLiteJDBCDriverConnection;
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
			int id = 0;
			String nome = "";
			String processador = "";
			int memoria = 0;
			int hd = 0;
			int ssd = 0;
			String situacao = "";
			String observacao = "";
			String grupo = "";
			
			try {
				id = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getNumeroField().getText());
				nome = telaPrincipal.getPainelAdicionarComputador().getNomeField().getText();
				processador = telaPrincipal.getPainelAdicionarComputador().getProcessadorField().getText();
				if(nome.equals("") || processador.equals("")) {
					throw new Exception("Campo vazio");
				}
				memoria = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getMemoriaField().getText());
				hd = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getHdField().getText());
				ssd = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getSsdField().getText());
				situacao = telaPrincipal.getPainelAdicionarComputador().getSituacaoField().getText();
				observacao = telaPrincipal.getPainelAdicionarComputador().getObservacaoField().getText();
				grupo = ""+telaPrincipal.getPainelAdicionarComputador().getGrupoBox().getSelectedItem();
				Computador computador = new Computador(id, nome, processador, memoria, hd, ssd, situacao, observacao, grupo);
				SQLiteJDBCDriverConnection.adicionarComputador(computador);
				JOptionPane.showMessageDialog(null, "Computador adicionado!", "Sucesso", JOptionPane.DEFAULT_OPTION);
				telaPrincipal.getPainelAdicionarComputador().getNumeroField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getNomeField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getProcessadorField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getMemoriaField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getHdField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getSsdField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getSituacaoField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getObservacaoField().setText("");
				telaPrincipal.getPainelAdicionarComputador().getGrupoBox().setSelectedIndex(0);
			} catch (Exception ee) {
				JOptionPane.showMessageDialog(null, "Campo inválido", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		
		}
	}

}
