package uy.edu.fing.redes2017.grupo12;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;


public class Cliente extends JFrame  {
    
	private static final long serialVersionUID = 3167419079621291526L;
	private String host;
	private int puerto;
	private static JFrame frameVideo;
	
	public Cliente(int puerto, String host){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.puerto = puerto;
		this.host = host;
	
	}
	
	public void arranca() throws Exception  {
		
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
		JPanel contentPane;
		frameVideo = new JFrame("Streaming");
		frameVideo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameVideo.setBounds(100, 100, 650, 490);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    frameVideo.setContentPane(contentPane);
	    frameVideo.setVisible(true);
	    
	}
	 
	public void clienteTCP() throws Exception {
				
    	ClienteTCPManager ctcp = new ClienteTCPManager(host, puerto);
    	ctcp.start();
    	frameVideo.dispose(); 
		
	}
	
	public void clienteUDP() throws Exception{
		
		ClienteUDPManager cudp=new ClienteUDPManager(host, puerto);
		cudp.start();
		frameVideo.dispose();
		
	}
	 
}