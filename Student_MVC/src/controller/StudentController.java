package controller;

import java.util.Scanner;

import model.StudentModel;
import model.domain.Student;
import view.EndView;

public class StudentController {
	static Scanner scan = new Scanner(System.in);
	static String name;
	static boolean result;
	public static boolean request(int num) {
		switch (num) {
		//전체검색
		case 1:
			EndView.printAll(StudentModel.allSearch());
			return true;
		// 단일 검색
		case 2:
			System.out.println("----------단일검색--------------");
			System.out.print("이름을 입력하세요: ");
			name = scan.next();
			EndView.printOne(StudentModel.oneSearch(name));
			return true;
		// 추가
		case 3:
			System.out.println("------------추가-------------");
			System.out.print("이름을 입력하세요: ");
			name = scan.next();
			System.out.print("나이를 입력하세요: ");
			int age = scan.nextInt();
			if(age>0&&age<120) {
			StudentModel.addStudent(new Student(name,age));
			}else {System.out.println("나이를 잘못 입력하셨습니다.");}
			return true;
		// 삭제
		case 4:
			System.out.println("------------삭제-------------");
			System.out.print("이름을 입력하세요: ");
			name = scan.next();
			result = StudentModel.removeStudent(name);
			if(result) {
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 실패");
			}
			return true;
		// 수정
		case 5:
			System.out.println("------------수정-------------");
			System.out.print("이름을 입력하세요: ");
			name = scan.next();
			result=StudentModel.update(StudentModel.oneSearch(name));
			if(result) {
				System.out.println("수정 완료");
			}else {
				System.out.println("수정 실패");
			}
			return true;
		// 종료
		case 6:
			System.out.println("종료합니다.");
			return false;
			
		default:
			System.out.println("잘못된 입력값입니다. 다시 입력하세요.");
			return true;
		}
	}

}
