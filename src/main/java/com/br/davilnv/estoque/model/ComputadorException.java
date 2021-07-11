package com.br.davilnv.estoque.model;

import com.br.davilnv.estoque.view.TelaMensagem;

public class ComputadorException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComputadorException(String mensagem) {
		TelaMensagem.exibirMensagemErro(mensagem);
	}
}
