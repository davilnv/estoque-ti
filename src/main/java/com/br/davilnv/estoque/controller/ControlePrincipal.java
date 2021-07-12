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
		
		ComputadorAcao computadorAcao = new ComputadorAcao();
		telaPrincipal.getAdicionarItem().addActionListener(computadorAcao);
		telaPrincipal.getPainelAdicionarComputador().getConfirmarAdicaoButton().addActionListener(computadorAcao);;

		telaPrincipal.getAlterarItem().addActionListener(computadorAcao);
		telaPrincipal.getPainelAlterarComputador().getBuscarButton().addActionListener(computadorAcao);
		telaPrincipal.getPainelAlterarComputador().getConfirmarAlteracaoButton().addActionListener(computadorAcao);
		
		telaPrincipal.getRemoverItem().addActionListener(computadorAcao);
		telaPrincipal.getPainelRemoverComputador().getBuscarButton().addActionListener(computadorAcao);
		telaPrincipal.getPainelRemoverComputador().getConfirmarRemocaoButton().addActionListener(computadorAcao);
		
		telaPrincipal.getAtualizarItem().addActionListener(computadorAcao);
		
		telaPrincipal.getBuscarPorNomeItem().addActionListener(computadorAcao);
		
		telaPrincipal.getBuscarPorIdItem().addActionListener(computadorAcao);
	}
	
	public class ComputadorAcao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == telaPrincipal.getAdicionarItem()) {
				telaPrincipal.getPainelAdicionarComputador().setVisible(true);
				telaPrincipal.getPainelAlterarComputador().setVisible(false);
				telaPrincipal.getPainelRemoverComputador().setVisible(false);
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
				telaPrincipal.getPainelRemoverComputador().setVisible(false);
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
			
			if (e.getSource() == telaPrincipal.getPainelAlterarComputador().getConfirmarAlteracaoButton()) {
				try {
					int id = Integer.parseInt(telaPrincipal.getPainelAlterarComputador().getNumeroField().getText());
					String nome = telaPrincipal.getPainelAlterarComputador().getNomeField().getText();
					String processador = telaPrincipal.getPainelAlterarComputador().getProcessadorField().getText();
					int memoria = Integer.parseInt(telaPrincipal.getPainelAlterarComputador().getMemoriaField().getText());
					int hd = Integer.parseInt(telaPrincipal.getPainelAlterarComputador().getHdField().getText());
					int ssd = Integer.parseInt(telaPrincipal.getPainelAlterarComputador().getSsdField().getText());
					String situacao = telaPrincipal.getPainelAlterarComputador().getSituacaoField().getText();
					String observacao = telaPrincipal.getPainelAlterarComputador().getObservacaoField().getText();
					String grupo = ""+telaPrincipal.getPainelAlterarComputador().getGrupoBox().getSelectedItem();
					if(nome.equals("") || processador.equals("")) {
						throw new Exception();
					}
					Computador computador = new Computador(id, nome, processador, memoria, hd, ssd, situacao, observacao, grupo);
					SQLiteJDBCDriverConnection.alterarComputador(id, computador);
					TelaMensagem.exibirMensagemSucesso("Computador alterado com sucesso!");
					telaPrincipal.getPainelAlterarComputador().getNumeroField().setText("");
					telaPrincipal.getPainelAlterarComputador().getNomeField().setText("");
					telaPrincipal.getPainelAlterarComputador().getNomeField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getProcessadorField().setText("");
					telaPrincipal.getPainelAlterarComputador().getProcessadorField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getMemoriaField().setText("");
					telaPrincipal.getPainelAlterarComputador().getMemoriaField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getHdField().setText("");
					telaPrincipal.getPainelAlterarComputador().getHdField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getSsdField().setText("");
					telaPrincipal.getPainelAlterarComputador().getSsdField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getSituacaoField().setText("");
					telaPrincipal.getPainelAlterarComputador().getSituacaoField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getObservacaoField().setText("");
					telaPrincipal.getPainelAlterarComputador().getObservacaoField().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getGrupoBox().setSelectedIndex(0);
					telaPrincipal.getPainelAlterarComputador().getGrupoBox().setEnabled(false);
					telaPrincipal.getPainelAlterarComputador().getConfirmarAlteracaoButton().setEnabled(false);
					telaPrincipal.getPainelTabela().criarTabela(SQLiteJDBCDriverConnection.listarComputador());
				} catch (Exception ee) {
					ee.printStackTrace();
					TelaMensagem.exibirMensagemErro(Mensagens.ERRO_CAMPOS);
				}
				
			}
			
			if(e.getSource() == telaPrincipal.getRemoverItem()) {
				telaPrincipal.getPainelRemoverComputador().setVisible(true);
				telaPrincipal.getPainelAdicionarComputador().setVisible(false);
				telaPrincipal.getPainelAlterarComputador().setVisible(false);
			}
			
			if (e.getSource() == telaPrincipal.getPainelRemoverComputador().getBuscarButton()) {
				try {
					int id = Integer.parseInt(telaPrincipal.getPainelRemoverComputador().getNumeroField().getText());
					Computador pc = SQLiteJDBCDriverConnection.buscarComputadorPorId(id);
					telaPrincipal.getPainelRemoverComputador().getNomeField().setText(pc.getNome());
					telaPrincipal.getPainelRemoverComputador().getProcessadorField().setText(pc.getProcessador());
					telaPrincipal.getPainelRemoverComputador().getMemoriaField().setText(""+pc.getMemoria());
					telaPrincipal.getPainelRemoverComputador().getHdField().setText(""+pc.getHd());
					telaPrincipal.getPainelRemoverComputador().getSsdField().setText(""+pc.getSsd());
					telaPrincipal.getPainelRemoverComputador().getSituacaoField().setText(pc.getSituacao());
					telaPrincipal.getPainelRemoverComputador().getObservacaoField().setText(pc.getObservacao());
					telaPrincipal.getPainelRemoverComputador().getGrupoBox().setSelectedItem(pc.getGrupo());
				} catch (SQLException e1) {
					TelaMensagem.exibirMensagemErro(Mensagens.NULL_COMPUTADOR);
				} catch (NumberFormatException e1) {
					TelaMensagem.exibirMensagemErro(Mensagens.ERRO_CAMPOS);
				}
			}
			
			if(e.getSource() == telaPrincipal.getPainelRemoverComputador().getConfirmarRemocaoButton()) {
				try {
					int id = Integer.parseInt(telaPrincipal.getPainelRemoverComputador().getNumeroField().getText());
					int op = TelaMensagem.exibirMensagemConfirmacao(Mensagens.REMOVER_COMPUTADOR+"["+id+"]?");
					if(op == 0) {
						SQLiteJDBCDriverConnection.removerComputador(id);
						TelaMensagem.exibirMensagemSucesso("Computador removido com sucesso!");
						telaPrincipal.getPainelRemoverComputador().getNumeroField().setText("");
						telaPrincipal.getPainelRemoverComputador().getNomeField().setText("");
						telaPrincipal.getPainelRemoverComputador().getNomeField().setEnabled(false);
						telaPrincipal.getPainelRemoverComputador().getProcessadorField().setText("");
						telaPrincipal.getPainelRemoverComputador().getProcessadorField().setEnabled(false);
						telaPrincipal.getPainelRemoverComputador().getMemoriaField().setText("");
						telaPrincipal.getPainelRemoverComputador().getMemoriaField().setEnabled(false);
						telaPrincipal.getPainelRemoverComputador().getHdField().setText("");
						telaPrincipal.getPainelRemoverComputador().getHdField().setEnabled(false);
						telaPrincipal.getPainelRemoverComputador().getSsdField().setText("");
						telaPrincipal.getPainelRemoverComputador().getSsdField().setEnabled(false);
						telaPrincipal.getPainelRemoverComputador().getSituacaoField().setText("");
						telaPrincipal.getPainelRemoverComputador().getSituacaoField().setEnabled(false);
						telaPrincipal.getPainelRemoverComputador().getObservacaoField().setText("");
						telaPrincipal.getPainelRemoverComputador().getObservacaoField().setEnabled(false);
						telaPrincipal.getPainelRemoverComputador().getGrupoBox().setSelectedIndex(0);
						telaPrincipal.getPainelRemoverComputador().getGrupoBox().setEnabled(false);
						telaPrincipal.getPainelTabela().criarTabela(SQLiteJDBCDriverConnection.listarComputador());
					}
				} catch (SQLException e1) {
					TelaMensagem.exibirMensagemErro(Mensagens.NULL_COMPUTADOR);
				} catch (NumberFormatException e2) {
					TelaMensagem.exibirMensagemErro(Mensagens.ERRO_CAMPOS);
				}
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
