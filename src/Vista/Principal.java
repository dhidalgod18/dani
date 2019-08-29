package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controlador.Controlador;

public class Principal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton AgregarP;
	private JButton EliminarP;
	private JButton buscarP;
	private  JList<String> listaPersonas;
	private JPanel panel;

	DefaultListModel<String> model;
	AgregarPe a1;
	Controlador c1;

	public Principal() throws Exception {

		a1 = new AgregarPe();
		listaPersonas = new JList<String>();
		model = new DefaultListModel<String>();

	/*	for (int i = 0; i < c1.getRegistradas().size(); i++) {
			model.addElement(c1.getRegistradas().get(i).getNombre().toUpperCase() + " - edad:( "
					+ c1.getRegistradas().get(i).getEdad() + c1.getRegistradas().get(i).getCedula() + " )");
		}
		listaPersonas.setModel(model);*/

		//setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/logo bosque.png")));
		setTitle("Principal page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);

		panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(0, 0, 420, 335);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAntecedentesFinancieros = new JLabel("Antecedentes financieros");
		lblAntecedentesFinancieros.setBounds(10, 11, 230, 39);
		panel.add(lblAntecedentesFinancieros);
		lblAntecedentesFinancieros.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 18));

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 224, 2);
		panel.add(separator);

		JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/images/logo bosque.png")));
		//lblNewLabel.setBounds(286, 48, 111, 99);
		panel.add(lblNewLabel);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));

		AgregarP = new JButton("Agregar Persona");
		AgregarP.setBounds(276, 186, 121, 31);
		AgregarP.setActionCommand("AGREGAR");
		AgregarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		AgregarP.addActionListener(this);
		panel.add(AgregarP);

		EliminarP = new JButton("Eliminar Persona");
		EliminarP.setBounds(276, 228, 121, 31);
		EliminarP.setActionCommand("ELIMINAR");
		panel.add(EliminarP);
		EliminarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		EliminarP.addActionListener(this);

		buscarP = new JButton("Buscar Persona");
		buscarP.setBounds(276, 270, 121, 31);
		buscarP.setActionCommand("BUSCAR");
		panel.add(buscarP);
		buscarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buscarP.addActionListener(this);

		listaPersonas = new JList();
		listaPersonas.setBounds(23, 101, 197, 200);
		panel.add(listaPersonas);
		listaPersonas.setBorder(new LineBorder(new Color(0, 0, 0)));

	}

	public JList<String> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(JList<String> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if (comando.equals("AGREGAR")) {
			a1.setVisible(true);

		}

		if (comando.equals("ELIMINAR")) {
			String cedula = JOptionPane.showInputDialog("Escribe la cedula de la persona que quieres eliminar: ");

			if (c1.buscaPersona(cedula) != null) {
				c1.eliminarPersona(cedula);

				System.out.println(c1.getRegistradas().size());

			} else {
				JOptionPane.showMessageDialog(null,
						"La persona con el documento: " + cedula + " NO existe en el sistema");
			}

		}
		if (comando.equals("BUSCAR")) {
			String cedula = JOptionPane.showInputDialog("Escribe la cedula de la persona que quieres buscar: ");
			if (c1.buscaPersona(cedula) != null) {
				JOptionPane.showMessageDialog(null, "");
			} else {
				JOptionPane.showMessageDialog(null,
						"La persona con el documento: " + cedula + " no se encuentra registrada ",
						"Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (comando.equals("VER")) {
			if (c1.getRegistradas().size() > 0) {
				c1.verPersonas();
			} else {
				JOptionPane.showMessageDialog(null, "No hay personas ingresadas por el momento", "mensaje de sistema",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		try {
			Principal p1 = new Principal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
