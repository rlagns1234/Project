package game1;

import java.awt.*;
import java.awt.event.*;
class FrameTest{
       public static void main(String args[]){
             Frame f = new Frame("Login");
             f.setSize(300,200);
            
             //EvenHandler클래스의 객체를 생성해서 Frame의 WindowListener로 등록한다.
             f.addWindowListener(new EventHandler());
             f.setVisible(true);
       }
}
 
class EventHandler implements WindowListener
{
       public void windowOpened(WindowEvent e){}
       //Frame의 닫기 버튼을 눌렀을 때 호출된다.
       public void windowClosing(WindowEvent e){
             //Frame을 화면에서 보이지 않도록 하고
             e.getWindow().setVisible(false);
             //메모리에서 제거한다.
             e.getWindow().dispose();
             //프로그램을 종료하다.
             System.exit(0);
       }
       //아무내용도 없는 메서드 구현
       public void windowClosed(WindowEvent e){}
       public void windowIconified(WindowEvent e){}
       public void windowDeiconified(WindowEvent e){}
       public void windowActivated(WindowEvent e){}
       public void windowDeactivated(WindowEvent e){}
}