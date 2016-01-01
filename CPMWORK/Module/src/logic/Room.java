package logic;

import java.util.ArrayList;


public class Room {

	public static final String codigoCamaExtra="E02";
	public static final int camDobInt=1;
	public static final int camDobExt=2;
	public static final int camFamInt=3;
	public static final int camFamExt=4;
	private int cam;
	private boolean camaExtra;
	private int adults;
	private int kids;
	private ArrayList<Person> people;
	private ArrayList<Extra> extras;
	
	public Room() {
		adults=0;
		kids=0;
		people=new ArrayList<>();
		cam=0;
		extras= new ArrayList<>();
	}
	
	public int getCam() {
		return cam;
	}
	public void setCam(int cam) {
		this.cam = cam;
	}
	public boolean isCamaExtra() {
		return camaExtra;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getKids() {
		return kids;
	}

	public void setKids(int kids) {
		this.kids = kids;
	}

	public Person[] getPeople() {
		return people.toArray(new Person[people.size()]);
	}

	public void addPeople(Person person) {
		people.add(person);
		if (person.isAdult()){
			adults++;
		}
		else{
			kids++;
		}
	}
	public void removePeople(Person person){
		people.remove(person);
		if (person.isAdult()){
			adults--;
		}
		else{
			kids--;
		}
	}
	public void calculateKidsAdults(){
		int adults=0;
		int kids=0;
		for (Person p:people){
			if(p.isAdult()){
				adults++;
			}
			else{
				kids++;
			}
		}
		this.adults=adults;
		this.kids=kids;
	}

	public ArrayList<Extra> getExtras() {
		return extras;
	}

	public void addExtra(Extra extra) {
		extras.add(extra);
		if (extra.getCodigoExtra().equals(codigoCamaExtra)){
			camaExtra=true;
		}
	}
	
	public void removeExtra(Extra extra){
		extras.remove(extra);
		if (extra.getCodigoExtra().equals(codigoCamaExtra)){
			camaExtra=false;
		}
	}
	
}
