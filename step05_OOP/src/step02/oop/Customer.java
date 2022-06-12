package step02.oop;
// 고객
// 고객ID, Name, Grade, BonusPoint, BonusRatio
// int carcPrice(int price),String showCustomerInfo() - Name, Grade, Point
public class Customer {
	protected int customerId;
	protected String customername;
	protected String customerGrade;
	protected int bonusPoint;
	protected double bonusRatio;
	
	// 추가 개발 한다면?
	protected String staffId = "11";
	private double saleRatio;
	
	
	public Customer(){
		customerGrade="SILVER";
		bonusRatio = 0.01;
		System.out.println("Customer 생성자 호출"); 
	}	
	public Customer(int customerId,String customerName){
		setCustomerId(customerId);
		setCustomerName(customerName);
		customerGrade="SILVER";
		bonusRatio = 0.01;
		System.out.println("Customer 생성자 호출"); 
	}	
	// showCustmoerInfo
	public String showCustomerInfo() {
		
		return customername + "님의 등급은 " + customerGrade + "이고, 보너스 포인트는 "+ bonusPoint+ "입니다.";
	}
	// calcPrice
	public int carcPrice(int price) {
			bonusPoint += price * bonusRatio;			
		return price; 
	}
	
	public int getCustomerId() {
		return customerId;
	}	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customername;
	}
	public void setCustomerName(String name) {
		this.customername = name;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String grade) {
		customerGrade = grade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
}
