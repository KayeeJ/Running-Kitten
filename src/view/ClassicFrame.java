package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import control.GamePanel;
import model.Person;

public class ClassicFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	//窗体的宽高
	public static final int WIDTH=1500;
	public static final int HEIGHT=750;
	
	//声明主面板对象
	GamePanel panel;
	Person person = Person.getPerson();

	public ClassicFrame() {
		panel=new GamePanel();
		panel.action();
		this.add(panel);
		//绑定键盘监听事件
		this.addKeyListener(panel);
		//调用生成线程的方法
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
				new EndFrame();
				person.restart();//<<<<<<<<<<<<<
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
		new ClassicFrame();
	}
}
