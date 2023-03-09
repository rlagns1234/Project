package Gambling;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Settings extends JFrame implements ActionListener{
	JButton nomal;
	JButton hard;
	
	ImageIcon nomalImage = new ImageIcon("GamblingImage/x3.png");
	Image nomalimage = nomalImage.getImage();
	ImageIcon noimge = new ImageIcon(nomalimage.getScaledInstance(100, 30,  java.awt.Image.SCALE_SMOOTH));
	JButton x3 = new JButton(noimge);

	ImageIcon hardImage = new ImageIcon("GamblingImage/x10.png");
	Image hardimage = hardImage.getImage();
	ImageIcon haimg = new ImageIcon(hardimage.getScaledInstance(100, 30,  java.awt.Image.SCALE_SMOOTH));
	JButton x10 = new JButton(haimg);

	ImageIcon nomalImageClick = new ImageIcon("GamblingImage/x3click.png");
	Image nomalimageclick = nomalImageClick.getImage();
	ImageIcon x3c = new ImageIcon(nomalimageclick.getScaledInstance(975, 673,  java.awt.Image.SCALE_SMOOTH));
	
	ImageIcon hardImageClick = new ImageIcon("GamblingImage/x10click.png");
	Image hardimageclick = hardImageClick.getImage();
	ImageIcon x10c = new ImageIcon(hardimageclick.getScaledInstance(975, 673,  java.awt.Image.SCALE_SMOOTH));

	Settings() {
		super.setIconImage(Slot.chipImg);
		super.setLayout(null);
		super.setSize(100, 50);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		x3.setPressedIcon(x3c);
		x10.setPressedIcon(x10c);
		x3.setFocusPainted(false);
		x10.setFocusPainted(false);
		x3.addActionListener(this);
		x10.addActionListener(this);
		x3.setContentAreaFilled(false);
		x3.setFocusPainted(false);
		x10.setContentAreaFilled(false);
		x10.setFocusPainted(false);
		x3.setBounds(40, 10, 100, 30);
		x10.setBounds(200, 10, 100, 30);
		add(x3);
		add(x10);
		setSize(340, 80);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == x3) {
			Slot.setting = false;
			dispose();
		} else if(e.getSource() == x10) {
			Slot.setting = true;
			dispose();
		}
	}
}
