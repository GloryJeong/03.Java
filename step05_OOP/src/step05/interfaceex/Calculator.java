package step05.interfaceex;

public class Calculator implements Calc {
	public int add(int x,int y) {
		return x+y;
	}
	public int substract(int x, int y) {
		return x-y;
	}

	public int times(int x, int y) {
		return x*y;
	}

	public int divide(int x, int y) {
		if(y != 0) {
			return x/y;
		}else {
			return ERROR;
		}
	}
}
	

