package sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5, 1, 3, 6, 8, 3, 4, 5, 2};
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {			
			if(arr[i] > arr[i+1]) {
				int temp;
				temp = arr[i+1];
				int j;
				for(j = i; j >= 0 && arr[j] > temp; j--) {
					arr[j+1] = arr[j] ;
				}
				arr[j+1] = temp;
			}
			
		}
		
	}
}
