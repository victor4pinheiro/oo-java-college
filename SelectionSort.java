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
	 * Ordena os números do array em ordem crescente, definindo que, para todo
	 * loop (definido pelo tamanho do array), verifica qual é o elemento de valor
	 * mínimo do resto não ordenado e coloca-o no início da parte não ordenada
	 * (possivelmente já ordenando)
	 * 
	 * @param array vetor a ser ordenado
	 */
	public static void selectionSort(int array[]) {
		int length = array.length;

		// Intera o array em busca de um novo elemento mínimo
		for (int i = 0; i < length - 1; i++) {
			int minElement = i;
			for (int j = i + 1; j < length; j++) {
				// verifica se o elemento mínimo é maior que o elemento na posição j
				if (array[j] < array[minElement])
					minElement = j;
			}

			// Faz a troca de valores entre o elemento mínimo e o da posição i
			int temp = array[minElement];
			array[minElement] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * Inicializa o array com valores estáticos, chama o método selectionSort
	 * para ordenar e imprime o valor ordenado
	 */
	public static void main() {
		int[] array = {12, 11, 22, 25, 34, 64, 90};

		selectionSort(array);

		System.out.println(Arrays.toString(array));
	}
}
