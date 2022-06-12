package step04.template;

public class MenualCar extends Car {

	@Override
	void drive() {
		System.out.println("사람이 직접 운행 시작");
	}

	@Override
	void stop() {
		System.out.println("사람이 직접 운행  종료");
	}
	
}
