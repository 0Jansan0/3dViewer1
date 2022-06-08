package Viewer;

import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.*;

import javax.swing.*;

public class panel1 extends JPanel implements Runnable{

	Thread hiloJuego;

	Line2D[] lines = new Line2D[3];
	

	/*	-------------------- COORDENADAS ----------------------
	 * 	
	* 				z
	*   		 |
	*   		 |
	* 	 		 |
	*    		 |
	* 	 		 |
	*    	 	 |
	*   		 ------------------ y
	*    		/
	*    	   /
	*    	  /
	*    	 /
	*       /  x
	*      
	*    
	*/	   
	
	
	public panel1() {
	    setBackground(Color.black);
	    setSize(375, 250);
	  	//Line2D.Double line = new Line2D.Double(10,10,50,50);
	  	//lines.add(line);
	    
	    

	}
	
	
	public void startHiloJuego() {
		 hiloJuego = new Thread(this);
		 hiloJuego.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/60;
		double nextDrawTime = System.nanoTime() + drawInterval;
		long timer = 0;
		int drawCount = 0;
		long ultTiempo = System.nanoTime();
		long current;
		
		while(hiloJuego != null) {
			
			// f --> FPS counter 
			// gl --> Game Loop
			
			current = System.nanoTime(); //f
			drawCount++; //f
						
			//System.out.println("");
			
			update();
			repaint();
			
			try {
				
				double tiempoRestante = nextDrawTime - System.nanoTime(); //gl
				tiempoRestante = tiempoRestante/1000000; //gl
				timer += (current - ultTiempo); //f
				if(tiempoRestante < 0) { //f
					tiempoRestante = 0;
				}
								
				Thread.sleep((long) tiempoRestante); //gl
				
				nextDrawTime += drawInterval;//gl
								
				ultTiempo = current; //gl
				
				if(timer >= 1000000000) { //gl
					System.out.println("FPS " + drawCount);
					drawCount = 0;
					timer = 0;
				}
				
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void update() {
	
		ViewrWB.LabelX.setText(Integer.toString(ViewrWB.sliderX.getValue()));
		ViewrWB.LabelY.setText(Integer.toString(ViewrWB.sliderY.getValue()));

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
	}
	
}
