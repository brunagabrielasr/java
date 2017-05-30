package jdbc.teste;

import dao.ContatoDao;
import model.Contato;

public class TestePesquisa {
    public static void main(String[] args) {
        ContatoDao dao = new ContatoDao();
        
        Contato contato = dao.getContato(1);
        
        System.out.println(contato.getNome());
    }
}
