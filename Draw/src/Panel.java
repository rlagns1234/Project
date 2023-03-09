import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

//제비뽑기 끝나고 결산 창
@SuppressWarnings("serial")
public class Panel extends JFrame {
	String result;
	JLabel s;
	//스크롤판
	JScrollPane js = new JScrollPane() {
		//스크롤 팬 배경 없애기
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
		s.setFont(new Font("맑은고딕", Font.BOLD, 40));
		s.setHorizontalAlignment(JLabel.CENTER);
		js.getVerticalScrollBar().setUnitIncrement(10);//스크롤 팬 스크롤 감도 조정
		js.setViewportView(s);
		js.setBounds(0, 0, 800, 450);
		add(js);
		super.setVisible(true);
	}
}
