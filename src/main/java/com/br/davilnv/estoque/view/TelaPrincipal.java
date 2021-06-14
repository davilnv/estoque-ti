package com.br.davilnv.estoque.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends TelaPadrao{
	private PainelAdicionarComputador painelAdicionarComputador;
	private PainelTabela painelTabela;
	private JMenu computadorMenu, computadorSubmenu;
	private JMenuItem adicionarItem, alterarItem, removerItem, listarTodos, buscarPorNomeItem, buscarPorIdItem;
	

	public TelaPrincipal(String titulo) {
		super(titulo);
		
		painelTabela = new PainelTabela("Tabela");
		painelTabela.setVisible(true);
		painelAdicionarComputador = new PainelAdicionarComputador("Adicionar um Computador");
		
		JMenuBar menuBar = new JMenuBar();
		
		computadorMenu = new JMenu("Computadores");
		computadorSubmenu = new JMenu("Buscar");
		
		adicionarItem = new JMenuItem("Adicionar Computador");
		alterarItem = new JMenuItem("Alterar Computador");
		removerItem = new JMenuItem("Remover Computador");
		listarTodos = new JMenuItem("Listar Todos");
		buscarPorNomeItem = new JMenuItem("Buscar por nome");
		buscarPorIdItem = new JMenuItem("Buscar por número");
		
		computadorMenu.add(adicionarItem);
		computadorMenu.add(alterarItem);
		computadorMenu.add(removerItem);
		computadorMenu.add(listarTodos);
		computadorMenu.add(computadorSubmenu);
		
		computadorSubmenu.add(buscarPorNomeItem);
		computadorSubmenu.add(buscarPorIdItem);
		
		menuBar.add(computadorMenu);
		
		setJMenuBar(menuBar);
		
		add(painelAdicionarComputador);
		add(painelTabela);
		
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

	public JMenuItem getListarTodos() {
		return listarTodos;
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
	
}
