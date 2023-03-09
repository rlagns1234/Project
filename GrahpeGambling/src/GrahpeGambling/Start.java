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
	Button b1 = new Button("����");
	Button b2 = new Button("ȯ��");
	Button b3 = new Button("����");

	Start(int money) {
		this.money = money;
		Label l1 = new Label("���� �ݾ� : " + money);
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
					"ȯ���� �����Ͻø� ���� �����ʹ� ���� ������ϴ�. ���� �Ͻðڽ��ϱ�?\n���� �ݾ� : "+money+"\nȯ�� ���� �ݾ� : " + (money/100)*100 + "��", "ȯ��",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == 0) {
				JOptionPane.showMessageDialog(null, "ȯ�� �ݾ� : " + (money/100)*100 + "��\n������ �ҷ� ȯ���Ͻʽÿ�.\n(���� â�� ���� ������.)");
				this.dispose();
				new Start(0);
				money = 0;
			}
		} else if (e.getSource() == b3) {
			Pw pw = new Pw("��й�ȣ �Է�");
			pw.money = money;
			this.dispose();
		}
	}
}
