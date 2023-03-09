import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Play extends JFrame implements ActionListener, ItemListener{
	int mn;
	boolean select = true;
	Choice ch = new Choice();
	LinkedList<String> M = new LinkedList<>();
	LinkedList<String> D = new LinkedList<>();
	LinkedList<JButton> B = new LinkedList<>();
	ArrayList<String> user = new ArrayList<>();
	ArrayList<String> draw = new ArrayList<>();
	Random r = new Random();
	
	int[] xList = new int[Main.dn];
	int[] yList = new int[Main.dn];
	
	//�̹��� �غ�
	ImageIcon Image = new ImageIcon("DrawImg/D.png");
	Image IMG = Image.getImage();
	ImageIcon img = new ImageIcon(IMG.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH));
	
	JLabel bg = new JLabel(new ImageIcon(new ImageIcon("DrawImg/maru.gif").getImage().getScaledInstance(1200, 800,  java.awt.Image.SCALE_SMOOTH)));
	Play(LinkedList<String> m, LinkedList<String> d){
		super("����̱�");
		super.setSize(1200, 800);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		M.addAll(m);
		D.addAll(d);
		mn = 0;
		
		//���� ����Ʈ
		for(String i : M) {
			ch.add(i);
		}
		ch.setFont(new Font("�������", Font.BOLD, 30));
		ch.setBounds(10, 10, 150, 100);
		ch.addItemListener(this);
		super.add(ch);
		
		//���� (���� ũ��� 100)
		for(int i = 0; i < D.size(); i++) {
			B.add(new JButton(img));
			B.get(i).setBorderPainted(false);
			B.get(i).setContentAreaFilled(false);
			B.get(i).setFocusPainted(false);
			B.get(i).addActionListener(this);
		}
		shuffle(B);
		
		//���
		bg.setBounds(0, 0, 1200, 800);
		super.add(bg);
		
		super.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//���� ���� ���� �׸���
		for(int i = 0; i < xList.length; i++) {
			g.setColor(Color.white);
			g.setFont(new Font("", Font.BOLD, 50));
			g.drawString(i+1+"",  xList[i]+45, yList[i]+20);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(ch.getSelectedIndex() > -1) {
			if(B.contains(e.getSource())){
				int rDraw = r.nextInt(D.size());
				int index = -1;
				//���õ� ������ ��ȣ�� ������� ���ϱ�
				for(JButton j : B) {
					if (j.equals(e.getSource())) {
						index = B.indexOf(j);
					}
				}
				//���â �� ������ ����
				user.add(ch.getItem(ch.getSelectedIndex()));
				draw.add(D.get(rDraw));
				mn++;
				//�˾�â ����
				new DrawPanel(D.get(rDraw), user, draw, mn);
				//choice ����Ʈ���� ����, ��ư ����Ʈ���� ����, ��ȣ ��ǥ -�μ����Ͽ� ȭ��� ����, ��ư ����
				ch.remove(ch.getSelectedIndex());
				D.remove(rDraw);
				B.get(index).setVisible(false);
				xList[index] = -500;
				yList[index] = -500;
				repaint();
				super.remove(B.get(index));
				if(mn == Main.mn) {
					this.dispose();
				}
			}
		}
	}
	
	//���� ���� �Լ� ����
	private void shuffle(LinkedList<JButton> B) {
		int n = 0;
		boolean t = true;//�ߺ��� ��ǥ Ȯ�� ����, ������ true, ������ false
		for(int j = 0; j < B.size(); j++) {
			//���� x, y ��ǥ ����
			int x = 0;
			int y = 0;
			if(Main.dn < 6) {
				x = r.nextInt(100*Main.dn)+10*(6-n)*(10-n);
				y = r.nextInt(80*Main.dn)+150;
			} else {
				x = r.nextInt(800)+50;
				y = r.nextInt(500)+150;
			}
			
			@SuppressWarnings("unused")
			int a = 0;
			//x, y ��ǥ�� �ٸ� ���� ��ǥ�� ��ġ�� continue
			for(int i = 0; i < n; i++) {
				if((x >= xList[i]-100 && x <= xList[i]+100) && (y >= yList[i]-200 && y <= yList[i]+200)) {
					t = false;
				}
			}
				
			//��ǥ Ȯ���� �Ϸ�� ���� ��ġ ����, �ƴϸ� continue
			if(t == true) {
				B.get(j).setBounds(x, y, 100, 100);
				xList[n] = x;
				yList[n] = y;
				n += 1;
				super.add(B.get(j));
			} else {
				j--;
				t = true;
				continue;
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
	}
}
