package com.erbo.java.borrow;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class TestBorrowFrame extends JFrame {
	private int  wid = 376;
	private int hig = 316;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TestBorrowFrame().setVisible(true);
	}
	
	public TestBorrowFrame(){
		
		setSize(628,402);
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setLocation((w-wid)/2, (h-hig)/2);

		final JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		final JButton button = new JButton();
		button.setBounds(0, 0, 360, 28);
		desktopPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
					BorrowFrameMasg bf = new BorrowFrameMasg("likui");//传递用户名
					desktopPane.add(bf);
					bf.setVisible(true);
			}
		});
		button.setText("个人资料查询");
		
	}

}
