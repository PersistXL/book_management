package com.java.io.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.entity.LibraryBook;
import com.java.service.LibraryBookService;

@SuppressWarnings("serial")
public class FindFrame extends JInternalFrame {
	/**
	 * 查看的方法
	 */
   private JTable table;
   DefaultTableModel dtm = new DefaultTableModel();
   public FindFrame(){
	   setSize(848,436);
	   setClosable(true);
	  
	   setTitle("图书信息");

	   final JScrollPane scrollPane = new JScrollPane();
	   scrollPane.setOpaque(false);
	   scrollPane.setFont(new Font("", Font.PLAIN, 15));
	   scrollPane.setBackground(SystemColor.text);
	   getContentPane().add(scrollPane, BorderLayout.CENTER);
	   setBackground(SystemColor.text);
	   getContentPane().setForeground(SystemColor.window);
	   getContentPane().setBackground(SystemColor.window);
	   setOpaque(false);

	   table = new JTable(20,3);
	   scrollPane.setViewportView(table);
	   table.setModel(dtm);
	   dtm.addColumn("图书编号");
	   dtm.addColumn("图书名称");
	   dtm.addColumn("图书单价");
	   dtm.addColumn("图书库存");
	   dtm.addColumn("图书类型");
	   
	   
	   
	   
	   
	   LibraryBookService bbs = new LibraryBookService();
	   try {
		   List<LibraryBook> list = bbs.findBook();
		   for (LibraryBook lib: list) {
			dtm.addRow(new Object[]{lib.getBOOKNO(),lib.getBOOKNAME(),lib.getBOOKPRICE(),lib.getBOOKINVEN(),lib.getBOOKTYPE()});
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
   }
   
}
