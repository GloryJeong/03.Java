package step01.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamTest {
	
	public static void fileSave(byte[] data) throws FileNotFoundException, IOException {
	    FileOutputStream fos = null;
	    try {
	        fos = new FileOutputStream("ByteStream.txt");
	            fos.write(97); // a
//					fos.write(65);
//					fos.write(66);
//					fos.write(67);
//					fos.write(68);
//					fos.write(69);

	            fos.write(data);
//					fos.write(data, 1, 3);
	            fos.close();
	    } finally {
	            fos.close();
	    }
	}
	public static void fileOpen(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		int data;
		
		// step01
//		while ((data =fis.read())!=-1) {
//			System.out.println((char)data);
//		}
		
		// step02
		int fileSize=(int) new File(path).length();
		byte[] readData = new byte[fileSize];
		fis.read(readData);
		for(int i = 0;i<fileSize;i++) {
			System.out.println((char)readData[i]);
		}
		
		
		
		fis.close();
		
	}
	
	
	public static void main(String[] args) {
//		byte[] data = {65,66,67,68,69};
//		try {
//			fileSave(data);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			fileOpen("ByteStream.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
