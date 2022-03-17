package pilha;


/**
 * Classe para adicionar tarefas
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 *
 */
public class Tarefa {
	private String descricao;
	private String nome;
	
	/**
	 * Atribui os valores passados via parâmetro aos atributos nome e descricao
	 * 
	 * @param nome 		nome da tarefa
	 * @param descricao	descrição da tarefa
	 */
	public Tarefa(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	/**
	 * Retorna o valor de descricao
	 * 
	 * @return  descrição da tarefa
	 */
	public String getDescricao() {
		return descricao;
	}

	/** 
	 * Retorna o valor de nome
	 * 
	 * @return nome da tarefa
	 */
	public String getNome() {
		return nome;
	}
	
	/** 
	 * Retorna os valores de nome e descricao passados via parâmetro ao construtor da Classe de acordo com os dados da tarefa registrada pelo usuário	 * 
	 * 
	 * @param nome		nome da tarefa
	 * @param descricao	descrição da tarefa
	 * @return			valores para o Construtor da classe para posterior atribuição
	 */
	public static Tarefa adicionarTarefa(String nome, String descricao) {
		return new Tarefa(nome, descricao);
	}
}
