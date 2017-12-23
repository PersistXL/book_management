package com.library.Frame;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.liubo.Service.RegLibraryService;

@SuppressWarnings("serial")
public class ChangeJFrame extends JFrame {
	public static JTextField textName;
	private JTextField textPass;
	private JTextField textPassw;
	private JTextField textPassword;
	public  ChangeJFrame(final String rname){
		setSize(432,384);
		setResizable(false);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;//设置窗口显示的位置
	    int h=Toolkit.getDefaultToolkit().getScreenSize().height;
	    setLocation((w-437)/2, (h-237)/2);
		getContentPane().setLayout(null);
		setTitle("修改密码");

		final JButton button = new JButton();
		button.setForeground(new Color(0, 0, 255));
		button.setOpaque(false);
		button.setBackground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				//获取文本框的值
			    textName.setText(rname);
				@SuppressWarnings("unused")
				String name = textName.getText();//用户名
				String pass = textPass.getText();//原密码
				String passw = textPassw.getText();//新密码
				String password = textPassword.getText();//再次输入的新密码
				RegLibraryService rls = new RegLibraryService();
				try {
					rls.changePass(rname, pass, passw, password);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		button.setText("确认修改");
		button.setBounds(165, 268, 98, 28);
		getContentPane().add(button);

		final JLabel label = new JLabel();
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("用户名：");
		label.setBounds(72, 42, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("原密码：");
		label_1.setBounds(72, 90, 66, 18);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("新密码：");
		label_2.setBounds(72, 132, 66, 18);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("再次输入：");
		label_3.setBounds(40, 175, 98, 18);
		getContentPane().add(label_3);

		textPassword = new JTextField();
		textPassword.setOpaque(false);
		textPassword.setBounds(165, 175, 140, 20);
		getContentPane().add(textPassword);

		textPassw = new JTextField();
		textPassw.setOpaque(false);
		textPassw.setBounds(165, 130, 140, 22);
		getContentPane().add(textPassw);

		textPass = new JTextField();
		textPass.setOpaque(false);
		textPass.setBounds(165, 88, 140, 22);
		getContentPane().add(textPass);

		textName = new JTextField();
		textName.setOpaque(false);
		textName.setEditable(false);
		textName.setBounds(165, 40, 140, 22);
		getContentPane().add(textName);

		final JPanel panel = new JPanel(){
		public void paintComponent(Graphics g){//画图片
			    super.paintComponent(g);
				ImageIcon icon=new ImageIcon("img\\read.jpg");
				Image img =icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
		};
		panel.setBackground(new Color(255, 255, 255));
		panel.setOpaque(false);
		panel.setBounds(0, 2, 426, 354);
		getContentPane().add(panel);
	}

}
