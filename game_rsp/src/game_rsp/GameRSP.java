package game_rsp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.Random;

@SuppressWarnings("serial")
public class GameRSP extends JFrame implements ActionListener, Runnable{
	JButton r;	//바위 버튼
	JButton s;	//가위 버튼
	JButton p;	//보 버튼
	JButton player;	//플레이어 버튼
	JButton cpu;	//컴퓨터 버튼
	JLabel pl = new JLabel("플레이어");	//플레이어 텍스트
	JLabel cl = new JLabel("컴퓨터");	//컴퓨터 텍스트
	JLabel vs = new JLabel("0승 0무 0패");	//컴퓨터 텍스트
	int pn;	//플레이어의 가위, 바위, 보 데이터  (0 == 가위, 1 == 바위, 2 == 보)
	int cn;	//컴의 가위, 바위, 보 데이터
	int loop = 0;	//컴퓨터 아이콘 변하는 루프 스위치
	int count_p;	//플레이어의 승리 횟수
	int count_c;	//컴의 승리 횟수
	ImageIcon ic[] = {new ImageIcon("sci.jpg"), new ImageIcon("rock.jpg"), new ImageIcon("paper.jpg")};	//이미지 데이터
	int w, e, l;

	public GameRSP() {
		super("가위바위보 게임");	//타이틀 설정
		setSize(300, 300);	//윈도우 창 크기 설정 300x300
		setLocationRelativeTo(null); //윈도우 창 생성 위치 항상 중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//윈도우창 닫힐 수 있게 설정
		setLayout(null);	//레이아웃 특별한 설정 없음
		
		//버튼 생성
		r = new JButton(ic[1]);
		s = new JButton(ic[0]);
		p = new JButton(ic[2]);
		player = new JButton();
		cpu = new JButton();
		
		//버튼 위치와 크기 설정
		r.setBounds(105, 10, 75, 75);	
		s.setBounds(10, 10, 75, 75);
		p.setBounds(200, 10, 75, 75);
		player.setBounds(40, 130, 75, 75);
		cpu.setBounds(170, 130, 75, 75);
		player.setBackground(new Color(150,150,200));
		cpu.setBackground(new Color(220,150,150));
		
		//레이블 위치와 크기 설정
		pl.setBounds(55, 110, 50, 20);
		cl.setBounds(190, 110, 50, 20);
		vs.setBounds(110, 225, 100, 20);
		
		//윈도우 창에 객체 추가
		add(r);	
		add(s);
		add(p);
		add(player);
		add(cpu);
		add(pl);
		add(cl);
		add(vs);
		
		//버튼 이벤트 활성화
		r.addActionListener(this);
		s.addActionListener(this);
		p.addActionListener(this);
		
		setVisible(true);	//윈도우 창 가시화
		
		run();
	}

	public static void main(String[] args) {
		new GameRSP();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//클릭 된 버튼에 맞는 이미지와 값으로 바꾸기
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
	
	//컴퓨터 가위, 바위, 보 랜덤 설정 메소드
	private void cpu() {
		Random r = new Random();
		int n = r.nextInt(3);	//랜덤 설정
		cn = n;	//컴퓨터 가위, 바위, 보 값 저장
		//값에 따라 알맞는 모양으로 바꾸기
		if(n == 0) {
			cpu.setIcon(ic[0]);
		} else if(n == 1) {
			cpu.setIcon(ic[1]);
		} else if(n == 2) {
			cpu.setIcon(ic[2]);
		}
	}
	
	//승자 판독 메소드
	private void winner() {
		if(cn == pn) {	//만약 숫자가 똑같다면
			JOptionPane.showMessageDialog(null, "비겼습니다");
			e++;//////////////////////////////////승패 구현
			//내가 가위, 컴이 보인 경우 외에 나의 값이 컴 값보다 작거나 내가 보, 컴이 가위인 경우 (가위 = 0, 보 = 2)
		} else if((!(pn == 0 && cn == 2) && (pn < cn)) || (pn == 2 && cn == 0)) {
			JOptionPane.showMessageDialog(null, "졌습니다");
		} else {	// 그 외
			JOptionPane.showMessageDialog(null, "이겼습니다");
		}
		//플레이어, 컴퓨터 아이콘 없이
		player.setIcon(new ImageIcon());
		cpu.setIcon(new ImageIcon());
		//플레이어, 컴퓨터의 버튼 색깔 설정
		player.setBackground(new Color(150,150,200));
		cpu.setBackground(new Color(220,150,150));
		loop = 1; //루프 실행
	}
	
	private void change() {
		int a = 0;	//이미지 배열 위치 저장값
		for(int i = 0; i < 12; i++) {
			a++;
			//a가 2보다 클 시 0으로 변경
			if(a > 2) {
				a = 0;
			}
			
			try {
				cpu.setIcon(ic[a]);	//이미지 변경
				Thread.sleep(100);	//0.1초 슬립
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			System.out.print("");	//왜 이 출력 문이 없으면 실행이 안되나?
			if(loop == 1) {
				change();	//이미지 1.2초동안 계속 변경 
				cpu();	//컴 가위, 바위, 보 설정
				winner();	//승자 판독
				loop = 0;	//루프 멈춤
			}
		}
	}

}
