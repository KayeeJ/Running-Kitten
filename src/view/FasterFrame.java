package view;


import javax.swing.ImageIcon;
import javax.swing.JFrame;


import control.FasterPanel;
import model.Person;

/*
  *    极速模式界面
 * 
 */
public class FasterFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Person person = Person.getPerson();

	//窗体的宽高
	public static final int WIDTH=1500;
	public static final int HEIGHT=750;
	
	//声明主面板对象
	FasterPanel panel;
	public FasterFrame() {
		panel=new FasterPanel();
		this.add(panel);
		//绑定键盘监听事件
		this.addKeyListener(panel);
		//调用生成线程的方法
		panel.action();
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);
		boolean flag=true;
		while(flag)
		{
			if(!panel.isGg())
			{
				dispose();
				new EndFrame();
				person.restart();                         //<<<<<<<<<<<<<
				break;
			}
			else
			{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new FasterFrame();
	}
}
