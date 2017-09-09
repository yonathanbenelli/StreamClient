package uy.edu.fing.redes2017.grupo12;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.excepcionDebeSeleccionar;
import excepciones.excepcionNoEsIP;
import excepciones.excepcionNoEsPuerto;
import excepciones.excepcionNoSeleccionoConexion;
import excepciones.excepcionNombreDominioVacio;

public class InterfazClientePrincipal extends JFrame {

	private static final long serialVersionUID = -6127618218696136228L;
	private JPanel contentPane;
	private PanelClienteDatos panelClienteDatos;
	private PanelBotonesCliente panelBotonesCliente;
	private Cliente cliente;
	public InterfazClientePrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelClienteDatos = new PanelClienteDatos();
		contentPane.add(panelClienteDatos, BorderLayout.CENTER);
		
		panelBotonesCliente = new PanelBotonesCliente(this);
		contentPane.add(panelBotonesCliente, BorderLayout.SOUTH);
	}

	public PanelClienteDatos getPanelClienteDatos() {
		return panelClienteDatos;
	}
	
	public PanelBotonesCliente getPanelBotonesCliente() {
		return panelBotonesCliente;
	}

	public void iniciar() {
		
		try{
			
			String ip = panelClienteDatos.getFtIP().getText();
			String dominio = panelClienteDatos.getTfNombreDominio().getText();
			
			if (ip.equals("") && dominio.equals(""))
				throw new excepcionDebeSeleccionar();
			
			if (panelClienteDatos.getRdbtnNombreDeDominio().isSelected() && dominio.equals(""))
				throw new excepcionNombreDominioVacio();
			
			if (panelClienteDatos.getRdbtnDireccinIp().isSelected() && ip.equals(""))
				throw new excepcionNoEsIP();
			
			if (!panelClienteDatos.getRdbtnDireccinIp().isSelected() && !panelClienteDatos.getRdbtnNombreDeDominio().isSelected())
				throw new excepcionDebeSeleccionar();
			
			if (panelClienteDatos.getRdbtnDireccinIp().isSelected()){
				
				String[] partesIP = new String[4];
				partesIP = ip.split("\\.");
				int primero = Integer.parseInt(partesIP[0]);
				int segundo = Integer.parseInt(partesIP[1]);
				int tercero = Integer.parseInt(partesIP[2]);
				int cuarto = Integer.parseInt(partesIP[3]);
				if  (!((0 <= primero) && (primero <= 255) && (0 <= segundo) && (segundo <= 255) && (0 <= tercero) && (tercero <= 255) && (0 <= cuarto) && (cuarto <= 255)))
					throw new excepcionNoEsIP();
				
			}
			
			String puerto = panelClienteDatos.getTfPuerto().getText();
			int p = Integer.parseInt(puerto);
			if ( !((0 <= p) && (p <= 65535)) )
				throw new excepcionNoEsPuerto();
		
			if ((!panelClienteDatos.getRdbtnTCP().isSelected()) && (!panelClienteDatos.getRdbtnUDP().isSelected()))
				throw new excepcionNoSeleccionoConexion();
			
			//Si pasa los chequeos creamos la instancia del Cliente.
			
			if (panelClienteDatos.getRdbtnNombreDeDominio().isSelected())
				cliente = new Cliente(p,dominio);
			else if (panelClienteDatos.getRdbtnDireccinIp().isSelected())
				cliente = new Cliente(p,ip);
			
		    cliente.arranca();
		    
		    if (panelClienteDatos.getRdbtnUDP().isSelected())
		    	cliente.clienteUDP();
		    else if (panelClienteDatos.getRdbtnTCP().isSelected())
		    	cliente.clienteTCP();
		    		
		} catch (excepcionNoEsIP | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "No ingresó una dirección IP válida", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (excepcionNoEsPuerto e){
			JOptionPane.showMessageDialog(null, "No ingresó un número de puerto válido.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (excepcionNoSeleccionoConexion e) {
			JOptionPane.showMessageDialog(null, "No selecciono ningún tipo de conexión.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (excepcionDebeSeleccionar e) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar nombre de dominio o dirección ip.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (excepcionNombreDominioVacio e) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar nombre de dominio o dirección ip.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
