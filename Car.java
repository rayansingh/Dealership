import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.*;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.*;

public class Car{
	private String name;
	private String make;
	private String model;
	private int year;
	private Double price;
	private int amt;
	private BufferedImage img;

	public Car(String name, String make, String model, int year, Double price){
		this.name = name;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		amt = 0;

		try {
            img = ImageIO.read(new File("./images/cars/" + make + "/" + model + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void u(){
		try {
            img = ImageIO.read(new File("./images/cars/unnamed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public String name(){
		return name;
	}

	public String make(){
		return make;
	}

	public String model(){
		return model;
	}

	public int year(){
		return year;
	}

	public Double price(){
		return price;
	}

	public int amt(){
		return amt;
	}

	public void add(){
		amt += 1;
	}

	public void remove(){
		if(amt > 0){
			amt -= 1;
		}
	}

	public int hashCode(){
		int code = 0;
		char[] chars = make.toCharArray();

		for(int i = 0; i < chars.length; i++){
			int x = (int)(chars[i]);
			System.out.println(chars[i]);
			code += (((int)(chars[i])-96)*(Math.pow(26,(chars.length-i-1))));
			System.out.println(code);
		}
		return code;
	}

	public String toString(){
		return make + "" + model;
	}

	public void drawMe(Graphics g, int x, int y){
		//Draw Frame

		g.setColor(Color.white);
		g.fillRect(x,y,175,200);

		g.setColor(Color.black);
		g.drawRect(x,y,175,200);
		g.drawString(year + " " + name,x+5,y+120);
		g.drawString("$" + price + "",x+5,y+150);
		g.drawString("Amount: " + amt,x+100,y+150);



		g.drawImage(img,x,y,175,100,null);

		


	}
}