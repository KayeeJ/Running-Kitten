package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import view.ClassicFrame;

/*
 * 云梯类的实现
 */

public class Block{
	private BufferedImage image;
	private BufferedImage []images;
	public static final int WIDTH=300;
	public static final int HEIGHT=30;//云梯模型图片大小

	private int x,y;
	Random rand=new Random();

	public Block() {
		setImages(new BufferedImage[1]);
				try {
					image=ImageIO.read(new File("image/hhh.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
		x=ClassicFrame.WIDTH+rand.nextInt(500);
		y=320+rand.nextInt(100);
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
		x--;
		}
	
	public void Fasterstep()
	{
		//图片移动
		x=x-2;
		}
	//绘制云梯
	public void paintBlock(Graphics g)
	{
		 g.drawImage(image,x,y,WIDTH,HEIGHT,null);
	}

	//判断是否越界
		public boolean isOver()
		{
			return x<=-WIDTH;
		}

		public BufferedImage [] getImages() {
			return images;
		}

		public void setImages(BufferedImage [] images) {
			this.images = images;
		}
}
