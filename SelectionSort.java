package ordenacao;

import java.util.Arrays;


/**
 * Classe para realizar um ordenamento usando o selectionSort
 * 
 * @author Victor Gabriel Alves Pereira
 * @author Victor Matheus Carvalho Pinheiro
 */
public class SelectionSort {
	/**
	 * Ordena os n�meros do array em ordem crescente, definindo que, para todo
	 * loop (definido pelo tamanho do array), verifica qual � o elemento de valor
	 * m�nimo do resto n�o ordenado e coloca-o no in�cio da parte n�o ordenada
	 * (possivelmente j� ordenando)
	 * 
	 * @param array vetor a ser ordenado
	 */
	public static void selectionSort(int array[]) {
		int length = array.length;

		// Intera o array em busca de um novo elemento m�nimo
		for (int i = 0; i < length - 1; i++) {
			int minElement = i;
			for (int j = i + 1; j < length; j++) {
				// verifica se o elemento m�nimo � maior que o elemento na posi��o j
				if (array[j] < array[minElement])
					minElement = j;
			}

			// Faz a troca de valores entre o elemento m�nimo e o da posi��o i
			int temp = array[minElement];
			array[minElement] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * Inicializa o array com valores est�ticos, chama o m�todo selectionSort
	 * para ordenar e imprime o valor ordenado
	 */
	public static void main() {
		int[] array = {12, 11, 22, 25, 34, 64, 90};

		selectionSort(array);

		System.out.println(Arrays.toString(array));
	}
}
