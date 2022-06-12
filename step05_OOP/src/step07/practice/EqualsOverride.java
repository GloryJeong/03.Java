package step07.practice;

class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object object) {
//		if((object instanceof Person)&& 
//				(name.equals(((Person) object).name)) &&
//				(this.age ==((Person) object).age)){
//			return true;
//		}else {
//			return false;
//		}
		if((object instanceof Person)) {
			Person person = (Person)object;
			if((name.equals(person.name)) &&(this.age ==person.age)){
				return true;
				}
			}
		return false;
		
//		if(this.name == person.name && this.age == person.age) {
//			return true;
//		}else {
//			return false;
//		}
	}
	
}
class Person2{
	String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class EqualsOverride {
	public static void main(String[] args) {
		Person p1 = new Person("Java",27);
		Person p2 = new Person("Java",27);
		Person2 p3 = new Person2("Java",27);
		
		//주소값 
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
//		System.out.println(p3.hashCode());
		
		//equals
		System.out.println(p1.equals(p2)); //false->true
		System.out.println(p1.equals(p3));
		
	}

}
