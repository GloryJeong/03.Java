package model;

import java.util.ArrayList;
import java.util.Scanner;

import model.domain.Student;

public class StudentModel {
	static ArrayList<Student> studentList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	
	
	
	//전체 검색
	public static ArrayList<Student> allSearch() {
		return studentList;
	}
	// 단일 검색
	public static Student oneSearch(String name) {
		for(Student student:studentList) {
			if(name != null&&name.equals(student.getName())){
				return student;
			}
		}
		return null;
	}
	
	//추가
	public static void addStudent(Student student) {
			studentList.add(student);
			System.out.println(studentList.get(studentList.size()-1));
	}
	
	//삭제
	public static boolean removeStudent(String name) {
		Student student = oneSearch(name);
		if(student != null) {
			studentList.remove(student);
			return true;
		}else {
			return false;
		}
	}
	public static boolean update(Student student) {
//		Student student = oneSearch(name);
		if(student != null) {
			System.out.print("수정할 이름을 입력 :");
			String updateName = scan.next();
			System.out.print("수정할 나이를 입력 :");
			int updateAge = scan.nextInt();
			student.setAge(updateAge);
			student.setName(updateName);
			return true;
		}else {
			return false;
		}
	}
}
