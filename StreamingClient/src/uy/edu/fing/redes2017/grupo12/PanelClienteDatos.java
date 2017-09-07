package uy.edu.fing.redes2017.grupo12;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClienteDatos extends JPanel {

	private static final long serialVersionUID = 2864132310961409436L;
	private JTextField tfPuerto;
	private JRadioButton rdbtnUDP;
	private JRadioButton rdbtnTCP;
	private JFormattedTextField ftIP;

	public PanelClienteDatos() {
		setLayout(new GridLayout(6, 3, 5, 5));
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel lblBienvenidoAlServidor = new JLabel("Bienvenido al cliente de streaming");
		add(lblBienvenidoAlServidor);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		add(label_3);
		
		JLabel label_5 = new JLabel("");
		add(label_5);
		
		JLabel lblIngreseLaDireccin = new JLabel("Ingrese la dirección IP del servidor");
		add(lblIngreseLaDireccin);
		
		JLabel label_6 = new JLabel("");
		add(label_6);
		
		try {
		    MaskFormatter mf = new MaskFormatter("###.###.###.###");
			ftIP = new JFormattedTextField(mf);
		    add(ftIP);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		JLabel lblIngreseElNmero = new JLabel("Ingrese el número de puerto del servidor");
		add(lblIngreseElNmero);
		
		JLabel label_7 = new JLabel("");
		add(label_7);
		
		tfPuerto = new JTextField();
		add(tfPuerto);
		tfPuerto.setColumns(10);
		
		JLabel lblSeleccioneUnTipo = new JLabel("Seleccione un tipo de conexión");
		add(lblSeleccioneUnTipo);
		
		JLabel label_8 = new JLabel("");
		add(label_8);
		
		rdbtnUDP = new JRadioButton("UDP");
		rdbtnUDP.setSelected(false);
		rdbtnUDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTCP.setSelected(false);
			}
		});
		add(rdbtnUDP);
		
		JLabel label_9 = new JLabel("");
		add(label_9);
		
		JLabel label_10 = new JLabel("");
		add(label_10);
		
		rdbtnTCP = new JRadioButton("TCP");
		rdbtnTCP.setSelected(false);
		rdbtnTCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnUDP.setSelected(false);
			}
		});
		add(rdbtnTCP);

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
	
	public JFormattedTextField getFtIP() {
		return ftIP;
	}
	
}
