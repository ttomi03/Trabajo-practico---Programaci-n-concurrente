package datos;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class QuicksortForkJoin extends RecursiveAction {
	
	private int[]array; 
	private int inicio; 
	private int fin;
	
	//Constructor
	public QuicksortForkJoin(int[] data, int start, int end) {
        this.array = data;
        this.inicio = start;
        this.fin = end;
    }
	
	//Constructor para arreglo
	public QuicksortForkJoin(int[] array) {
        this(array, 0, array.length -1); 
    }
	
	@Override
	protected void compute() { //Se ejecuta QuickSort utilizando ForkJoin
		// TODO Auto-generated method stub
		if (inicio < fin) //Condicional de corte de recursividad 
		{
			int s= partition2(array, inicio, fin); //Se obtione la posicion de pivote
			
			invokeAll(new QuicksortForkJoin(array,inicio, s-1), //Se crean tareas para ordenar la particion
					  new QuicksortForkJoin(array, s+1, fin)); //Se crean tareas para ordenar la particion
		}
	} 
	
	private static int partition2(int[] arr, int start, int end) { //Particion similar a la hecha en QuickSort
		int pivot = arr[end];
        int s = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, ++s, i);
            }
        }
        swap(arr, ++s, end);
        return s;
    }
	private static void swap(int[] arr, int i, int j) { //Intercambio de variables
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
