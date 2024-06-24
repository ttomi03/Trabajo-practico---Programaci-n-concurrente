package test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import datos.Array;
import datos.QuickSort;
import datos.QuicksortForkJoin;


public class main {
	
	public static void main(String[] args)
	{
		int n=1000; 
		int[] array= Array.randomList(n, 1 , 90000); //Se genera el array
		int[] array2= Arrays.copyOf(array, array.length); //Se genera una copia 
		int[] array3= Arrays.copyOf(array, array.length); //Se genera otra copia 
		
		QuicksortForkJoin quicksortTaskRandom= new QuicksortForkJoin(array2); // Crea la tarea pero no la ejecuta
		ForkJoinPool pool= new ForkJoinPool(); //Pileta de hilos la cual va a generar la mayor cantidad de hilos posibles
		System.out.println("Hilos generados: " + pool.getParallelism());
		
		double tiempoInicio= System.currentTimeMillis(); //Empieza a correr el tiempo
		pool.invoke(quicksortTaskRandom); //Se invoca la tarea
		double tiempoFin= System.currentTimeMillis(); //El tiempo deja de correr
		double tiempoTotal= tiempoFin - tiempoInicio; //Se calcula tiempo final
		System.out.println("Tiempo de concurrencia: " + tiempoTotal);
		
		double tiempoInicio2= System.currentTimeMillis(); //Empieza a contar el tiempo
		QuickSort.quickSort(array3, 0, array3.length-1); //Se realiza la ejecucion secuencial
		double tiempoFin2= System.currentTimeMillis(); //Se deja de contar el tiempo
		double tiempoTotal2= tiempoFin2 - tiempoInicio2; //Se calcula el tiempo final
		System.out.println("Tiempo de secuencial: " + tiempoTotal2);
		
	}

}
