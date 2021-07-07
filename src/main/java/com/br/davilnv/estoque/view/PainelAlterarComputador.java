package com.br.davilnv.estoque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.br.davilnv.estoque.model.SQLiteJDBCDriverConnection;

public class PainelAlterarComputador extends PainelPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton confirmarAlteracaoButton, buscarButton;
	private JTextField numeroField, nomeField, processadorField, memoriaField, hdField, ssdField, situacaoField, observacaoField;
	private JComboBox<String> grupoBox;

	public PainelAlterarComputador(String titulo){
		super(titulo);
		
		grupoBox = new JComboBox<>();
		try {
			for (String item : SQLiteJDBCDriverConnection.listarGrupoComputador()) {
				grupoBox.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numeroField = new JTextField();
		numeroField.setBounds(30, 66, 140, 20);
		nomeField = new JTextField();
		nomeField.setBounds(230, 66, 140, 20);
		nomeField.setEnabled(false);
		processadorField = new JTextField();
		processadorField.setBounds(430, 66, 140, 20);
		processadorField.setEnabled(false);
		memoriaField = new JTextField();
		memoriaField.setBounds(630, 66, 140, 20);
		memoriaField.setEnabled(false);
		hdField = new JTextField();
		hdField.setBounds(830, 66, 140, 20);
		hdField.setEnabled(false);
		ssdField = new JTextField();
		ssdField.setBounds(1030, 66, 140, 20);
		ssdField.setEnabled(false);
		situacaoField = new JTextField();
		situacaoField.setBounds(30, 128, 140, 20);
		situacaoField.setEnabled(false);
		observacaoField = new JTextField();
		observacaoField.setBounds(230, 128, 140, 20);
		observacaoField.setEnabled(false);
		
		grupoBox.setBounds(430, 128, 140, 20);
		grupoBox.setEnabled(false);
		
		grupoBox.setSelectedItem(grupoBox.getItemAt(19));

		buscarButton = new JButton("Buscar Computador");
		buscarButton.setBackground(Color.WHITE);
		buscarButton.setFont(new Font("Arial", Font.BOLD, 10));
		buscarButton.setBounds(30, 178, 140, 30);
		
		confirmarAlteracaoButton = new JButton("Confirmar Alteração");
		confirmarAlteracaoButton.setBackground(Color.WHITE);
		confirmarAlteracaoButton.setFont(new Font("Arial", Font.BOLD, 10));
		confirmarAlteracaoButton.setBounds(230, 178, 140, 30);
		confirmarAlteracaoButton.setEnabled(false);
		
		
		add(numeroField);
		add(nomeField);
		add(processadorField);
		add(memoriaField);
		add(hdField);
		add(ssdField);
		add(situacaoField);
		add(observacaoField);
		add(grupoBox);
		add(buscarButton);
		add(confirmarAlteracaoButton);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setFont(getFont());
		g.drawString("Número do Computador:", 30, 50);
		g.drawString("Nome do Computador:", 230, 50);
		g.drawString("Processador:", 430, 50);
		g.drawString("Memória RAM (GB):", 630, 50);
		g.drawString("HD (GB):", 830, 50);
		g.drawString("SSD (GB):", 1030, 50);
		g.drawString("Situação:", 30, 112);
		g.drawString("Observação:", 230, 112);
		g.drawString("Grupo:", 430, 112);
	}

	public JButton getBuscarButton() {
		return buscarButton;
	}

	public JButton getConfirmarAlteracaoButton() {
		return confirmarAlteracaoButton;
	}

	public JTextField getNumeroField() {
		return numeroField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getProcessadorField() {
		return processadorField;
	}

	public JTextField getMemoriaField() {
		return memoriaField;
	}

	public JTextField getHdField() {
		return hdField;
	}

	public JTextField getSsdField() {
		return ssdField;
	}

	public JTextField getSituacaoField() {
		return situacaoField;
	}

	public JTextField getObservacaoField() {
		return observacaoField;
	}

	public JComboBox<String> getGrupoBox() {
		return grupoBox;
	}

}
