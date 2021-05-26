package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import view.ClassicFrame;

/*
 * 地面障碍类的实现
 */

public class Animal {
	private BufferedImage []images;
	private BufferedImage image;
	public static final int WIDTH=60;
	public static final int HEIGHT=69;//模型图片大小
	private int x,y;
	private int speed;
	Random rand=new Random();

	public Animal() {
		images=new BufferedImage[2];
				try {
					images[0]=ImageIO.read(new File("image/a1.png"));
					images[1]=ImageIO.read(new File("image/a2.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
		image=images[rand.nextInt(2)];
		x=ClassicFrame.WIDTH+rand.nextInt(500);
		y=475;
		speed=1;
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
	//图片移动
		x=x-speed;
	}
	public void Fasterstep()
	{
	//图片移动
		x=x-3*speed;
	}
	//绘制障碍
	public void paintCrab(Graphics g)
	{
		 g.drawImage(image,x,y,WIDTH,HEIGHT,null);
	}
	//判断是否越界
	public boolean isOver()
	{
		return x<=-WIDTH;
	}
}
