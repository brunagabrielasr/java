package jdbc.teste;

import dao.ContatoDao;
import java.util.ArrayList;
import java.util.List;
import model.Contato;

public class TestaLista {
    public static void main(String[] args) {
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();
        
        for(Contato c: contatos){
            System.out.println("Id: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("E-mail: " + c.getEmail());
            System.out.println("");
        }
    }
}
