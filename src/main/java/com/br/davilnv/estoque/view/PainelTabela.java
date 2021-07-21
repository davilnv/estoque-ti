package com.br.davilnv.estoque.view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.br.davilnv.estoque.model.Computador;

public class PainelTabela extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font fonte;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;
	
	public PainelTabela(String titulo) {
		setSize(1336, 339);
		setBorder(BorderFactory.createTitledBorder(titulo));
		setLocation(15, 364);
		setLayout(null);
		
		fonte = new Font("Arial", Font.PLAIN, 12);
		
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Processador");
		modelo.addColumn("Memória");
		modelo.addColumn("HD");
		modelo.addColumn("SSD");
		modelo.addColumn("Situação");
		modelo.addColumn("Observação");
		modelo.addColumn("Grupo");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(310);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(290);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(140);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(230);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(5, 20, 1327, 315);
		
		
		add(barraRolagem);
		setVisible(false);
	}
	
	public void criarTabela(ArrayList<Computador> computadores) {
		modelo.setNumRows(0);
		for (Computador pc : computadores) {
			modelo.addRow(new Object[]{pc.getId(), pc.getNome(), pc.getProcessador(), pc.getMemoria(), pc.getHd(), pc.getSsd(), pc.getSituacao(), pc.getObservacao(), pc.getGrupo()});
		}
	}
	
	public void criarTabela(Computador pc) {
		modelo.setNumRows(0);
		modelo.addRow(new Object[]{pc.getId(), pc.getNome(), pc.getProcessador(), pc.getMemoria(), pc.getHd(), pc.getSsd(), pc.getSituacao(), pc.getObservacao(), pc.getGrupo()});

	}

	public Font getFonte() {
		return fonte;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}
	
	
}
