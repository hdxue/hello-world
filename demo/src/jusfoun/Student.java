package jusfoun;

import java.util.Arrays;

public class Student {

	private String name;
	private int id;
	private String sex;
	private int age;
	private String[] hobby;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + ", hobby="
				+ Arrays.toString(hobby) + "]";
	}
	

}
