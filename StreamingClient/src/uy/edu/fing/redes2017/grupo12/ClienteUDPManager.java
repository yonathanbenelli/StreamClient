package uy.edu.fing.redes2017.grupo12;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;


public class ClienteUDPManager extends Thread{
    
	volatile Map<Long,byte[]> packPend = new HashMap<Long, byte[]>();
	Long numpack = 0L;
	DisplayFrameJFrame jframe ;
	DatagramSocket socketCliente;
	InetAddress dirSer;
	int puerto;
	long frmAnt = 0;
	
	public ClienteUDPManager(String host, int puerto) throws Exception{
		
		jframe = new DisplayFrameJFrame();
		jframe.setTitle("UDP");
		jframe.setVisible(true);
		this.puerto = puerto;
		socketCliente = new DatagramSocket();
		dirSer = InetAddress.getByName(host);
	
	}

	@Override
	public void run(){
				
		
		ClienteUDPSender cs = new ClienteUDPSender(socketCliente, dirSer, puerto, this);
		cs.start();
		ClienteUDPReciver cr = new ClienteUDPReciver(socketCliente, dirSer, puerto, this);
		cr.start();
		while (true)
			muestroOrdenados();
		
	}

	void muestroOrdenados(){
		
		Map<Long,byte[]> pl = packPend;
		Iterator<Long> it = pl.keySet().iterator();
		
		if(it.hasNext()){
			
			Long key = it.next();
			
			if(key >= frmAnt){
				
				muestroFrame(pl.get(key));
				frmAnt = key;
			
			}
			packPend.remove(key);
		
		}
		
	}
	
	void muestroFrame(byte[] message){
		
		Mat img = Highgui.imdecode(new MatOfByte(message),  Highgui.CV_LOAD_IMAGE_COLOR);
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (img.channels() > 1){
	        type = BufferedImage.TYPE_3BYTE_BGR;
	    }
		BufferedImage image = new BufferedImage(img.cols(),img.rows(), type);
	    img.get(0,0,((DataBufferByte)image.getRaster().getDataBuffer()).getData()); // get all the pixels
	    jframe.nuevoFrame(image);
	    
	}

}
