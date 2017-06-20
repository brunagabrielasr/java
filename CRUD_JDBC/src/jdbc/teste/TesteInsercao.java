package jdbc.teste;

import dao.AlunoDao;
import dao.ContatoDao;
import model.Aluno;
import model.Contato;


public class TesteInsercao {

	public static void main(String[] args) {
		
		AlunoDao dao = new AlunoDao();
		//Aluno aluno = new Aluno();
		
//		Aluno aluno = new Aluno("Carlos", "151234");
//		dao.inserir(aluno);
//		
//		System.out.println("Gravado!!!");
		
		
		Aluno aluno = dao.obterAluno(1);
		
		System.out.println(aluno.getRa());
		
		
		aluno.setRa("123456");		
		
		dao.alterar(aluno);
		
		Aluno cUp = dao.getContato(1);
		
		System.out.println(cUp.getEmail());
		
		
//		Aluno aluno = new Aluno("Camila", "151234");
//		
//		AlunoDao dao = new AlunoDao();
//		dao.inserir(aluno);
//		
//		System.out.println("Gravado!!!");

	}

}
