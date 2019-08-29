package Controlador;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Persona;
import Vista.Principal;

public class Controlador {
	
  
	
	private ArrayList<Persona> registradas;

	/**
	 * @throws Exception 
	 * 
	 */
	public Controlador() throws Exception {
		 

		registradas = new ArrayList<Persona>();
		System.out.println("Iniciando programa...");
	}

	/**
	 * 
	 * @return
	 */

	public ArrayList<Persona> getRegistradas() {
		return registradas;
	}

	public void verPersonas() {
		String texto = "";
		for (int i = 0; i < registradas.size(); i++) {
			texto = texto.concat(registradas.get(i).toString() + "\n");
		}

		System.out.println(texto);
		JOptionPane.showMessageDialog(null, texto, "Personas", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * 
	 * @param cedula
	 * @return
	 */
	public Persona buscaPersona(String cedula) {
		Persona encontrada = null;
		try {

			if (!registradas.isEmpty()) {
				System.out.println(registradas);
				for (int i = 0; i < registradas.size(); i++) {
					if (registradas.get(i).getCedula().equals(cedula)) {
						encontrada = registradas.get(i);
						System.out.println(encontrada);
//						JOptionPane.showMessageDialog(null, "" + encontrada);
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return encontrada;
	}

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param genero
	 * @param cedula
	 * @return
	 */
	public boolean agregarPersona(String nombre, int edad, String genero, String cedula) {

		Persona nuevo = new Persona(nombre, edad, cedula, genero);
		boolean resp = false;

		if (buscaPersona(cedula) == null) {
			registradas.add(nuevo);
			JOptionPane.showMessageDialog(null, "Se ha registrado el usuario identifacado con el documento: " + cedula,
					" Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(nuevo);
			resp = true;

		}
		if (buscaPersona(cedula) != null) {
			JOptionPane.showMessageDialog(null,
					"El usuario identifacado con el documento: " + cedula + " ya se encuentra agregado",
					" Operacion Denegada", JOptionPane.ERROR_MESSAGE);
			System.out.println("existe");
			resp = false;
		}

		System.out.println("retornar");
		return resp;
	}

	/**
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean eliminarPersona(String cedula) {
		Persona p = buscaPersona(cedula);

		try {
			if (p != null) {
				registradas.remove(p);
				JOptionPane.showMessageDialog(null, "Operacion Exitosa",
						"Se ha eliminado el usuario identifacado con el documento: " + cedula,
						JOptionPane.INFORMATION_MESSAGE);

				return true;
			}
			JOptionPane.showMessageDialog(null, "Operacion Denegada",
					"El empleado con cedula: " + cedula + " NO existe para poder ser eliminado",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void Pasar() throws Exception {
		Principal pin=new Principal();
		pin.getListaPersonas();
	}


}
