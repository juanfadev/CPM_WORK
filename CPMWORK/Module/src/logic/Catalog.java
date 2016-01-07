package logic;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.swing.JOptionPane;

import igu.ModeloNoEditable;

public class Catalog {

	private ArrayList<Cruise> cruises;
	private ArrayList<Ship> ships;
	private ArrayList<Extra> extras;
	public static final double descuento = 0.15;
	private ArrayList<String> zonas;
	private Locale localizacion;
	public final static File cruisesFile = new File("data/cruises.dat");
	public final static File shipsFile = new File("data/ships.dat");
	public final static File extrasFile = new File("data/extras.dat");
	public final static String cruisesCompleted = "data/booked.dat";

	public Catalog(Locale localizacion) throws IOException {
		this.localizacion = localizacion;
		cruises = new ArrayList<>();
		ships = new ArrayList<>();
		zonas = new ArrayList<>();
		try {
			extras = new ArrayList<>();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		start();
	}

	public void start() throws IOException {
		readShips(shipsFile);
		readCruises(cruisesFile);
		readExtras(extrasFile);
		readCruisesCompleted(cruisesCompleted);
	}

	private void readShips(File file) throws IOException {
		CatalogReader reader = new CatalogReader(file);
		for (int index = 0; index < reader.getFileSize(); index++) {
			String[] tokens = reader.processLine(index);

			String codigoBarco = tokens[0];
			String denominacion = tokens[1];
			String descripcion = tokens[2];
			long camDobInt = Long.parseLong(tokens[3]);
			long camDobExt = Long.parseLong(tokens[4]);
			long camFamInt = Long.parseLong(tokens[5]);
			long camFamExt = Long.parseLong(tokens[6]);
			double precioCamDobInt = Double.parseDouble(tokens[7]);
			double precioCamDobExt = Double.parseDouble(tokens[8]);
			double precioCamFamInt = Double.parseDouble(tokens[9]);
			double precioCamFamExt = Double.parseDouble(tokens[10]);
			Ship barco = new Ship(codigoBarco, denominacion, descripcion, camDobInt, camDobExt, camFamInt, camFamExt,
					precioCamDobInt, precioCamDobExt, precioCamFamInt, precioCamFamExt);
			ships.add(barco);
		}
	}

	private void readCruises(File file) throws IOException {
		CatalogReader reader = new CatalogReader(file);
		for (int index = 0; index < reader.getFileSize(); index++) {
			String[] tokens = reader.processLine(index);
			String codigoCrucero = tokens[0];
			String zona = tokens[1];
			if (!zonas.contains(zona)) {
				zonas.add(zona);
			}
			String denominacion = tokens[2];
			String puertoSalida = tokens[3];
			String itinerario = tokens[4];
			String descripcion = tokens[5];
			boolean aptoMenores;
			if (tokens[6] == "S") {
				aptoMenores = Cruise.UNDER16;
			} else {
				aptoMenores = Cruise.NOTUNDER16;
			}
			int duration = Integer.parseInt(tokens[7]);
			DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT, localizacion);
			String[] fechasString = tokens[8].split("%");
			String [][] reservas= new String[fechasString.length][6];
			Date[] fechasSalida= new Date[fechasString.length];
			for (int i=0; i<fechasString.length;i++){
				try{
					fechasSalida[i]=formato.parse(fechasString[i]);
					reservas[i][0]=codigoCrucero;
					reservas[i][1]=formato.format(fechasSalida[i]);
					reservas[i][2]="0";
					reservas[i][3]="0";
					reservas[i][4]="0";
					reservas[i][5]="0";
				} catch (ParseException e) {
					System.out.print("Date format error " + e);
				}
			}
			String codigoBarco = tokens[9];
			Ship barco = findBarco(codigoBarco);
			Cruise crucero = new Cruise(codigoCrucero, zona, denominacion, puertoSalida, itinerario, descripcion,
					aptoMenores, duration, fechasSalida, barco, reservas);
			if (crucero.getBarco().toString() == null) {
				//System.out.print("The cruise " + crucero+ " has not a ship available");
				//JOptionPane.showMessageDialog(null, "The cruise " + crucero + " has not a ship available");
			} else {
				cruises.add(crucero);
			}

		}
	}

	private void readExtras(File file) throws IOException {
		CatalogReader reader = new CatalogReader(file);
		for (int index = 0; index < reader.getFileSize(); index++) {
			String[] tokens = reader.processLine(index);
			String codigoExtra = tokens[0];
			String denominacion = tokens[1];
			double precio = Double.parseDouble(tokens[2]);
			Extra extra = new Extra(codigoExtra, denominacion, precio);
			extras.add(extra);
		}
	}
	private void readCruisesCompleted(String filename) throws IOException{
		File file=new File(filename);
		if (file.exists()){
			CatalogReader reader = new CatalogReader(file);
			DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT, localizacion);
			for (int index = 0; index < reader.getFileSize(); index++) {
				String[] tokens= reader.processLine(index);
				String codigoCrucero = tokens[0];
				String date=tokens[1];
				String camDobInt=(tokens[2]);
				String camDobExt=(tokens[3]);
				String camFamInt=(tokens[4]);
				String camFamExt=(tokens[5]);
				getCruiseByCode(codigoCrucero).addReserva(tokens);
			}
		}
		else{
			System.out.println("No cruises have been booked yet");
		}
	}

	private Ship findBarco(String codigoBarco) {
		for (Ship barco : ships) {
			if (barco.getCodigoBarco().equals(codigoBarco)) {
				return barco;
			}
			;
		}
		Ship barco = new Ship(codigoBarco);
		ships.add(barco);
		return barco;
	}

	public Cruise getCruise(String name) {
		for (Cruise c : cruises) {
			if (name == c.getDenominacion()) {
				return c;
			}
		}
		return null;

	}
	
	public Cruise getCruiseByCode(String code){
		for (Cruise c: cruises){
			if (code.equals(c.getCodigoCrucero())){
				return c;
			}
		}
		return null;
	}

	public Cruise[] selectDescuento() {
		Random random = new Random();
		int rand1 = random.nextInt(cruises.size());
		int rand2 = random.nextInt(cruises.size());
		while (rand1 == rand2) {
			rand2 = random.nextInt(cruises.size());
		}
		int[] pos = { rand1, rand2 };
		Cruise[] cruisesDescuento = new Cruise[2];
		for (int i = 0; i < cruises.size(); i++) {
			if (i == pos[0]) {
				cruises.get(i).setDescuento(true);
				cruisesDescuento[0] = cruises.get(i);
			}
			if (i == pos[1]) {
				cruises.get(i).setDescuento(true);
				cruisesDescuento[1] = cruises.get(i);
			}
		}
		return cruisesDescuento;
	}

	public ArrayList<String> getZonas() {
		return zonas;
	}

	public ModeloNoEditable searchZonaDate(String start, String end, String zona, ModeloNoEditable modeloTabla)
			throws ParseException {
		DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT, localizacion);
		Date inicial = new Date(0);
		Date fin = new Date(Long.MAX_VALUE);
		if (start.equals("")) {
			inicial = new Date(0);
		} else {
			inicial = formato.parse(start);
		}
		if (end.equals("")) {
			fin = new Date(Long.MAX_VALUE);
		} else {
			fin = formato.parse(end);
		}
		Object[] nuevaFila = new Object[6];
		for (Cruise c : cruises) {
			if (c.getZona().equals(zona)) {
				for (Date fecha : c.getFechasSalida()) {
					if (fecha.after(inicial) && fecha.before(fin)) {
						nuevaFila[0] = c.getDenominacion();
						nuevaFila[1] = c.getPuertoSalida();
						nuevaFila[2] = c.getDuration();
						nuevaFila[3] = c.getItinerario();
						nuevaFila[4] = formato.format(fecha);
						nuevaFila[5] = c.getCodigoCrucero();
						modeloTabla.addRow(nuevaFila);
					}
				}
			}
		}
		return modeloTabla;
	}

	public Date parseDate(String fecha) {
		DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT, localizacion);
		try {
			return formato.parse(fecha);
		} catch (ParseException e) {
			System.out.println("Error in data format " + e);
		}
		return null;
	}

	public Extra[] getExtras() {
		return extras.toArray(new Extra[extras.size()]);
	}

}
