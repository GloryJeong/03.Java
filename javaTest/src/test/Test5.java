package test;

class PersonTest {
	String name;
	int age;
	int weight;
	int num = 10;
	PersonTest() {}
	PersonTest( String name, int age, int weight ) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	void wash() { System.out.println( "wash" ); }
	void study() { System.out.println( "study" ); }
	void play() { System.out.println( "play" ); }
	public void test() {
		System.out.println("클래스에서 호출");
	}
}

interface Allowance {
	abstract void in( int price, String name );
	abstract void out( int price, String name );
	public default void test() {
		System.out.println("인터페이스에서 호출");
	}
}

interface Train {
	abstract void payTuitionFee( int tuitionFee, String name );
}

class StudentTest extends PersonTest implements Allowance, Train {
	StudentTest() {}
	StudentTest( String name, int age, int weight ) {
		super( name, age, weight );
	}
	
	public void in( int price, String name ) { System.out.printf( "%s 에게서 %d원 용돈을 받았습니다.%n", name, price ); }
	public void out( int price, String name ) { System.out.printf( "%d원 금액을 지출했습니다. [지출용도 --> %s]%n", price, name ); }
	public void payTuitionFee( int tuitionFee, String name ) { System.out.printf( "[%s --> %d원 입금완료]%n", name, tuitionFee ); }
	public void run(int price1,String name1,int price2,String name2,int tuitionFee, String name3) {
		wash();
		study();
		play();
		in(price1,name1);
		out(price2,name2);
		payTuitionFee(tuitionFee, name3);
	}

}

public class Test5 {
	public static void main(String[] args) {
		
		
		PersonTest person = new PersonTest();
		StudentTest student = new StudentTest();
		
		student.run(10000,"엄마", 5000, "편의점", 50000, "훈련비");
		
		// 상속받은 test메소드에 10을 넣었을때 20이됨 implements가 먼저 적용된후 extends가 적용됨 
		student.test();
		
		
		// Test5 결과 출력하기 & extends와 implements중에서 우선적으로 적용되는 것은 무엇인지 확인해보기
		/* 
		 * wash
		 * study
		 * play
		 * 엄마 에게서 10000원 용돈을 받았습니다.
		 * 5000원 금액을 지출했습니다. [지출용도 --> 편의점]
		 * [훈련비 --> 50000원 입금완료]
		 */
		

		
	}
}
