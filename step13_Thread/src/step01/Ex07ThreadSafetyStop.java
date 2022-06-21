package step01;

public class Ex07ThreadSafetyStop extends Thread{
	public Ex07ThreadSafetyStop() {
	}
	public Ex07ThreadSafetyStop(ThreadGroup threadGroup, String threadName) {
		super(threadGroup, threadName);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("스레드 실행중");
			if(Thread.interrupted()) {
				System.out.println("---스레드 종료---");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Ex07ThreadSafetyStop thread = new Ex07ThreadSafetyStop();
		thread.start();
		try {
			Thread.sleep(1000);
			thread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ThreadGroup busan = new ThreadGroup("busan");
		Ex07ThreadSafetyStop thread1 = new Ex07ThreadSafetyStop(busan,"thread1");
		Ex07ThreadSafetyStop thread2 = new Ex07ThreadSafetyStop(busan,"thread2");
		Ex07ThreadSafetyStop thread3 = new Ex07ThreadSafetyStop(busan,"thread3");
		thread1.start();
		thread2.start();
		thread3.start();
		busan.interrupt();
	}
}
