package logic;

public class Person {

	private int age;
	
	
	public Person(int age) {
		super();
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAdult(){
		if (age>=16){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public String toString(){
		if (isAdult()){
			return "Adult: "+age+" yo";
		}
		else{
			return "Kid: " + age + " yo";
		}
	}
	
}
