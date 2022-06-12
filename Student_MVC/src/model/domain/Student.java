package model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
	

}
