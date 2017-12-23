package com.qingeng.Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.qingeng.Service.BuyBookService;

@SuppressWarnings("serial")
public class BuyBookFrame extends JInternalFrame {
	public BuyBookFrame(){
		this.setSize(402, 395);
		setClosable(true);
		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("购买数量");
		label.setBounds(84, 137, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("书的单价");
		label_1.setBounds(84, 184, 66, 18);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("购买书名");
		label_2.setBounds(84, 95, 64, 18);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("书的类型");
		label_3.setBounds(84, 231, 66, 18);
		getContentPane().add(label_3);

		final JTextPane buyBookName = new JTextPane();
		buyBookName.setBounds(176, 95, 133, 24);
		getContentPane().add(buyBookName);

		final JTextPane buyBookInven = new JTextPane();
		buyBookInven.setBounds(176, 137, 133, 24);
		getContentPane().add(buyBookInven);

		final JTextPane buyBookPrice = new JTextPane();
		buyBookPrice.setBounds(176, 184, 133, 24);
		getContentPane().add(buyBookPrice);

		final JTextPane buyBookType = new JTextPane();
		buyBookType.setBounds(176, 231, 133, 24);
		getContentPane().add(buyBookType);

		final JButton button = new JButton();
		button.setBackground(new Color(192, 192, 192));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				BuyBookService bs = new BuyBookService();
				String buyName = buyBookName.getText();//输入购买书的书名的文本框
				String buyNum = buyBookInven.getText();//输入购买书的数量
				String buyPrice = buyBookPrice.getText();//输入购买书的单价
				String buyType = buyBookType.getText();//输入购买书的类型
				@SuppressWarnings("unused")
				String mess;
				try {
					bs.chanService(buyName);
					mess= bs.buyService(buyName, buyNum, buyPrice, buyType);//提示信息内容
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());//提示信息框
				}
			}
		});
		button.setText("确认");
		button.setBounds(78, 296, 73, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.setBackground(new Color(192, 192, 192));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		button_1.setText("取消");
		button_1.setBounds(237, 296, 80, 28);
		getContentPane().add(button_1);
		setTitle("新书购入界面");

		final JLabel label_4 = new JLabel();
		label_4.setForeground(new Color(0, 0, 255));
		label_4.setFont(new Font("", Font.BOLD | Font.ITALIC, 22));
		label_4.setText("新    书    购    入");
		label_4.setBounds(119, 25, 210, 46);
		getContentPane().add(label_4);

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 392, 360);
		getContentPane().add(panel);
	}

}
