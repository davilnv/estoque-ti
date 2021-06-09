package com.br.davilnv.estoque.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteJDBCDriverConnection {
	private static Statement statement;
	
	private static void connect() {
        try {
        	Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
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

//    public static Statement getStatement() {
//		return statement;
//	}



	public static void main(String[] args) throws SQLException {
//        connect();
  
//        statement.execute("INSERT INTO COMPUTADOR(ID, NOME, PROCESSADOR, MEMORIA, HD, SSD, SITUACAO, OBSERVACAO, GRUPO) VALUES ('2', 'VENDAS-PC-02', 'INTEL I3 2120', '4', '500', '0', '', 'PC VENDAS - 02', 'LOJA')");
//        statement.execute("CREATE TABLE IF NOT COMPUTADOR(ID INTEGER PRIMARY KEY, NOME VARCHAR, PROCESSADOR VARCHAR, MEMORIA INTEGER, HD INTEGER, SSD INTEGER, SITUACAO VARCHAR, OBSERVACAO VARCHAR, GRUPO VARCHAR)");
    }
}