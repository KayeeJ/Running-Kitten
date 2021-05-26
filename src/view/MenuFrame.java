package view;

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

public class MenuFrame extends JFrame implements MouseListener{
	/*
	 * 菜单选择界面：三个图片按钮、开始游戏、帮助、退出
	 */
	//开始、帮助、退出、图片按钮
	private static final long serialVersionUID = 1L;
	JLabel start,help,exit;
	
	public MenuFrame() {
		//开始按钮
		start=new JLabel(new ImageIcon("image/hh1.png"));                           
		start.setBounds(560,150,400,100);
		//start.setEnabled(false);
		//绑定监听
		start.addMouseListener(this);
		start.setEnabled(true);
		this.add(start);
		//帮助按钮
		help=new JLabel(new ImageIcon("image/hh2.png"));
		help.setBounds(560,330,400,100);
		//help.setEnabled(false);
		help.addMouseListener(this);
		help.setEnabled(true);
		this.add(help);
		//退出
		exit=new JLabel(new ImageIcon("image/hh3.png"));
		exit.setBounds(560,510,400,100);
		//exit.setEnabled(false);
		exit.addMouseListener(this);
		exit.setEnabled(true);
		this.add(exit);
		this.add(new MenuBack());
		//在构造方法中设置窗体的基本属性
		this.setSize(1500,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MenuFrame();
	}
	public void mouseClicked(MouseEvent e) {
		//点击鼠标
		if(e.getSource().equals(start)&&e.getButton()==MouseEvent.BUTTON1)
		{
		    dispose();
		    //new WindowFrame().go();
		    new MainFrame();
		}
		if(e.getSource().equals(help)&&e.getButton()==MouseEvent.BUTTON1)
		{
			dispose();
			new HelpFrame();
		}
		if(e.getSource().equals(exit)&&e.getButton()==MouseEvent.BUTTON1)
		{
			dispose();
		}	
	}
	public void mouseEntered(MouseEvent e) {

	}
	public void mouseExited(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}

}

//背景图片面板
class MenuBack extends JPanel
{
	private static final long serialVersionUID = 1L;
	Image BackGround;
	public MenuBack() {
		try {
			BackGround=ImageIO.read(new  File("image/main.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	//绘制方法
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(BackGround,0,0,1500,750,null);
	}
}















