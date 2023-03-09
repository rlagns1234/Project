package GrahpeGambling;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class Start extends JFrame implements ActionListener {
	boolean charge = false;
	int money;
	DecimalFormat form = new DecimalFormat("#");
	Button b1 = new Button("시작");
	Button b2 = new Button("환전");
	Button b3 = new Button("충전");

	Start(int money) {
		this.money = money;
		Label l1 = new Label("보유 금액 : " + money);
		super.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		l1.setBounds(200, 10, 400, 100);
		b1.setBounds(30, 150, 100, 50);
		b2.setBounds(190, 150, 100, 50);
		b3.setBounds(350, 150, 100, 50);
		super.add(l1);
		super.add(b1);
		super.add(b2);
		super.add(b3);
		super.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	public static void main(String[] args) {
		start(0);
	}
	
	public static void start(int inputMoney) {
		new Start(inputMoney);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			new Grahpe(money);
			this.dispose();
		} else if (e.getSource() == b2) {
			int result = JOptionPane.showConfirmDialog(null,
					"환전을 진행하시면 현재 데이터는 전부 사라집니다. 진행 하시겠습니까?\n현재 금액 : "+money+"\n환전 가능 금액 : " + (money/100)*100 + "원", "환전",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == 0) {
				JOptionPane.showMessageDialog(null, "환전 금액 : " + (money/100)*100 + "원\n딜러를 불러 환전하십시오.\n(현재 창을 닫지 마세요.)");
				this.dispose();
				new Start(0);
				money = 0;
			}
		} else if (e.getSource() == b3) {
			Pw pw = new Pw("비밀번호 입력");
			pw.money = money;
			this.dispose();
		}
	}
}
