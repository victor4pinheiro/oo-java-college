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
	 * Atribui os valores passados via par�metro aos atributos nome e descricao
	 * 
	 * @param nome 		nome da tarefa
	 * @param descricao	descri��o da tarefa
	 */
	public Tarefa(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	/**
	 * Retorna o valor de descricao
	 * 
	 * @return  descri��o da tarefa
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
	 * Retorna os valores de nome e descricao passados via par�metro ao construtor da Classe de acordo com os dados da tarefa registrada pelo usu�rio	 * 
	 * 
	 * @param nome		nome da tarefa
	 * @param descricao	descri��o da tarefa
	 * @return			valores para o Construtor da classe para posterior atribui��o
	 */
	public static Tarefa adicionarTarefa(String nome, String descricao) {
		return new Tarefa(nome, descricao);
	}
}
