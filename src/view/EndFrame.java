package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * 结束界面的实现  背景图片、按钮
 * 背景图片的绘制、按钮的功能实现
 */

public class EndFrame extends JFrame implements MouseListener{
	
	
	private static final long serialVersionUID = 1L;
	JLabel bzbg,back,score,distance;//设置背景图片和按钮标签
	Graphics g;
	public static int Score;
	public static int Distance;
	public static int Total;

	public EndFrame() {
		//背景图片设置
		bzbg =new JLabel(new ImageIcon("image/endbg.png"));
		this.add(BorderLayout.CENTER,bzbg);
		
		//按钮设置
		back=new JLabel(new ImageIcon("image/back.png"));
		back.setBounds(360,650,150,50);
		back.setEnabled(false);
		back.addMouseListener(this);
		this.add(back);
		
		this.add(new EndBack());
		
		Total=Distance+Score;
		//窗口设置
		this.setSize(1500,750);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public static int getTotal() {
		return Total;
	}


	public static void setTotal(int total) {
		Total = total;
	}


	public static int getScore() {
		return Score;
	}


	public static void setScore(int score) {
		Score = score;
	}


	public static int getDistance() {
		return Distance;
	}


	public static void setDistance(int distance) {
		Distance = distance;
	}


	public static void main(String[] args) {
		new EndFrame();
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(back)&&e.getButton()==MouseEvent.BUTTON1)
		{
			dispose();
			new MainFrame();
		}
	}
	public void mouseEntered(MouseEvent e) {
		back.setEnabled(true);
	}
	public void mouseExited(MouseEvent e) {
		back.setEnabled(false);
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
}

class EndBack extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image BackGround;
	public EndBack() {
		try {
			BackGround=ImageIO.read(new  File("image/endbg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	//绘制方法
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(BackGround, 0, 0, 1500,750,null);
		g.setFont(new Font("华文中宋",Font.BOLD,40));
		g.setColor(Color.black);
		g.drawString(""+EndFrame.getDistance()+"",670,325);
		g.setFont(new Font("华文中宋",Font.BOLD,40));
		g.setColor(Color.black);
		g.drawString(""+EndFrame.getTotal()+"",670,475);
	}

}