package uy.edu.fing.redes2017.grupo12;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;


public class ClienteUDPSender extends Thread {
    

	DatagramSocket socketCliente;
	InetAddress dirSer ;
	int puerto ;
	ClienteUDPManager cudpm;
	
	public ClienteUDPSender(DatagramSocket s,InetAddress h, int p, ClienteUDPManager cudpm){
		
		this.socketCliente=s;
		this.dirSer=h;
		this.puerto=p;
		this.cudpm=cudpm;
		
	}

	@Override
	public void run() {
		
		while (true)
		{
			
			String msg=("test:"+cudpm.numpack);
			DatagramPacket pe= new DatagramPacket(msg.getBytes(), msg.length(), dirSer, puerto);
			try {
				
				socketCliente.send(pe);
				cudpm.numpack++;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				this.sleep(1000/30);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
				
	}
	
}
