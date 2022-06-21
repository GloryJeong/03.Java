package step01;

public class Ex01Thread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" " + (i+1) + "번 실행");
		}
	}
	
	public static void main(String[] args) {
		
		Ex01Thread thread1 = new Ex01Thread();
		thread1.start();
		Ex01Thread thread2 = new Ex01Thread();
		thread2.start();
		
		System.out.println(Thread.currentThread().getName());
		
	}
}
 