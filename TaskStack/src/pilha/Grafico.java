package pilha;

import java.util.Scanner;

public class Grafico {
	public static void main(String[] args) {
		Pilha pilhaTarefas = new Pilha();
		Scanner entrada = new Scanner(System.in);

		while (true) {
			int option = 0;
			
			System.out.println("Op��es:");
			System.out.println("1 - Adicionar tarefa");
			System.out.println("2 - Obter a pr�xima tarefa");
			System.out.println("3 - Listar tarefas");
			System.out.println("4 - Sair");
			option = entrada.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("Digite o nome da tarefa:");
				entrada.nextLine();
				String nome = entrada.nextLine();
				
				System.out.println("Digite a descri��o da tarefa:");
				String descricao = entrada.nextLine();
				
				Tarefa tarefa = Tarefa.adicionarTarefa(nome, descricao);
				pilhaTarefas.adicionarTarefa(tarefa);
				break;
				
			case 2:
				Tarefa tmp = pilhaTarefas.proximaTarefa();
				
				if (tmp == null) {
					System.out.println("Nulo");
				} else {
					System.out.println(tmp.getNome());
					System.out.println(tmp.getDescricao());
				}
				break;
				
			case 3:
				pilhaTarefas.listarTarefas();
				break;
				
			case 4:
				entrada.close();
				System.exit(0);
				break;

			default:
				System.out.println("Op��o n�o reconhecida");
				break;
			}
			
		}
	}
}

