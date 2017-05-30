package jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConnectionFactory;

public class TestaInclusao {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO contatos (nome, email) VALUES (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "Maria");
		ps.setString(2, "maria@gmail.com");
		
		ps.execute();
		ps.close();
		conn.close();
		
		System.out.println("Gravado!!");

	}

}
