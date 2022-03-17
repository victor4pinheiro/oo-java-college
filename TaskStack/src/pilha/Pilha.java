package pilha;

import java.util.Stack;

/**
 * Cria uma pilha de tarefas do tipo Tarefa e permite que possa adicionar e mostrar somente a próxima a tarefa a ser concluída
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 *
 */
public class Pilha {
	Stack<Tarefa> tarefas = new Stack<Tarefa>();
	
	/**
	 * Adiciona a tarefa do tipo Tarefa à pilha
	 * 
	 * @param tarefa
	 */
	public void adicionarTarefa(Tarefa tarefa) {
		this.tarefas.push(tarefa);
	}
	
	/**
	 * Elimina a tarefa a atual e retorna a próxima tarefa
	 * 
	 * @return tarefa que atualmente está no topo da pilha
	 */
	public Tarefa proximaTarefa() {
		if (this.tarefas.empty())
			return null;
		this.tarefas.pop();
		if (this.tarefas.empty())
			return null;
		return tarefas.peek();
	}
	
	/**
	 * Lista todas as tarefas presentes na pilha se e somente se não estver nula
	 */
	public void listarTarefas() {
		System.out.println("Tarefas:");
		for (Tarefa tarefa : tarefas) {
			System.out.println("Nome: " + tarefa.getNome());
			System.out.println("Descrição: " + tarefa.getDescricao());
			System.out.println();
		}
	}
}
