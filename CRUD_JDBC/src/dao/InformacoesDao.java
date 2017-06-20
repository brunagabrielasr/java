package dao;

import java.sql.Connection;

import jdbc.ConnectionFactory;


public class InformacoesDao {
	
	private Connection conn;
	
	public InformacoesDao() {
		this.conn = new ConnectionFactory().getConnection();
	}
}
