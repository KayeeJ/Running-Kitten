package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.*;
import music.MusicPlay;
import view.ClassicFrame;
import view.EndFrame;

/*
 * 经典面板类：核心代码区域
 * 主要实现背景图片动态效果
 */
public class GamePanel extends JPanel implements KeyListener {

    private static final long serialVersionUID = 1L;
    MusicPlay newMusicPlay = new MusicPlay();//<<<<<<<<<<<<<
    //private PaintAction paintAction;

    //声明背景图片变量
    Image background;

    //声明对象
    Person person;
    Animal[] animal = {};
    Missile[] missile = {};
    Block[] block = {};
    Baffle[] baffle = {};
    Coin[] coin = {};
    Graphics g;

    boolean gg = true;

    public GamePanel() {
        person = Person.getPerson();             //<<<<<<<<<<<<<<<<<<<<<
        try {
            background = ImageIO.read(new File("image/cc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int x = 0;

    public void paint(Graphics g) {
        x--;
        person.setScore(person.getDistance() / 10);
        person.setDistance(person.getDistance() + 1);
        // TODO Auto-generated method stub
        super.paint(g);
        //绘制背景图片
        g.drawImage(background, x, 0, ClassicFrame.WIDTH, ClassicFrame.HEIGHT, null);
        g.drawImage(background, x + ClassicFrame.WIDTH, 0, ClassicFrame.WIDTH, ClassicFrame.HEIGHT, null);
        if (x <= -ClassicFrame.WIDTH) {
            x = 0;
        }
        //小猫、小鸡、导弹、金币绘制
        person.paintPerson(g);
        enteredAction();
        stepAction();
        for (int i = 0; i < animal.length; i++) {
            animal[i].paintCrab(g);
            animal[i].step();

        }
        for (int i = 0; i < missile.length; i++) {
            missile[i].paintMissile(g);
            missile[i].step();
        }
        for (int i = 0; i < baffle.length; i++) {
            baffle[i].paintBaffle(g);
            baffle[i].step();
        }
        for (int i = 0; i < block.length; i++) {
            block[i].paintBlock(g);
            block[i].step();
        }
        for (int i = 0; i < coin.length; i++) {
            coin[i].paintCoin(g);
            coin[i].step();
        }

        //绘制玩家分数及跑酷距离
        g.setFont(new Font("华文中宋", Font.BOLD, 20));
        g.setColor(Color.white);
        g.drawString("距离:" + person.getScore() + "米", 50, 50);
        g.setFont(new Font("华文中宋", Font.BOLD, 20));
        g.setColor(Color.white);
        g.drawString("得分:" + person.getDistance() + "分", 50, 90);
    }

    int index = 0;

    public void enteredAction() {
        index++;
        if (index % 300 == 0) {
            //生成实例
            Animal animal1 = new Animal();
            Missile missile1 = new Missile();
            Baffle baffle1 = new Baffle();
            Block block1 = new Block();
            Coin coin1 = new Coin();
            //给数组扩容
            animal = (Animal[]) Arrays.copyOf(animal, animal.length + 1);
            missile = (Missile[]) Arrays.copyOf(missile, missile.length + 1);
            baffle = (Baffle[]) Arrays.copyOf(baffle, baffle.length + 1);
            block = (Block[]) Arrays.copyOf(block, block.length + 1);
            coin = (Coin[]) Arrays.copyOf(coin, coin.length + 1);
            //将生成的实例放到数组中
            animal[animal.length - 1] = animal1;
            missile[missile.length - 1] = missile1;
            baffle[baffle.length - 1] = baffle1;
            block[block.length - 1] = block1;
            coin[coin.length - 1] = coin1;
        }
    }

    //判断游戏结束
    public void gameOver() {
        if (person.getX() <= -Person.WIDTH) {
            gg = !gg;
        }
    }

    //越界删除
    public void stepAction() {

        for (int i = 0; i < animal.length; i++) {
            animal[i].step();
            if (animal[i].isOver()) {
                animal[i] = animal[animal.length - 1];
                animal = (Animal[]) Arrays.copyOf(animal, animal.length - 1);
            }
        }
        for (int i = 0; i < missile.length; i++) {
            missile[i].step();
            if (missile[i].isOver()) {
                missile[i] = missile[missile.length - 1];
                missile = (Missile[]) Arrays.copyOf(missile, missile.length - 1);
            }
        }
        for (int i = 0; i < baffle.length; i++) {
            baffle[i].step();
            if (baffle[i].isOver()) {
                baffle[i] = baffle[baffle.length - 1];
                baffle = (Baffle[]) Arrays.copyOf(baffle, baffle.length - 1);
            }
        }
        for (int i = 0; i < block.length; i++) {
            block[i].step();
            if (block[i].isOver()) {
                block[i] = block[block.length - 1];
                block = (Block[]) Arrays.copyOf(block, block.length - 1);
            }
        }
        for (int i = 0; i < coin.length; i++) {
            coin[i].step();
            if (coin[i].isOver()) {
                coin[i] = coin[coin.length - 1];
                coin = (Coin[]) Arrays.copyOf(coin, coin.length - 1);
            }
        }
    }

    //碰撞逻辑
    public void onCrashAction() {
        //玩家和螃蟹碰撞
        for (int i = 0; i < animal.length; i++) {
            if (person.getX() + Person.WIDTH >= animal[i].getX() && person.getX() <= animal[i].getX() + Animal.WIDTH &&
                    person.getY() + Person.HEIGHT >= animal[i].getY() && person.getY() <= animal[i].getY() + Animal.HEIGHT) {
                if (person.getX() + Person.WIDTH <= animal[i].getX() + Animal.WIDTH / 2) {
                    person.setX(animal[i].getX() - Person.WIDTH);
                } else {
                    person.setX(animal[i].getX() + Animal.WIDTH);
                }
            }
        }
        //导弹碰撞
        for (int i = 0; i < missile.length; i++) {
            if (person.getX() + Person.WIDTH >= missile[i].getX() && person.getX() <= missile[i].getX() + Missile.WIDTH &&
                    person.getY() + Person.HEIGHT >= missile[i].getY() && person.getY() <= missile[i].getY() + Missile.HEIGHT) {
                gg = !gg;
            }
        }

        //鱼叉碰撞
        for (int i = 0; i < baffle.length; i++) {
            if (person.getX() + Person.WIDTH >= baffle[i].getX() && person.getX() <= baffle[i].getX() + Baffle.WIDTH &&
                    person.getY() + Person.HEIGHT >= baffle[i].getY() && person.getY() <= baffle[i].getY() + Baffle.HEIGHT) {
                if (person.getX() + Person.WIDTH <= baffle[i].getX() + Baffle.WIDTH / 2) {
                    person.setX(baffle[i].getX() - Person.WIDTH);
                } else {
                    person.setX(baffle[i].getX() + Baffle.WIDTH);
                }
            }
        }
        //金币碰撞
        for (int i = 0; i < coin.length; i++) {
            if (person.getX() + Person.WIDTH >= coin[i].getX() && person.getX() <= coin[i].getX() + Coin.WIDTH &&
                    person.getY() + Person.HEIGHT >= coin[i].getY() && person.getY() <= coin[i].getY() + Coin.HEIGHT) {
                coin[i] = coin[coin.length - 1];
                person.setScore(person.getScore() + 10);
                MusicPlay.play("music/coin.wav");         //<<<<<<<<<
                //停1s
                //newMusicPlay.stop();
                //金币加分规则(未填写)
            }
        }
        //云梯碰撞
        for (int i = 0; i < block.length; i++) {
            if (person.getX() + Person.WIDTH >= block[i].getX() && person.getX() <= block[i].getX() + Block.WIDTH &&
                    person.getY() + Person.HEIGHT >= block[i].getY() && person.getY() <= block[i].getY() + Block.HEIGHT) {
                if (person.getY() + Person.HEIGHT <= block[i].getY() + Block.HEIGHT / 2) {
                    person.setY(block[i].getY() - Person.HEIGHT);
                } else {
                    person.setY(block[i].getY() + Block.HEIGHT);
                }
            }
        }
    }

    public boolean isGg() {
        return gg;
    }

    public void setGg(boolean gg) {
        this.gg = gg;
    }

    boolean flag = true;

    //创建一个生成线程的方法并启动线程,用于调用paint方法自执行
    public void action() {
        new Thread() {
            public void run() {
                while (gg) {
                    if (flag) {
                        person.step();
                        onCrashAction();
                        repaint();
                        gameOver();
                        person.setScore(person.getScore());
                        EndFrame.setScore(person.getScore());
                        person.setDistance(person.getDistance());
                        EndFrame.setDistance(person.getDistance());
                    }
                    try {
                        Thread.sleep(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    public void keyPressed(KeyEvent e) {
        //右键
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            person.setX(person.getX() + 20);
            if (person.getX() >= ClassicFrame.WIDTH - Person.WIDTH) {
                person.setX(ClassicFrame.WIDTH - Person.WIDTH);
            }
        }
        //上键
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            person.setY(person.getY() - 145);
            if (person.getY() <= 0) {
                person.setY(0);
            }
        }
        //左键
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            person.setX(person.getX() - 20);
            if (person.getX() <= 50) {
                person.setX(50);
            }
        }
        //下键
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            person.setY(person.getY() + 60);
            if (person.getY() >= 600) {
                person.setY(220);
            }
        }
        //空格
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            flag = !flag;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
    }
}
