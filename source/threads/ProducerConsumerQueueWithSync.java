package threads;

import java.util.LinkedList;
import java.util.Queue;

/*
 * With synchronization read & write lock makes to run without any issue at consumer
 * */
public class ProducerConsumerQueueWithSync {

	static class Producer implements Runnable {
		Queue<String> queue;

		public Producer(Queue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			synchronized (queue) {
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

	}

	static class Consumer implements Runnable {
		Queue<String> queue;

		public Consumer(Queue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			String message;
			synchronized (queue) {
				while (!(message = queue.poll()).equals("done")) {
					System.out.println(message);
				}
			}
		}

	}

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();

		Thread th1 = new Thread(new Producer(queue));
		Thread th2 = new Thread(new Consumer(queue));
		th1.start();
		th2.start();
	}
}
