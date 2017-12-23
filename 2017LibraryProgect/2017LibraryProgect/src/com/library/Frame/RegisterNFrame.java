package com.library.Frame;

import java.awt.Color;
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
public class RegisterNFrame extends JFrame{
	private JTextField textPassword;
	private JTextField textName;
	public RegisterNFrame(){
		setSize(433,432);
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("新用户注册");
		
		
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;//设置窗口显示的位置
	    int h=Toolkit.getDefaultToolkit().getScreenSize().height;
	    setLocation((w-445)/2, (h-383)/2);

		final JPanel panel = new JPanel(){
		public void paintComponent(Graphics g){//画图片
			    super.paintComponent(g);
				ImageIcon icon=new ImageIcon("img\\04-26_151811-21.jpg");
				Image img =icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
		};
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 10, 417, 394);
		getContentPane().add(panel);

		textName = new JTextField();
		textName.setBounds(177, 53, 146, 28);
		panel.add(textName);
		textName.setOpaque(false);

		final JLabel label = new JLabel();
		label.setBounds(87, 54, 66, 26);
		panel.add(label);
		label.setText("用户名:");

		final JLabel label_1 = new JLabel();
		label_1.setBounds(87, 165, 66, 26);
		panel.add(label_1);
		label_1.setText("密    码:");

		textPassword = new JTextField();
		textPassword.setBounds(177, 164, 146, 28);
		panel.add(textPassword);
		textPassword.setOpaque(false);

		final JButton button = new JButton();
		button.setBounds(153, 253, 106, 28);
		panel.add(button);
		button.setBackground(new Color(0, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				 String NewName =  textName.getText();
				 String psw = textPassword.getText();
				 RegLibraryService rls = new RegLibraryService();
				 try {
					rls.query(NewName, psw);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setText("确认注册");
	}

}
