package test;

import java.util.ArrayList;

abstract class Car {
	abstract void run();
}

class Ambulance extends Car { 
	void run() { System.out.println( "앰뷸런스  run!" ); } 
}

class Cultivator extends Car {
	void run() { System.out.println( "경운기 run!" ); }
}

class SportsCar extends Car {
	void run() { System.out.println( "스포츠카 run!" ); }
}


public class Test4 {
	public static void main(String[] args) {
		ArrayList<Car> carList = new ArrayList<Car>();
		// ArrayList에 값을 추가
		carList.add(new Ambulance());
		carList.add(new Cultivator());
		carList.add(new SportsCar());
		
		// Test4 ArrayList를 통해 전체 값 출력하기
		/*
		 * 앰뷸런스  run!
		 * 경운기 run!
		 * 스포츠카 run!
		 */
		// ArrayList에 있는 객체에 있는 run메소드 실행
		carList.forEach(v->v.run());

		
	}
}
