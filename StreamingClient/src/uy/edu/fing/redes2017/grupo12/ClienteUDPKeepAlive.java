package uy.edu.fing.redes2017.grupo12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPKeepAlive extends Thread{
	
	private DatagramSocket socketCliente;
	private InetAddress dirSer ;
	private int puerto;
	private volatile Boolean fin=false;
	
	ClienteUDPKeepAlive(DatagramSocket socketCliente, InetAddress dirSer, int puerto){
		this.socketCliente = socketCliente;
		this.dirSer = dirSer;
		this.puerto = puerto;
	}
	
	@Override
	public void run(){
		
		while (!fin){ 
			
			String msg = "renovar";				
			DatagramPacket pe= new DatagramPacket(msg.getBytes(), msg.length(), dirSer, puerto);
				
			try {
				socketCliente.send(pe);
				Thread.sleep(30000);	
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
						
		}
				
	}
	
	public void fin()
	{
		this.fin=true;
	}
}
