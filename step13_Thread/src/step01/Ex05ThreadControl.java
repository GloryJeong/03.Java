package step01;

class ThreadA extends Thread{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag= flag;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println(Thread.currentThread().getState());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(flag) {
				System.out.println("ThreadA 작업중");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class ThreadB extends Thread{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag= flag;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			if(flag) {
				System.out.println("ThreadB 작업중");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Thread.yield();
			}
		}
	}
}

class SumThread extends Thread{
	private int sum;
	
	public int getSum() {
		return sum;
	}
	
	@Override
	public void run() {
		for(int i = 1;i<=100;i++) {
			sum +=i;
		}
	}
}


public class Ex05ThreadControl {

	public static void main(String[] args) {
		//
//		ThreadA threadA = new ThreadA();
//		ThreadB threadB = new ThreadB();
//		
//		threadA.start();
//		threadB.start();
		
		// Thread B만 실행?
		// Thread A는 RUNNABLE상태
//		threadA.setFlag(false);
		
		// Thread A, B 종료
//		threadA.setStop(true);
//		threadB.setStop(true);
		
		
		
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			// 메인 스레드는 일시 정지 -> sumThread의 실행이 끝나면 다시 실행시키는 메소드
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 0이 출력되는 이유?
		// 메인스레드가 먼저 실행되어 sumThread가 동작하기전에 결과를 내보내기때문
		System.out.println(sumThread.getSum());
		
		 
		
		
		
	}

}
