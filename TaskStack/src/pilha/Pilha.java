package pilha;

import java.util.Stack;

public class Pilha {
	Stack<Tarefa> tarefas = new Stack<Tarefa>();
	
	public void adicionarTarefa(Tarefa tarefa) {
		this.tarefas.push(tarefa);
	}
	
	public Tarefa proximaTarefa() {
		if (this.tarefas.empty())
			return null;
		this.tarefas.pop();
		if (this.tarefas.empty())
			return null;
		return tarefas.peek();
	}
	
	public void listarTarefas() {
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa.getNome());
			System.out.println(tarefa.getDescricao());
		}
	}
}
