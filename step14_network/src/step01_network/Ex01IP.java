package step01_network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01IP {
	public static void main(String[] args) {
		// IP 주소 : java.net.xxx
		
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local);
			System.out.println(local.getHostName());
			System.out.println(local.getHostAddress());
			
			System.out.println();
			
			// 외부 정보
			InetAddress[] inetAddress= InetAddress.getAllByName("google.com");
			System.out.println(Arrays.toString(inetAddress));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
