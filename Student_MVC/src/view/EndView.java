package view;

import java.util.ArrayList;

import model.domain.Student;

public class EndView {
	public static void printAll(ArrayList<Student> studentList) {
		if(studentList.size() == 0) {
			System.out.println("학셍 데이터 없음");
		}else {
			for(Student student:studentList) {
				System.out.println(student);
			}			
		}
	}
	public static void printOne(Student student) {
		if(student != null) {
		System.out.println(student);
		}else {System.out.println("학생 정보 없음");}
	}
}
