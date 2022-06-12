/* 접근 제한자(Access Modifier)
 * -public : 동일 class/ package, 외부 package
 * -private : 동일 class
 * -default(생략시) : 동일 package
 * -protected : 동일 class/ package, 단 상속 관계일 경우 외부 package 접근 가능함
 * 
 * 2. 사용 가능 위치
 * - 클래스 선언구 : public, default
 * - 변수/생성자/메소드 선언구 : public,default,private,protected
*/
package step02;
import model.domain.People;
public class Ex05Access {

	public static void main(String[] args) {
		People ppl1 = new People("Java",27);
		
//		System.out.println(ppl1.name); // 더이상 접근 불가 -> private
//		System.out.println(ppl1.age);
		System.out.println(ppl1.getName());
		ppl1.setAge(-30);
		
	}

}
