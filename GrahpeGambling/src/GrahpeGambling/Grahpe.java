package GrahpeGambling;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.Random;

@SuppressWarnings("serial")
public class Grahpe extends JFrame implements KeyListener, Runnable{
	private static final int GM_THR_OUT_RATE = 150;
	Thread th;
	DecimalFormat form = new DecimalFormat("#.##");
	DecimalFormat form2 = new DecimalFormat("#");
	Random rPlay = new Random();
	Random rStop = new Random();
	boolean stop = false;
	boolean dead = false;
	double num = 1;
	double num2;
	double startingMoney;
	double finalMoney;
	int money;
	int j = 0;
	int x1 = 0;
	int y1 = 490;
	int b = 0;
	int grahpe[] = new int[10000000];

	Grahpe(int money){
		this.money = money;
		while(true) {
			String bettingMoney = JOptionPane.showInputDialog(null,"배팅 금액을 입력해 주세요.");
			if(bettingMoney.matches("\\d+0{2,}") && Integer.parseInt(bettingMoney) <= money) {
				startingMoney = Integer.parseInt(bettingMoney);
				break;
			}
		}
//		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(Color.black);
		super.setVisible(true);
		super.addKeyListener(this);
		super.setLocationRelativeTo(null);
		th = new Thread(this);
		th.start();
		for(int q = 0; q < grahpe.length/2; q+=2) {
			grahpe[q] = x1+b;
			grahpe[q+1] = y1-b;
			b+=1;
		}
		
		for(int q = 3; q < grahpe.length/2; q+=2) {
			int rP = rPlay.nextInt(2);
			grahpe[q] = grahpe[q-2]-rP;
		}	
	}
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(dead) {
			th.stop();
			if(! stop) {
				num2 = 0.0;
			}
			finalMoney = num2 * startingMoney;
			JOptionPane.showMessageDialog(null, "최종 배수 : " + form.format(num) + "\n정지한 배수 : "+form.format(num2)+"\n배팅 금액 : "+(int)startingMoney+"\n딴 금액 : "+form2.format(finalMoney));
			this.dispose();
			Start.start((money-(int)startingMoney)+(int)finalMoney);
		}
		if(! stop) {
			g.setColor(Color.green);
			num2 = Math.round(num*100)*0.01;
		} else {
			g.setColor(Color.GRAY);
		}
		for(int i = 0; i < j; i += 2) {
			g.fillOval(grahpe[i], grahpe[i+1], 10, 10);
			g.setFont(new Font("", Font.BOLD, 50));
			g.drawString(""+form.format(num += 0.0001), 100, 200);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE || arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			stop = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public void run() {
		while(true) {
			int rS = rStop.nextInt(GM_THR_OUT_RATE);
			int rs = rStop.nextInt(GM_THR_OUT_RATE);
			j += 2;
			repaint();
			try {
				if(rS == rs) {
					if(num > 1.01) {
						dead = true;
					}
				} else {
					Thread.sleep(60);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
