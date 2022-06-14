package model.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Kid implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1234681498020267688L;
	private String name;
	private int age;
	// transient 키워드가 있으면 데이터를 내보내지 않음
	private transient int personalNumber;
	// Object object = new Object();
	// 클래스 내부에 Object 객체가 존재한다면 이 클래스는 직렬화가 되지 않음!!
	public Kid() {
	}
	public Kid(String name, int age, int personalNumber) {
		super();
		this.name = name;
		this.age = age;
		this.personalNumber = personalNumber;
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
	public int getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
	}
	
	
}
