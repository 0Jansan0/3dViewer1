package Viewer;

import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.*;

import javax.swing.*;

public class panel1 extends JPanel implements Runnable{

	Thread hiloJuego;

	Line2D.Double[] lines = new Line2D.Double[3];
	

	/*	-------------------- COORDENADAS ----------------------
	 * 	
	* 				z
	*   	  1  | 
	*   		 |
	* 	 		 |
	*    		 |
	* 	 		 |
	*    	  2  | 1               2
	*   		 ------------------ y
	*    	2	/
	*    	   /
	*    	  /
	*    	 /
	*     1 /  x
	*      
	*    
	*/	 
	
	int Zx1 = 100,Zy1 = 10
	   ,Zx2 = 100,Zy2 = 100;
	
	int Xx1 = 80 ,Xy1 = 180
	   ,Xx2 = 100,Xy2 = 100;

	int Yx1 = 100,Yy1 = 100,
	    Yx2 = 200,Yy2 = 100;

	
	public panel1() {
	    setBackground(Color.black);
	    setSize(375, 250);
	    lines[0] = new Line2D.Double(Zx1,Zy1,Zx2,Zy2); 
	    lines[1] = new Line2D.Double(Xx1,Xy1,Xx2,Xy2);
	    lines[2] = new Line2D.Double(Yx1,Yy1,Yx2,Yy2);
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
	    g2.setStroke(new BasicStroke(3));
	    g2.setColor(Color.WHITE);
		for(int i = 0; i <= 2; i++) {
			g.drawLine((int)lines[i].x1,(int)lines[i].y1,(int)lines[i].x2,(int)lines[i].y2);
		}
	}
	
}
