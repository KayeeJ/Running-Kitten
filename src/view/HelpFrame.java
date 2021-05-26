package view;

import java.awt.BorderLayout;
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


import java.net.URI;
import java.net.URL;
/*
 * 帮助界面的实现  背景图片、按钮
 * 背景图片的绘制、按钮的功能实现
 */

public class HelpFrame extends JFrame implements MouseListener{
	

	private static final long serialVersionUID = 1L;
	JLabel bzbg,back;//设置背景图片和按钮标签
	File f;
	URI uri;
	URL url;
	public HelpFrame() {
		//背景图片设置
		bzbg =new JLabel(new ImageIcon("image/bzbg.png"));
		this.add(BorderLayout.CENTER,bzbg);
		
		//按钮设置
		back=new JLabel(new ImageIcon("image/back.png"));
		back.setBounds(1050,550,150,50);
		back.setEnabled(false);
		back.addMouseListener(this);
		this.add(back);
		
		this.add(new HelpBack());
		
		//窗口设置
		this.setSize(1500,750);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new HelpFrame();
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(back)&&e.getButton()==MouseEvent.BUTTON1)
		{
			dispose();
			new MenuFrame();
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

class HelpBack extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image BackGround;
	public HelpBack() {
		try {
			BackGround=ImageIO.read(new  File("image/bzbg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	//绘制方法
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(BackGround, 0, 0, 1500,750,null);
	}
}







