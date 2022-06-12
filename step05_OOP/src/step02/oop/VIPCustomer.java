package step02.oop;
/* 제품 구입시 10% 할인된 가격으로 제공
 * 보너스 포인트는 제품 가격의 5% 적립
 * staffId 배정
*/
public class VIPCustomer extends Customer {
	private String staffId;
	private double saleRatio;
	
	//기본 정의 생성자
	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCustomer 생성자 호출");
	}
	public VIPCustomer(int customerId,String customerName) {
		super(customerId,customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCustomer 생성자 호출");
	}
	
	// 메소드 오버라이딩 (Method Overriding)
	// 전제 조건 : 반환타입 메소드명 (매개변수)가 모두 100% 동일 한 경우에만
	@Override
	public int carcPrice(int price) {
		price -= (int)(super.carcPrice(price)*saleRatio);
		return price;
	}
}
