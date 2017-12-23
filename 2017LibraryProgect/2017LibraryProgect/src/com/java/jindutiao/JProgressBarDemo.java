package com.java.jindutiao;

/** * java swing 之进度条的使用 * @author gao */ 
import java.awt.FlowLayout;

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JProgressBar; 
import javax.swing.border.EmptyBorder;  
  @SuppressWarnings("serial")
public class JProgressBarDemo extends JFrame { 
	  public JProgressBarDemo(){ 
		  this.setTitle("进度条的使用"); 
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		  this.setBounds(100, 100, 250, 100); 
		  JPanel contentPane=new JPanel(); 
		  contentPane.setBorder(new EmptyBorder(5,5,5,5)); 
		  this.setContentPane(contentPane); 
		  contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5)); 
		  final JProgressBar progressBar=new JProgressBar(); 
		  progressBar.setStringPainted(true); 
		  new Thread(){ 
			  public void run(){ 
				  for(int i=0;i<=100;i++){ 
					  try{ 
						  Thread.sleep(100); 
						  }catch(InterruptedException e){ 
							  e.printStackTrace(); 
							  } progressBar.setValue(i); 
							  } progressBar.setString("加载完成！"); } 
			  }.start(); 
			  contentPane.add(progressBar); 
			  this.setVisible(true); 
			  } 
	  public static void main(String[]args){ 
		  @SuppressWarnings("unused")
		JProgressBarDemo example=new JProgressBarDemo(); 
		  } 
}
