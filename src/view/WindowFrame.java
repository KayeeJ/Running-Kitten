package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


/*
 * 缓冲加载界面：进度条功能
 * 
 */

public class WindowFrame extends JFrame implements Runnable, ChooseMode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel image;
	JProgressBar jpb;
	
	public WindowFrame() {
		
		image =new JLabel(new ImageIcon("image/hbg.png"));
		image.setBounds(1000, 300, 1000, 300);
		this.add(BorderLayout.NORTH,image);
		
		jpb=new JProgressBar();
		jpb.setStringPainted(true);
		jpb.setBackground(Color.ORANGE);
		this.add(BorderLayout.SOUTH,jpb);
			
		this.setSize(568,340);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowFrame().go();
	}

	@Override
	public void go()         //创建线程并启动
	{
		Thread t=new Thread(new WindowFrame());
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
		new ClassicFrame();
	}
}
