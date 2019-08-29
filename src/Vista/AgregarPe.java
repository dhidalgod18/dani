package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controlador.Controlador;

public class AgregarPe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNombre;
	private JTextField campoCedula;
	private JTextField campoEdad;
	private JTextField Genero;
	private JButton agregar;

	Controlador c1 ;

	/**
	 * @throws Exception 
	 * 
	 */
	public AgregarPe() throws Exception {
		 c1 = new Controlador();

		setTitle("Agregar persona");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 329, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(false);

		JLabel lblAntecedentesFinancieros = new JLabel("Antecedentes Financieros");
		lblAntecedentesFinancieros.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 15));
		lblAntecedentesFinancieros.setBounds(10, 11, 194, 32);
		contentPane.add(lblAntecedentesFinancieros);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 41, 194, 2);
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(0, 0, 313, 448);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 70, 70, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		campoNombre = new JTextField();
		campoNombre.setBounds(90, 71, 164, 23);
		panel.add(campoNombre);
		campoNombre.setColumns(10);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 104, 70, 23);
		panel.add(lblEdad);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 159, 70, 23);
		panel.add(lblCedula);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 13));

		campoEdad = new JTextField();
		campoEdad.setBounds(90, 105, 89, 23);
		panel.add(campoEdad);
		campoEdad.setColumns(10);

		campoCedula = new JTextField();
		campoCedula.setBounds(90, 161, 164, 21);
		panel.add(campoCedula);
		campoCedula.setColumns(10);

		agregar = new JButton("Aceptar");
		agregar.setBounds(112, 401, 89, 23);
		agregar.setActionCommand("ACEPTAR");
		panel.add(agregar);
		agregar.addActionListener(this);

		JButton eliminarA = new JButton("Eliminar Antecedente");
		eliminarA.setBounds(90, 367, 138, 23);
		panel.add(eliminarA);

		JButton agregarA = new JButton("Agregar Antecedente");
		agregarA.setBounds(90, 333, 137, 23);
		panel.add(agregarA);

		JList list = new JList();
		list.setBounds(90, 208, 139, 114);
		panel.add(list);
		list.setFont(new Font("Tahoma", Font.BOLD, 11));
		list.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(10, 132, 70, 23);
		panel.add(lblSexo);

		Genero = new JTextField();
		Genero.setBounds(90, 134, 89, 20);
		panel.add(Genero);
		Genero.setColumns(10);

		agregar.addActionListener(this);

	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals("ACEPTAR")) {
			if (campoNombre.getText().isEmpty() || campoEdad.getText().isEmpty() || campoCedula.getText().isEmpty()
					|| Genero.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Debes agregar todos los valores solicitados para agregar un nuevo empleado",
						"Mensaje de Sistema", JOptionPane.ERROR_MESSAGE);
			} else {
				c1.agregarPersona(campoNombre.getText(), Integer.parseInt(campoEdad.getText()), Genero.getText(),
						campoCedula.getText());
				setVisible(false);
			}
		}
	}
}

	
	


