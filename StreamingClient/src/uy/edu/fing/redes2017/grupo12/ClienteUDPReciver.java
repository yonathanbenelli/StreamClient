package uy.edu.fing.redes2017.grupo12;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;


public class ClienteUDPReciver  extends Thread{
    

	DatagramSocket socketCliente;
	InetAddress dirSer ;
	 int puerto ;
	 ClienteUDPManager cudpm;
		DisplayFrameJFrame jframe;
	public ClienteUDPReciver(DatagramSocket s,InetAddress h, int p, ClienteUDPManager cudpm)
	{

		this.socketCliente=s;
		this.dirSer=h;
		this.puerto=p;
		this.cudpm=cudpm;
	}



	@Override
	public void run() {		
				
        	
		
		while (true)
		{
	
			DatagramPacket pr= new DatagramPacket(new byte[65000], 65000);
			try {
				socketCliente.receive(pr);
				
				int length = pr.getLength();     // read length of incoming message
				if(length>0) {
				    byte[] recived = pr.getData();

				    DataInputStream di= new DataInputStream(new ByteArrayInputStream(recived));
				    Long nump=di.readLong();
				    
				    byte[] message = new byte[65000];
				    di.read(message);
					    cudpm.packPend.put(nump,message);
				    
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}		
		//socketCliente.close();


		// TODO Auto-generated method stub
			}
	
	
	 
	 
	
}
