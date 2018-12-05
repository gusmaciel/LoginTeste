package br.ifsp.login.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.ifsp.login.controle.JDBCControll;

public class UILogin {

	public static void main(String[] args) {

		
		//frame
		JFrame frame = new JFrame("POO-IFSP");
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//painel
		JPanel panel = new JPanel();
		
		//label
		JLabel lblUser = new JLabel();
		lblUser.setText("User: ");
		panel.add(lblUser);
		
		//textbox
		JTextField txtUser = new JTextField(15);
		panel.add(txtUser);
		
		JLabel lblSenha = new JLabel();
		lblSenha.setText("Password: ");
		panel.add(lblSenha);
		
		JPasswordField txtPwd = new JPasswordField(15);
		panel.add(txtPwd);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				JDBCControll controleAcesso = new JDBCControll();
				
					controleAcesso.Logar(txtUser.getText(), txtPwd.getText());
					
					if(controleAcesso.permissao == true) {
						System.exit(0);
					}
					
					if(controleAcesso.permissao == false) {
						txtUser.setText("");
						txtPwd.setText("");
						txtUser.requestFocus();
					}
			}
		});
		panel.add(btnEntrar);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
