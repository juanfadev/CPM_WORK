package logic;

public class Extra {

	private String codigoExtra;
	private String denominacion;
	private double precio;
	
	public String getCodigoExtra() {
		return codigoExtra;
	}
	public void setCodigoExtra(String codigoExtra) {
		this.codigoExtra = codigoExtra;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Extra(String codigoExtra, String denominacion, double precio) {
		super();
		this.codigoExtra = codigoExtra;
		this.denominacion = denominacion;
		this.precio = precio;
	}
	
	
}
