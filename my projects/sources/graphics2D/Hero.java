package graphics2D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class Hero {
	int x;
	int y;

	BufferedImage sprite;
	String name;
	
	public Hero(String name, String imageLocation, int locationX, int locationY){
		this.name = name;
		int width = 100;
		int height = 200;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageLocation);
		try{
		BufferedImage original = ImageIO.read(url);
		Graphics2D g = (Graphics2D) sprite.getGraphics();
		int w = original.getWidth();
		int h = original.getHeight();
		
		
		
		g.drawImage(original, 0, 0, width,height,0,0,w,h,null);
		} catch (IOException e) {
			e.printStackTrace();
		
	}
}
	 public BufferedImage getImage(){
		 
		 return sprite; 
	 }
	 public String getName(){
		 return name;
	 }
	 
	 public int getX(){
		 return x;
	 }
	 
	 public int getY(){
		 return y;
	 }
	public void moveUp() {
		// TODO Auto-generated method stub
		y--;
		
	}
	public void moveDown() {
		// TODO Auto-generated method stub
		y++;
	}
	public void moveRight() {
		// TODO Auto-generated method stub
		x++;
	}
	public void moveLeft() {
		// TODO Auto-generated method stub
		x--;
	}
}