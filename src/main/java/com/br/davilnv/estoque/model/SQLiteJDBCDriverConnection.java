package com.br.davilnv.estoque.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteJDBCDriverConnection {
	private static Statement statement;
	private static Connection connection;
	
	private static void connect() {
		List<String> leitura = null;
		String localbd = null;
        try {
        	try {
        		new File("c:\\banco").mkdir();
				FileWriter localBanco = new FileWriter("c:\\banco\\localBanco.txt");
				PrintWriter gravarArq = new PrintWriter(localBanco);
				gravarArq.print("jdbc:sqlite:/banco/banco.db");
				localBanco.close();
				Path path = Paths.get("/banco/localBanco.txt");
				leitura = Files.readAllLines(path);
			} catch (IOException e) {
			}
        	
        	for (String string : leitura) {
        		localbd = string;
			}
        	
        	if(connection == null){        		
        		connection = DriverManager.getConnection(localbd);
        	}
            System.out.println("Conexão realizada!");
            statement = connection.createStatement();
           
//            statement.execute("CREATE TABLE COMPUTADOR (ID INTEGER PRIMARY KEY, NOME VARCHAR, PROCESSADOR VARCHAR, MEMORIA INTEGER, HD INTEGER, SSD INTEGER, SITUACAO VARCHAR, OBSERVACAO VARCHAR, GRUPO VARCHAR)");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public static ArrayList<String> listarGrupoComputador() throws SQLException {
		connect();
		ResultSet rs = statement.executeQuery("SELECT NOME FROM GRUPO");
		
		ArrayList<String> grupo = new ArrayList<>();
		
		while(rs.next()) {
			grupo.add(rs.getString(1));
		}
		
		return grupo;
	}
	
	public static boolean adicionarComputador(Computador computador) throws SQLException {
		connect();
		String SQL = "INSERT INTO COMPUTADOR(ID, NOME, PROCESSADOR, MEMORIA, HD, SSD, "
				+ "SITUACAO, OBSERVACAO, GRUPO) VALUES ('"
				+ computador.getId() +"', '"
				+ computador.getNome() +"', '"
				+ computador.getProcessador() +"', '"
				+ computador.getMemoria() +"', '"
				+ computador.getHd() +"', '"
				+ computador.getSsd() +"', '"
				+ computador.getSituacao() +"', '"
				+ computador.getObservacao() +"', '"
				+ computador.getGrupo() 
				+"')";
		return statement.execute(SQL);
	}
	
	public static boolean alterarComputador(int id, Computador computador) throws SQLException {
		connect();
		String SQL = "UPDATE COMPUTADOR SET NOME = '" + computador.getNome() + "', "
				+ "PROCESSADOR = '" + computador.getProcessador() + "', "
				+ "MEMORIA = " + computador.getMemoria() + ", "
				+ "HD = " + computador.getHd() + ", "
				+ "SSD = " + computador.getSsd() + ", "
				+ "SITUACAO = '" + computador.getSituacao() + "', "
				+ "OBSERVACAO = '" + computador.getObservacao() + "', "
				+ "GRUPO = '" + computador.getGrupo() + "' "
				+ "WHERE ID = " + id;
		
		return statement.execute(SQL);
	}
	
	public static boolean removerComputador(int id) throws SQLException {
		connect();
		String SQL = "DELETE FROM COMPUTADOR WHERE id = " + id;
		return statement.execute(SQL);
	}
	
	public static Computador buscarComputadorPorId(int id) throws SQLException {
		connect();
		String SQL = "SELECT * FROM COMPUTADOR WHERE id = "+ id;
		ResultSet rs = statement.executeQuery(SQL);
		
		String nome = rs.getObject(2).toString();
		String processador = rs.getObject(3).toString();
		int memoria = Integer.parseInt(rs.getObject(4).toString());
		int hd = Integer.parseInt(rs.getObject(5).toString());
		int ssd = Integer.parseInt(rs.getObject(6).toString());
		String situacao = rs.getObject(7).toString();;
		String observacao = rs.getObject(8).toString();;
		String grupo = rs.getObject(9).toString();
		
		Computador pc = new Computador(id, nome, processador, memoria, hd, ssd, situacao, observacao, grupo);
		
		return pc;
		
	}

	public static ArrayList<Computador> listarComputador() throws SQLException {
		connect();
		ResultSet rs = statement.executeQuery("SELECT * FROM COMPUTADOR");
		
		ArrayList<Computador> computadores = new ArrayList<>();
		
		while(rs.next()) {
			int id = Integer.parseInt(rs.getObject(1).toString());
			String nome = rs.getObject(2).toString();
			String processador = rs.getObject(3).toString();
			int memoria = Integer.parseInt(rs.getObject(4).toString());
			int hd = Integer.parseInt(rs.getObject(5).toString());
			int ssd = Integer.parseInt(rs.getObject(6).toString());
			String situacao = rs.getObject(7).toString();;
			String observacao = rs.getObject(8).toString();;
			String grupo = rs.getObject(9).toString();
			
			Computador pc = new Computador(id, nome, processador, memoria, hd, ssd, situacao, observacao, grupo);
			computadores.add(pc);
		}
		
		return computadores;
	}

	public static void main(String[] args) throws SQLException {
//        connect();
//        statement.execute("INSERT INTO COMPUTADOR(ID, NOME, PROCESSADOR, MEMORIA, HD, SSD, SITUACAO, OBSERVACAO, GRUPO) VALUES ('2', 'VENDAS-PC-02', 'INTEL I3 2120', '4', '500', '0', '', 'PC VENDAS - 02', 'LOJA')");
//        statement.execute("CREATE TABLE IF NOT COMPUTADOR(ID INTEGER PRIMARY KEY, NOME VARCHAR, PROCESSADOR VARCHAR, MEMORIA INTEGER, HD INTEGER, SSD INTEGER, SITUACAO VARCHAR, OBSERVACAO VARCHAR, GRUPO VARCHAR)");
	}
}
