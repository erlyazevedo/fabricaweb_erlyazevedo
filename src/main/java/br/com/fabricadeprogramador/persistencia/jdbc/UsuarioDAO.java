package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection conexao = ConexaoFactory.getConnection();
			
	public void cadastrar(Usuario usu) {		
	String sql = "insert into usuario (nome,login,senha)values (?,?,?)";
	
	try {
		PreparedStatement preparador = conexao.prepareStatement(sql);
		preparador.setString(1, usu.getNome());
		preparador.setString(2, usu.getLogin());
		preparador.setString(3, usu.getSenha());
		
		// executando o comando sql no banco 
		preparador.execute();

		//fechando o objeto preparador
		preparador.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
			
	}

}
