package br.edu.ifsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/dsi";
		String user = "root";
		String password = "";
		String sql = "SELECT * FROM pessoa";
		
		Connection conexao = null;
		
		System.out.println("Abrindo programa ...");
		
		try {		
			// 1� - � necess�rio carregar o driver no projeto
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Carregando driver JDBC ...");
			
			// 2� - Estabele�o uma conex�o com o BD
			conexao = 
				DriverManager.getConnection(url, user, password);
			System.out.println("Abrindo conexao ...");
			
			// 3� - Criar o Statement (compila o comando SQL e envia para BD)
			Statement stm = conexao.createStatement();
			
			// 4� - Executa o SQL - N�o SELECT (INSERT, UPDATE e DELETE)
			//stm.executeUpdate(sql);
			ResultSet rs = stm.executeQuery(sql);
			
			// 5� - Exibir as informa��es
			System.out.println("Exibindo Dados ...");
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1));
				System.out.println("Nome:" + rs.getString(2));
				System.out.println("Idade:" + rs.getInt(3));
				System.out.println("Endereco:" + rs.getString(4));
			}
			
		} catch(ClassNotFoundException cnfex) {
			System.out.println("Erro ao carregar o driver de conexao");
			
		} catch(SQLException sqlex) {
			System.out.println("Problema ao estabelecer conexao com o BD");
			
		} finally {
			
			try {
				// 3� - Fechar a conex�o
				if(conexao != null)
					conexao.close();
				System.out.println("Fechando conexao ...");
				
			} catch(SQLException sqlex) {
				System.out.println("Problema ao fechar a conexao com o BD");
			}
		}
		
		System.out.println("Fechando programa ...");
	}
}
