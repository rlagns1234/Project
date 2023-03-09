import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DrawPanel extends JFrame implements ActionListener{
	int x = 800;
	int y = 500;
	int mn;
	JLabel bg = new JLabel(new ImageIcon(new ImageIcon("DrawImg/memo.jpeg").getImage().getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH)));
	JButton acc = new JButton("확인");
	LinkedList<JLabel> JL = new LinkedList<>();
	ArrayList<String> user = new ArrayList<>();
	ArrayList<String> draw = new ArrayList<>();
	DrawPanel(String s, ArrayList<String> u, ArrayList<String> d, int nm){
		user = u;
		draw = d;
		mn = nm;
		super.setSize(x, y);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		//문자열
		String[] st = sort(s);
		for(int i = 0; i < 6; i++) {
			JL.add(new JLabel(st[i]));
			JL.get(i).setBounds(85, 90+50*i, 620, 50);
			JL.get(i).setFont(new Font("",Font.ITALIC, 30));
			JL.get(i).setHorizontalAlignment(JLabel.CENTER);
			super.add(JL.get(i));
		}
		
		//확인버튼
		acc.setBorderPainted(false); //윤곽선 없애기
		acc.setBackground(Color.white); 
		acc.setFocusPainted(false); //선택 테두리 없애기
		acc.setFont(new Font("맑은고딕", Font.BOLD, 20));
		acc.setBounds(350, 420, 100, 30);
    	add(acc);
    	acc.addActionListener(this);
		
    	//배경
    	bg.setBounds(-5, -40, x, y);
		super.add(bg);
		super.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	//문자열 행 나누기 함수
	private String[] sort(String s) {
		String[] st = {"", "", "", "", "", ""};
		int sLength = s.length()/25;
		if(sLength == 0 || (sLength == 1 && s.length()%25 == 0)) {
			st[2] = s;
		} else if((sLength == 1 &&  s.length()%25 != 0) || (sLength == 2 && s.length()%25 == 0)) {
			st[1] = s.substring(0, 25);
			st[2] = s.substring(25);
		} else if((sLength == 2 &&  s.length()%25 != 0) || (sLength == 3 && s.length()%25 == 0)) {
			st[1] = s.substring(0, 25);
			st[2] = s.substring(25, 50);
			st[3] = s.substring(50);
		} else if((sLength == 3 &&  s.length()%25 != 0) || (sLength == 4 && s.length()%25 == 0)) {
			st[1] = s.substring(0, 25);
			st[2] = s.substring(25, 50);
			st[3] = s.substring(50, 75);
			st[4] = s.substring(75);
		} else if((sLength == 4 &&  s.length()%25 != 0) || (sLength == 5 && s.length()%25 == 0)) {
			st[0] = s.substring(0, 25);
			st[1] = s.substring(25, 50);
			st[2] = s.substring(50, 75);
			st[3] = s.substring(75, 100);
			st[4] = s.substring(100);
		} else {
			st[0] = s.substring(0, 25);
			st[1] = s.substring(25, 50);
			st[2] = s.substring(50, 75);
			st[3] = s.substring(75, 100);
			st[4] = s.substring(100, 125);
			st[5] = s.substring(125);
		}
		return st;
	}
	
	//결산창 문자열 제작 (JLabel용)
	private String print() {
		//<html> : 문자열 시작, <br/> : 행 바꾸기, </html> : 문자열 끝
		String result = "<html>";
		for(int i = 0; i < user.size(); i++) {
			result = result+user.get(i)+" : "+draw.get(i)+"<br/>";
		}
		result = result+"</html>";
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == acc) {
			//창 닫기
			this.dispose();
			//마지막 오브젝트면 결산창 띄우기
			if(mn == Main.mn) {
				new Panel(print());
			}
		}
	}
}
