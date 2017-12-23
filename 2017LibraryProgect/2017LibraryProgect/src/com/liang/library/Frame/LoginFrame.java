package com.liang.library.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.library.Frame.RegisterNFrame;
import com.liubo.Service.RegLibraryService;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	private JTextField textField;
	private JTextField passwordField;
	String rname;
	public LoginFrame(final ChatFrame cf){
		 setSize(538,325);
   	     setResizable(false);
   	     int w=Toolkit.getDefaultToolkit().getScreenSize().width;//���ô�����ʾ��λ��
	     int h=Toolkit.getDefaultToolkit().getScreenSize().height;
	     setLocation((w-549)/2, (h-333)/2);
       
		
		final JPanel panel = new JPanel(){
		public void paintComponent(Graphics g){//��ͼƬ
			    super.paintComponent(g);
				ImageIcon icon=new ImageIcon("image\\IMG_1068.JPG");
				Image img =icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
		};
		panel.setLayout(null);
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);
//		setUndecorated(true);//ȡ������߿�
		
		panel.setBorder(new EmptyBorder(5,5,5,5)); 
		  this.setContentPane(panel); 
		  final JProgressBar progressBar=new JProgressBar(); 
		  progressBar.setBackground(Color.BLUE);
		  
   	 textField = new JTextField();
   	 textField.setBounds(253, 130, 192, 22);
	 panel.add(textField);
	    passwordField = new JPasswordField();
		passwordField.setBounds(253, 162, 191, 22);
		panel.add(passwordField);
	 final JButton button = new JButton();//ȷ����ť
	 button.setBounds(259, 202, 60, 28);
	 
	 button.setText("ȷ��");
	 button.setPreferredSize(new Dimension(24, 13));
	 button.setBackground(Color.CYAN);
	 panel.add(button);

	 final JButton button_1 = new JButton();//���ð�ť
	 button_1.setBounds(335, 202, 67, 28);
	 
	 button_1.setText("����");
	 button_1.setBackground(Color.CYAN);
	 panel.add(button_1);

	 final JButton button_2 = new JButton();//ע�ᰴť
	 button_2.setBounds(414, 202, 60, 28);
	 
	 button_2.setFont(new Font("", Font.BOLD, 12));
	 button_2.setBackground(Color.CYAN);
	 button_2.setText("ע��");
	 panel.add(button_2);
	 new Thread(){ 
		  public void run(){ 
			  for(int i=0;i<=100;i++){ 
				  try{ 
					  Thread.sleep(150); 
					  }catch(InterruptedException e){ 
						  e.printStackTrace(); 
						  } progressBar.setValue(i); 
						  } progressBar.setString("������ɣ�"); 
						  
						  
						  
						  button.addActionListener(new ActionListener() {
							  public void actionPerformed(final ActionEvent e) {//ȷ����ť
							 		rname = textField.getText();
						            String pass = passwordField.getText();
						            RegLibraryService rls = new RegLibraryService();
						            try {
										rls.login(cf,rname, pass);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
										JOptionPane.showMessageDialog(null, e1.getMessage());
									}
							 		
							 	}
							 });		  
		  
						  
						  button_1.addActionListener(new ActionListener() {//���ð�ť
							 	public void actionPerformed(final ActionEvent e) {
							 		textField.setText(null);
						            passwordField.setText(null);
							 	}
							 });
					
						  
						  button_2.addActionListener(new ActionListener() {
							 	public void actionPerformed(final ActionEvent e) {//ע��
							 		new RegisterNFrame().setVisible(true);
							 	}
							 }); 
		  
		  } 
		  }.start(); 
		  this.setVisible(true);
	progressBar.setBounds(10, 259, 512, 28);
	progressBar.setPreferredSize(new Dimension(500, 15));
	progressBar.setStringPainted(true); 
	panel.add(progressBar); 
	 
	 
	 
	 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
