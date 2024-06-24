package datos;

public class QuickSort {
	
	
	public static void quickSort(int[] arr, int start, int end) { // Método iniciar el algoritmo de QuickSort
        if (end <= start) return; // Condicion que finaliza la recursividad
        int s = partition(arr, start, end); //Posicion del pivote
        quickSort(arr, start, s - 1); //Se ordena la particion divididas por el pivote
        quickSort(arr, s + 1, end); //Se ordena la particion divididas por el pivote
    }
	
	public static int partition(int[] arr, int start, int end) { //Produce una particion dejando a los valores mas chicos del lado izquierdo y los mas grendes del lado derecho
        if (start == end) return start; // Si hay un solo elemento retorna
        int pivot = arr[end]; //Toma el ultimo elemento de la lista como pivote
        int s = start - 1; //Posicon del ultimo menor
        for (int i = start; i < end; i++) { //Recorre el arreglo sin llegar al pivote
            if (arr[i] <= pivot) { //Si el elemnto es menor al pivote se coloca a la izquierda
                swap(arr, ++s, i); //Intercambio de variables
            }
        }
        swap(arr, ++s, end);//Coloco al pivote en la posicion siguiente al ultimo moenor
        return s; //Retorno el pivote
    }
	
	public static void swap(int[] arr, int i, int j) { //Intercambio de variables
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
