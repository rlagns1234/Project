import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

//����̱� ������ ��� â
@SuppressWarnings("serial")
public class Panel extends JFrame {
	String result;
	JLabel s;
	//��ũ����
	JScrollPane js = new JScrollPane() {
		//��ũ�� �� ��� ���ֱ�
		public void setBorder(Border border) {
			
		}
	};
	Panel(String r){
		result = r;
		s = new JLabel(r);
		super.setSize(800, 500);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);;
		s.setFont(new Font("�������", Font.BOLD, 40));
		s.setHorizontalAlignment(JLabel.CENTER);
		js.getVerticalScrollBar().setUnitIncrement(10);//��ũ�� �� ��ũ�� ���� ����
		js.setViewportView(s);
		js.setBounds(0, 0, 800, 450);
		add(js);
		super.setVisible(true);
	}
}
