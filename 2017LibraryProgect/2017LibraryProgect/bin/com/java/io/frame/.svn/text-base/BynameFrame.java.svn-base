package com.java.io.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.entity.LibraryBook;
import com.java.service.LibraryBookService;

@SuppressWarnings("serial")
public class BynameFrame extends JInternalFrame {//通过书名查找
   private JTable table;
   DefaultTableModel dtm = new DefaultTableModel();
   public BynameFrame(String name){
	   setSize(732,416);
       setClosable(true);
       setMaximizable(true);
	   final JScrollPane scrollPane = new JScrollPane();
	   scrollPane.setBackground(new Color(0, 255, 255));
	   getContentPane().add(scrollPane, BorderLayout.CENTER);

	   table = new JTable();
	   scrollPane.setViewportView(table);
	   table.setModel(dtm);
	   dtm.addColumn("图书编号");
	   dtm.addColumn("图书名称");
	   dtm.addColumn("图书单价");
	   dtm.addColumn("图书库存");
	   dtm.addColumn("图书类型");
	   LibraryBookService bbs = new LibraryBookService();
	   try {
			List<LibraryBook> list  = bbs.queryByname(name);
			for (LibraryBook lib : list) {
				dtm.addRow(new Object[]{lib.getBOOKNO(),lib.getBOOKNAME(),lib.getBOOKPRICE(),lib.getBOOKINVEN(),lib.getBOOKTYPE()});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
   }
}
