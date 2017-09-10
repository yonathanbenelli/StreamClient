package uy.edu.fing.redes2017.grupo12;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClienteDatos extends JPanel {

	private static final long serialVersionUID = 2864132310961409436L;
	private JRadioButton rdbtnUDP;
	private JRadioButton rdbtnTCP;
	private JTextField tfServidor;
	private JTextField tfPuerto;

	public PanelClienteDatos() {
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 2, 296, 78);
		add(label);
		
		JLabel lblBienvenidoAlServidor = new JLabel("Bienvenido al cliente de streaming");
		lblBienvenidoAlServidor.setBounds(301, 2, 296, 78);
		add(lblBienvenidoAlServidor);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(602, 2, 296, 78);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 85, 296, 78);
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(301, 85, 296, 78);
		add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(602, 85, 296, 78);
		add(label_5);
		
		JLabel lblServidor = new JLabel("Ingrese el nombre de dominio o la ip del servidor:");
		lblServidor.setBounds(0, 168, 466, 78);
		add(lblServidor);
		
		tfServidor = new JTextField();
		tfServidor.setBounds(602, 168, 296, 78);
		add(tfServidor);
		tfServidor.setColumns(10);
		
		JLabel lblSeleccioneUnTipo = new JLabel("Seleccione un tipo de conexión");
		lblSeleccioneUnTipo.setBounds(0, 251, 296, 78);
		add(lblSeleccioneUnTipo);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(301, 251, 296, 78);
		add(label_8);
		
		rdbtnUDP = new JRadioButton("UDP");
		rdbtnUDP.setBounds(602, 251, 296, 78);
		rdbtnUDP.setSelected(false);
		rdbtnUDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTCP.setSelected(false);
				tfPuerto.setText("9876");
			}
		});
		add(rdbtnUDP);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(0, 334, 296, 78);
		add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(301, 334, 296, 78);
		add(label_10);
		
		rdbtnTCP = new JRadioButton("TCP");
		rdbtnTCP.setBounds(602, 334, 296, 78);
		rdbtnTCP.setSelected(false);
		rdbtnTCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnUDP.setSelected(false);
				tfPuerto.setText("6789");
			}
		});
		add(rdbtnTCP);
		
		JLabel label_6 = new JLabel("Ingrese el número de puerto del servidor");
		label_6.setBounds(0, 417, 296, 78);
		add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(301, 417, 296, 78);
		add(label_7);
		
		tfPuerto = new JTextField();
		tfPuerto.setBounds(602, 417, 296, 78);
		tfPuerto.setColumns(10);
		add(tfPuerto);

	}

	public JRadioButton getRdbtnUDP() {
		return rdbtnUDP;
	}
	
	public JRadioButton getRdbtnTCP() {
		return rdbtnTCP;
	}
	
	public JTextField getTfPuerto() {
		return tfPuerto;
	}
	
	public JTextField getTfServidor() {
		return tfServidor;
	}
}
