package sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5, 1, 3, 6, 8, 3, 4, 5, 2};
		System.out.println(Arrays.toString(arr));
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void shellSort(int[] arr) {
		for(int d = arr.length/2; d > 0; d /= 2) {
			for(int i = d; i < arr.length; i++) {
				for(int j = i-d; j>=0; j-=d) {
					if(arr[j] > arr[j+d]) {
						int temp = arr[j];
						arr[j] = arr[j+d];
						arr[j+d] = temp;
					}
				}
			}
			
		}
	}
}
