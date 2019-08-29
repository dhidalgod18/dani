package Modelo;

public class Persona {
	private String nombre;
	private int edad;
	private String cedula;
	private String genero;

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param cedula
	 * @param genero
	 */
	public Persona(String nombre, int edad, String cedula, String genero) {
		this.nombre = nombre;
		this.edad = edad;
		this.cedula = cedula;
		this.genero = genero;
	}

	/**
	 * 
	 * @return
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * 
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * 
	 * @return
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * 
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * 
	 * @return
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * 
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", cedula=" + cedula + ", genero=" + genero + "]";
	}
}

