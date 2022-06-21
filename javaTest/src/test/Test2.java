package test;


abstract class Animal {
	abstract void cry();
}

class Dog extends Animal {
	public void cry() {
		System.out.println("멍멍!");
	}
}

class Cat extends Animal{
	public void cry() {
		System.out.println("야옹!");
	}
}

class Cow extends Animal{
	public void cry() {
		System.out.println("음메!");
	}
}

class Animal2 {
	public void fly() {
		System.out.println("윙윙!");
	}
}

public class Test2 {
	public static void main(String[] args) {
		
		// Test2 결과 출력하기
		/*
		 * 윙윙!
		 * 멍멍!
		 * 야옹!
		 * 음메!
		 */
		
		Animal2 dragonfly = new Animal2();
		dragonfly.fly(); // 윙윙!
		
		Dog dog = new Dog();
		dog.cry();  // 멍멍!
		
		Cat cat = new Cat();
		cat.cry();  // 야옹!
		
		Cow cow = new Cow();
		cow.cry();  // 음메!
		
	}
}
