package uy.edu.fing.redes2017.grupo12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPSender extends Thread {
    
	private DatagramSocket socketCliente;
	private InetAddress dirSer ;
	private int puerto ;
	private boolean inicio=false;
	private volatile Boolean fin=false;
	
	
	public ClienteUDPSender(DatagramSocket s,InetAddress h, int p){
		
		this.socketCliente = s;
		this.dirSer = h;
		this.puerto = p;
		
	}

	@Override
	public void run(){
		
		while (!fin){ 
			
			String msg;
			if (!inicio){
				
				msg=("inicio");
				this.inicio=true;
			
			} else{
				msg=("pido frame");	
			}
				
			DatagramPacket pe= new DatagramPacket(msg.getBytes(), msg.length(), dirSer, puerto);
				
			try {
				socketCliente.send(pe);
				Thread.sleep(1000/30);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

		}
				
	}
	
	public void fin()
	{
		this.fin=true;
	}
	public Boolean getFin() {
		return fin;
	}

	public void setFin(Boolean fin) {
		this.fin = fin;
	}

}
