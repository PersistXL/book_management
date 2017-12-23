package com.java.io.frame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.java.service.BorrowBookService;
import com.java.service.LibraryBookService;
import com.jgoodies.forms.factories.DefaultComponentFactory;

@SuppressWarnings("serial")
public class BorrowBookFrame extends JInternalFrame {
    final JDesktopPane desktopPane = new JDesktopPane();
    LibraryBookService lbs = new LibraryBookService();
    BorrowBookService bbs = new BorrowBookService();
    Component[] com = desktopPane.getComponents();
    public BorrowBookFrame(final String rname){   //传入用户名
    	setSize(1000,600);
    	setTitle("用户借书系统");
    	setMaximizable(true);
    	setClosable(true);

    	final JPanel panel = new JPanel();
    	panel.setBackground(new Color(250, 240, 230));
    	getContentPane().add(panel, BorderLayout.NORTH);

    	final JLabel label_4 = new JLabel();
    	label_4.setPreferredSize(new Dimension(320, 0));
    	panel.add(label_4);

    	final JLabel label_6 = new JLabel();
    	label_6.setText("图书名称：");
    	panel.add(label_6);

    	final JTextPane textPane_name = new JTextPane();
    	textPane_name.setPreferredSize(new Dimension(150, 30));
    	panel.add(textPane_name);

    	final JButton button_3 = new JButton();
    	button_3.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {
    			String name = textPane_name.getText();
    				BynameFrame bf = new BynameFrame(name);//把用户名传给借阅界面
    				lbs.showOnlybf(desktopPane, bf);
    		}
    	});
    	button_3.setText("搜索");
    	panel.add(button_3);

    	final JLabel label_5 = new JLabel();
    	label_5.setText("图书类型：");
    	panel.add(label_5);

    	final JTextPane textPane = new JTextPane();
    	textPane.setPreferredSize(new Dimension(150, 30));
    	panel.add(textPane);

    	final JButton button = new JButton();
    	button.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {//搜索功能
    			String type = textPane.getText();
    		    TypeFrame tf = new TypeFrame(type);
    		    lbs.showOnlytf(desktopPane, tf);
    		}
    	});
    	button.setText("搜索");
    	panel.add(button);

    	final JPanel panel_1 = new JPanel();
    	panel_1.setBackground(new Color(154, 205, 50));
    	panel_1.setPreferredSize(new Dimension(120, 80));
    	getContentPane().add(panel_1, BorderLayout.WEST);

    	final JLabel label_2 = new JLabel();
    	label_2.setPreferredSize(new Dimension(100, 100));
    	label_2.setMinimumSize(new Dimension(100, 100));
    	label_2.setMaximumSize(new Dimension(100, 100));
    	panel_1.add(label_2);

    	final JButton button_1 = new JButton();
    	button_1.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {
    			FindFrame ff = new FindFrame();
    		    lbs.showOnlyff(desktopPane, ff);
    		}
    	});
    	button_1.setText("查看");
    	panel_1.add(button_1);

    	final JLabel label_3 = new JLabel();
    	label_3.setPreferredSize(new Dimension(100, 80));
    	panel_1.add(label_3);

    	final JButton button_2 = new JButton();
    	button_2.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {//借阅书籍
    			BorrowFrame bbff = new BorrowFrame(rname);
    			lbs.showOnlybbff(desktopPane, bbff);
    		}
    	});
    	button_2.setText("借阅");
    	panel_1.add(button_2);

    	final JLabel label_7 = DefaultComponentFactory.getInstance().createLabel("");
    	label_7.setPreferredSize(new Dimension(60, 80));
    	panel_1.add(label_7);

    	final JButton button_4 = new JButton();
    	button_4.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {//还书按钮
    			ReturnBookFrame rbf = new ReturnBookFrame(rname);
    			bbs.showOnlybbff(desktopPane, rbf);
    			rbf.setVisible(true);
    		}
    	});
    	button_4.setText("还书");
    	panel_1.add(button_4);

    	final JPanel panel_2 = new JPanel();
    	panel_2.setBackground(new Color(221, 160, 221));
    	getContentPane().add(panel_2, BorderLayout.SOUTH);

    	final JLabel label = new JLabel();
    	label.setText("当前时间：");
    	panel_2.add(label);

    	final JLabel label_1 = new JLabel();
    	label_1.setPreferredSize(new Dimension(100, 30));
    	label_1.setMaximumSize(new Dimension(0, 0));
    	label_1.setText("2017-01-11");
    	panel_2.add(label_1);

    	
    	getContentPane().add(desktopPane, BorderLayout.CENTER);
    	desktopPane.setBackground(new Color(224, 255, 255));
    }
}
