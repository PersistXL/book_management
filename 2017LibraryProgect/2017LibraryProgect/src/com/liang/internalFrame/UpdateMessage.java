package com.liang.internalFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.liang.entity.LibraryBookEntity;
import com.liang.entity.RnameSumFinemoney;
import com.liang.service.BorrowBookService;
import com.liang.service.LibraryBookService;
import com.liang.service.RegLibraryService;


@SuppressWarnings("serial")
public class UpdateMessage extends JInternalFrame {
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	RegLibraryService rls=new RegLibraryService();
	BorrowBookService bbs=new BorrowBookService();
	LibraryBookService lbs=new LibraryBookService();
	String name;
	private JTextField tf7;
	private JTextField tf6;
	private JTextField tf5;
	private JTextField tf4;
	private JTextField tf3;
	private JTextField tf2;
	private JTextField tf1;
	private JTextField tf0;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UpdateMessage(){
		setSize(462,337);
		setClosable(true);
		setTitle("信息修改窗口");
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		
		

		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(22, 41, 405, 231);
		getContentPane().add(tabbedPane);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("修改用户信息", null, panel, null);

		final JLabel label = new JLabel();
		label.setBounds(39, 10, 91, 18);
		label.setText("请输入用户名：");
		panel.add(label);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				name=tf0.getText();
				try {
					if(name.equals("")){
						throw new RuntimeException("用户名不能为空！");
					}
					ArrayList<RnameSumFinemoney> list = rls.queryFM(name);
					for (RnameSumFinemoney x : list) {
						String mborr=x.getRmaxborrow();
						String bord=x.getRborrowed();
						String sum=x.getSumfinemoney();
						tf1.setText(mborr);
						tf2.setText(bord);
						tf3.setText(sum);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setBounds(284, 10, 60, 18);
		button.setText("确定");
		panel.add(button);

		tf0 = new JTextField();
		tf0.setBounds(164, 8, 87, 22);
		panel.add(tf0);

		final JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 204, 153));
		panel_2.setBounds(0, 41, 400, 4);
		panel.add(panel_2);

		final JLabel label_1 = new JLabel();
		label_1.setText("最大借阅量：");
		label_1.setBounds(39, 67, 78, 18);
		panel.add(label_1);

		tf1 = new JTextField();
		tf1.setBounds(164, 65, 87, 22);
		panel.add(tf1);

		final JLabel label_2 = new JLabel();
		label_2.setText("已借书本数：");
		label_2.setBounds(39, 110, 78, 18);
		panel.add(label_2);

		tf2 = new JTextField();
		tf2.setBounds(164, 108, 87, 22);
		panel.add(tf2);

		final JLabel label_3 = new JLabel();
		label_3.setText("罚金：");
		label_3.setBounds(39, 152, 66, 18);
		panel.add(label_3);

		tf3 = new JTextField();
		tf3.setBounds(164, 150, 87, 22);
		panel.add(tf3);

		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String maxb=tf1.getText();
				String borrowed=tf2.getText();
				String fineMoney=tf3.getText();
//				if(maxb.equals("")){
//					throw new RuntimeException("最大借阅量不能为空！");
//				}
//				if(borrowed.equals("")){
//					throw new RuntimeException("用户名不能为空！");
//				}
//				if(fineMoney.equals("")){
//					throw new RuntimeException("用户名不能为空！");
//				}
				try {
					rls.updateByName(maxb, borrowed, name);
					bbs.upgateFM(fineMoney, name);
					JOptionPane.showMessageDialog(null, "修改成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setText("修改");
		button_2.setBounds(284, 92, 60, 57);
		panel.add(button_2);

		final JPanel panel_1 = new JPanel();
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(167, 162, 84, 27);
		comboBox.setEditable(true);
		panel_1.add(comboBox);
		comboBox.addItem("小说类");
		comboBox.addItem("名著类");
		comboBox.addItem("玄幻类");
		comboBox.addItem("科普类");
		comboBox.addItem("杂志类");
		comboBox.addItem("哲学类");
		panel_1.setLayout(null);
		tabbedPane.addTab("修改图书信息", null, panel_1, null);

		final JLabel label_4 = new JLabel();
		label_4.setBounds(38, 10, 104, 18);
		label_4.setText("请输入图书编号：");
		panel_1.add(label_4);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String bookno=tf4.getText();
				try {
					ArrayList<LibraryBookEntity> list = lbs.queryByNo(bookno);
					for (LibraryBookEntity x : list) {
						tf5.setText(x.getBookname());
						tf6.setText(x.getBookinven());
						tf7.setText(x.getBookprice());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(284, 10, 60, 18);
		button_1.setText("确定");
		panel_1.add(button_1);

		tf4 = new JTextField();
		tf4.setBounds(167, 8, 87, 22);
		panel_1.add(tf4);
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 204, 153));
		panel_3.setBounds(0, 41, 400, 4);
		panel_1.add(panel_3);

		final JLabel label_5 = new JLabel();
		label_5.setText("书名：");
		label_5.setBounds(38, 58, 66, 18);
		panel_1.add(label_5);

		tf5 = new JTextField();
		tf5.setBounds(167, 56, 87, 22);
		panel_1.add(tf5);

		final JLabel label_6 = new JLabel();
		label_6.setText("库存：");
		label_6.setBounds(38, 94, 66, 18);
		panel_1.add(label_6);

		tf6 = new JTextField();
		tf6.setBounds(167, 92, 87, 22);
		panel_1.add(tf6);

		final JLabel label_7 = new JLabel();
		label_7.setText("价格：");
		label_7.setBounds(38, 126, 66, 18);
		panel_1.add(label_7);

		tf7 = new JTextField();
		tf7.setBounds(167, 124, 87, 22);
		panel_1.add(tf7);

		final JLabel label_8 = new JLabel();
		label_8.setText("类型：");
		label_8.setBounds(38, 162, 66, 18);
		panel_1.add(label_8);

		final JButton button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String bookno=tf4.getText();
				String bookname=tf5.getText();
				String booki=tf6.getText();
				String bookpri=tf7.getText();
				String booktype=(String) comboBox.getSelectedItem();
				int bookinven = 0;
				double bookprice = 0;
				try{
					lbs.chargeNull(bookno,bookname,booki,bookpri);
					bookinven = Integer.parseInt(booki);
					bookprice =  Double.parseDouble(bookpri);
					lbs.findName(bookname,bookno);
					lbs.updateByNo(bookname, bookinven, booktype, bookprice, bookno);
					JOptionPane.showMessageDialog(null, "修改成功");
				}catch(Exception e3){
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
			}
		});
		button_3.setText("修改");
		button_3.setBounds(273, 94, 87, 50);
		panel_1.add(button_3);

		
	}

}
