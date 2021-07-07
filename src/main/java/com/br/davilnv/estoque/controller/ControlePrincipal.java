package com.br.davilnv.estoque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.davilnv.estoque.model.Computador;
import com.br.davilnv.estoque.model.Mensagens;
import com.br.davilnv.estoque.model.SQLiteJDBCDriverConnection;
import com.br.davilnv.estoque.view.TelaMensagem;
import com.br.davilnv.estoque.view.TelaMenu;
import com.br.davilnv.estoque.view.TelaPrincipal;

public class ControlePrincipal{
	
	TelaMenu telaMenu;
	TelaPrincipal telaPrincipal;
	
	public ControlePrincipal(TelaMenu telaMenu, TelaPrincipal telaPrincipal) {
		super();
		this.telaMenu = telaMenu;
		this.telaPrincipal = telaPrincipal;
		
		telaMenu.getEntrarButton().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					telaPrincipal.getPainelTabela().getModelo().setNumRows(0);
					telaPrincipal.getPainelTabela().criarTabela(SQLiteJDBCDriverConnection.listarComputador());
				} catch (SQLException e1) {
					TelaMensagem.exibirMensagemErro(Mensagens.NULL_COMPUTADOR);
				}
				telaPrincipal.setVisible(true);
				telaMenu.setVisible(false);
			}
		});
		
		ComputadoAcao computadorAcao = new ComputadoAcao();
		telaPrincipal.getAdicionarItem().addActionListener(computadorAcao);
		telaPrincipal.getPainelAdicionarComputador().getConfirmarAdicaoButton().addActionListener(computadorAcao);;
	}
	
	public class ComputadoAcao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == telaPrincipal.getAdicionarItem()) {
				telaPrincipal.getPainelAdicionarComputador().setVisible(true);
			}
			
			if(e.getSource() == telaPrincipal.getPainelAdicionarComputador().getConfirmarAdicaoButton()) {
				try {
					int id = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getNumeroField().getText());
					String nome = telaPrincipal.getPainelAdicionarComputador().getNomeField().getText();
					String processador = telaPrincipal.getPainelAdicionarComputador().getProcessadorField().getText();
					int memoria = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getMemoriaField().getText());
					int hd = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getHdField().getText());
					int ssd = Integer.parseInt(telaPrincipal.getPainelAdicionarComputador().getSsdField().getText());
					String situacao = telaPrincipal.getPainelAdicionarComputador().getSituacaoField().getText();
					String observacao = telaPrincipal.getPainelAdicionarComputador().getObservacaoField().getText();
					String grupo = ""+telaPrincipal.getPainelAdicionarComputador().getGrupoBox().getSelectedItem();
					if(nome.equals("") || processador.equals("")) {
						throw new Exception();
					}
					Computador computador = new Computador(id, nome, processador, memoria, hd, ssd, situacao, observacao, grupo);
					SQLiteJDBCDriverConnection.adicionarComputador(computador);
					TelaMensagem.exibirMensagemSucesso("Computador adicionado!");
					telaPrincipal.getPainelAdicionarComputador().getNumeroField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getNomeField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getProcessadorField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getMemoriaField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getHdField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getSsdField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getSituacaoField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getObservacaoField().setText("");
					telaPrincipal.getPainelAdicionarComputador().getGrupoBox().setSelectedIndex(0);
					telaPrincipal.getPainelTabela().criarTabela(SQLiteJDBCDriverConnection.listarComputador());
				} catch (Exception ee) {
					TelaMensagem.exibirMensagemErro(Mensagens.ERRO_CAMPOS);
				}
			}
			
			if(e.getSource() == telaPrincipal.getAlterarItem()) {
				
			}
			
			if(e.getSource() == telaPrincipal.getRemoverItem()) {
				
			}
			
			if(e.getSource() == telaPrincipal.getAtualizarItem()) {
				
			}
			
			if(e.getSource() == telaPrincipal.getBuscarPorNomeItem()) {
				
			}
			
			if(e.getSource() == telaPrincipal.getBuscarPorIdItem()) {
				
			}
			
		}
	}
}
