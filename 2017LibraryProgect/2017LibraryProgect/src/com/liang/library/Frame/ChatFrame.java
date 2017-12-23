package com.liang.library.Frame;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class ChatFrame extends JFrame implements Runnable{
	private JTextArea textArea;
	private JTextPane sendText;
	public ChatFrame(){
		setSize(446,340);
		getContentPane().setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 430, 187);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 199, 436, 71);
		getContentPane().add(scrollPane_1);

		sendText = new JTextPane();
		scrollPane_1.setViewportView(sendText);

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 185, 430, 16);
		getContentPane().add(panel);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		button.setText("关闭");
		button.setBounds(256, 273, 60, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String send=sendText.getText();
				textArea.append("发送端开启。。。。"+send+"\n");//将输入的发送消息也写到对话框中
				send();
				sendText.setText("");//发送完成后，将输入框清空
			}
		});
		button_1.setText("发送");
		button_1.setBounds(349, 273, 60, 28);
		getContentPane().add(button_1);

		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/**
		 * 接收端
		 */
		//创建连接
		try {
			@SuppressWarnings("resource")
			DatagramSocket ds=new DatagramSocket(6000);
			while(ds!=null){
				byte[] buf=new byte[1024];
				DatagramPacket dp=new DatagramPacket(buf,buf.length);//将接收到的数据打包
				ds.receive(dp);//接收消息
				String str=new String(dp.getData(),0,dp.getLength());//将接收到字节数组从第零位开始读取，解析为字符串
				textArea.append("接收端。。。。"+str+dp.getAddress()+"\n");
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	/**
	 * 发送端
	 * @throws  
	 */
	public void send(){
		try {
			@SuppressWarnings("resource")
			DatagramSocket ds=new DatagramSocket();
			String message=sendText.getText();//获取要发送的内容
			if(!message.equals("")){
				byte[] buf=message.getBytes();
				DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.139"), 8000);
				ds.send(dp);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
