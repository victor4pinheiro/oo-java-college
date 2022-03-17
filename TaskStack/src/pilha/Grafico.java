package pilha;

import java.util.Scanner;

/**
 * Permite que o usu�rio crie e pule para a pr�xima tarefa (se e somente se a primeira estiver conclu�da) atrav�s do terminal
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 *
 */
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
			case 1: // Adicionar tarefa
				System.out.println("Digite o nome da tarefa:");
				entrada.nextLine();
				String nome = entrada.nextLine();
				
				System.out.println("Digite a descri��o da tarefa:");
				String descricao = entrada.nextLine();
				
				Tarefa tarefa = Tarefa.adicionarTarefa(nome, descricao);
				pilhaTarefas.adicionarTarefa(tarefa);
				break;
				
			case 2: // Obter a pr�xima tarefa
				Tarefa tmp = pilhaTarefas.proximaTarefa();
				
				if (tmp == null) {
					System.out.println("Nulo");
				} else {
					System.out.println(tmp.getNome());
					System.out.println(tmp.getDescricao());
				}
				break;
				
			case 3: // Listar tarefas
				pilhaTarefas.listarTarefas();
				break;
				
			case 4: // Sair do programa
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

