package Gambling;

import java.util.Random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Sniffling extends JFrame implements ActionListener, Runnable{
	Random random = new Random();
	static Image snifflingImg = Toolkit.getDefaultToolkit().getImage("GamblingImage/Snifflingico.png");
	static int addMoney;
	int num = 0;
	Thread th;
	int a = 0;
	int n = 0;
	boolean S = false;
	int c[] = new int[] {
		0,0,0,0,0	
	};
	int[] sc = new int[] {
		0,0,0,0,0
	};
	ImageIcon bluec = new ImageIcon("GamblingImage/Blue.png");
	Image bco = bluec.getImage();
	ImageIcon redc = new ImageIcon("GamblingImage/Red.png");
	Image rco = redc.getImage();
	
	Image greyco = Toolkit.getDefaultToolkit().getImage("GamblingImage/Grey.png");
	Image blueco = Toolkit.getDefaultToolkit().getImage("GamblingImage/Blue.png");
	Image redco = Toolkit.getDefaultToolkit().getImage("GamblingImage/Red.png");
	Image greych = Toolkit.getDefaultToolkit().getImage("GamblingImage/Greycheck.png");
	Image bluech = Toolkit.getDefaultToolkit().getImage("GamblingImage/Bluecheck.png");
	Image redch = Toolkit.getDefaultToolkit().getImage("GamblingImage/Redcheck.png");
	
	JButton Blue = new JButton(new ImageIcon(bco.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH)));
	JButton Red = new JButton(new ImageIcon(rco.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH)));
	JButton start = new JButton("시작");
	JButton delect = new JButton("취소");
	
	int[] x = new int[] {160, 310, 460, 610, 760};
	
	Sniffling(){	
		super.setSize(1000, 600);
//		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setIconImage(snifflingImg);
		Blue.setBorderPainted(false);
		Blue.setContentAreaFilled(false);
//		Blue.setFocusPainted(false);
		Red.setBorderPainted(false); //윤곽선 없애기
		Red.setContentAreaFilled(false); //배경색 없애기
//		Red.setFocusPainted(false); //선택 테두리 없애기
		start.setFocusPainted(false);
		delect.setFocusPainted(false);
		start.setBackground(Color.ORANGE);
		delect.setBackground(Color.LIGHT_GRAY);
		start.setBounds(100, 400, 90, 60);
		delect.setBounds(750, 400, 90, 60);
		Blue.setBounds(350, 400, 90, 90);
		Red.setBounds(550,400, 90, 90);
		super.add(start);
		super.add(delect);
		super.add(Blue);
		super.add(Red);
		super.setVisible(true);
		Blue.addActionListener(this);
		Red.addActionListener(this);
		start.addActionListener(this);
		delect.addActionListener(this);
		th = new Thread(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("", Font.BOLD, 60));
		g.setColor(Color.BLUE);
		g.drawString("홀", 300, 485);
		g.setColor(Color.RED);
		g.drawString("짝", 640, 485);
		g.setColor(Color.yellow);
		g.setFont(new Font("", Font.BOLD, 80));
		g.drawString("【                              】", 80, 290);
		g.drawImage(greyco, 160,50, 60, 60, this );
		g.drawImage(greyco, 310,50, 60, 60, this );
		g.drawImage(greyco, 460,50, 60, 60, this );
		g.drawImage(greyco, 610,50, 60, 60, this );
		g.drawImage(greyco, 760,50, 60, 60, this );
		g.drawImage(greych, 160,230, 60, 60, this );
		g.drawImage(greyco, 310,230, 60, 60, this );
		g.drawImage(greyco, 460,230, 60, 60, this );
		g.drawImage(greyco, 610,230, 60, 60, this );
		g.drawImage(greyco, 760,230, 60, 60, this );
		
		if(c[0] == 1) {
			g.drawImage(blueco, 160,230, 60, 60, this );
			g.drawImage(greych, 310,230, 60, 60, this );
		} else if(c[0] == 2) {
			g.drawImage(redco, 160,230, 60, 60, this );
			g.drawImage(greych, 310,230, 60, 60, this );
		}
		
		if(c[1] == 1) {
			g.drawImage(blueco, 310,230, 60, 60, this );
			g.drawImage(greych, 460,230, 60, 60, this );
		} else if(c[1] == 2) {
			g.drawImage(redco, 310,230, 60, 60, this );
			g.drawImage(greych, 460,230, 60, 60, this );
		}
		
		if(c[2] == 1) {
			g.drawImage(blueco, 460,230, 60, 60, this );
			g.drawImage(greych, 610,230, 60, 60, this );
		} else if(c[2] == 2) {
			g.drawImage(redco, 460,230, 60, 60, this );
			g.drawImage(greych, 610,230, 60, 60, this );
		}
		
		if(c[3] == 1) {
			g.drawImage(blueco, 610,230, 60, 60, this );
			g.drawImage(greych, 760,230, 60, 60, this );
		} else if(c[3] == 2) {
			g.drawImage(redco, 610,230, 60, 60, this );
			g.drawImage(greych, 760,230, 60, 60, this );
		}
		
		if(c[4] == 1) {
			g.drawImage(bluech, 760,230, 60, 60, this );
		} else if(c[4] == 2) {
			g.drawImage(redch, 760,230, 60, 60, this );
		}
		
		if(sc[0] == 1) {
			g.drawImage(blueco, 160,50, 60, 60, this );
		} else if(sc[0] == 2) {
			g.drawImage(redco, 160,50, 60, 60, this );
		}
		
		if(sc[1] == 1) {
			g.drawImage(blueco, 310,50, 60, 60, this );
		} else if(sc[1] == 2) {
			g.drawImage(redco, 310,50, 60, 60, this );
		}
		
		if(sc[2] == 1) {
			g.drawImage(blueco, 460,50, 60, 60, this );
		} else if(sc[2] == 2) {
			g.drawImage(redco, 460,50, 60, 60, this );
		}
		
		if(sc[3] == 1) {
			g.drawImage(blueco, 610,50, 60, 60, this );
		} else if(sc[3] == 2) {
			g.drawImage(redco, 610,50, 60, 60, this );
		}
		
		if(sc[4] == 1) {
			g.drawImage(blueco, 760,50, 60, 60, this );
		} else if(sc[4] == 2) {
			g.drawImage(redco, 760,50, 60, 60, this );
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(num < 5) {
			if(e.getSource() == Blue) {
				repaint();
				c[num] = 1;
				num++;
			} else if(e.getSource() == Red) {
				repaint();
				c[num] = 2;
				num++;
			}
		}
		
		if(S == false) {
			if(e.getSource() == start) {
				S = true;
				th.start();
			} else if(e.getSource() == delect) {
				if(num > 0) {
					--num;
					c[num] = 0;
					repaint();
				}
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		if(num == 5) {
			for(int  k = 0; k < 5; k++) {
				int r = random.nextInt(2)+1;
				sc[k] = r;
				repaint();
				if(Start.money > 0) {
					if(c[k] == sc[k]) {
						Start.money += addMoney;
						a++;
					} else {
						Start.money -= addMoney;
						n++;
					}
				}
				try {
					th.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(Start.money < 0) {
				Start.money = 0;
			}
			Start.s.put();
			Start.g.put();
			JOptionPane.showMessageDialog(null, "맞춘 수 : "+a+"개(+"+(a*addMoney)+"원)\n틀린 수 : "+n+"개(-"+(n*addMoney)+"원)\n딴 금액 : "+((a-n)*addMoney)+"원");
			super.dispose();
		}
	}
}
