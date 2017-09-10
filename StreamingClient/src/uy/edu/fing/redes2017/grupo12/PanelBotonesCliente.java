package uy.edu.fing.redes2017.grupo12;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBotonesCliente extends JPanel {
	
	private static final long serialVersionUID = -5666017896171978022L;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private InterfazClientePrincipal principal;

	public PanelBotonesCliente() {
		setLayout(new GridLayout(2, 3, 5, 5));
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		add(label_3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.iniciar();
				principal.dispose();
			}
		});
		add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.dispose();
			}
		});
		add(btnCancelar);

	}
	
	public PanelBotonesCliente(InterfazClientePrincipal principal) {
		this();	//Constructor por defecto.
		this.principal = principal;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
