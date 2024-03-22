package t2_CRUD;

public class HoewonVO {
	private int idx;
	private String name;
	private int age;
	private String gender;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
		return gender;
	}
	@Override
	public String toString() {
		return "HoewonVO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
				+ address + ", getIdx()=" + getIdx() + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getGender()=" + getGender() + ", getAddress()=" + getAddress() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
}
