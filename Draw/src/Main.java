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
	
	//��� ����Ʈ
	LinkedList<String> Member = new LinkedList<>();
	@SuppressWarnings("rawtypes")
	JList l = new JList();
	JScrollPane List_Scroll = new JScrollPane();//����Ʈ ��ũ�� ��
	JButton ad = new JButton("��� �߰�");
	JButton de = new JButton("����");
	
	//���� ����Ʈ
	static LinkedList<String> Draw = new LinkedList<>();
	@SuppressWarnings("rawtypes")
	JList l2 = new JList();
	JScrollPane List_Scroll2 = new JScrollPane();//����Ʈ ��ũ�� ��
	JButton ad2 = new JButton("�׸� �߰�");
	JButton de2 = new JButton("����");
	
	ArrayList<JButton> jb = new ArrayList<>(Arrays.asList(ad, de, ad2, de2, st)); //JButton ����Ʈ //����Ʈ ����� ���ÿ� ���� �� �ʱ�ȭ
	@SuppressWarnings("rawtypes")
	ArrayList<JList> jl = new ArrayList<>(Arrays.asList(l, l2));//JList ����Ʈ
	ArrayList<JScrollPane> jlp = new ArrayList<>(Arrays.asList(List_Scroll, List_Scroll2));//JList ����Ʈ
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Main(){
		super("����̱�");
		super.setSize(1020, 500);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		//����Ʈ ���� �� �߰�
		List_Scroll.setBounds(100, 80, 200, 300);//����Ʈ ��ũ�� �� ũ��, ��ġ ����
		List_Scroll2.setBounds(700, 80, 200, 300);//����Ʈ ��ũ�� �� ũ��, ��ġ ����
        setList(Member, l);//����Ʈ ���� ����
        setList(Draw, l2);
        for(JList a : jl) {
	        //����Ʈ ��� ��� ����
	        a.setCellRenderer(new DefaultListCellRenderer(){
	            public int getHorizontalAlignment() {
	                     return CENTER;
	            }
	        });
	        a.setFont(new Font("�������", Font.BOLD, 20));//��Ʈ �� ũ�� ����
	        a.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//�ѹ��� �׸� �Ѱ��� ���� ����
	        a.addListSelectionListener(this);//����Ʈ �̺�Ʈ �߰�
        }
        List_Scroll.setViewportView(l);//����Ʈ ��ũ�� �ҿ� ����Ʈ �߰�
        add(List_Scroll);
        List_Scroll2.setViewportView(l2);
        add(List_Scroll2);
        
        //��ư ���� �� �߰�
        ad.setBounds(150, 40, 100, 30);
        de.setBounds(160, 400, 80, 30);
        ad2.setBounds(750, 40, 100, 30);
        de2.setBounds(750, 400, 80, 30);
        st.setBounds(450, 150, 100, 150);
        for(JButton j : jb) {
        	j.setBorderPainted(false); //������ ���ֱ�
        	j.setBackground(Color.LIGHT_GRAY); 
        	j.setFocusPainted(false); //���� �׵θ� ���ֱ�
        	j.setFont(new Font("�������", Font.BOLD, 15));
        	add(j);
        	j.addActionListener(this);
        }
        
        //���
        bg.setBounds(0, 0, 1010, 461);
      	add(bg);
		super.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ad) {
			String name = JOptionPane.showInputDialog(null,"��� �߰�");
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
			String name = JOptionPane.showInputDialog(null,"�׸� �߰�");
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
		//��� ����Ʈ�� ���õ� �׸��� �ε��� ��ȯ
		if(l.getSelectedIndex() >= 0 && l.getSelectedIndex() <= Member.size()) {
			memberI = l.getSelectedIndex();
			sec = 1;
		}
		
		//���� ����Ʈ�� ���õ� �׸��� �ε��� ��ȯ
		if(l2.getSelectedIndex() >= 0 && l2.getSelectedIndex() <= Draw.size()) {
			drawI = l2.getSelectedIndex();
			sec = 2;
		}
	}
	
	//����Ʈ ���� �ʱ�ȭ �Լ�
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
	
	//������ ��ư�� ���� �� ������ �׸��� �߰��ߴ� ����Ʈ�� �׸� �߰� ����
	//(������ ���� �̻�� �Լ�)
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
//			System.out.println(1);
//			if(sec == 1) {
//				String name = JOptionPane.showInputDialog(null,"��� �߰�");
//				Member.add(name);
//				setList(Member, l);
//			} else if(sec == 2) {
//				String name = JOptionPane.showInputDialog(null,"�׸� �߰�");
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
