package model;

import java.util.ArrayList;

import model.domain.Student;

public class StudentModel {
	static ArrayList<Student> studentList = new ArrayList<>();
	
	
	
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
	

}
