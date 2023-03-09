package game1;

import java.awt.*;
import java.awt.event.*;
class FrameTest{
       public static void main(String args[]){
             Frame f = new Frame("Login");
             f.setSize(300,200);
            
             //EvenHandlerŬ������ ��ü�� �����ؼ� Frame�� WindowListener�� ����Ѵ�.
             f.addWindowListener(new EventHandler());
             f.setVisible(true);
       }
}
 
class EventHandler implements WindowListener
{
       public void windowOpened(WindowEvent e){}
       //Frame�� �ݱ� ��ư�� ������ �� ȣ��ȴ�.
       public void windowClosing(WindowEvent e){
             //Frame�� ȭ�鿡�� ������ �ʵ��� �ϰ�
             e.getWindow().setVisible(false);
             //�޸𸮿��� �����Ѵ�.
             e.getWindow().dispose();
             //���α׷��� �����ϴ�.
             System.exit(0);
       }
       //�ƹ����뵵 ���� �޼��� ����
       public void windowClosed(WindowEvent e){}
       public void windowIconified(WindowEvent e){}
       public void windowDeiconified(WindowEvent e){}
       public void windowActivated(WindowEvent e){}
       public void windowDeactivated(WindowEvent e){}
}