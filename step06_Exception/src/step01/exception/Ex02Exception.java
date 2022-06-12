package step01.exception;

class Info{
	static {
		System.out.println("Info 클래스");
	}
}
public class Ex02Exception {
	public static void main(String[] args) {
		
		try {
			Class.forName("step01.exception.Info");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		}finally {
		}
		
		// catch문 순서
		try {
		// java.lang.NullPointerException
		String str1 = null;
		System.out.println(str1.length());
		String str2 = "three";
		Integer.parseInt(str2);
		
		// java.lang.NumberFormatException
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
