package game1;

import java.awt.Color;
import java.util.Timer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameMain extends JFrame implements KeyListener, Runnable {
	Thread th;
	int x1 = 230, y1 = 230;
	int x2 = 230, y2 = 230;
	int x3 = 230, y3 = 230;
	int x4 = 230, y4 = 230;
	int a = 0;
	int b = 10;
	int num = 0;
	boolean c = false;
	boolean d = true;
	Image img;
	Image img2;
	GameMain(){
		super.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		super.setVisible(true);
		super.addKeyListener(this);
		img = Toolkit.getDefaultToolkit().getImage("imges/gg.png");
		img2 = Toolkit.getDefaultToolkit().getImage("imges/hamer.png");
	}
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.YELLOW);
		g.fillOval(x1, y1, 10, 10);
		g.setColor(Color.RED);
		g.fillOval(x2, y2, 10, 10);
		g.setColor(Color.BLUE);
		g.fillOval(x3, y3, 10, 10);
		g.setColor(Color.GREEN);
		g.fillOval(x4, y4, 10, 10);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		th = new Thread(this);
		th.start();
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			a = 1;
		} else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			a = 2;
		} else if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			a = 3;
		} else if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			a = 4;
		}else if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			a = 5;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveX(int a) {
		try {
			x1 = x1+b*a;
			y2 = y1;
			if(x1 <= 10) {
				x1 = 10;
			} else if(x1 >= 440) {
				x1 = 440;
			}
			repaint();
			Thread.sleep(50);
			x2 = x1-(10*a);
			y2 = y1;
			repaint();
			Thread.sleep(50);
			x3 = x1-(20*a);
			y3 = y1;
			repaint();
			Thread.sleep(50);
			x4 = x1-(30*a);
			y4 = y1;
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void moveY(int a) {
		try {
			y1 = y1+b*a;
			if(y1 <= 30) {
				y1 = 30;
			} else if(y1 >= 440) {
				y1 = 440;
			}
			repaint();
			Thread.sleep(50);
			y2 = y1-(10*a);
			x2 = x1;
			repaint();
			Thread.sleep(50);
			y3 = y1-(20*a);
			x3 = x1;
			repaint();
			Thread.sleep(50);
			y4 = y1-(30*a);
			x4 = x1;
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		// TODO Auto-generated method stu
		switch(a) {
		case 1 : moveX(-1);break;
		case 2 : moveX(1);break;
		case 3 : moveY(-1);break;
		case 4 : moveY(1);break;
		}
	}
}
