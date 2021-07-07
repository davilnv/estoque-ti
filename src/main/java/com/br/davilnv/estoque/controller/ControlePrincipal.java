package com.br.davilnv.estoque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import com.br.davilnv.estoque.model.Computador;
import com.br.davilnv.estoque.model.Mensagens;
import com.br.davilnv.estoque.model.SQLiteJDBCDriverConnection;
import com.br.davilnv.estoque.view.TelaMensagem;
import com.br.davilnv.estoque.view.TelaMenu;
import com.br.davilnv.estoque.view.TelaPrincipal;

public class ControlePrincipal{
	
	TelaMenu telaMenu;
	TelaPrincipal telaPrincipal;
	
	public ControlePrincipal() {
		super();
		telaMenu = new TelaMenu("Sistema do TI");
    	telaPrincipal = new TelaPrincipal("Sistema do TI");
		
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

		telaPrincipal.getAlterarItem().addActionListener(computadorAcao);
		telaPrincipal.getPainelAlterarComputador().getBuscarButton().addActionListener(computadorAcao);
		
		telaPrincipal.getRemoverItem().addActionListener(computadorAcao);
		
		telaPrincipal.getAtualizarItem().addActionListener(computadorAcao);
		
		telaPrincipal.getBuscarPorNomeItem().addActionListener(computadorAcao);
		
		telaPrincipal.getBuscarPorIdItem().addActionListener(computadorAcao);
	}
	
	public class ComputadoAcao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == telaPrincipal.getAdicionarItem()) {
				telaPrincipal.getPainelAdicionarComputador().setVisible(true);
				telaPrincipal.getPainelAlterarComputador().setVisible(false);
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
				telaPrincipal.getPainelAdicionarComputador().setVisible(false);
				telaPrincipal.getPainelAlterarComputador().setVisible(true);
			}
			
			if(e.getSource() == telaPrincipal.getPainelAlterarComputador().getBuscarButton()) {
				
				try {
					int id = Integer.parseInt(telaPrincipal.getPainelAlterarComputador().getNumeroField().getText());
					Computador pc = SQLiteJDBCDriverConnection.buscarComputadorPorId(id);
					telaPrincipal.getPainelAlterarComputador().getNumeroField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getBuscarButton().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getConfirmarAlteracaoButton().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getNomeField().setText(pc.getNome());
					telaPrincipal.getPainelAlterarComputador().getNomeField().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getProcessadorField().setText(pc.getProcessador());
					telaPrincipal.getPainelAlterarComputador().getProcessadorField().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getMemoriaField().setText(""+pc.getMemoria());
					telaPrincipal.getPainelAlterarComputador().getMemoriaField().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getHdField().setText(""+pc.getHd());
					telaPrincipal.getPainelAlterarComputador().getHdField().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getSsdField().setText(""+pc.getSsd());
					telaPrincipal.getPainelAlterarComputador().getSsdField().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getSituacaoField().setText(pc.getSituacao());
					telaPrincipal.getPainelAlterarComputador().getSituacaoField().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getObservacaoField().setText(pc.getObservacao());
					telaPrincipal.getPainelAlterarComputador().getObservacaoField().setEnabled(true);
					telaPrincipal.getPainelAlterarComputador().getGrupoBox().setSelectedItem(pc.getGrupo());
					telaPrincipal.getPainelAlterarComputador().getGrupoBox().setEnabled(true);
				} catch (SQLException e1) {
					TelaMensagem.exibirMensagemErro(Mensagens.NULL_COMPUTADOR);
				} catch (NumberFormatException e1) {
					TelaMensagem.exibirMensagemErro(Mensagens.ERRO_CAMPOS);
				}
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
