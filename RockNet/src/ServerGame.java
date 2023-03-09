import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGame extends JFrame implements ActionListener {
//�Ѵ� ���ÿ� ����� ���� �ʰ� ���� ����� �ϸ� ���� ����
	JButton b1 = new JButton("�Է�");
	JButton b2 = new JButton("����");
	JButton b3 = new JButton("����");
	JButton b4 = new JButton("��");
	JButton b5 = new JButton("�����");
	JTextArea ta1=new JTextArea();
	JTextField tf1=new JTextField(18);
	Socket socket;
	ServerSocket server;
	OutputStream out;
	DataOutputStream dout;

	InputStream in;
	DataInputStream din;
	int my=0,you=0;

	ServerGame() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(300, 300);
		super.setTitle("Server");
		super.setLayout(new BorderLayout());
        Panel p1=new Panel();
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
		super.add(BorderLayout.NORTH,p1);
		super.add(BorderLayout.CENTER,ta1);
		Panel p2=new Panel();
        p2.add(tf1);
        p2.add(b1);
        super.add(BorderLayout.SOUTH,p2);
       
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        
		super.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		try {
			server = new ServerSocket(8111);//-----------------------------
			ta1.append("�����غ�Ϸ�\n");
			
	       	socket = server.accept();//-----------------------------
	       	
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			
			out = socket.getOutputStream();//-----------------------------
			dout = new DataOutputStream(out);//-----------------------------
			dout.writeUTF("A");
			ta1.append("���� ����\n");

			in = socket.getInputStream();
			din = new DataInputStream(in);
			
			while (true) {
				String xx = din.readUTF();
				String temp = xx.substring(0, 1);
				String temp1 = xx.substring(1);
				if (temp.equals("B")) {
					ta1.append("Ŭ���� : " + temp1 + "\n");

				} else if (temp.equals("C")) {
					you = Integer.parseInt(temp1);
					result();
				} else if (temp.equals("D")) {
					ta1.append("Ŭ���̰� ������� �������ϴ�\n");
				}
			}
			

		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerGame();
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub

		try {
			if (e1.getSource() == b1) {

				String t1 = tf1.getText().toString();
				dout.writeUTF("B" + t1);
				ta1.append("���� : " + t1 + "\n");
				dout.flush();
			}
			else if(e1.getSource() == b2) {
				dout.writeUTF("C" + 1);
				ta1.append("���� : ������ �����Ͽ����ϴ�\n");
				my=1;
				b2.setEnabled(false);
		        b3.setEnabled(false);
		        b4.setEnabled(false);
				result();
				dout.flush();
			}
			else if(e1.getSource() == b3) {
				dout.writeUTF("C" + 2);
				ta1.append("���� : ������ �����Ͽ����ϴ�\n");
				my=2;
				b2.setEnabled(false);
		        b3.setEnabled(false);
		        b4.setEnabled(false);
				result();
				dout.flush();
			}
			else if(e1.getSource() == b4) {
				dout.writeUTF("C" +3);
				ta1.append("���� : ���� �����Ͽ����ϴ�\n");
				my=3;
				b2.setEnabled(false);
		        b3.setEnabled(false);
		        b4.setEnabled(false);
				result();
				dout.flush();
			}
			else if(e1.getSource() == b5) {
				dout.writeUTF("D");
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
				b5.setEnabled(false);
		        my=0;
		        you=0;
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void result() {
		if(my!=0 && you !=0) {
			if(my==1 && you==1) {
				ta1.append("���� ���� ���浵 ���� �����ϴ�\n");
			}
			else if(my==1 && you==2) {
				ta1.append("���� ���� ������ ���� ���̽��ϴ�\n");
			}
			else if(my==1 && you==3) {
				ta1.append("���� ���� ������ ���� �̱�̽��ϴ�\n");
			}
			else if(my==2 && you==1) {
				ta1.append("���� ���� ������ ���� �̱�̽��ϴ�\n");
			}
			else if(my==2 && you==2) {
				ta1.append("���� ���� ������ ���� ���̽��ϴ�\n");
			}
			else if(my==2 && you==3) {
				ta1.append("���� ���� ������ �� ���̽��ϴ�\n");
			}
			else if(my==3 && you==1) {
				ta1.append("���� �� ������ ���� ���̽��ϴ�\n");
			}
			else if(my==3 && you==2) {
				ta1.append("���� �� ������ ���� �̱�̽��ϴ�\n");
			}
			else if(my==4 && you==3) {
				ta1.append("���� �� ���浵 �� ��̽��ϴ�\n");
			}
			b5.setEnabled(true);;
		}
	}
}

	