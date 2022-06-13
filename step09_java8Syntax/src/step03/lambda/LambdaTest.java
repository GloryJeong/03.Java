package step03.lambda;
public class LambdaTest {
	interface LambdaInter1 {
		void method();
	}
	interface LambdaInter2 {
		void method(int x);
	}
	// 함수형 인터페이스 어노테이션
	@FunctionalInterface
	interface LambdaInter3 {
		int method(int x, int y);
	}
	
	// 직접 해보기?
	@FunctionalInterface
	interface Calculation{
		int operation(int v1, int v2);
	}
	static String operation(int v1, int v2,Calculation cal) {
		String result;
		try {
			result=Integer.toString(cal.operation(v1, v2));
		} catch (Exception e) {
			result ="0으로 나눌수 없음";
		}
		return result;
	}
	
	public static void main(String[] args) {
		// 람다1 : 매개 변수 없는 람다식
		LambdaInter1 li1;
		li1 = () -> System.out.println("람다식");
//		System.out.println(li1);
//		li1.method();
		
		LambdaInter2 li2;
		li2 = x -> System.out.println(x+1);
//		li2.method(5);
		
		//람다3-1 : 매개 변수가 2개일 때는 매개변수 괄호는 생략 불가능
		// *** method2가 있을 때에는 에러 발생 -> 어떤 것을 구현하는지 모호, 형태가 달라도 애초에 발생할 수 있는 오류 방지하기 위해
		//							-> 에러 발생 시킴 -> 따라서 함수형 인터페이스는 "하나의 메소드만" 구현 하도록 설계					
		
		LambdaInter3 li3;
		li3 = (int x,int y) -> x+y;
//		int result = li3.method(5, 10);
//		System.out.println(result);
		
		
		Calculation add =(v1,v2) -> v1+v2;
		Calculation sub =(v1,v2) -> v1-v2;
		Calculation mul =(v1,v2) -> v1*v2;
		Calculation div =(v1,v2) -> v1/v2;
			
//		System.out.println(add);
		
//		System.out.println(operation(5,5,add));
//		System.out.println(operation(5,5,sub));
//		System.out.println(operation(5,5,mul));
//		System.out.println(operation(5,0,div));
		// 클래스 + 인터페이스 vs 람다식 구현 차이를 비교

	      // 두가지 문자열을 연결하고, !기호를 붙이는 인터페이스 vs 람다식
	    String str1 = "Hello";
	    String str2 = "Java";
	      
	   // 클래스 + 인터페이스
	    BangMarkImpl bangMarkImpl = new BangMarkImpl();
	    bangMarkImpl.addBangMark(str1, str2);

	    // 람다식
	    BangMark bangMark2 = (s1, s2) -> System.out.println(s1+ " "+ s2+ "!");
	    bangMark2.addBangMark(str1, str2);
	    
	    // 람다식은 내부적으로 내부 익명 클래스가 적용된 것
	    BangMark bangMark3 = new BangMark() {
			@Override
			public void addBangMark(String str1, String str2) {
				System.out.println(str1+ " "+ str2+ "!");
			}
	    };
	    bangMark3.addBangMark(str1, str2);
	    
	}
}
