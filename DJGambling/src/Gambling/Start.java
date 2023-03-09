package Gambling;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class Start extends JFrame implements ActionListener {
	boolean charge = false;
	static int money;
	static Start s;
	static Game g;
	static Image main = Toolkit.getDefaultToolkit().getImage("GamblingImage/main.jpg");
	static Image icon = Toolkit.getDefaultToolkit().getImage("GamblingImage/1570634146344.png");
	DecimalFormat form = new DecimalFormat("#");
	Button b1 = new Button("시작");
	Button b2 = new Button("환전");
	Button b3 = new Button("충전");
	Label l = new Label();
	static Label l1 = new Label("보유 금액 : " + money);

	Start(int m) {
		super.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setIconImage(icon);
		l1.setFont(new Font("", Font.BOLD, 15));
		b1.setFont(new Font("", Font.BOLD, 15));
		b2.setFont(new Font("", Font.BOLD, 15));
		b3.setFont(new Font("", Font.BOLD, 15));
		l.setBounds(120, 0, 1000, 4);
		l.setBackground(Color.black);
		l1.setBackground(Color.black);
		l1.setForeground(Color.WHITE);
		l1.setBounds(190, 4, 1000, 20);
		b1.setBackground(Color.gray);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.gray);
		b2.setForeground(Color.WHITE);
		b3.setBackground(Color.gray);
		b3.setForeground(Color.WHITE);
		b1.setBounds(30, 150, 100, 50);
		b2.setBounds(190, 150, 100, 50);
		b3.setBounds(350, 150, 100, 50);
		super.add(l);
		super.add(l1);
		super.add(b1);
		super.add(b2);
		super.add(b3);
		super.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(main, 0, 10, 500, 300, this);
	}
	
	public static void main(String[] args) {
		s = new Start(0);
	}
	
	public void put() {
		super.remove(l1);
		l1 = new Label("보유 금액 : "+money);
		l1.setFont(new Font("", Font.BOLD, 15));
		l1.setBackground(Color.black);
		l1.setForeground(Color.WHITE);
		l1.setBounds(190, 4, 1000, 20);
		super.add(l1);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			g = new Game();
		} else if (e.getSource() == b2) {
			int result = JOptionPane.showConfirmDialog(null,
					"환전을 진행하시면 현재 데이터는 전부 사라집니다. 진행 하시겠습니까?\n현재 금액 : "+money+"\n환전 가능 금액 : " + (money/100)*100 + "원", "환전",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == 0) {
				money = 0;
				JOptionPane.showMessageDialog(null, "환전 금액 : " + (money/100)*100 + "원\n딜러를 불러 환전하십시오.\n(현재 창을 닫지 마세요.)");
				this.dispose();
				put();
				s = new Start(0);
			}
		} else if (e.getSource() == b3) {
			Pw pw = new Pw("비밀번호 입력");
			pw.money = money;
		}
	}
}
