package com.liang.library.Frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.java.io.frame.FindFrame;
import com.java.service.LibraryBookService;
import com.liang.internalFrame.UpdateMessage;
import com.qingeng.Frame.BuyBookFrame;
import com.qingeng.Frame.DelBookFrame;
import com.qingeng.Service.BuyBookService;
import com.qingeng.Service.DelBookService;


@SuppressWarnings("serial")
public class AdminControlFrame extends JFrame{
	/*public static void main(String[] args) {
		new AdminControlFrame().setVisible(true);
	}*/
	
	public static JLabel lab2= new JLabel();
	public AdminControlFrame(final ChatFrame cf){
	    setSize(1010,617);
	    setResizable(false);//设置窗口不可最大化
	    
	    int w=Toolkit.getDefaultToolkit().getScreenSize().width;//设置窗口显示的位置
	    int h=Toolkit.getDefaultToolkit().getScreenSize().height;
	    setLocation((w-1010)/2, (h-679)/2);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);

	    final JPanel panel1 = new JPanel(){
	    	public void paintComponent(Graphics g){//画图片
			    //super.paintComponent(g);
				ImageIcon icon=new ImageIcon("img\\IMG_1085.JPG");
				Image img =icon.getImage();
				
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
	    };
	    panel1.setLayout(null);
	    panel1.setBounds(0, 0, 1002, 140);
	    getContentPane().add(panel1);

	    final JLabel label = new JLabel();
	    label.setText("现在是：");
	    label.setBounds(28, 112, 66, 18);
	    panel1.add(label);

	    
	    lab2.setBounds(93, 112, 188, 18);//设置lab2的位置
	    panel1.add(lab2);
	    
	    final JPanel panel = new JPanel(){
	    	public void paintComponent(Graphics g){//画图片
			    //super.paintComponent(g);
				ImageIcon icon=new ImageIcon("img\\IMG_1080.jpg");
				Image img =icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
	    };
	    panel.setLayout(null);
	    panel.setBounds(152, 146, 852, 500);
	    getContentPane().add(panel);

	    
	    final JDesktopPane desktopPane = new JDesktopPane();
	    desktopPane.setOpaque(false);
	    desktopPane.setBounds(0, 0, 852, 500);
	    panel.add(desktopPane);

	    final JPanel panel2 = new JPanel();
	    panel2.setBackground(new Color(0, 206, 209));
	    panel2.setLayout(null);
	    panel2.setBounds(0, 146, 146, 500);
	    getContentPane().add(panel2);
	    
	    final JButton butt1 = new JButton();
	    butt1.setBounds(33, 34, 90, 38);
	    butt1.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		LibraryBookService lbs = new LibraryBookService();
	    		FindFrame ff = new FindFrame();
    		    lbs.showOnlyff(desktopPane, ff);
	    	}
	    });
	    butt1.setText("图书检索");
	    panel2.add(butt1);

	    final JButton butt2 = new JButton();
	    butt2.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		BuyBookFrame bbf = new BuyBookFrame();
	    		BuyBookService bbs = new BuyBookService();
	    		bbs.showOnlybbf(desktopPane, bbf);
	    	}
	    });
	    butt2.setBounds(33, 92, 90, 38);
	    butt2.setText("新书购入");
	    panel2.add(butt2);

	    final JButton butt3 = new JButton();
	    butt3.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		DelBookFrame dbf = new DelBookFrame();
	    		DelBookService dbs = new DelBookService();
	    		dbs.showOnlybbs(desktopPane, dbf);
	    	}
	    });
	    butt3.setBounds(33, 151, 90, 38);
	    butt3.setText("图书注销");
	    panel2.add(butt3);

	    final JButton butt4 = new JButton();
	    butt4.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		UpdateMessage um=new UpdateMessage();
	    		desktopPane.add(um);
	    		um.setVisible(true);
	    	}
	    });
	    butt4.setBounds(33, 209, 90, 38);
	    butt4.setText("信息修改");
	    panel2.add(butt4);

	    final JButton butt5 = new JButton();
	    butt5.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		new LoginFrame(cf).setVisible(true);
	    		dispose();
	    	}
	    });
	    butt5.setBounds(33, 267, 90, 38);
	   // butt5.setEnabled(false);
	    butt5.setText("退出");
	    panel2.add(butt5);

	    final JButton button = new JButton();
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		cf.setVisible(true);
	    	}
	    });
	    button.setForeground(new Color(0, 51, 102));
	    button.setBackground(new Color(210, 105, 30));
	    button.setBounds(33, 335, 60, 30);
	    panel2.add(button);
	    button.setText("消息");

	    final JLabel label_1 = new JLabel();
	    label_1.setOpaque(true);
	    label_1.setBackground(new Color(107, 142, 35));
	    label_1.setBounds(10, 44, 18, 18);
	    panel2.add(label_1);

	    final JLabel label_2 = new JLabel();
	    label_2.setOpaque(true);
	    label_2.setBackground(new Color(107, 142, 35));
	    label_2.setBounds(10, 102, 18, 18);
	    panel2.add(label_2);

	    final JLabel label_3 = new JLabel();
	    label_3.setOpaque(true);
	    label_3.setBackground(new Color(107, 142, 35));
	    label_3.setBounds(10, 161, 18, 18);
	    panel2.add(label_3);

	    final JLabel label_4 = new JLabel();
	    label_4.setOpaque(true);
	    label_4.setBackground(new Color(107, 142, 35));
	    label_4.setBounds(10, 219, 18, 18);
	    panel2.add(label_4);

	    final JLabel label_5 = new JLabel();
	    label_5.setOpaque(true);
	    label_5.setBackground(new Color(107, 142, 35));
	    label_5.setBounds(10, 277, 18, 18);
	    panel2.add(label_5);

	    final JLabel label_6 = new JLabel();
	    label_6.setBackground(new Color(107, 142, 35));
	    label_6.setBounds(10, 299, 18, 18);
	    panel2.add(label_6);

	    
	    

	    



	}
	
}
