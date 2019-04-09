package myStack;

public class Mystack {
	private int[] arr;
	private int index; //栈顶标号
	private int max;
	private int min;
	
	public Mystack() {
		arr = new int[0];
		index = 0;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
	
	public void push(int num) {
		//每进来一个元素，比较是否是最大元素或者最小元素
		if(max < num) {
			max = num;
		}
		if(min > num) {
			min = num;
		}
		int[] arr1 = new int[arr.length+1];
		System.arraycopy(arr, 0, arr1, 0, arr.length);
		arr1[index] = num;
		index++;
		arr = arr1;
	}
	
	public int pop() {
		//每推出一个元素，比较是否是最大元素或者最小元素
		if(isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		int element = arr[index - 1];
		int[] arr1 = new int[arr.length - 1];
		System.arraycopy(arr, 0, arr1, 0, arr.length-1);
		index--;
		arr = arr1;
		if(index != 0) {
			if(max == element) {
				max = arr[0];
				for(int i = 1; i < arr.length; i++) {
					if(max < arr[i]) {
						max = arr[i];
					}
				}
			}
			if(min == element) {
				min = arr[0];
				for(int i = 1; i < arr.length; i++) {
					if(min > arr[i]) {
						min = arr[i];
					}
				}
			}
		}
		return element;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		return arr[index-1];
	}
	
	public boolean isEmpty() {
		return index == 0;
		
	}
	
	public int getMax() {
		if(isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		return max;
	}

	public int getMin() {
		if(isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		return min;
	}
	
	
}
