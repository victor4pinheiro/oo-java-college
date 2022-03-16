package pilha;

public class Tarefa {
	private String descricao;
	private String nome;
	
	public Tarefa(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}
	
	public static Tarefa adicionarTarefa(String nome, String descricao) {
		return new Tarefa(nome, descricao);
	}
}
