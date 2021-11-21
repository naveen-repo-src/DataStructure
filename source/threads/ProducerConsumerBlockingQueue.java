package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * With blocking queue take will wait until value is present
 * add will wait until memory is available
 * */
public class ProducerConsumerBlockingQueue {

	static class Producer implements Runnable {
		BlockingQueue<String> queue;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				queue.add("" + i);
			}
			queue.add("done");
		}

	}

	static class Consumer implements Runnable {
		BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			String message;
			try {
				while (!(message = queue.take()).equals("done")) {
					System.out.println(message);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		BlockingQueue<String> queue = new PriorityBlockingQueue<String>();

		Thread th1 = new Thread(new Producer(queue));
		Thread th2 = new Thread(new Consumer(queue));
		th1.start();
		th2.start();
	}
}
