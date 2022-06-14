package step01.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStream {

	public static void main(String[] args) {
		// Buffer(8192) : 입력 혹은 출력에 대한 임시 저장공간 -> 데이터를 한번에 처리하는 보조 스트림
		// FileWriter - BufferedWriter
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter("cheerup.txt"));
//			bw.write("여러분" + "\n" );
//			bw.write("요즘 다들 힘드시죠? 에너지 충전이 필요할겁니다" + "\n" );
//			bw.write("그래서 오늘 숙제 드릴거에요");
//			
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		BufferedReader br =null;
		try {
			br = new BufferedReader(new FileReader("cheerup.txt"));
			
			String msg;
			try {
				while((msg=br.readLine()) != null) {
					System.out.println(msg);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Buffered 보조 스트림 성능 차이 실습
		long startTime;
		long endTime;
		
		try {
			FileInputStream fis = new FileInputStream("default.png");
			startTime = System.currentTimeMillis();
			while(fis.read()!=-1) {}
			endTime = System.currentTimeMillis();
			
			System.out.println("FileInputStream : "+(endTime-startTime)+"ms");
			fis.close();
			
			// 사용
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("default.png"));
			startTime = System.currentTimeMillis();
			while(bis.read()!=-1) {}
			endTime = System.currentTimeMillis();
			
			System.out.println("BufferedInputStream : "+(endTime-startTime)+"ms");
			fis.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {e.printStackTrace();}
		
		
	}

}
