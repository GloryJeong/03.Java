package step02.oop;
public class CustomerTest {
	public static void main(String[] args) {
//		Customer customerCentum = new Customer();
//		customerCentum.setCustomerId(10001);
//		customerCentum.setCustomerName("Centum");
		Customer customerCentum = new Customer(10001,"Centum");
		
//		VIPCustomer customerSuyeong = new VIPCustomer();
		Customer customerSuyeong = new VIPCustomer(10001,"Suyeong");
//		customerSuyeong.setCustomerId(10002);
//		customerSuyeong.setCustomerName("Suyeong");
		customerSuyeong.setBonusPoint(1000);
		
		System.out.println(customerCentum.showCustomerInfo());
		System.out.println(customerSuyeong.showCustomerInfo());
		
		System.out.println(customerCentum.carcPrice(1000));
		System.out.println(customerSuyeong.carcPrice(1000));
		System.out.println(customerSuyeong.getBonusPoint());

	}

}
