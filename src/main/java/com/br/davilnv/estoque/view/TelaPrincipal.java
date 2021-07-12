package com.br.davilnv.estoque.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends TelaPadrao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PainelAdicionarComputador painelAdicionarComputador;
	private PainelAlterarComputador painelAlterarComputador;
	private PainelRemoverComputador painelRemoverComputador;
	private PainelTabela painelTabela;
	private JMenu computadorMenu, computadorSubmenu;
	private JMenuItem adicionarItem, alterarItem, removerItem, atualizarTodos, buscarPorNomeItem, buscarPorIdItem;
	

	public TelaPrincipal(String titulo) {
		super(titulo);
		
		painelTabela = new PainelTabela("Tabela");
		painelTabela.setVisible(true);
		painelAdicionarComputador = new PainelAdicionarComputador("Adicionar um Computador");
		painelAlterarComputador = new PainelAlterarComputador("Alterar um Computador");
		painelRemoverComputador = new PainelRemoverComputador("Remover um Computador");
		
		JMenuBar menuBar = new JMenuBar();
		
		computadorMenu = new JMenu("Computadores");
		computadorSubmenu = new JMenu("Buscar");
		
		adicionarItem = new JMenuItem("Adicionar Computador");
		alterarItem = new JMenuItem("Alterar Computador");
		removerItem = new JMenuItem("Remover Computador");
		atualizarTodos = new JMenuItem("Atualizar Tabela");
		buscarPorNomeItem = new JMenuItem("Buscar por nome");
		buscarPorIdItem = new JMenuItem("Buscar por número");
		
		computadorMenu.add(adicionarItem);
		computadorMenu.add(alterarItem);
		computadorMenu.add(removerItem);
		computadorMenu.add(atualizarTodos);
		computadorMenu.add(computadorSubmenu);
		
		computadorSubmenu.add(buscarPorNomeItem);
		computadorSubmenu.add(buscarPorIdItem);
		
		menuBar.add(computadorMenu);
		
		setJMenuBar(menuBar);
		
		add(painelTabela);
		add(painelAdicionarComputador);
		add(painelAlterarComputador);
		add(painelRemoverComputador);
		
	}

	public PainelAdicionarComputador getPainelAdicionarComputador() {
		return painelAdicionarComputador;
	}

	public JMenuItem getAdicionarItem() {
		return adicionarItem;
	}

	public JMenuItem getAlterarItem() {
		return alterarItem;
	}

	public JMenuItem getRemoverItem() {
		return removerItem;
	}

	public JMenuItem getAtualizarItem() {
		return atualizarTodos;
	}

	public JMenuItem getBuscarPorNomeItem() {
		return buscarPorNomeItem;
	}

	public JMenuItem getBuscarPorIdItem() {
		return buscarPorIdItem;
	}

	public PainelTabela getPainelTabela() {
		return painelTabela;
	}

	public PainelAlterarComputador getPainelAlterarComputador() {
		return painelAlterarComputador;
	}

	public PainelRemoverComputador getPainelRemoverComputador() {
		return painelRemoverComputador;
	}
	
}
