package jdbc.teste;

import dao.ContatoDao;
import model.Contato;

public class TestaInclusaoDao {

	public static void main(String[] args) {
		
		Contato contato = new Contato("Ana", "ana@gmail.com");
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		System.out.println("Gravado!!!");

	}

}
