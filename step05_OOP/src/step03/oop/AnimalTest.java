package step03.oop;
//Animal
class Animal{
	
	public void move() {
		System.out.println("Animal Move");
	}
	
	public void eating() {
		
	}
}

class Human extends Animal{
	@Override
	public void move() {
		System.out.println("Human Move");
	}
	
	public void readBooks() {
		System.out.println("Human Read books");
	}
}

class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("Tiger Move");
	}
	
	public void hunting() {
		System.out.println("Tiger Hunt");
	}
}


class Eagle extends Animal{
	@Override
	public void move() {
		System.out.println("Eagle Move");
	}
	
	public void fly() {
		System.out.println("Eagle Fly");
	}
}

public class AnimalTest {
	// public void downCasting(Animal[] animaArray);
			// instanceof : 객체의 타입 확인
			// - 문법 : 객체 instanceof 타입
			// - 결과 : boolean(true or false)
			public static void downCasting(Animal[] animalArray) {
				for(int i=0;i< animalArray.length;i++) {
					Animal animal = animalArray[i];
					if(animal instanceof Human) {
						((Human)animal).readBooks();
					}else if (animal instanceof Tiger) {
						((Tiger)animal).hunting();
					}else if (animal instanceof Eagle) {
						((Eagle)animal).fly();
					}
				}
			}
	public static void main(String[] args) {
		// 다형성 (Polymorphism)
		
		// UpCasting : 자식객체가 부모타입으로 형변환 하면서 생성되는 것
		Animal human = new Human();
		System.out.println(human);
		
		human.move();
//		human.readBooks();
		
		// DownCasting : 부모타입으로 생성된 자식객체가 자신의 타입으로 형변환 하는 것
		Human human1 = (Human)human;
		
		human1.readBooks();
		System.out.println();
		
		// 자식 객체는 자식 타입으로 생성 가능하다. O
		// 부모 객체는 부모타입으로 생성 가능하다. O
		// 자식 객체는 부모 타입으로 생성 가능하다. O
		// 부모 객체는 자식 타입으로 생성 가능하다. x
		
//		Human test = (Human) new Animal();
//		test.move(); //java.lang.ClassCastException
		
		System.out.println();
		
		Animal tiger = new Tiger();
		tiger.move();
//		tiger.hunting();
		
		System.out.println();
		
		Animal eagle = new Eagle();
		eagle.move();
//		eagle.fly();
		System.out.println();
		//
		Animal[] animalArray= {human,tiger,eagle};
//		for(Animal animal:animalArray) {
//			animal.move();
//		}
		
		downCasting(animalArray);

		
		
		
		
		
	}	
		
}
