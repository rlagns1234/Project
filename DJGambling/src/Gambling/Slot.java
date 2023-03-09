package Gambling;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Slot extends JFrame implements ActionListener, Runnable {
	Thread th;
	int money;
	int chip;
	Random random = new Random();
	int first;
	int second;
	int third;
	boolean start= false;
	static boolean setting = false;
	
	ImageIcon background = new ImageIcon("GamblingImage/SlotMachine.jpg");
	Image back = background.getImage();
	ImageIcon bgimg = new ImageIcon(back.getScaledInstance(975, 673,  java.awt.Image.SCALE_SMOOTH));
	JLabel bg = new JLabel(bgimg);
	
	ImageIcon ChipAdd = new ImageIcon("GamblingImage/ChipAdd.jpg");
	Image chipadd = ChipAdd.getImage();
	ImageIcon caimg = new ImageIcon(chipadd.getScaledInstance(200, 70,  java.awt.Image.SCALE_SMOOTH));
	JButton ca = new JButton(caimg);
	
	ImageIcon ChipAddClick = new ImageIcon("GamblingImage/addclick.png");
	Image chipaddclick = ChipAddClick.getImage();
	ImageIcon cacimg = new ImageIcon(chipaddclick.getScaledInstance(200, 70,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon StartButton = new ImageIcon("GamblingImage/StartButton.jpg");
	Image startbutton = StartButton.getImage();
	ImageIcon sbimg = new ImageIcon(startbutton.getScaledInstance(200, 100,  java.awt.Image.SCALE_SMOOTH));
	JButton st = new JButton(sbimg);
	
	ImageIcon StartButtonClick = new ImageIcon("GamblingImage/stclick.png");
	Image startbuttonclick = StartButtonClick.getImage();
	ImageIcon stcimg = new ImageIcon(startbuttonclick.getScaledInstance(200, 100,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon settingsImage = new ImageIcon("GamblingImage/Settings.png");
	Image settingsimage = settingsImage.getImage();
	ImageIcon setimg = new ImageIcon(settingsimage.getScaledInstance(200, 70,  java.awt.Image.SCALE_SMOOTH));
	JButton set = new JButton(setimg);
	
	ImageIcon settingsImageClick = new ImageIcon("GamblingImage/Settingsclick.png");
	Image settingsimageclick = settingsImageClick.getImage();
	ImageIcon setc = new ImageIcon(settingsimage.getScaledInstance(200, 70,  java.awt.Image.SCALE_SMOOTH));
	
	static Image chipImg = Toolkit.getDefaultToolkit().getImage("GamblingImage/chip.png");
	
	Image chipBox[] = new Image[] {
			Toolkit.getDefaultToolkit().getImage("GamblingImage/RedChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/OrangeChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/YellowChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/GreenChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/BlueChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/DeepblueChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/PurpleChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/GrayChip.png"),
			Toolkit.getDefaultToolkit().getImage("GamblingImage/BlackChip.png")
	};
	
	Slot() {
		super.setIconImage(chipImg);
		super.setLocation(500, 200);
		super.setSize(980, 700);
		super.setLayout(null);
		super.setResizable(false);
		super.setVisible(true);
		st.setPressedIcon(stcimg);
		ca.setPressedIcon(cacimg);
		set.setPressedIcon(setc);
		st.setBorderPainted(false);
		st.setContentAreaFilled(false);
		st.setFocusPainted(false);
		ca.setBorderPainted(false);
		ca.setContentAreaFilled(false);
		ca.setFocusPainted(false);
		set.setBorderPainted(false);
		set.setContentAreaFilled(false);
		set.setFocusPainted(false);
		bg.setBounds(0, 0, 975, 673);
		st.setBounds(400, 520, 200, 100);
		ca.setBounds(670, 435, 200, 100);
		set.setBounds(670, 520, 200, 100);
		add(st);
		add(ca);
		add(set);
		add(bg);
		st.addActionListener(this);
		ca.addActionListener(this);
		set.addActionListener(this);
		th = new Thread(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.setFont(new Font("", Font.BOLD, 40));
		g.drawString(money+"", 210, 525);
		if(start == true) {
			g.drawImage(chipBox[first], 95, 170, 200, 200, this);
			g.drawImage(chipBox[second], 393, 170, 200, 200, this);
			g.drawImage(chipBox[third], 688, 170, 200, 200, this);
		} else {
			g.drawImage(chipImg, 95, 170, 200, 200, this);
			g.drawImage(chipImg, 393, 170, 200, 200, this);
			g.drawImage(chipImg, 688, 170, 200, 200, this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ca) {
			while(true) {
				String bettingMoney = JOptionPane.showInputDialog(null,"���� �ݾ��� �Է��� �ּ���.");
				if(bettingMoney.matches("\\d+0{2,}") && Integer.parseInt(bettingMoney) <= Start.money) {
					money = (int)Integer.parseInt(bettingMoney);
					repaint();
					break;
				}
			}
		} else if(e.getSource() == st) {
			if(setting == true) {
				while(true) {
					String bettingMoney = JOptionPane.showInputDialog(null,"���� �Է� 1~9");
					if(bettingMoney.matches("\\d{1}") && Integer.parseInt(bettingMoney) <= money) {
						chip = (int)Integer.parseInt(bettingMoney);
						start = true;
						th.start();
						break;
					}
				}
			} else {
				start = true;
				th.start();
			}
		} else if(e.getSource() == set) {
			new Settings();
		}
	}
	

	@SuppressWarnings("static-access")
	public void run() {
		try {
			for(int i = 0; i < 40; i++) {
				if(i >= 20 && i < 30) {
					second = random.nextInt(9);
					third = random.nextInt(9);
				} else if(i >= 30) {
					third = random.nextInt(9);
				} else {
					first = random.nextInt(9);
					second = random.nextInt(9);
					third = random.nextInt(9);
				}
				repaint();
				th.sleep(100);
			}
			
			if(first == second && second == third) {
				if(setting == true && chip-1 == first) {
					Start.money += money*9;
					JOptionPane.showMessageDialog(null, "���� ���� : "+(chip)+"\n�� �ݾ� : "+money+"x10 = "+money*10);
				} else if(setting == false){
					Start.money += money*4;
					JOptionPane.showMessageDialog(null, "\n�� �ݾ� : "+money+"x5 = "+money*5);
				} else {
					Start.money -= money;
					JOptionPane.showMessageDialog(null, "\n�� �ݾ� : "+money+"x0 = "+money*0);
				}
			} else if((first == second || second == third) || first == third) {
				if(setting == true && ((chip-1 == first&& chip-1 == second) || (chip-1 == second&& chip-1 == third) || (chip-1 == first&& chip-1 == third))) {
					Start.money += money*4;
					JOptionPane.showMessageDialog(null, "���� ���� : "+(chip)+"\n�� �ݾ� : "+money+"x5 = "+money*5);
				} else if(setting == false){
					Start.money += money;
					JOptionPane.showMessageDialog(null, "\n�� �ݾ� : "+money+"x2 = "+money);
				} else {
					Start.money -= money;
					JOptionPane.showMessageDialog(null, "\n�� �ݾ� : "+money+"x0 = "+money*0);
				}
			} else {
				Start.money -= money;
				JOptionPane.showMessageDialog(null, "\n�� �ݾ� : "+money+"x0 = "+money*0);
			}
			Start.s.put();
			Start.g.put();
			dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
