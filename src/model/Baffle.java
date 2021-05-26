package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import view.ClassicFrame;

/*
 * 鱼叉类的实现
 */

public class Baffle {
	private BufferedImage image;
	private BufferedImage [] images;
	public static final int WIDTH=40;
	public static final int HEIGHT=150;//鱼叉模型图片大小
	private int x,y;
	Random rand=new Random();

	public Baffle() {
		images=new BufferedImage[4];
			try {
				images[0]=ImageIO.read(new File("image/11.png"));
				images[1]=ImageIO.read(new File("image/12.png"));
				images[2]=ImageIO.read(new File("image/13.png"));
				images[3]=ImageIO.read(new File("image/14.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		image=images[rand.nextInt(4)];
		x=ClassicFrame.WIDTH+rand.nextInt(500);
		y=0;

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
		//经典模式鱼叉移动规则
		x--;
		}
	
	public void Fasterstep()
	{
		//极速模式鱼叉移动规则
		x=x-2;
		}
	//绘制鱼叉
	public void paintBaffle(Graphics g)
	{
		 g.drawImage(image,x,y,WIDTH,HEIGHT,null);
	}
	
	//判断是否越界
		public boolean isOver()
		{
			return x<=-WIDTH;
		}
}