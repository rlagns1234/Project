package pad;

import java.net.*;
import java.io.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class part1_1 extends JFrame implements ActionListener {
	Button b1 = new Button("Send");
	String msg = "Hello";
	
	part1_1() {
		super.setSize(300,150);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		super.setResizable(false);
		b1.setBounds(100,30,100,50);
		super.add(b1);
		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(e.getSource() == b1 ) {
			try {
				DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length);
				DatagramSocket ds = new DatagramSocket();
				ds.send(dp);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
