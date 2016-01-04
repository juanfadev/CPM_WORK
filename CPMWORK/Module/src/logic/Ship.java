package logic;

public class Ship {

	private String codigoBarco;
	private String denominacion;
	private String descripcion;
	private long camDobInt;
	private long camDobExt;
	private long camFamInt;
	private long camFamExt;
	private double precioCamDobInt;
	private double precioCamDobExt;
	private double precioCamFamInt;
	private double precioCamFamExt;
	private String imgRoute;

	public String getCodigoBarco() {
		return codigoBarco;
	}

	public void setCodigoBarco(String codigoBarco) {
		this.codigoBarco = codigoBarco;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public double getPrecioCamDobInt() {
		return precioCamDobInt;
	}

	public void setPrecioCamDobInt(double precioCamDobInt) {
		this.precioCamDobInt = precioCamDobInt;
	}

	public double getPrecioCamDobExt() {
		return precioCamDobExt;
	}

	public void setPrecioCamDobExt(double precioCamDobExt) {
		this.precioCamDobExt = precioCamDobExt;
	}

	public double getPrecioCamFamInt() {
		return precioCamFamInt;
	}

	public void setPrecioCamFamInt(double precioCamFamInt) {
		this.precioCamFamInt = precioCamFamInt;
	}

	public double getPrecioCamFamExt() {
		return precioCamFamExt;
	}

	public void setPrecioCamFamExt(double precioCamFamExt) {
		this.precioCamFamExt = precioCamFamExt;
	}

	public Ship(String codigoBarco, String denominacion, String descripcion, long camDobInt, long camDobExt,
			long camFamInt, long camFamExt, double precioCamDobInt, double precioCamDobExt, double precioCamFamInt,
			double precioCamFamExt) {
		super();
		this.codigoBarco = codigoBarco;
		this.denominacion = denominacion;
		this.descripcion = descripcion;
		this.camDobInt = camDobInt;
		this.camDobExt = camDobExt;
		this.camFamInt = camFamInt;
		this.camFamExt = camFamExt;
		this.precioCamDobInt = precioCamDobInt;
		this.precioCamDobExt = precioCamDobExt;
		this.precioCamFamInt = precioCamFamInt;
		this.precioCamFamExt = precioCamFamExt;
		imgRoute="/img/"+codigoBarco+".jpg";
	}

	public Ship (String codigoBarco){
		super();
		this.codigoBarco=codigoBarco;
		imgRoute="/img/"+codigoBarco+"/";
		/*this.denominacion = null;
		this.descripcion = null;
		this.numeroCamarotes = 0;
		this.precioCamarotes = 0;*/
	}

	public String getImgRoute() {
		return imgRoute;
	}

	public double precioCamarotes(long camDobInt, long camDobExt,
			long camFamInt, long camFamExt){
		return camDobInt*precioCamDobInt + camDobExt*precioCamDobExt + camFamInt*precioCamFamInt + camFamExt*precioCamFamExt;
	}
	
	@Override
	public String toString(){
		return denominacion;
	}
}
