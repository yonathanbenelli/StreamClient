package uy.edu.fing.redes2017.grupo12;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DisplayFrameJFrame extends JFrame{

	private static final long serialVersionUID = -4863046612292887293L;
	private  JPanel contentPane;
	private  BufferedImage image;
	
	public DisplayFrameJFrame(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 650, 490);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	   
	}
	
    public void paint(Graphics g){
    	
        g = contentPane.getGraphics();
        g.drawImage(image, 0, 0, this);
    
    }
    
    public void nuevoFrame(BufferedImage i){	
    
    	image=i;
    	repaint();
    
    }
}
