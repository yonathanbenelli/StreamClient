package uy.edu.fing.redes2017.grupo12;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;


public class Cliente   {
    

	static String host =null;
	static int puerto=0;
	static JFrame frame;
	
	public  static void main(String[] args) throws Exception  {
		
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
		if (args.length == 2) {
			host = args[0];
			puerto = new Integer(args[1]);
		} else if (args.length == 1) {
			puerto = new Integer(args[0]);
		}
		JPanel contentPane;
		
		frame = new JFrame("Streaming");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 650, 490);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    JButton buttonU = new JButton("UDP");
	    JButton buttonT = new JButton("TCP");
	    buttonU.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) { 
	        	try {
					clienteUDP();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } 
	    });
	    buttonT.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) { 
	        	try {
					clienteTCP();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } 
	    });
	    frame.setContentPane(contentPane);
	    frame.getContentPane().add(buttonT);
	    frame.getContentPane().add(buttonU);
	    
	    frame.setVisible(true);   
	    
/*ClienteTCPManager ctcp=new ClienteTCPManager(host, puerto);
ctcp.start();
*/

		//socketCliente.close();
	}
	
	 
	public static void clienteTCP() throws Exception{
		
       	//Primera pasada del timer.
		
		if(host==null)
    		host = "localhost";
    	if(puerto==0)
    		puerto =6789;

    	ClienteTCPManager ctcp= new ClienteTCPManager(host, puerto);
    	ctcp.start();
    	frame.dispose();
        
		//Definicion timer.
    	
		
	   
	     
	    
		
	}
	
	public static void clienteUDP() throws Exception{
		
		if(host==null)
			host = "localhost";
		if(puerto==0)
			puerto =  9876;

		ClienteUDPManager cudp=new ClienteUDPManager(host, puerto);
		cudp.start();
		frame.dispose();
		
	
	}
	 
}
