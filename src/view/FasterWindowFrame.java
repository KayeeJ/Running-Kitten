package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import java.applet.AudioClip; 
import java.io.*; 
import java.awt.Frame; 
import java.net.MalformedURLException; 
import java.net.URI;
import java.net.URL;
/*
 * 缓冲加载界面：进度条功能
 * 
 */

@SuppressWarnings({ "unused", "deprecation" })
public class FasterWindowFrame extends JFrame implements Runnable, ChooseMode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel image;
	JProgressBar jpb;
	
	File f;
	URI uri;
	URL url;
	public FasterWindowFrame() {
		image =new JLabel(new ImageIcon("image/hbg.png"));
		this.add(BorderLayout.NORTH,image);
		
		jpb=new JProgressBar();
		jpb.setStringPainted(true);
		jpb.setBackground(Color.orange);
		this.add(BorderLayout.SOUTH,jpb);
			
		this.setSize(568,340);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FasterWindowFrame().go();
	}
	
	//创建线程并启动
	@Override
	public void go()
	{
		Thread t=new Thread(new FasterWindowFrame());
		t.start();
		dispose();
	}

	public void run() {
		int []values= {0,9,16,25,37,46,58,72,81,90,100};
		for(int i=0;i<values.length;i++)
		{
			jpb.setValue(values[i]);
			try {           //线程休眠
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}                   //关闭当前界面
		dispose();
		//转到下一界面
		new FasterFrame();
	}
}