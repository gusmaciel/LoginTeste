package br.ifsp.login.controle;

import br.ifsp.login.dao.ILogin;
import br.ifsp.login.dao.JDBCLogin;

public class JDBCControll extends JDBCLogin {
	
	public void Logar(String login, String senha) {
		
		ILogin log = new JDBCLogin();
		log.Logar(login, senha);
	}
}
