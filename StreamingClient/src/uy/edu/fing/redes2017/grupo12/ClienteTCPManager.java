package uy.edu.fing.redes2017.grupo12;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;

public class ClienteTCPManager extends Thread {
    
	private DisplayFrameJFrame jframe ;
	private Socket socketCliente ;
	
	public ClienteTCPManager(String host, int puerto) throws Exception  {
		
		jframe = new DisplayFrameJFrame();
	    jframe.setVisible(true);
	    jframe.setTitle("TCP");
	    
		socketCliente = new Socket(host, puerto);
		socketCliente.setKeepAlive(true);
		
	}

	@Override
	public void run() {
		
		while (true){
		
			try {
				
				DataInputStream dIn = new DataInputStream(socketCliente.getInputStream());
				int length = dIn.readInt();
				if(length>0) {
					
					byte[] message = new byte[length];
					dIn.readFully(message, 0, message.length); // read the message
					Mat img = Highgui.imdecode(new MatOfByte(message),  Highgui.CV_LOAD_IMAGE_COLOR);
			    
					int type = BufferedImage.TYPE_BYTE_GRAY;
					if (img.channels() > 1) {
						type = BufferedImage.TYPE_3BYTE_BGR;
					}
					BufferedImage image = new BufferedImage(img.cols(),img.rows(), type);
					img.get(0,0,((DataBufferByte)image.getRaster().getDataBuffer()).getData()); // get all the pixels
					jframe.nuevoFrame(image);
				
				};
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}		

	}

}
