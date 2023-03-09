package Gambling;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Select_money extends JFrame implements ActionListener{
	Label l = new Label("배팅 금액 선택",Label.CENTER);
	JButton m100 = new JButton("100원 게임");
	JButton m500 = new JButton("500원 게임");
	JButton m1000 = new JButton("1000원 게임");
	Select_money() {
		super.setSize(510, 200);
		super.setLayout(null);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		super.setIconImage(Sniffling.snifflingImg);
//		l.setFont(f);
		l.setBackground(Color.white);
		l.setBounds(200,10,100,50);
		m100.setBackground(Color.cyan);
		m100.setBounds(20,100,130,50);
		m500.setBackground(Color.ORANGE);
		m500.setBounds(180,100,130,50);
		m1000.setBackground(Color.green);
		m1000.setBounds(330,100,130,50);
		m100.setFocusPainted(false);
		m500.setFocusPainted(false);
		m1000.setFocusPainted(false);
		super.add(l);
		super.add(m100);
		super.add(m500);
		super.add(m1000);
		m100.addActionListener(this);
		m500.addActionListener(this);
		m1000.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == m100) {
			Sniffling.addMoney = 100;
			super.dispose();
			new Sniffling();
		} else if(e.getSource() == m500) {
			Sniffling.addMoney = 500;
			super.dispose();
			new Sniffling();
		} else if(e.getSource() == m1000) {
			Sniffling.addMoney = 1000;
			super.dispose();
			new Sniffling();
		}
	}
}
