package Gambling;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class UpDown extends JFrame implements ActionListener, Runnable{
	Thread th;
	Random random = new Random();
	int cardboxselect = random.nextInt(4);
	int bluecardselect = random.nextInt(10);
	int redcardselect = random.nextInt(10);
	int money;
	boolean UPDOWN;
	boolean bcopen = false;
	boolean bcremove = false;
	boolean rcopen = false;
	boolean click = false;
	Image UpDownimg = Toolkit.getDefaultToolkit().getImage("GamblingImage/card.png");
	Image spade[] = new Image[] {
		Toolkit.getDefaultToolkit().getImage("GamblingImage/sA.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s2.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s3.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s4.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s5.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s6.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s7.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s8.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s9.png"),
		Toolkit.getDefaultToolkit().getImage("GamblingImage/s10.png")
	};
	Image clover[] = new Image[] {
			Toolkit.getDefaultToolkit().getImage("GamblingImage/cA.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c2.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c3.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c4.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c5.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c6.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c7.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c8.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c9.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/c10.png")
	};
	Image heart[] = new Image[] {
			Toolkit.getDefaultToolkit().getImage("GamblingImage/hA.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h2.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h3.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h4.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h5.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h6.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h7.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h8.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h9.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/h10.png")
	};
	Image Diamond[] = new Image[] {
			Toolkit.getDefaultToolkit().getImage("GamblingImage/dA.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d2.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d3.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d4.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d5.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d6.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d7.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d8.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d9.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/d10.png")
	};
	
	ArrayList<Image[]> cardList = new ArrayList<>();
	
	Image cardbox[];
	Image bci;
	Image rci;
	
	ImageIcon background = new ImageIcon("GamblingImage/background.png");
	Image back = background.getImage();
	ImageIcon bgimg = new ImageIcon(back.getScaledInstance(1200, 800,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon UPDOWN_UP = new ImageIcon("GamblingImage/UP.png");
	Image updown_up = UPDOWN_UP.getImage();
	ImageIcon UP = new ImageIcon(updown_up.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon UPDOWN_UP_CLICK = new ImageIcon("GamblingImage/UPclick.png");
	Image updown_up_click = UPDOWN_UP_CLICK.getImage();
	ImageIcon UP_CLICK = new ImageIcon(updown_up_click.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon UPDOWN_DOWN = new ImageIcon("GamblingImage/DOWN.png");
	Image updown_down = UPDOWN_DOWN.getImage();
	ImageIcon DOWN = new ImageIcon(updown_down.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon UPDOWN_DOWN_CLICK = new ImageIcon("GamblingImage/DOWNclick.png");
	Image updown_down_click = UPDOWN_DOWN_CLICK.getImage();
	ImageIcon DOWN_CLICK = new ImageIcon(updown_down_click.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon CARD_OPEN = new ImageIcon("GamblingImage/open.png");
	Image card_open = CARD_OPEN.getImage();
	ImageIcon CO = new ImageIcon(card_open.getScaledInstance(200, 80,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon CARD_OPEN_CLICK = new ImageIcon("GamblingImage/openclick.png");
	Image card_open_click = CARD_OPEN_CLICK.getImage();
	ImageIcon CO_CLICK = new ImageIcon(card_open_click.getScaledInstance(200, 80,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon BLUE_CARD = new ImageIcon("GamblingImage/cardblue.png");
	Image blue_card = BLUE_CARD.getImage();
	ImageIcon bluecard = new ImageIcon(blue_card.getScaledInstance(120, 180,  java.awt.Image.SCALE_SMOOTH));
	
	JLabel bg = new JLabel(bgimg);
	JButton up = new JButton(UP);
	JButton down = new JButton(DOWN);
	JButton co = new JButton(CO);
	JButton bc = new JButton(bluecard);
	
	
	UpDown(int m){
		money = m;
		cardList.add(spade);
		cardList.add(clover);
		cardList.add(heart);
		cardList.add(Diamond);
		cardbox = cardList.get(cardboxselect);
		bci = cardbox[bluecardselect];
		rci = cardbox[redcardselect];
		ImageIcon BLUE_CARD_ICON = new ImageIcon(bci);
		Image blue_card_icon = BLUE_CARD_ICON.getImage();
		ImageIcon bco = new ImageIcon(blue_card_icon.getScaledInstance(120, 180,  java.awt.Image.SCALE_SMOOTH));
		super.setIconImage(UpDownimg);
		super.setSize(1200, 800);
		super.setLayout(null);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		up.setPressedIcon(UP_CLICK);
		down.setPressedIcon(DOWN_CLICK);
		co.setPressedIcon(CO_CLICK);
		bc.setPressedIcon(bco);
		up.setBorderPainted(false);
		up.setContentAreaFilled(false);
		up.setFocusPainted(false);
		down.setBorderPainted(false);
		down.setContentAreaFilled(false);
		down.setFocusPainted(false);
		co.setBorderPainted(false);
		co.setContentAreaFilled(false);
		bc.setBorderPainted(false);
		bc.setContentAreaFilled(false);
		bc.setFocusPainted(false);
		bg.setBounds(0, 0, 1200, 800);
		up.setBounds(100, 210, 120, 150);
		down.setBounds(100, 390, 120, 150);
		co.setBounds(950, 325, 200, 80);
		bc.setBounds(550, 100, 120, 180);
		add(up);
		add(down);
		add(co);
		add(bc);
		add(bg);
		up.addActionListener(this);
		down.addActionListener(this);
		co.addActionListener(this);
		bc.addActionListener(this);
		th = new Thread(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("GamblingImage/cardred.png"), 510, 350, 200, 300, this);
		if(bcremove == true) {
			g.drawImage(bci, 553, 126, 120, 180, this);
		}
		if(rcopen == true) {
			g.drawImage(rci, 510, 350, 200, 300, this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == up) {
			UPDOWN = true;
			click = true;
		} else if(e.getSource() == down) {
			UPDOWN = false;
			click = true;
		} else if(e.getSource() == bc) {
			bcopen = true;
		} else if(e.getSource() == co) {
			if(click == true) {
				remove(up);
				remove(down);
				remove(co);
				repaint();
				th.start();
			}
		}
	}
	
	public void opencard() {
		if(redcardselect == bluecardselect) {
			money = -money;
		} else if(UPDOWN == true) { //up
			open(true);
		} else if(UPDOWN == false) { //down
			open(false);
		}
		Start.money+=money;
		if(Start.money < 0) {
			Start.money = 0;
		}
		Start.s.put();
		Start.g.put();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dispose();
	}
	
	public boolean open(boolean ud) {
		boolean ox = false;
		boolean cp = compare();
		if(ud == cp) {
			check(true);
		} else {
			check(false);
		}
		return ox;
	}
	
	public boolean compare() {
		boolean result = false;
		if(redcardselect > bluecardselect) { //up
			result = true;
		} else if(redcardselect < bluecardselect) { //down
			result = false;
		}
		return result;
	}
	
	public void check(boolean ox) {
		double m = 0.0;
		double mn = 0.0;
		
		if(bcopen == true) {
			m = 0.1;
			mn = -2.0;
		} else {
			m = 0.5;
			mn = -1;
		}
		
		if(ox == true) {
			money*=m;
		} else {
			money*=mn;
		}
	}

	@SuppressWarnings("static-access")
	public void run() {
		try {
			remove(bc);
			bcremove = true;
			th.sleep(200);
			repaint();
			th.sleep(1000);
			rcopen = true;
			repaint();
			opencard();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
