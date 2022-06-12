/* 도메인 모델(Domain Model)
 * -객체 지향 분석 설계 기반으로 구현하고자 하는 비즈니영역의 모델을 생성하는 패턴
 * - 속성, 기능 분리
 * - 단순 : 하나의 도메인 객체 = 테이블 하나
 * - 재사용성, 유지보수 용이
*/
package model.domain;

public class People {
	//멤버변수(필드)
	//캡슐화(Capsulation)
	private String name;
	private int age;
	
	// 생성자
	People(){}
	
	public People(String name, int age){
		this.name = name;
		this.age = age;
	}
	// get메소드, getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	// set메소드, setter
	public void setAge(int age) {
		if(age >= 0) {
		this.age = age;
		}else {System.out.println("입력한 나이는 유효하지 않습니다.");}
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
