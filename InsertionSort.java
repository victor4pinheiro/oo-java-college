package atividade;

import java.util.Arrays;

public class InsertionSort {
	/**
	 * Separa os elementos em ordenados para a esquerda e n�o ordenados para a
	 * direita. Da esquerda para a direita, verifica se o primeiro n�mero da
	 * parte n�o ordenada � menor que seu predecessor at� que encontre um
	 * predecessor menor que ele, trocando os valores de suas posi��es. Caso
	 * encontre, � trocado para posi��o posteriorao predecessor que seja menor
	 * que ele.
	 * 
	 * @param array
	 */
	public static void insertionSort(int[] array) {
		int x,j;//declara��o de vari�vel
		for(int i = 1; i < array.length;i++) {//for iniciando da primeira posi��o
			x = array[i];
			j = i - 1;
			while(( j >= 0 ) && array[j] > x) {//enquanto 
				array[j + 1] = array[j];
				j = j -1;
			}
			array[j + 1] = x;
		}

	}
	public static void main(String[] args) {
		int []array = {8, 15, 20, 16, 3, 5, 1};
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
