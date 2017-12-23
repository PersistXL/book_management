package com.erbo.java.borrow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.erbo.java.service.BorrowService;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.erbo.java.entityclass.EntityBookBow;



@SuppressWarnings("serial")
public class BorrowFrameMasg extends JInternalFrame {
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	public BorrowFrameMasg(final String rname){
		setSize(841,400);
		setTitle("个人借书历史信息查询");
		setClosable(true);
		getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("img\\read.PNG");
				Image img = icon.getImage();
				
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
		};
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBounds(0, 0, 831, 365);
		getContentPane().add(panel);

		final JButton button = new JButton();
		button.setOpaque(false);
		button.setBackground(SystemColor.text);
		button.setBounds(251, 302, 71, 28);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int rowsel = table.getSelectedRow(); //获得选择的行
				int rowcount = table.getSelectedRowCount(); //获得选中的总行数
				BorrowService bs  = new BorrowService();
				     try{
				       bs.showMessage(rowcount);
				       int onlyno = (int) table.getValueAt(rowsel, 0);
				       bs.stateService(onlyno);
				       new BorrowService().continueService(rname,dtm,rowsel);
				       JOptionPane.showMessageDialog(null, "续借成功！");
				       }catch(Exception e1){
				    	   JOptionPane.showMessageDialog(null, e1.getMessage());
				       }
			}
		});
		button.setText("续借");

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		button_1.setOpaque(false);
		button_1.setBackground(Color.GREEN);
		button_1.setText("取消");
		button_1.setBounds(526, 302, 71, 28);
		panel.add(button_1);

		final JLabel label = DefaultComponentFactory.getInstance().createLabel("欢迎进去个人借书历史查询系统！");
		label.setForeground(new Color(0, 0, 255));
		label.setFont(new Font("", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(257, 10, 364, 45);
		panel.add(label);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(SystemColor.textHighlightText);
		scrollPane.setBackground(SystemColor.text);
		scrollPane.setBounds(42, 67, 753, 223);
		getContentPane().add(scrollPane);
		setBackground(SystemColor.window);
		scrollPane.setOpaque(false);
//		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
//		render.setOpaque(false);
	
		scrollPane.getViewport().setOpaque(false);
		
		

		table = new JTable();
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		table.setModel(dtm);
//		JRadioButton rb = new JRadioButton();
		dtm.addColumn("借书序列");
		dtm.addColumn("图书编号");
		dtm.addColumn("图书名称");
		
		
		dtm.addColumn("图书价格");
		dtm.addColumn("图书类型");
		
		dtm.addColumn("借阅时间");
		dtm.addColumn("应还时间");
		dtm.addColumn("实还时间");
		
		dtm.addColumn("罚金");
		dtm.addColumn("租金");
		
//		dtm.addColumn("是否续借");
//		dtm.addColumn(rb);
		
		try {
			ArrayList<EntityBookBow> list = new BorrowService().lookUp(rname);
			for (EntityBookBow entityBookBow : list) {
				dtm.addRow(new Object[]{entityBookBow.getOnlyno(),entityBookBow.getBOOKNO(),entityBookBow.getBOOKNAME(),entityBookBow.getBookprice(),entityBookBow.getBooktype(),entityBookBow.getLENDDATE(),entityBookBow.getMAXDATE(),entityBookBow.getACTUDATE(),entityBookBow.getFINEMONEY(),entityBookBow.getRENTMONEY()});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}		
	}

}
