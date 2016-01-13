package graphics2D;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;



public class MyWindow extends JFrame implements KeyListener {
	int width = 500;
	int height = 500;
	Hero Pain;
	Hero Sak;
	private BufferedImage landscape;
	
	public static void main(String[] args){
		new MyWindow();
	}

public MyWindow(){
	 Pain = new Hero ("pain","/images/heroes/cmon.png",50,50);
	 Sak = new Hero ("sask","/images/heroes/swag.png",50,50);
	 
	setVisible(true);
	setSize(width , height);
	setLocation(200,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	addKeyListener(this);
	landscape=  new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = (Graphics2D) landscape.getGraphics();
	paint(g2);
	g2.fillRect(0,0,width, height);
	
	
}
public void paint(Graphics g){

	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = (Graphics2D)image.getGraphics();
	g2.setColor (Color.white);
	//g2.fillRect(0,0,width, height);
	//g2.setColor(Color.red);
	//g2.drawOval(50,100,200,100);
	//g2.setColor(Color.blue);
	//g2.drawOval(50,100,200,100);
	
	//g2.drawArc(50, 300, 200, 100, 0, 90);
	//g2.drawString("strings are drawn" + "like this", 300, 300);
	//g2.drawLine (0, 0, width, height);
	
	//g2.setColor( new Color(50,100,200));
	//g2.fillRect(0, 0, width, height);
	
	
	
	g2.drawImage(Pain.getImage(), Pain.getX(),Pain.getY(),null);
	
	g.drawImage(image, 200, 100, null );
	
	g2.drawImage(Sak.getImage(), Sak.getX(),Sak.getY(),null);
	//int squareD = 20;
	//int margin = 2;
	//int  c = 0;
	//for(int x = 0; x<width; x+=squareD+margin){
	//	for (int y = 0; y < height; y+=squareD+margin){
		
	//		g2.setColor(new Color(0, 0, c));
	//	g2.fillRect(x, y, squareD, squareD);
	//	c++;
	//	if( c == 255){
		//	c = 0;
			
	//	}}
		g.drawImage(image, 300,100 , null );
		}

public void keyPressed(KeyEvent arg0){
	int key = arg0.getKeyCode();
	if( key ==KeyEvent.VK_UP){
		Pain.moveUp();
	}
	else if( key== KeyEvent.VK_DOWN){
		Pain.moveDown();
	}else if( key== KeyEvent.VK_RIGHT){
		Pain.moveRight();
	}else if( key== KeyEvent.VK_LEFT){
		Pain.moveLeft();
	}
	repaint();
}


public void keyReleased(KeyEvent arg0){
	
}


public void keyTyped(KeyEvent arg0){
	
}
	
}

	
