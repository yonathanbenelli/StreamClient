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
import java.util.ArrayList;
import java.util.HashMap;
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


public class ClienteUDPManager extends Thread{
    
	Map<Long,byte[]> packPend= new HashMap<Long, byte[]>();
	Long numpack=0L;
	DisplayFrameJFrame jframe ;
	DatagramSocket socketCliente;
	InetAddress dirSer;
	int puerto;
	
	public ClienteUDPManager(String host, int puerto) throws Exception{
		
		jframe = new DisplayFrameJFrame();
		jframe.setTitle("UDP");
		jframe.setVisible(true);
		this.puerto = puerto;
		socketCliente = new DatagramSocket();
		dirSer = InetAddress.getByName(host);		//Seba Pregunta, se supone que nosotros le vamos a pasar la ip del servidor al cliente
												//InetAddress.getByName(host) esto anda igual??
	
	}

	@Override
	public void run() {
				
		
		ClienteUDPSender cs= new ClienteUDPSender(socketCliente, dirSer, puerto, this);
		cs.start();
		ClienteUDPReciver cr= new ClienteUDPReciver(socketCliente, dirSer, puerto, this);
		cr.start();
		while (true)
			muestroOrdenados();
		
	}

	void muestroOrdenados()
	{
		
		Map<Long,byte[]> pl = packPend;
		Iterator<Long> it = pl.keySet().iterator();
		if(it.hasNext()){
			
			Long key=it.next();
			if(pl.get(key).length>0)
				muestroFrame(pl.get(key));
			packPend.remove(key);
		
		}
		
	}
	
	void muestroFrame(byte[] message){
		
		Mat img = Highgui.imdecode(new MatOfByte(message),  Highgui.CV_LOAD_IMAGE_COLOR);
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if ( img.channels() > 1 ) {
	        type = BufferedImage.TYPE_3BYTE_BGR;
	    }
		BufferedImage image = new BufferedImage(img.cols(),img.rows(), type);
	    img.get(0,0,((DataBufferByte)image.getRaster().getDataBuffer()).getData()); // get all the pixels
	    jframe.nuevoFrame(image);
	    
	}

}
