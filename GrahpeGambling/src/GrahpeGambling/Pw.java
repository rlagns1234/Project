package GrahpeGambling;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Pw extends JFrame implements ActionListener {
	int money;
	Label lpwd;
	TextField tfPwd;
	Button ok;
	Button cancel;

	Pw(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.setLocationRelativeTo(null);
		lpwd = new Label("Password :", Label.CENTER);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');

		ok = new Button("확인");
		cancel = new Button("취소");
		tfPwd.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);

		setLayout(new FlowLayout());
		add(lpwd);
		add(tfPwd);
		add(ok);
		add(cancel);
		setSize(300, 70);
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
		Start.start(money);
	}
	
	public void approval() {
		String password = tfPwd.getText();
		if (!password.equals("1805")) {
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
			Start.start(money);
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