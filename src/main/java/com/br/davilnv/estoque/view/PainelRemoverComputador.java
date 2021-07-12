package com.br.davilnv.estoque.view;

public class PainelRemoverComputador extends PainelPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public PainelRemoverComputador(String titulo){
		super(titulo);
		getNomeField().setEnabled(false);
		getProcessadorField().setEnabled(false);
		getMemoriaField().setEnabled(false);
		getHdField().setEnabled(false);
		getSsdField().setEnabled(false);
		getSituacaoField().setEnabled(false);
		getObservacaoField().setEnabled(false);
		getGrupoBox().setEnabled(false);
	}
	
}
