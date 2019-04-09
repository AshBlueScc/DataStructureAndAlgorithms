package test;

import myQueue.MyQueue;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		mq.add(1);
		mq.add(2);
		mq.add(3);
		
		System.out.println("poll from the queue:" + mq.poll());
		System.out.println("poll from the queue:" + mq.poll());
		System.out.println("poll from the queue:" + mq.poll());
	}

}
