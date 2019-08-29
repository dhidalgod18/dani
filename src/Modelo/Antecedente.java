package Modelo;

public class Antecedente {
	private int edad;
	private String descripcion;
	private String tipoAntecedente;

	public Antecedente(int edad, String descripcion, String tipoAntecedente) {
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoAntecedente = tipoAntecedente;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoAntecedente() {
		return tipoAntecedente;
	}

	public void setTipoAntecedente(String tipoAntecedente) {
		this.tipoAntecedente = tipoAntecedente;
	}
}

