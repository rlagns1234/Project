package Gambling;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
class Pw extends JFrame implements KeyListener, ActionListener {
	int money;
	JLabel lpwd;
	TextField tfPwd;
	JButton ok;
	JButton cancel;
	Pw(String title) {
		super(title);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		lpwd = new JLabel("Password :", JLabel.CENTER);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		super.setIconImage(Start.icon);
		getContentPane().setBackground(Color.black);
		lpwd.setForeground(Color.WHITE);
		ok = new JButton("확인");
		cancel = new JButton("취소");
		ok.setFocusPainted(false);cancel.setFocusPainted(false);
		ok.setBackground(Color.BLACK);
		cancel.setBackground(Color.BLACK);
		ok.setForeground(Color.WHITE);
		cancel.setForeground(Color.WHITE);
		tfPwd.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		getContentPane().setBackground(Color.black);
		setLayout(new FlowLayout());
		add(lpwd);
		add(tfPwd);
		add(ok);
		add(cancel);
		setSize(340, 80);
		setVisible(true);
	}

	public void add() {
		while (true) {
			String inputMoney = JOptionPane.showInputDialog(null, "충전 금액 입력.");
			if (inputMoney.matches("\\d*")) {
				money += Integer.parseInt(inputMoney);
				this.dispose();
				break;
			}
		}
		Start.money = this.money;
		Start.s.put();
	}
	
	public void approval() {
		String password = tfPwd.getText();
		if (!password.equals("GamblingDJ12!@")) {
			tfPwd.setText("");
		} else {
			add();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			approval();
		} else if (e.getSource() == cancel) {
			this.dispose();
		}
	}
	
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			approval();
		}
	}
	
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

}