package view;

import java.util.Scanner;

import controller.StudentController;

public class StartView {
	public static void main(String[] args) {
		boolean check;
		
		
		Scanner scan = new Scanner(System.in);
		int selectNum;
		do {
			System.out.println("---------------------------");
			System.out.println("1. 모든 정보 출력");
			System.out.println("2. 이름 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 수정");
			System.out.println("6. 종료");
			System.out.println("---------------------------");
			System.out.print("번호 선택  : ");
			selectNum=scan.nextInt();
			check = StudentController.request(selectNum);
			 }while (check);
		
		scan.close();

	}
}
