package br.ifsp.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class JDBCLogin implements ILogin {

	public boolean permissao;
	
	@Override
	public void Logar (String login, String senha) {
		
		
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "SELECT login, senha FROM usuario WHERE login = ? AND senha = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, login);
			comando.setString(2, senha);
		
			ResultSet resultado = comando.executeQuery();
			
			if(resultado.next()) {
				JOptionPane.showMessageDialog(null, "ACESSO CONCEDIDO");
				permissao = true;
			} else {
				JOptionPane.showMessageDialog(null, "ACESSO NEGADO");
				permissao = false;
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
