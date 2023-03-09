package Gambling;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener{
	Label l = new Label("보유 금액 : " + Start.money);
	Button b[] = new Button[] {
		new Button("소셜그래프"),
		new Button("UP&DOWN"),
		new Button("슬롯머신"),
		new Button("홀짝게임")};
	
	Game(){
		super.setSize(420, 420);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		super.setResizable(false);
		super.setIconImage(Start.icon);
		l.setBounds(155, 4, 500, 20);
		l.setFont(new Font("", Font.BOLD, 15));
		b[0].setBounds(34, 100, 120, 50);
		b[1].setBounds(250, 100, 120, 50);
		b[2].setBounds(34, 250, 120, 50);
		b[3].setBounds(250, 250, 120, 50);
		for(Button bt:b) {
			bt.setFont(new Font("", Font.BOLD, 20));
			bt.setBackground(Color.white);
			super.add(bt);
			bt.addActionListener(this);
		}
		super.add(l);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(Start.icon, 35, 55, 350, 350, this);
	}
	
	public void put() {
		super.remove(l);
		l = new Label("보유 금액 : "+Start.money);
		l.setBounds(155, 4, 500, 20);
		l.setFont(new Font("", Font.BOLD, 15));
		super.add(l);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b[0]) {
			if(Start.money >= 100) {
				new Grahpe(Start.money);
			} else {
				JOptionPane.showMessageDialog(null, "소셜그래프는 보유액이 100원 이상이어야 진행이 가능합니다.\n현재 보유액 : "+Start.money);
			}
		} else if(e.getSource() == b[1]) {
			if(Start.money >= 100) {
				while(true) {
					String bettingMoney = JOptionPane.showInputDialog(null,"배팅 금액을 입력해 주세요.");
					if(bettingMoney.matches("\\d+0{2,}") && Integer.parseInt(bettingMoney) <= Start.money) {
						new UpDown((int)Integer.parseInt(bettingMoney));
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "UP&DOWN 게임은 보유액이 100원 이상이어야 진행이 가능합니다.\n현재 보유액 : "+Start.money);
			}
		} else if(e.getSource() == b[2]) {
			new Slot();
		} else if(e.getSource() == b[3]) {
			if(Start.money >= 500) {
				new Select_money();
			} else {
				JOptionPane.showMessageDialog(null, "홀짝 게임은 보유액이 500원 이상이어야 진행이 가능합니다.\n현재 보유액 : "+Start.money);
			}
		}
		
	}
	
}
