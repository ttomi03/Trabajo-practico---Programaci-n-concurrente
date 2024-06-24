package datos;

import java.util.Random;

public class Array {
	public static int[] randomList(int n, int min, int max) {
        Random random = new Random();
        int[] RandomArray = new int[n];
        for (int i = 0; i < RandomArray.length; i++) {
            RandomArray[i] = random.nextInt(max - min + 1)+min;
        }
        return RandomArray;
    }
	public static void mostrar(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("{" + array[i] + "} ");
		}
		System.out.println();
	}

}
