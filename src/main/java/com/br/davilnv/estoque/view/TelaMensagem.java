package com.br.davilnv.estoque.view;

import javax.swing.JOptionPane;

public class TelaMensagem {
	public static void exibirMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void exibirMensagemSucesso(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.DEFAULT_OPTION);
	}
	
	public static int exibirMensagemConfirmacao(String mensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem, "Confirmação", JOptionPane.YES_NO_OPTION);
	}
}
