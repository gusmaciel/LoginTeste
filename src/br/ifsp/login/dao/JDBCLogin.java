package br.ifsp.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ifsp.login.modelo.Login;

public class JDBCLogin implements ILogin {

	@Override
	public ArrayList<Login> obterLogin() {
		
		try {
			
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "SELECT * FROM login;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			ResultSet resultado = comando.executeQuery();
			
			ArrayList<Login> listaLogin = new ArrayList<Login>();
			
			while (resultado.next()) {
				System.out.println("%d : %s - %s");
					resultado.getString("idUsuario");
					resultado.getString("login");
					resultado.getString("senha");
					
				Login l = new Login();
				
				l.setIdUsuario(resultado.getString("idUsuario"));
				l.setUsuario(resultado.getString("login"));
				l.setUsuario(resultado.getString("senha"));
				
				listaLogin.add(l);
			}
			conexao.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
