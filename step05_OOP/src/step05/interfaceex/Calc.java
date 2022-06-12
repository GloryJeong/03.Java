package step05.interfaceex;

public interface Calc {
	   double PI = 3.14;
	   int ERROR = -999999;

	   int add(int x, int y);

	   int substract(int x, int y);

	   int times(int x, int y);

	   int divide(int x, int y);
	   
	   default void turnOn() {
		   System.out.println("turn On");
	   }
}
