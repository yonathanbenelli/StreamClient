package uy.edu.fing.redes2017.grupo12;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPSender extends Thread {
    
	private DatagramSocket socketCliente;
	private InetAddress dirSer ;
	private int puerto ;
	//private ClienteUDPManager cudpm;
	private boolean inicio=false;
	
	public ClienteUDPSender(DatagramSocket s,InetAddress h, int p, ClienteUDPManager cudpm){
		
		this.socketCliente = s;
		this.dirSer = h;
		this.puerto = p;
		//this.cudpm = cudpm;
		
	}

	@Override
	public void run(){
		
		while (true){ 
			
			String msg;
			if (!inicio){
				
				msg=("inicio");
				this.inicio=true;
			
			} else{
				msg=("renovar");	
			}
				
			DatagramPacket pe= new DatagramPacket(msg.getBytes(), msg.length(), dirSer, puerto);
				
			try {
				socketCliente.send(pe);
				Thread.sleep(30000);	
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
				
	}
	
}
