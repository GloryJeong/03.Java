package step01.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import model.domain.Kid;
import model.domain.Student;

public class Serialization {
	public static void main(String[] args) {
		// 객체 출력  -ObjectOutputStream
//		try {
//			FileOutputStream fos = new FileOutputStream("Object.txt");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			
//			oos.writeObject(new String("Busan"));
//			oos.writeObject(new Integer(1));
//			oos.close();
//			fos.close();
//			System.out.println("객체 출력 성공");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// 객체 입력 - ObjectInputStream
		try {
			FileInputStream fis = new FileInputStream("Object.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			//
			boolean flag = true;
			Object obj = null;
			while(flag) {
				obj = ois.readObject();
				System.out.println(obj);
			}
			
			ois.close();
			fis.close();
		
			
			// 직렬화
			Kid kidOut = new Kid();
			kidOut.setName("Busan");
			kidOut.setAge(27);
			kidOut.setPersonalNumber(12345);
			
			ObjectOutputStream ooskid = new ObjectOutputStream(new FileOutputStream("Kid.txt"));
			ooskid.writeObject(kidOut);
			
			ooskid.close();
			
			// 역직렬화
			ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("Kid.txt"));
			Kid kidIn = (Kid) ois1.readObject();
			System.out.println(kidIn.getName());
			System.out.println(kidIn.getAge());
			System.out.println(kidIn.getPersonalNumber());
			
			ois1.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		
//		Student student =new Student();
//		student.setAge(18);
//		student.setName("정영훈");
//		student.setStdNo(1);
//		
//		try {
//			ObjectOutputStream oosstudent = new ObjectOutputStream(new FileOutputStream("Student.txt"));
//			oosstudent.writeObject(student);
//			
//			oosstudent.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
	}
}
