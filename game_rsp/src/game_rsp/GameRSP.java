package game_rsp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.Random;

@SuppressWarnings("serial")
public class GameRSP extends JFrame implements ActionListener, Runnable{
	JButton r;	//���� ��ư
	JButton s;	//���� ��ư
	JButton p;	//�� ��ư
	JButton player;	//�÷��̾� ��ư
	JButton cpu;	//��ǻ�� ��ư
	JLabel pl = new JLabel("�÷��̾�");	//�÷��̾� �ؽ�Ʈ
	JLabel cl = new JLabel("��ǻ��");	//��ǻ�� �ؽ�Ʈ
	JLabel vs = new JLabel("0�� 0�� 0��");	//��ǻ�� �ؽ�Ʈ
	int pn;	//�÷��̾��� ����, ����, �� ������  (0 == ����, 1 == ����, 2 == ��)
	int cn;	//���� ����, ����, �� ������
	int loop = 0;	//��ǻ�� ������ ���ϴ� ���� ����ġ
	int count_p;	//�÷��̾��� �¸� Ƚ��
	int count_c;	//���� �¸� Ƚ��
	ImageIcon ic[] = {new ImageIcon("sci.jpg"), new ImageIcon("rock.jpg"), new ImageIcon("paper.jpg")};	//�̹��� ������
	int w, e, l;

	public GameRSP() {
		super("���������� ����");	//Ÿ��Ʋ ����
		setSize(300, 300);	//������ â ũ�� ���� 300x300
		setLocationRelativeTo(null); //������ â ���� ��ġ �׻� �߾�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//������â ���� �� �ְ� ����
		setLayout(null);	//���̾ƿ� Ư���� ���� ����
		
		//��ư ����
		r = new JButton(ic[1]);
		s = new JButton(ic[0]);
		p = new JButton(ic[2]);
		player = new JButton();
		cpu = new JButton();
		
		//��ư ��ġ�� ũ�� ����
		r.setBounds(105, 10, 75, 75);	
		s.setBounds(10, 10, 75, 75);
		p.setBounds(200, 10, 75, 75);
		player.setBounds(40, 130, 75, 75);
		cpu.setBounds(170, 130, 75, 75);
		player.setBackground(new Color(150,150,200));
		cpu.setBackground(new Color(220,150,150));
		
		//���̺� ��ġ�� ũ�� ����
		pl.setBounds(55, 110, 50, 20);
		cl.setBounds(190, 110, 50, 20);
		vs.setBounds(110, 225, 100, 20);
		
		//������ â�� ��ü �߰�
		add(r);	
		add(s);
		add(p);
		add(player);
		add(cpu);
		add(pl);
		add(cl);
		add(vs);
		
		//��ư �̺�Ʈ Ȱ��ȭ
		r.addActionListener(this);
		s.addActionListener(this);
		p.addActionListener(this);
		
		setVisible(true);	//������ â ����ȭ
		
		run();
	}

	public static void main(String[] args) {
		new GameRSP();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Ŭ�� �� ��ư�� �´� �̹����� ������ �ٲٱ�
		if(e.getSource() == s) {
			pn = 0;
			player.setIcon(ic[0]);
		} else if(e.getSource() == r) {
			pn = 1;
			player.setIcon(ic[1]);
		} else if(e.getSource() == p) {
			pn = 2;
			player.setIcon(ic[2]);
		}

		loop = 1;
	}
	
	//��ǻ�� ����, ����, �� ���� ���� �޼ҵ�
	private void cpu() {
		Random r = new Random();
		int n = r.nextInt(3);	//���� ����
		cn = n;	//��ǻ�� ����, ����, �� �� ����
		//���� ���� �˸´� ������� �ٲٱ�
		if(n == 0) {
			cpu.setIcon(ic[0]);
		} else if(n == 1) {
			cpu.setIcon(ic[1]);
		} else if(n == 2) {
			cpu.setIcon(ic[2]);
		}
	}
	
	//���� �ǵ� �޼ҵ�
	private void winner() {
		if(cn == pn) {	//���� ���ڰ� �Ȱ��ٸ�
			JOptionPane.showMessageDialog(null, "�����ϴ�");
			e++;//////////////////////////////////���� ����
			//���� ����, ���� ���� ��� �ܿ� ���� ���� �� ������ �۰ų� ���� ��, ���� ������ ��� (���� = 0, �� = 2)
		} else if((!(pn == 0 && cn == 2) && (pn < cn)) || (pn == 2 && cn == 0)) {
			JOptionPane.showMessageDialog(null, "�����ϴ�");
		} else {	// �� ��
			JOptionPane.showMessageDialog(null, "�̰���ϴ�");
		}
		//�÷��̾�, ��ǻ�� ������ ����
		player.setIcon(new ImageIcon());
		cpu.setIcon(new ImageIcon());
		//�÷��̾�, ��ǻ���� ��ư ���� ����
		player.setBackground(new Color(150,150,200));
		cpu.setBackground(new Color(220,150,150));
		loop = 1; //���� ����
	}
	
	private void change() {
		int a = 0;	//�̹��� �迭 ��ġ ���尪
		for(int i = 0; i < 12; i++) {
			a++;
			//a�� 2���� Ŭ �� 0���� ����
			if(a > 2) {
				a = 0;
			}
			
			try {
				cpu.setIcon(ic[a]);	//�̹��� ����
				Thread.sleep(100);	//0.1�� ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			System.out.print("");	//�� �� ��� ���� ������ ������ �ȵǳ�?
			if(loop == 1) {
				change();	//�̹��� 1.2�ʵ��� ��� ���� 
				cpu();	//�� ����, ����, �� ����
				winner();	//���� �ǵ�
				loop = 0;	//���� ����
			}
		}
	}

}
