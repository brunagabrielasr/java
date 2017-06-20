package model;

public class Informacoes {
	private int id;
	private int alunoId;
	private String fone;
	private String email;
	
	public Informacoes() {};
		
	public Informacoes(int id, int alunoId, String fone, String email) {
		super();
		this.id = id;
		this.alunoId = alunoId;
		this.fone = fone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAluno_id() {
		return alunoId;
	}
	
	public void setAluno_id(int aluno_id) {
		this.alunoId = aluno_id;
	}
	
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
