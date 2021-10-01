package br.edu.ifsp.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifsp.Conexao;

public class TelaPessoa extends JFrame {
	
	public TelaPessoa(String titulo) {
		
		super(titulo);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		
		JLabel texto1 = new JLabel("Nome: ");
		JLabel texto2 = new JLabel("Idade: ");
		JLabel texto3 = new JLabel("Endereco: ");
		
		JTextField campo1 = new JTextField(20);
		JTextField campo2 = new JTextField(5);
		JTextField campo3 = new JTextField(20);
		
		JButton botao = new JButton("Salvar");
		botao.addActionListener( new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nome = campo1.getText();
				int idade = Integer.parseInt(campo2.getText());
				String endereco = campo3.getText();
				
				Conexao conexao = new Conexao();
				conexao.executeConexao(nome, idade, endereco);
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(texto1);
		panel.add(campo1);
		panel.add(texto2);
		panel.add(campo2);
		panel.add(texto3);
		panel.add(campo3);
		panel.add(botao);
		
		getContentPane().add(panel);
		
		//pack();
		setVisible(true);
	
	}

}
