package model.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Student {
	private int stdNo;
	private static int primaryNo =1;
	private String name;
	private int age;
	public Student(String name, int age){
		this.stdNo=primaryNo++;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "학번:"+stdNo+" 이름:"+name+" 나이:"+age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
