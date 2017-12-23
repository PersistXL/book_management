package com.java.Pingjia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Wukexing extends JFrame {
	private JLabel lbl1 = new JLabel();
	private JLabel lbl2 = new JLabel();
	private JLabel lbl3 = new JLabel();
	private JLabel lbl4 = new JLabel();
	private JLabel lbl5 = new JLabel();
	int a = 0;
	public Wukexing(){
		
		setSize(357,246);
		Toolkit tk = Toolkit.getDefaultToolkit() ;
		int x = (tk.getScreenSize().width-347)/2 ;
		int y = (tk.getScreenSize().height-264)/2 ;
		setLocation(x, y);
		setUndecorated(true);
		getContentPane().setLayout(null);
 
		lbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl1.setText("¡ï");
				lbl2.setText("¡î");
				lbl3.setText("¡î");
				lbl4.setText("¡î");
				lbl5.setText("¡î");
				a=1;
			}
		});
		lbl1.setBackground(Color.WHITE);
		lbl1.setForeground(new Color(0, 0, 255));
		lbl1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lbl1.setText("¡î");
		lbl1.setBounds(55, 110, 20, 19);
		getContentPane().add(lbl1);
		
		lbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl1.setText("¡ï");
				lbl2.setText("¡ï");
				lbl3.setText("¡î");
				lbl4.setText("¡î");
				lbl5.setText("¡î");
				a=2;
			}
		});
		lbl2.setForeground(new Color(0, 0, 255));
		lbl2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lbl2.setText("¡î");
		lbl2.setBounds(108, 110, 20, 19);
		getContentPane().add(lbl2);
		
		
		lbl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl1.setText("¡ï");
				lbl2.setText("¡ï");
				lbl3.setText("¡ï");
				lbl4.setText("¡î");
				lbl5.setText("¡î");
				a=3;
			}
		});
		
		lbl3.setForeground(new Color(0, 0, 255));
		lbl3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lbl3.setText("¡î");
		lbl3.setBounds(165, 110, 20, 19);
		getContentPane().add(lbl3);
		
		lbl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl1.setText("¡ï");
				lbl2.setText("¡ï");
				lbl3.setText("¡ï");
				lbl4.setText("¡ï");
				lbl5.setText("¡î");
				a=4;
			}
		});
		lbl4.setForeground(new Color(0, 0, 255));
		lbl4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lbl4.setText("¡î");
		lbl4.setBounds(223, 110, 20, 19);
		getContentPane().add(lbl4);
		lbl5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl1.setText("¡ï");
				lbl2.setText("¡ï");
				lbl3.setText("¡ï");
				lbl4.setText("¡ï");
				lbl5.setText("¡ï");
				a=5;
			}
		});
		lbl5.setForeground(new Color(0, 0, 255));
		lbl5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lbl5.setText("¡î");
		lbl5.setBounds(274, 110, 20, 19);
		getContentPane().add(lbl5);
		
		
		

		final JLabel label_5 = new JLabel();
		label_5.setForeground(new Color(0, 255, 255));
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 26));
		label_5.setText("     ¸ÐÐ»ÄúµÄÆÀ¼Û");
		label_5.setBounds(55, 32, 239, 48);
		getContentPane().add(label_5);
		getContentPane().setBackground(Color.WHITE);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				switch(a){//ÆÀ¼ÛÍêÖ®ºóÏÔÊ¾¶¯Í¼
				case 1:
					EventQueue.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                    File gifFile = new File("img//1x.gif");
			                    JFrame frm = new JFrame();
			                    frm.setBounds(550, 200,320, 320);
			                    frm.setResizable(false);
			                    frm.getContentPane().add(new Gif(gifFile, 10));
			                    frm.setVisible(true);
			            }
			        });
				     break;
				case 2:
					EventQueue.invokeLater(new Runnable() {

			            @Override
			            public void run() {
			                    File gifFile = new File("img//2x.gif");
			                    JFrame frm = new JFrame();
			                   
			                    frm.setBounds(550, 200,250, 270);
			                    frm.setResizable(false);
			                    frm.getContentPane().add(new Gif(gifFile, 10));
			                    frm.setVisible(true);

			            }
			        });
					
					
					break;
				case 3:
					EventQueue.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                    File gifFile = new File("img//3x.gif");
			                    JFrame frm = new JFrame();
			                    frm.setBounds(550, 200,280, 280);
			                    frm.setResizable(false);
			                    frm.getContentPane().add(new Gif(gifFile, 10));
			                    frm.setVisible(true);
			            }
			        });
					
					break;
				case 4:
					
					EventQueue.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                    File gifFile = new File("img//4x.jpg");
			                    JFrame frm = new JFrame();
			                    frm.setBounds(550, 200,310, 330);
			                    frm.setResizable(false);
			                    frm.getContentPane().add(new Gif(gifFile, 10));
			                    frm.setVisible(true);
			            }
			        });
					break;
				case 5:
					EventQueue.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                    File gifFile = new File("img//5x.gif");
			                    JFrame frm = new JFrame();
			                    frm.setBounds(550, 200,250, 270);
			                    frm.setResizable(false);
			                    frm.getContentPane().add(new Gif(gifFile, 105));
			                    frm.setVisible(true);
			            }
			        });
					break;
                }
		
				
				
			}
		});
		button.setBackground(Color.WHITE);
		button.setText("È·ÈÏ");
		button.setBounds(67, 186, 60, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setText("È¡Ïû");
		button_1.setBounds(213, 186, 60, 28);
		getContentPane().add(button_1);
	}
	
	
//	public static void main(String[] args) {
//		new Wukexing().setVisible(true);
//	}

}
