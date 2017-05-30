package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;
import jdbc.ConnectionFactory;

public class ContatoDao {
	
	private Connection conn;
	
	public ContatoDao() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		
            String sql = "INSERT INTO contatos (nome, email) VALUES (?,?)";

            try {

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, contato.getNome());
                ps.setString(2, contato.getEmail());

                ps.execute();
                ps.close();
                conn.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
	}
        
        public Contato getContato(int id){
            try{
                Contato contato = new Contato();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM contatos WHERE id = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()){
                    contato.setId(rs.getInt("id"));
                    contato.setEmail(rs.getString("email"));
                    contato.setNome(rs.getString("nome"));
                }
                rs.close();
                ps.close();
                
                return contato;
                
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        
        public List<Contato> getLista(){
            try{
                List<Contato> contatos = new ArrayList<Contato>();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM contatos");
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    Contato contato = new Contato();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setEmail(rs.getString("email"));
                    
                    contatos.add(contato);
                }
                rs.close();
                ps.close();
                
                return contatos;
                
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

}
