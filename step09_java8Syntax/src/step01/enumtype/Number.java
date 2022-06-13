package step01.enumtype;

public enum Number {
	ONE(1,"one"),
	TWO(2,"two"),
	THREE(3,"three"),
	FOUR(4,"four"),
	FIVE(5,"five"),
	SIX(6,"six"),
	SEVEN(7,"seven"),
	EIGHT(8,"eight"),
	NINE(9,"nine"),
	TEN(10,"ten");
	private final int intNumber;
	private final String stringNumber;

	Number(int intNumber,String stringNumber) {
		this.intNumber = intNumber;
		this.stringNumber= stringNumber;
	}
	public int getIntNumber() {
		return intNumber;
	}
}
