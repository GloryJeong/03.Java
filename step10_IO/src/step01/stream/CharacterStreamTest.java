package step01.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamTest {
	public static void main(String[] args) {
		//Writer
		try {
			FileWriter fw = new FileWriter("CharacterStream.txt");
			fw.write("여행이 너무 가고 싶어요"+"\n");
			fw.write("어디로 가지?"+"\n");
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reader
		FileReader fr = null;
		try {
			fr = new FileReader("CharacterStream.txt");
			
			int data;
			try {
				while((data = fr.read()) != -1) {
					System.out.println((char)data);
				}
			fr.close();
			}catch(IOException e) {}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
