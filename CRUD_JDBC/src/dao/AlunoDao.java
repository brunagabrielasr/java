package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import jdbc.ConnectionFactory;

public class AlunoDao {

	private Connection conn;
	
	public AlunoDao() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void inserir(Aluno aluno) {
		
		String sql1 = "INSERT INTO aluno(nome, ra) VALUES (?, ?)";
				
		try {
			
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			
			ps1.setString(1, aluno.getNome());
			ps1.setString(2, aluno.getRa());
			
			ps1.execute();
			ps1.close();
			
			//recuperar o ultimo aluno inserido para colocar no relacionamento da segunda tabela
			//criar foreign key no banco
			
//			PreparedStatement ps2 = conn.prepareStatement(sql2);
//			
//			ps2.setString(1, aluno.getId());
//			ps2.setString(2, aluno.getEmail());
//			ps2.setString(3, aluno.getFone());
//			
//			ps2.execute();
//			ps2.close();
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}			
	}
//	
	public void alterar(Aluno aluno) {
		String up = "UPDATE aluno SET nome = ?, ra = ? WHERE id = ?";
		
		try 
		{
			PreparedStatement ps = conn.prepareStatement(up);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getRa());
			ps.setInt(3, aluno.getId());
			
			ps.execute();
			ps.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Aluno obterAluno(int id){
		String sql = "Select * FROM aluno WHERE id = ?";
		
		try
		{
			Aluno aluno = new Aluno();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRa(rs.getString("nome"));
			}			
				rs.close();
				ps.close();
				return aluno;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	public void inserirInformacoes(Informacoes informacoes){
//		String sql2 = "INSERT INTO informacoes(alunoId, email, telefone, ) VALUES (?, ?, ?)";
//	}
	
	/*public void alterar(Aluno aluno) {
		String up = "UPDATE aluno SET nome = ?, ra = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(up);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setInt(3, contato.getId());
			
			ps.execute();
			ps.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
	
	public void excluir (int id) {
		String del = "DELETE FROM aluno WHERE id = ?";
		String del2 = "DELETE FROM informacao WHERE aluno_id = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(del);
			ps.setInt(1, id);
			
			ps.execute();
			ps.close();
			
			PreparedStatement ps2 = conn.prepareStatement(del2);
			ps2.setInt(1, id);
			
			ps2.execute();
			ps2.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*public Aluno getAluno(int id) {
		
		try {
			
			Contato contato = new Contato();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM contatos WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				contato.setId(rs.getInt("id"));
				contato.setEmail(rs.getString("email"));
				contato.setNome(rs.getString("nome"));
			}
			
			rs.close();
			ps.close();
			return contato;			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}*/
	
	/*public List<Aluno> getLista() {
		try {
			
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM aluno LEFT JOIN informacao ON aluno.id = informacao.aluno_id");
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
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
	
}
