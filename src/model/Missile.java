package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import view.ClassicFrame;
/*
 * 导弹类
 * 
 */

public class Missile{
	private BufferedImage image;
	public static final int WIDTH=100;
	public static final int HEIGHT=50;//导弹模型图片大小
	private int x,y;
	Random rand=new Random();

	public Missile() {
				try {
					image=ImageIO.read(new File("image/daodan.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
		x=ClassicFrame.WIDTH+rand.nextInt(20);
		y=200+rand.nextInt(200);
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

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public void step()
	{
		//导弹移动
		x=x-2;
		}
	
	public void Fasterstep()
	{
		//导弹移动
		x=x-5;
		}
	//绘制导弹
	public void paintMissile(Graphics g)
	{
		 g.drawImage(image,x,y,WIDTH,HEIGHT,null);
	}
	
	//判断是否越界
		public boolean isOver()
		{
			return x<=-WIDTH;
		}
}