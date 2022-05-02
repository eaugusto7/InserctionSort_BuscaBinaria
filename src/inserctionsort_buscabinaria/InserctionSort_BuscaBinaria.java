/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inserctionsort_buscabinaria;

import java.util.Random;

public class InserctionSort_BuscaBinaria {

    public static void Inserction(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }

    public static int BuscaBinaria(int[] array, int valor) {
        int inicio = 0;
		int fim = array.length-1;
 
		while(inicio <= fim){
			int meio = (inicio+fim)/2;
			if(array[meio] == valor){
				return meio;
			}
 
			if(valor > array[meio]){
				inicio = meio+1;
			} else {
				fim = meio-1;
			}
		}
	return -1;
    }

    public static void main(String args[]) {
        int tam1 = 100000;
        int valor_busca = (tam1+1);

        int vetor1[] = new int[tam1];
        int vetor2[] = new int[tam1];
        int vetor3[] = new int[tam1];

        for (int i = 0; i < tam1; i++) //Crescente
            vetor1[i] = i;

        for (int i = 1; i < tam1; i++) //Decrescente
            vetor2[i] = tam1 - i;

        Random valor1 = new Random(tam1); //Aleatorio
        for (int i = 0; i < tam1; i++)
            vetor3[i] = valor1.nextInt(tam1);
       
        /*for(int i=0;i<tam1;i++)
            System.out.println(vetor1[i]);*/
        
        long inicio1 = System.nanoTime();
        Inserction(vetor1);
        BuscaBinaria(vetor1, valor_busca);
        long fim1 = System.nanoTime();
        System.out.println("Vetor ordenado: "+(fim1 - inicio1) + " nanosegundos");

        long inicio2 = System.nanoTime();
        Inserction(vetor2);
        BuscaBinaria(vetor2, valor_busca);
        long fim2 = System.nanoTime();
        System.out.println("Vetor na ordem inversa: "+(fim2 - inicio2) + " nanosegundos");
 
        long inicio3 = System.nanoTime();
        Inserction(vetor3);
        BuscaBinaria(vetor3, valor_busca);
        long fim3 = System.nanoTime();
        System.out.println("Vetor na ordem aleatória: "+(fim3 - inicio3) + " nanosegundos");
    
        /*for(int i=0;i<tam1;i++)
            System.out.println(vetor1[i]);*/
    }
}
