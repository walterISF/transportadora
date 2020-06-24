package br.com.transportadorasi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.transportadorasi.jdbc.Conexao;
import br.com.transportadorasi.modelo.ClienteFinal;

public class ClienteFinalDao {
	

	public static String novoClienteFinal(ClienteFinal clienteFinal) {
		
		Connection con = Conexao.receberConexao();
		
		String sql = "INSERT INTO clientefinal(nome,login,senha,cpf,email,endereco) VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, clienteFinal.getNome());
			preparador.setString(2, clienteFinal.getLogin());
			preparador.setString(3, clienteFinal.getSenha());
			preparador.setString(4, clienteFinal.getCpf());
			preparador.setString(5, clienteFinal.getEmail());
			preparador.setString(6, clienteFinal.getEndereco());
			
			
			preparador.execute();
			
			preparador.close();
			
			return "Cadastro feito com Sucesso";
			
		} catch (SQLException e) {
			e.printStackTrace(); 
			
			return "Seu cadastro nao foi realizado".concat(e.getMessage());
		}
		
		
	}

	public static String loginClienteFinal(String login, String senha) {
		
		Connection con = Conexao.receberConexao();
		
		String sql = "select * from clientefinal where login = "+login+" and senha = "+senha+"";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.execute();
			
			if (preparador.getFetchSize() > 0) {
				
				preparador.close();
				return "Usuario logado";
			}
						
			return "Usuario não encontrado";
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return "Usuario ou Senha incorretos".concat(e.getMessage());
		}
	
	}
}