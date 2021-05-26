package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/*
 *     玩家实体类
 *     属性：图片数组当前显示图片宽，高，起始绘制坐标x、y,得分——跑酷距离
 */

public class Person {
	private BufferedImage [] images;
	private BufferedImage image;
	public static final int WIDTH=115;
	public static final int HEIGHT=97;//角色模型图片大小
	private int x,y;
	private int score;
	private int distance;
	private int index;
	Random rand=new Random();

	private static Person person = new Person();                          //<<<<<<<创建 SingleObject 的一个对象

	//<<<<<<<<<<<<<<<<<<<<<让构造函数为 private，这样该类就不会被实例化
	private Person() {
		images=new BufferedImage[6];
		for(int i=0;i<images.length;i++)
		{
			try {
				images[i]=ImageIO.read(new File("image/"+(i+1)+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		image=images[0];
		x=120;
		y=2*HEIGHT;
		score=0;
		distance=0;
		index=0;
	}

	//<<<<<<<<<<<<<<<<<<<<<<<<<
	//获取唯一可用的对象.提供了一个静态方法，供外界获取它的静态实例。
	public static Person getPerson(){
		 if (person == null) {  
		        synchronized (Person.class) {  
		        if (person == null) {  
		        	person = new Person();  
		        }  
		        }  
		    }  
		    return person;  
  }  

	public void restart(){
		images=new BufferedImage[6];
		for(int i=0;i<images.length;i++)
		{
			try {
				images[i]=ImageIO.read(new File("image/"+(i+1)+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		image=images[0];
		x=120;
		y=2*HEIGHT;
		score=0;
		distance=0;
		index=0;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//玩家移动的方法
	public void step()
	{
		//重力问题
		y++;
		if(y>=460)
		{
			y=460;
		}
		//图片切换
		image=images[index++/25%images.length];
		}
	public void Fasterstep()
	{
		//重力问题
		y++;
		if(y>=460)
		{
			y=460;
		}
		//图片切换
		image=images[index++/25%images.length];
		}
	
	public void score() {
		this.setScore(score=score+rand.nextInt(100));
	}
	//绘制玩家的方法
	public void paintPerson(Graphics g)
	{
		 g.drawImage(image,x,y,WIDTH,HEIGHT,null);
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public  int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}	
}
















