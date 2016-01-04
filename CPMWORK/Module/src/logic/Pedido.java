package logic;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

public class Pedido {

	private long codigoPedido;
	private int adults;
	private int kids;
	private long camDobInt;
	private long camDobExt;
	private long camFamInt;
	private long camFamExt;
	private int camasExtra;
	private Cruise crucero;
	private Usuario usuario;
	private ArrayList<Extra> extras;
	private double precioCamarotes;
	private double precioExtras;
	private double precioDescuento;
	private double precioFinal;
	private ArrayList<Room> rooms;
	private String date;

	public Pedido() {
		codigoPedido = new Random().nextLong();
		extras = new ArrayList<>();
		rooms = new ArrayList<>();
	}

	public boolean personasCorrectas() {
		if (kids < camasExtra) {
			return false;
		}
		int kids = this.kids - camasExtra;
		long totalPeople = camDobExt * 2 + camDobInt * 2 + camFamExt * 5 + camFamInt * 5;

		if ((adults + kids) <= totalPeople) {
			return true;
		} else {
			return false;
		}
	}

	public double calcularPrecioCamarotes() {
		precioCamarotes= precioCamarotes*crucero.getDuration();
		return precioCamarotes;
	}

	public double precioExtras() {
		for (Extra e : extras) {
			precioExtras += e.getPrecio();
		}
		return precioExtras;
	}

	public double precioDescuento() {
		if (crucero.isDescuento()) {
			precioDescuento = precioCamarotes * Catalog.descuento;
			return precioDescuento;
		} else {
			return 0;
		}
	}
	
	public double precioFinal(){
		precioFinal=calcularPrecioCamarotes()-precioDescuento()+precioExtras();
		return precioFinal;
	}

	public void addExtra(Extra extra) {
		extras.add(extra);
	}

	public void removeExtra(Extra extra) {
		extras.remove(extra);
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
		return camasExtra;
	}

	public void addCamaExtra() {
		camasExtra++;
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

	public long getCodigoPedido() {
		return codigoPedido;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void addRoom(Room room) {
		rooms.add(room);
		Ship barco= crucero.getBarco();
		if (room.getCam() == 1) {
			camDobInt++;
			precioCamarotes+=barco.getPrecioCamDobInt()*(room.getAdults()+room.getKids());
		} else if (room.getCam() == 2) {
			camDobExt++;
			precioCamarotes+=barco.getPrecioCamDobExt()*(room.getAdults()+room.getKids());
		} else if (room.getCam() == 3) {
			camFamInt++;
			precioCamarotes+=barco.getPrecioCamFamInt()*(room.getAdults()+room.getKids());
		} else if (room.getCam() == 4) {
			camFamExt++;
			precioCamarotes+=barco.getPrecioCamFamExt()*(room.getAdults()+room.getKids());
		}
		if (room.isCamaExtra()) {
			camasExtra++;
		}
		adults = adults + room.getAdults();
		kids = kids + room.getKids();
		extras.addAll(room.getExtras());

	}

	public void removeRoom(int index) {
		Room room = rooms.remove(index);
		Ship barco= crucero.getBarco();
		if (room.getCam() == 1) {
			camDobInt--;
			precioCamarotes-=barco.getPrecioCamDobInt()*(room.getAdults()+room.getKids());
		} else if (room.getCam() == 2) {
			camDobExt--;
			precioCamarotes-=barco.getPrecioCamDobExt()*(room.getAdults()+room.getKids());
		} else if (room.getCam() == 3) {
			camFamInt--;
			precioCamarotes-=barco.getPrecioCamFamInt()*(room.getAdults()+room.getKids());
		} else if (room.getCam() == 4) {
			camFamExt--;			
			precioCamarotes-=barco.getPrecioCamFamExt()*(room.getAdults()+room.getKids());
		}
		if (room.isCamaExtra()) {
			camasExtra--;
		}
		adults = adults - room.getAdults();
		kids = kids - room.getKids();
		extras.removeAll(room.getExtras());
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public String toString() {
		precioFinal();
		String string = "NOMBRE: " + usuario.getName() + "  NIF: " + usuario.getID() + "   TEL: "
				+ usuario.getPhoneNumber() + System.lineSeparator();
		string += System.lineSeparator();
		string += "**DATOS DEL CRUCERO**" + System.lineSeparator();
		string += "Crucero: " + crucero.getDenominacion() + System.lineSeparator();
		string += "Barco: " + crucero.getBarco() + System.lineSeparator();
		string += "Fecha de salida: " + date + System.lineSeparator();
		string += "D�as: " + crucero.getDuration() + System.lineSeparator();
		string += "Salida: " + crucero.getPuertoSalida() + System.lineSeparator();
		string += "N. Pasajeros: " + (adults + kids) + System.lineSeparator();
		string += "Camarotes: ";
		for (Room r : rooms) {
			string += r.toString();
		}
		string += System.lineSeparator() + System.lineSeparator();
		string += "** PAGADO RESERVA **" + System.lineSeparator();
		string += "Camarotes: " + System.lineSeparator();
		string += precioCamarotes + System.lineSeparator();
		string += "Extras: " + System.lineSeparator();
		string += precioExtras + System.lineSeparator();
		if (precioDescuento > 0) {
			string += "Descuento Oferta: " + System.lineSeparator();
			string += precioDescuento + System.lineSeparator();
		}
		string += "Importe Total: " + System.lineSeparator();
		string += precioFinal + System.lineSeparator();

		return string;

	}

}
