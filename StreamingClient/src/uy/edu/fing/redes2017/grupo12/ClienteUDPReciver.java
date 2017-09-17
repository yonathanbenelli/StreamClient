package uy.edu.fing.redes2017.grupo12;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClienteUDPReciver  extends Thread{
    

	private DatagramSocket socketCliente;
	private ClienteUDPManager cudpm;
	
	public ClienteUDPReciver(DatagramSocket s,InetAddress h, int p, ClienteUDPManager cudpm){

		this.socketCliente = s;
		this.cudpm = cudpm;
	
	}

	@Override
	public void run() {		
				
		while (true){
	
			DatagramPacket pr = new DatagramPacket(new byte[65000], 65000);
			try{
				
				socketCliente.receive(pr);
				int length = pr.getLength();     // read length of incoming message
				if(length > 0) {
				    
					byte[] recived = pr.getData();
					
				    DataInputStream di = new DataInputStream(new ByteArrayInputStream(recived));
				    byte[] message = new byte[65000];
				    di.read(message);
				    
				    cudpm.muestroFrame(message);
				    
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
					
		}		

	}
	
}
