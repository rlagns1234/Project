package game1;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Game1 extends JFrame implements ActionListener {
	Button b1 = new Button("게임시작");
	Button b2 = new Button("게임종료");
	Game1() {
		super.setSize(300,150);
		super.setLayout(null);
		b1.setBounds(10,20,100,50);
		b2.setBounds(150,20,100,50);
		super.add(b1);
		super.add(b2);
		super.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Game1 star = new Game1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1 ) {
			new GameMain();
		} else if(e.getSource() == b2) {
			System.exit(0);
		}
	}

}
