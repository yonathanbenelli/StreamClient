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
	private JTextField tfNombreDominio;
	private JRadioButton rdbtnNombreDeDominio;
	private JRadioButton rdbtnDireccinIp;

	public PanelClienteDatos() {
		setLayout(new GridLayout(9, 3, 5, 5));
		
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
		
		JLabel lblServidor = new JLabel("Servidor:");
		add(lblServidor);
		
		JLabel label_4 = new JLabel("");
		add(label_4);
		
		rdbtnNombreDeDominio = new JRadioButton("Nombre de dominio");
		rdbtnNombreDeDominio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNombreDeDominio.isSelected()){
					rdbtnDireccinIp.setSelected(false);
					tfNombreDominio.setEditable(true);
					ftIP.setEditable(false);
				} else{
					rdbtnNombreDeDominio.setSelected(false);
					tfNombreDominio.setEditable(false);
					ftIP.setEditable(true);
				}
			}
		});
		add(rdbtnNombreDeDominio);
		
		JLabel label_11 = new JLabel("");
		add(label_11);
		
		JLabel label_12 = new JLabel("");
		add(label_12);
		
		rdbtnDireccinIp = new JRadioButton("Dirección IP");
		rdbtnDireccinIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDireccinIp.isSelected()){
					rdbtnNombreDeDominio.setSelected(false);
					tfNombreDominio.setEditable(false);
					ftIP.setEditable(true);
				} else {
					rdbtnNombreDeDominio.setSelected(false);
					tfNombreDominio.setEditable(false);
					ftIP.setEditable(true);
				}
			}
		});
		add(rdbtnDireccinIp);
		
		JLabel lblNombreDeDominio = new JLabel("Nombre de dominio");
		add(lblNombreDeDominio);
		
		JLabel label_14 = new JLabel("");
		add(label_14);
		
		tfNombreDominio = new JTextField();
		tfNombreDominio.setEditable(false);
		add(tfNombreDominio);
		tfNombreDominio.setColumns(10);
		
		JLabel lblIngreseLaDireccin = new JLabel("Ingrese la dirección IP del servidor");
		add(lblIngreseLaDireccin);
		
		JLabel label_6 = new JLabel("");
		add(label_6);
		
		try {
		    MaskFormatter mf = new MaskFormatter("###.###.###.###");
			ftIP = new JFormattedTextField(mf);
			ftIP.setEditable(false);
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
				tfPuerto.setText("8086");
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
				tfPuerto.setText("8085");
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
	
	public JRadioButton getRdbtnNombreDeDominio() {
		return rdbtnNombreDeDominio;
	}
	public JRadioButton getRdbtnDireccinIp() {
		return rdbtnDireccinIp;
	}
	public JTextField getTfNombreDominio() {
		return tfNombreDominio;
	}
}
