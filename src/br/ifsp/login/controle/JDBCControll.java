package br.ifsp.login.controle;

import java.util.ArrayList;

import br.ifsp.login.dao.ILogin;
import br.ifsp.login.dao.JDBCLogin;
import br.ifsp.login.modelo.Login;

public class JDBCControll {
	
	public ArrayList<Login> obterLogin() {
		
		ILogin log = new JDBCLogin();
		return log.obterLogin();
	}
}
