package com.java.io.frame;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.java.entity.BorrowBook;
import com.java.entity.LibraryBook;
import com.java.service.BorrowBookService;
import com.java.service.LibraryBookService;
import com.java.service.ReglibraryService;

@SuppressWarnings("serial")
public class BorrowFrame extends JInternalFrame {
   private JTable table_1;
   private JTable table;
   private JTextField textno;
   DefaultTableModel dtm = new DefaultTableModel();
   DefaultTableModel dtm1 = new DefaultTableModel();
   public BorrowFrame(final String rname){
	   final BorrowBookService bbs = new BorrowBookService();
	   setSize(844,458);
	   setClosable(true);
	   setTitle("借阅书籍");
	   getContentPane().setLayout(null);

	   final JLabel label = new JLabel();
	   label.setBackground(Color.LIGHT_GRAY);
	   label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	   label.setFont(new Font("@黑体", Font.BOLD | Font.ITALIC, 15));
	   label.setText("请输入图书编号：");
	   label.setBounds(144, 80, 139, 37);
	   getContentPane().add(label);

	   textno = new JTextField();
	   textno.setOpaque(false);
	   textno.setBackground(Color.WHITE);
	   textno.setBounds(300, 81, 242, 37);
	   getContentPane().add(textno);

	   final JLabel label_1 = new JLabel();
	   label_1.setHorizontalAlignment(SwingConstants.CENTER);
	   label_1.setForeground(new Color(0, 128, 0));
	   label_1.setFont(new Font("", Font.BOLD | Font.ITALIC, 22));
	   label_1.setText("欢迎进入黄金屋图书馆借阅系统！");
	   label_1.setBounds(154, 10, 492, 55);
	   getContentPane().add(label_1);

	   final JScrollPane scrollPane = new JScrollPane();
	   scrollPane.setBackground(new Color(255, 255, 255));
	   scrollPane.setOpaque(false);
	   scrollPane.setForeground(Color.BLUE);
	   scrollPane.setBounds(165, 187, 499, 41);
	   getContentPane().add(scrollPane);

	   table = new JTable();
	   scrollPane.setViewportView(table);

	   final JLabel label_2 = new JLabel();
	   label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	   label_2.setText("请阅读：");
	   label_2.setBounds(78, 153, 76, 28);
	   getContentPane().add(label_2);

	   final JButton button = new JButton();
	   button.setOpaque(false);
	   button.addActionListener(new ActionListener() {
	   	public void actionPerformed(final ActionEvent e) {
	   		LibraryBookService lbs = new LibraryBookService();
	 	   String number = textno.getText();
	 	   int cont = table.getRowCount();
	 	   for(int i=0;i<cont;i++){
	 		   dtm.removeRow(0);
	 	   }
	 	   try {
	 		   List<LibraryBook> list = lbs.queryBynumber(number);
	 		   for (LibraryBook lib: list) {
	 			     dtm.addRow(new Object[]{lib.getBOOKNO(),lib.getBOOKNAME(),lib.getBOOKPRICE(),lib.getBOOKINVEN(),lib.getBOOKTYPE()});
	 			}
	 	} catch (Exception e1) {
	 		// TODO Auto-generated catch block
	 		//e1.printStackTrace();
	 		JOptionPane.showMessageDialog(null, e1.getMessage());
	 	}
	   	}
	   });
	   button.setBackground(Color.GREEN);
	   button.setText("确定");
	   button.setBounds(568, 85, 60, 28);
	   getContentPane().add(button);
	   table.setModel(dtm);

	   final JButton button_1 = new JButton();
	   button_1.setOpaque(false);
	   button_1.addActionListener(new ActionListener() {
	   	public void actionPerformed(final ActionEvent e) {//点击借阅按钮后
	   		int cont = table_1.getRowCount();
		 	   for(int i=0;i<cont;i++){
		 		   dtm1.removeRow(0);
		 	   }
	   		String bookno = textno.getText();//获取文本框的图书编号
	   		String bookname =null;
	   		double bookprice = 0;
	   		@SuppressWarnings("unused")
			int bookinven=0;
	   		String booktype=null;
	   		//通过用户名链接注册表判断是否可借
	   		try {
	   			ReglibraryService rs= new ReglibraryService();
	   			rs.RborService(rname);//
	   			LibraryBookService ls = new LibraryBookService();
	   			ls.InvenService(bookno);
				rs.updateService(rname);
				ls.libookService(bookno);
				List<LibraryBook> list = ls.BybooknoService(bookno);
				for (LibraryBook lib : list) {
					bookname = lib.getBOOKNAME();
					bookprice = lib.getBOOKPRICE();
					bookinven = lib.getBOOKINVEN();
					booktype = lib.getBOOKTYPE();
				}
				
				bbs.borrowService(rname, bookno, bookname, bookprice, booktype);
				   try {
					   List<BorrowBook> list1 =bbs.queryByrnameService(rname);
					   for (BorrowBook bor : list1) {
						dtm1.addRow(new Object[]{bor.getBookno(),bor.getBookname(),bor.getBookprice(),bor.getLenddate(),bor.getMaxdate(),bor.getBooktype()});
					}
					   JOptionPane.showMessageDialog(null, "恭喜您,借书成功,请按时归还,防止逾期!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage());
				List<BorrowBook> list1 = null;
				try {
					list1 = bbs.queryByrnameService(rname);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				   for (BorrowBook bor : list1) {
					dtm1.addRow(new Object[]{bor.getBookno(),bor.getBookname(),bor.getBookprice(),bor.getLenddate(),bor.getMaxdate(),bor.getBooktype()});
				}
				//dispose();
			}
	   	}
	   });
	   button_1.setBackground(Color.ORANGE);
	   button_1.setForeground(Color.BLUE);
	   button_1.setText("借阅");
	   button_1.setBounds(214, 260, 104, 28);
	   getContentPane().add(button_1);

	   final JButton button_2 = new JButton();
	   button_2.setOpaque(false);
	   button_2.addActionListener(new ActionListener() {
	   	public void actionPerformed(final ActionEvent e) {
	   		dispose();
	   	}
	   });
	   button_2.setBackground(Color.ORANGE);
	   button_2.setForeground(Color.BLUE);
	   button_2.setText("取消");
	   button_2.setBounds(465, 260, 104, 28);
	   getContentPane().add(button_2);

	   final JScrollPane scrollPane_1 = new JScrollPane();
	   scrollPane_1.setBackground(SystemColor.text);
	   scrollPane_1.setOpaque(false);
	   scrollPane_1.setBounds(135, 313, 582, 93);
	   getContentPane().add(scrollPane_1);
	   setBackground(SystemColor.text);

	   table_1 = new JTable();
	   scrollPane_1.setViewportView(table_1);
	   dtm.addColumn("图书编号");
	   dtm.addColumn("图书名称");
	   dtm.addColumn("图书单价");
	   dtm.addColumn("图书库存");
	   dtm.addColumn("图书类型");
	   table_1.setModel(dtm1);

	   final JPanel panel = new JPanel()
	   {
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("img\\IMG_1056.JPG");
				Image img = icon.getImage();
				
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
		};
	   panel.setBackground(UIManager.getColor("Button.light"));
	   panel.setOpaque(false);
	   panel.setBounds(0, 0, 834, 423);
	   getContentPane().add(panel);
	   setOpaque(false);
	   dtm1.addColumn("图书编号");
	   dtm1.addColumn("图书名称");
	   dtm1.addColumn("图书单价");
	   dtm1.addColumn("借出时间");
	   dtm1.addColumn("最大期限");
	   dtm1.addColumn("图书类型");
	   
   }
}
