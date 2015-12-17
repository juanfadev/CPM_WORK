package logic;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Catalog {

	private ArrayList<Cruise> cruises;
	private ArrayList<Ship> ships;
	private ArrayList<Extra> extras;

	public Catalog() {
		cruises = new ArrayList<>();
		ships = new ArrayList<>();
		extras = new ArrayList<>();
	}

	public static void main(String[] args) {

	}

	public void start() throws IOException {
		File cruises = new File("/Module/data/cruises.dat");
		File ships = new File("/Module/data/ships.dat");
		File extras = new File("/Module/data/extras.dat");
		readShips(ships);
		readCruises(cruises);
		readExtras(extras);
	}

	private void readShips(File file) throws IOException {
		CatalogReader reader = new CatalogReader(file);
		for (int index = 0; index < reader.getFileSize(); index++) {
			String[] tokens = reader.processLine(index);

			String codigoBarco = tokens[0];
			String denominacion = tokens[1];
			String descripcion = tokens[2];
			long camDobInt=Long.parseLong(tokens[3]);
			long camDobExt=Long.parseLong(tokens[4]);
			long camFamInt=Long.parseLong(tokens[5]);
			long camFamExt=Long.parseLong(tokens[6]);
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
			String[] fechasSalida = tokens[8].split("%");
			String codigoBarco = tokens[9];
			Ship barco = findBarco(codigoBarco);
			Cruise crucero = new Cruise(codigoCrucero, zona, denominacion, puertoSalida, itinerario, descripcion,
					aptoMenores, duration, fechasSalida, barco);

			cruises.add(crucero);
		}
	}
	
	private void readExtras(File file) throws IOException{
		CatalogReader reader = new CatalogReader(file);
		for (int index = 0; index < reader.getFileSize(); index++) {
			String[] tokens = reader.processLine(index);
			String codigoExtra = tokens[0];
			String denominacion= tokens[1];
			double precio = Double.parseDouble(tokens[2]);
			Extra extra = new Extra(codigoExtra, denominacion, precio);
			extras.add(extra);
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

}