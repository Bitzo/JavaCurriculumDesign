package cn.jit.myproject.domain;

public class Person {
	private String ID;
	private String name;
	private int age;
	private boolean gender;
	private String grade;
	private String password;
	private String address;
	private String telephone;
	
	public Person(String ID, String name, int age, boolean gender, String grade, String pw, String address, String telephone)
	{
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
		this.password = pw;
		this.address = address;
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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

	public String getGender() {
		if (this.gender == true) {
			return "ÄÐ";
		} else {
			return "Å®";
		}
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return ID + " " + name + " " + age + " " + this.getGender() + " " + grade + " " + address + " " + telephone;
	}
}
