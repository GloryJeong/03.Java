/* 클래스와 객체
 *	-설계
 *		1. 데이터(멤버 변수, 필드) : name, age
 *		2. 기능 (메소드) : name, age 값 반환 / 단순 출력
*/
package step02;

public class Ex02People {
	//멤버 변수(필드)
	String name = "Java";
	int age = 27;
	
	// 생성자 : 객체 생성 시, 필수 요소
	// 클래스의 이름과 동일할 것!
	// 반환값이 없음!
	// 기본 생성자 
	Ex02People(){
	}
	// 사용자 정의 생성자
	public Ex02People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Ex02People(String name) {
		this.name = name;
	}
	
	// 메소드
	// name 반환 메소드
	// 1. 메소드명 : getName
	// 2. 반환값 유무 
	String getName(){
		return name;
	}
	
	//age 반환 메소드
	int getAge() {
		return age;
	}
	
	// 단순 출력 메소드("단순 출력 메소드") 메소드
	// 1. 메소드명 : print	
	// 2. 반환값 유무: void(반환 타입 없음)
	void print(){
		System.out.println("단순 출력 메소드");
	}
	
	public static void main(String[] args) {
		Ex02People ppl1 = new Ex02People();
		System.out.println(ppl1);
		System.out.println(ppl1.age);
		System.out.println(ppl1.getName());
		ppl1.print();
		
		//ppl1의 이름을 New Java 으로 변경하고자 한다면?
		ppl1.name= "New Java";
		System.out.println(ppl1.getName());
		
		//ppl2
		Ex02People ppl2 = new Ex02People();
		
		//ppl3
		Ex02People ppl3 = new Ex02People("Java3",45);
		System.out.println(ppl3.age);
		System.out.println(ppl3.getName());
		ppl3.print();
		
		Ex02People ppl4 = new Ex02People("Java4");
		System.out.println(ppl4.getName());
		
		
		
	}

}