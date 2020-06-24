package br.com.transportadorasi.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.transportadorasi.jdbc.Conexao;
import br.com.transportadorasi.modelo.Frete;

public class FreteDao {
	
	public static String cadastrarFrete(Frete frete) {
		
		Connection con = Conexao.receberConexao();
		
		String sql = "INSERT INTO frete(solicitante,cep,id_parceiro,id_mercadoria) VALUES(?,?,?,?)";
		
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1, frete.getSolicitante());
		preparador.setString(2, frete.getCep());
		preparador.setInt(3, frete.getIdParceiro());
		preparador.setInt(4, frete.getIdParceiro());
		
		return "Frete feito com sucesso";
		
		}catch (SQLException e) {
			e.printStackTrace();
			
			return "seu cadastro nao foi realizado".concat(e.getMessage());
			
		}

	}
}
