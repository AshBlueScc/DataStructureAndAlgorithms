package sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[]{2, 4, 6, 3, 2 ,4 ,7, 1};
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void bubbleSort(int[] arr){
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length - 1 -i; j++) {
				int temp;
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
