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

public class MainFrame extends JFrame implements MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel classic, faster, bkg;

    private ChooseMode chooseMode;                                         //》》》增加接口属性

    public MainFrame() {
        bkg = new JLabel(new ImageIcon("image/login.png"));//背景图片
        this.add(BorderLayout.CENTER, bkg);

        //按钮设置
        classic = new JLabel(new ImageIcon("image/120.png"));
        classic.setBounds(200, 350, 220, 80);
        classic.setEnabled(true);
        classic.addMouseListener(this);
        this.add(classic);

        faster = new JLabel(new ImageIcon("image/121.png"));
        faster.setBounds(200, 475, 220, 80);
        faster.setEnabled(true);
        faster.addMouseListener(this);
        this.add(faster);

        this.add(new MainBack());

        this.setSize(1500, 750);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setIconImage(new ImageIcon("image/115.png").getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    class MainBack extends JPanel {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        Image BackGround;

        public MainBack() {
            try {
                BackGround = ImageIO.read(new File("image/login.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //绘制方法
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(BackGround, 0, 0, 1500, 750, null);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(classic) && e.getButton() == MouseEvent.BUTTON1) {
            dispose();
            //new WindowFrame().go();
            //WindowFrame w = new WindowFrame();
            //this.chooseMode = w;                                         //》》》
            this.chooseMode = new WindowFrame();                           //》》》
        }
        if (e.getSource().equals(faster) && e.getButton() == MouseEvent.BUTTON1) {
            dispose();
            //new FasterWindowFrame().go();
            this.chooseMode = new FasterWindowFrame();                     //》》》
        }
        chooseMode.go();                                                   //》》》
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
