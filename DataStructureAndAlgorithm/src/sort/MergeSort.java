package sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String args[]) {
		int[] arr = new int[] {0, 1, 3, 2, 4, 6, 8, 10};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int low, int high) {
		int middle = (low+high)/2;
		if(low < high){
			mergeSort(arr, low, middle);
			mergeSort(arr, middle + 1, high);
			merge(arr, low, middle, high);
		}
	}
	
	public static void merge(int[] arr, int low, int middle, int high) {
		int[] temp = new int[high - low + 1];
		
		int index = 0;
	
		//第一个数组的下标
		int i = low;
		
		//第二个数组中要遍历的下标
		int j = middle + 1;
		
		while(i <= middle && j <= high) {
			if(arr[i] <= arr[j]) {
				temp[index] = arr[i];
				i++;
			}else {
				temp[index] = arr[j];
				j++;
			}
			index ++;
		}
		
		while(i <= middle) {
			temp[index] = arr[i];
			i++;
			index++;
		}
		
		while(j <= high) {
			temp[index] = arr[j];
			j++;
			index++;
		}
		
		for(int k = 0; k < temp.length; k++) {
			arr[k+low] = temp[k];
		}
	}
}
