package threads;

public class DeadLock {

	static String resource1 = "resource1";
	static String resource2 = "resource2";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread() {
			public void run() {
				synchronized(resource1) {
					System.out.println("Resource 1 from thread 1");
					try {
						this.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(resource2) {
						System.out.println("Resource 2 from thread 1");	
						try {
							this.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};

		Thread thread2 = new Thread() {
			public void run() {
				synchronized(resource2) {
					System.out.println("Resource 2 from thread 2");
					try {
						this.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(resource1) {
						System.out.println("Resource 1 from thread 2");	
						try {
							this.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		
		thread1.start();
		thread2.start();
	}

}
