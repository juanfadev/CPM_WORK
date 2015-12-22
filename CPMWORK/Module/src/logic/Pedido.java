package logic;

import java.util.ArrayList;

public class Pedido {

	private int people;
	private int menores;
	private long camDobInt;
	private long camDobExt;
	private long camFamInt;
	private long camFamExt;
	private long camaExtra;
	private Cruise crucero;
	private Usuario usuario;
	private ArrayList<Extra> extras;
	private double precioCamarotes;
	private double precioExtras;

	public Pedido() {
	}

	public boolean personasCorrectas() {
		long totalPeople = camDobExt * 2 + camDobInt * 2 + camFamExt * 5 + camFamInt * 5;
		if (people < totalPeople) {
			return true;
		} else {
			return false;
		}
	}

	public double precioCamarotes(Cruise crucero) {
		Ship barco = crucero.getBarco();
		precioCamarotes = (barco.getPrecioCamDobExt() * camDobExt) + (barco.getPrecioCamDobInt() * camDobInt)
				+ (barco.getPrecioCamFamExt() * camFamExt) + (barco.getPrecioCamFamInt() * camFamInt);
		return precioCamarotes;
	}

	public double precioExtras() {
		for (Extra e : extras) {
			precioExtras += e.getPrecio();
		}
		return precioExtras;
	}

	public void addExtra(Extra extra) {
		extras.add(extra);
	}

	public void removeExtra(Extra extra) {
		extras.remove(extra);
	}

	public int getPeople() {
		return people;
	}

	public void addPeople(int people) {
		this.people = this.people + people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getMenores() {
		return menores;
	}

	public void setMenores(int menores) {
		this.menores = menores;
	}

	public long getCamDobInt() {
		return camDobInt;
	}

	public void setCamDobInt(long camDobInt) {
		this.camDobInt = camDobInt;
	}

	public long getCamDobExt() {
		return camDobExt;
	}

	public void setCamDobExt(long camDobExt) {
		this.camDobExt = camDobExt;
	}

	public long getCamFamInt() {
		return camFamInt;
	}

	public void setCamFamInt(long camFamInt) {
		this.camFamInt = camFamInt;
	}

	public long getCamFamExt() {
		return camFamExt;
	}

	public void setCamFamExt(long camFamExt) {
		this.camFamExt = camFamExt;
	}

	public long getCamaExtra() {
		return camaExtra;
	}

	public void setCamaExtra(long camaExtra) {
		this.camaExtra = camaExtra;
	}

	public Cruise getCrucero() {
		return crucero;
	}

	public void setCrucero(Cruise crucero) {
		this.crucero = crucero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
