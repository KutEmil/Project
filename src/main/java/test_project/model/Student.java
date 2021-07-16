package test_project.model;

public class Student {

	private String name;
	private boolean sex;
	private int age;
	private int course;

	public Student() {}

	public Student(String name, boolean sex, int age, int course) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.course = course;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age + ", course=" + course + "]";
	}

}
