package br.edu.ifsp.principal;

import br.edu.ifsp.controlador.InserePessoaController;
import br.edu.ifsp.tela.TelaPessoa;

public class ExecutarProjeto {

	public static void main(String[] args) {
		
		TelaPessoa telaPessoa = new TelaPessoa("Formulario Pessoa");
		InserePessoaController controller = new InserePessoaController(telaPessoa);
		telaPessoa.setVisible(true);
	}
}
