package sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5, 1, 3, 6, 8, 3, 4, 5, 2};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);	
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int standard = arr[start];
			int low = start;
			int high = end;
			while(low < high) {		
				while( low < high && standard <= arr[high]) {
					high --;
				}
				arr[low] = arr[high];
				while( low < high && arr[low] <= standard) {
					low ++;
				}
				arr[high] = arr[low];			
			}
			arr[low] = standard;
			quickSort(arr, start, low);
			quickSort(arr, low + 1, end);
		}		
	}
}
