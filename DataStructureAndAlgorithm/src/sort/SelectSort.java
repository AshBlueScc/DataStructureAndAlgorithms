package sort;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5, 1, 3, 6, 8, 3, 4, 5, 2};
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void selectSort(int[] arr){
		
		for(int i = 0; i < arr.length; i++) {
			int minimum_index = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minimum_index]) {
					minimum_index = j;
				}
			}
			if(i != minimum_index) {
				int temp = arr[i];
				arr[i] = arr[minimum_index];
				arr[minimum_index] = temp;	
			}		
		}
	}
}
