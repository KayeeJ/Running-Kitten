package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import view.ClassicFrame;

/*
 *  金币实体类
 * 
 */

public class Coin {
	private BufferedImage [] images;
	private BufferedImage image;
	public static final int WIDTH=40;
	public static final int HEIGHT=40;//金币模型图片大小
	private int x,y;
	private int index;
	Random rand=new Random();
	
	public Coin() {
		images=new BufferedImage[6];
		{
			try {
				images[0]=ImageIO.read(new File("image/21.png"));
				images[1]=ImageIO.read(new File("image/22.png"));
				images[2]=ImageIO.read(new File("image/23.png"));
				images[3]=ImageIO.read(new File("image/24.png"));
				images[4]=ImageIO.read(new File("image/25.png"));
				images[5]=ImageIO.read(new File("image/26.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		image=images[rand.nextInt(6)];
		x=ClassicFrame.WIDTH+rand.nextInt(500);
		y=200+rand.nextInt(200);
		index=0;
	}
	
	//金币移动的方法
	public void step()
	{
		x=x-2;
		}
	public void Fasterstep()
	{
		x=x-4;
		}
	
	//绘制金币的方法
	public void paintCoin(Graphics g)
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
	//判断是否越界
		public boolean isOver()
		{
			return x<=-WIDTH;
		}	
}