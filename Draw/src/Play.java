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
	
	//이미지 준비
	ImageIcon Image = new ImageIcon("DrawImg/D.png");
	Image IMG = Image.getImage();
	ImageIcon img = new ImageIcon(IMG.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH));
	
	JLabel bg = new JLabel(new ImageIcon(new ImageIcon("DrawImg/maru.gif").getImage().getScaledInstance(1200, 800,  java.awt.Image.SCALE_SMOOTH)));
	Play(LinkedList<String> m, LinkedList<String> d){
		super("제비뽑기");
		super.setSize(1200, 800);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		M.addAll(m);
		D.addAll(d);
		mn = 0;
		
		//선택 리스트
		for(String i : M) {
			ch.add(i);
		}
		ch.setFont(new Font("맑은고딕", Font.BOLD, 30));
		ch.setBounds(10, 10, 150, 100);
		ch.addItemListener(this);
		super.add(ch);
		
		//제비 (제비 크기는 100)
		for(int i = 0; i < D.size(); i++) {
			B.add(new JButton(img));
			B.get(i).setBorderPainted(false);
			B.get(i).setContentAreaFilled(false);
			B.get(i).setFocusPainted(false);
			B.get(i).addActionListener(this);
		}
		shuffle(B);
		
		//배경
		bg.setBounds(0, 0, 1200, 800);
		super.add(bg);
		
		super.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//제비 고유 숫자 그리기
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
				//선택된 제비의 번호가 몇번인지 구하기
				for(JButton j : B) {
					if (j.equals(e.getSource())) {
						index = B.indexOf(j);
					}
				}
				//결산창 용 데이터 저장
				user.add(ch.getItem(ch.getSelectedIndex()));
				draw.add(D.get(rDraw));
				mn++;
				//팝업창 띄우기
				new DrawPanel(D.get(rDraw), user, draw, mn);
				//choice 리스트에서 제거, 버튼 리스트에서 제거, 번호 좌표 -로설정하여 화면상 제거, 버튼 제거
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
	
	//제비 셔플 함수 구현
	private void shuffle(LinkedList<JButton> B) {
		int n = 0;
		boolean t = true;//중복된 좌표 확인 변수, 없을시 true, 있으면 false
		for(int j = 0; j < B.size(); j++) {
			//랜덤 x, y 좌표 설정
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
			//x, y 좌표가 다른 제비 좌표와 겹치는 continue
			for(int i = 0; i < n; i++) {
				if((x >= xList[i]-100 && x <= xList[i]+100) && (y >= yList[i]-200 && y <= yList[i]+200)) {
					t = false;
				}
			}
				
			//좌표 확인이 완료시 제비 위치 설정, 아니면 continue
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
