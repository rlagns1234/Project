package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import java.awt.Dialog;


public class DongGame extends JFrame implements KeyListener, Runnable{
	int myx=230,myy=450;
	int dongx[]=new int[100];
	int dongy[]=new int[100];
	int dongh[]=new int[100];
	int count=5;
	Random r=new Random();
	Thread th;
	int sw=1;
	int score=0;
	Image img,jol,jol1;
	int bb=1;
	DongGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setResizable(false);
		super.setLocation(600, 300);
		super.setSize(500, 500);
		super.setTitle("똥피하기");
		getContentPane().setBackground(Color.white);
		super.setVisible(true);
		img=Toolkit.getDefaultToolkit().getImage("imges/back.jpg");
		jol=Toolkit.getDefaultToolkit().getImage("imges/jol2.png");
		jol1=Toolkit.getDefaultToolkit().getImage("imges/jol11.png");
		super.addKeyListener(this);
		th= new Thread(this);
		th.start();
		for (int i = 0; i < count; i++) {

			dongx[i] = r.nextInt(super.getWidth() - 60);
			dongy[i] = -10;
			dongh[i] = r.nextInt(50)+10;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DongGame();
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(img, 0, 0, 500, 500,this);
		if(bb==1) {
		g.drawImage(jol,myx, myy, 40, 50,this);
		}
		else if(bb==0) {
			g.drawImage(jol1,myx, myy, 50, 40,this);	
		}
		//g.fillRect(myx, myy, 30, 20);
		g.setColor(Color.RED);
		for(int i=0;i<count;i++) {
		g.fillOval(dongx[i], dongy[i], 20, 20);
		
		}
		g.setColor(Color.BLUE);
		g.drawString("점수 : "+score, 400, 50);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (bb == 1) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				myx = myx + 20;
				if (myx >= super.getWidth() - 60) {
					myx = super.getWidth() - 60;
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				myx = myx - 20;
				if (myx <= 10) {
					myx = 10;
				}
			}
			for (int i = 0; i < count; i++) {
				if(Math.abs(dongx[i]-myx)<=30 && bb==1) {
					if(Math.abs(dongy[i]-myy)<=20) {
						//th.stop();
						bb=0;
					}
					
				}
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(sw==1) {
			try {
				for (int i = 0; i < count; i++) {
					if(Math.abs(dongx[i]-myx)<=30 ) {
						if(Math.abs(dongy[i]-myy)<=20) {
							if(bb==1) {
							//th.stop();
							bb=0;
							}
						}
						
					}
					dongy[i] = dongy[i]+dongh[i];
					if(dongy[i]>=super.getHeight()) {
						if( bb==1) {
						score=score+10;
						}
						if(score%100==0) {
							count++;
							dongx[count-1] = r.nextInt(super.getWidth() - 60);
							dongy[count-1] = -10;
							dongh[count-1] = r.nextInt(50)+10;
						}
						dongx[i] = r.nextInt(super.getWidth() - 60);
						dongy[i] = -10;
						dongh[i] = r.nextInt(50)+10;
					}
				}
				
				
				
				
				th.sleep(300);
				repaint();
				if(bb == 0) {
					th.stop();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
