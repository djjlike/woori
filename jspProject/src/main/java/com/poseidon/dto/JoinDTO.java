package com.poseidon.dto;

public class JoinDTO {

	private String id, name, password, email, address, tel;
	private int age;
	//생성자 똑같은 이름으로 여러개 만들고 싶어요 =
	
	public JoinDTO() {}
	
	public JoinDTO(String id) {
		this.id = id;
	}
	
	
	public JoinDTO(int age, String id, String password, String name, String email, String address, String tel) {

		this.age = age;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
