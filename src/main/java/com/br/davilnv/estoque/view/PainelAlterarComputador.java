package com.br.davilnv.estoque.view;

public class PainelAlterarComputador extends PainelPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PainelAlterarComputador(String titulo){
		super(titulo);
		getNomeField().setEnabled(false);
		getProcessadorField().setEnabled(false);
		getMemoriaField().setEnabled(false);
		getHdField().setEnabled(false);
		getSsdField().setEnabled(false);
		getSituacaoField().setEnabled(false);
		getObservacaoField().setEnabled(false);
		getGrupoBox().setEnabled(false);
		getConfirmarButton().setEnabled(false);
	}

}
