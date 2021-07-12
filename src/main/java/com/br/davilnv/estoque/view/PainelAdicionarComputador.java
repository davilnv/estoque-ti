package com.br.davilnv.estoque.view;

public class PainelAdicionarComputador extends PainelPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PainelAdicionarComputador(String titulo){
		super(titulo);
		getBuscarButton().setVisible(false);
		getConfirmarButton().setBounds(getBuscarButton().getBounds());
		
	}

}
