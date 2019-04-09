package myQueue;

public class MyQueue {

	private int[] arr;
	
	public MyQueue(){
		arr = new int[0];
	}
	
	public void add(int num) {
		int[] arr1 = new int[arr.length + 1];
		System.arraycopy(arr, 0, arr1, 0, arr.length);
		arr1[arr.length] = num;
		arr =arr1;
	}
	
	public int poll() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty!");
		}
		int element = arr[0];
		int[] arr1 = new int[arr.length -1];
		System.arraycopy(arr, 1, arr1, 0, arr.length-1);
		arr = arr1;	
		return element;
	}
	
	public int peek() {
		return arr[0];
	}
	public boolean isEmpty() {
		return arr.length == 0;	
	}
}
