import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings({ "serial", "unused" })
public class Main extends JFrame implements KeyListener, ActionListener, ListSelectionListener{
	static int mn;
	static int dn;
	int memberI;
	int drawI;
	int sec = 0;
	JLabel bg = new JLabel(new ImageIcon(new ImageIcon("DrawImg/back.jpg").getImage().getScaledInstance(1010, 461,  java.awt.Image.SCALE_SMOOTH)));
	JButton st = new JButton(new ImageIcon(new ImageIcon("DrawImg/fortune.png").getImage().getScaledInstance(100, 150,  java.awt.Image.SCALE_SMOOTH)));
	
	//멤버 리스트
	LinkedList<String> Member = new LinkedList<>();
	@SuppressWarnings("rawtypes")
	JList l = new JList();
	JScrollPane List_Scroll = new JScrollPane();//리스트 스크롤 팬
	JButton ad = new JButton("멤버 추가");
	JButton de = new JButton("제거");
	
	//제비 리스트
	static LinkedList<String> Draw = new LinkedList<>();
	@SuppressWarnings("rawtypes")
	JList l2 = new JList();
	JScrollPane List_Scroll2 = new JScrollPane();//리스트 스크롤 팬
	JButton ad2 = new JButton("항목 추가");
	JButton de2 = new JButton("제거");
	
	ArrayList<JButton> jb = new ArrayList<>(Arrays.asList(ad, de, ad2, de2, st)); //JButton 리스트 //리스트 선언과 동시에 여러 값 초기화
	@SuppressWarnings("rawtypes")
	ArrayList<JList> jl = new ArrayList<>(Arrays.asList(l, l2));//JList 리스트
	ArrayList<JScrollPane> jlp = new ArrayList<>(Arrays.asList(List_Scroll, List_Scroll2));//JList 리스트
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Main(){
		super("제비뽑기");
		super.setSize(1020, 500);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		//리스트 구현 및 추가
		List_Scroll.setBounds(100, 80, 200, 300);//리스트 스크롤 팬 크기, 위치 설정
		List_Scroll2.setBounds(700, 80, 200, 300);//리스트 스크롤 팬 크기, 위치 설정
        setList(Member, l);//리스트 내용 변경
        setList(Draw, l2);
        for(JList a : jl) {
	        //리스트 목록 가운데 정렬
	        a.setCellRenderer(new DefaultListCellRenderer(){
	            public int getHorizontalAlignment() {
	                     return CENTER;
	            }
	        });
	        a.setFont(new Font("맑은고딕", Font.BOLD, 20));//폰트 및 크기 설정
	        a.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//한번에 항목 한개만 선택 가능
	        a.addListSelectionListener(this);//리스트 이벤트 추가
        }
        List_Scroll.setViewportView(l);//리스트 스크롤 팬에 리스트 추가
        add(List_Scroll);
        List_Scroll2.setViewportView(l2);
        add(List_Scroll2);
        
        //버튼 구현 및 추가
        ad.setBounds(150, 40, 100, 30);
        de.setBounds(160, 400, 80, 30);
        ad2.setBounds(750, 40, 100, 30);
        de2.setBounds(750, 400, 80, 30);
        st.setBounds(450, 150, 100, 150);
        for(JButton j : jb) {
        	j.setBorderPainted(false); //윤곽선 없애기
        	j.setBackground(Color.LIGHT_GRAY); 
        	j.setFocusPainted(false); //선택 테두리 없애기
        	j.setFont(new Font("맑은고딕", Font.BOLD, 15));
        	add(j);
        	j.addActionListener(this);
        }
        
        //배경
        bg.setBounds(0, 0, 1010, 461);
      	add(bg);
		super.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ad) {
			String name = JOptionPane.showInputDialog(null,"멤버 추가");
			if(name.matches(".+")) {
				Member.add(name);
				setList(Member, l);
				sec = 1;
			}
		} else if(e.getSource() == de) {
			Member.remove(memberI);
			setList(Member, l);
			sec = 1;
		} else if(e.getSource() == ad2) {
			String name = JOptionPane.showInputDialog(null,"항목 추가");
			if(name.matches(".+")) {
				Draw.add(name);
				setList(Draw, l2);
				sec = 2;
			}
		} else if(e.getSource() == de2) {
			Draw.remove(drawI);
			setList(Draw, l2);
			sec = 2;
		} else if(e.getSource() == st) {
			mn = Member.size();
			dn = Draw.size();
			Play p = new Play(Member, Draw);
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//멤버 리스트의 선택된 항목의 인덱스 반환
		if(l.getSelectedIndex() >= 0 && l.getSelectedIndex() <= Member.size()) {
			memberI = l.getSelectedIndex();
			sec = 1;
		}
		
		//제비 리스트의 선택된 항목의 인덱스 반환
		if(l2.getSelectedIndex() >= 0 && l2.getSelectedIndex() <= Draw.size()) {
			drawI = l2.getSelectedIndex();
			sec = 2;
		}
	}
	
	//리스트 내용 초기화 함수
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setList(LinkedList<String> a, JList b) {
		String[] list = new String[a.size()];
		for(int i = 0; i < a.size(); i++) {
			list[i] = a.get(i);
		}
		b.setListData(list);
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//지정된 버튼을 누를 시 이전에 항목을 추가했던 리스트에 항목 추가 가능
	//(오류로 인한 미사용 함수)
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
//			System.out.println(1);
//			if(sec == 1) {
//				String name = JOptionPane.showInputDialog(null,"멤버 추가");
//				Member.add(name);
//				setList(Member, l);
//			} else if(sec == 2) {
//				String name = JOptionPane.showInputDialog(null,"항목 추가");
//				Draw.add(name);
//				setList(Draw, l2);
//			}
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
