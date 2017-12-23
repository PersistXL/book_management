package com.java.io.frame;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.entity.LibraryBook;
import com.java.service.LibraryBookService;
/**
 * 通过类型搜索
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class TypeFrame extends JInternalFrame {
   private JTable table;
   DefaultTableModel dtm = new DefaultTableModel();
   public TypeFrame(String type){
	   setSize(713,409);
       setClosable(true);
       setMaximizable(true);
	   final JScrollPane scrollPane = new JScrollPane();
	   getContentPane().add(scrollPane, BorderLayout.CENTER);

	   table = new JTable();
	   scrollPane.setViewportView(table);
	   scrollPane.setViewportView(table);
	   table.setModel(dtm);
	   dtm.addColumn("图书编号");
	   dtm.addColumn("图书名称");
	   dtm.addColumn("图书单价");
	   dtm.addColumn("图书库存");
	   dtm.addColumn("图书类型");
	   LibraryBookService bbs = new LibraryBookService();
	   try {
			List<LibraryBook> list  = bbs.queryType(type);
			for (LibraryBook lib : list) {
				dtm.addRow(new Object[]{lib.getBOOKNO(),lib.getBOOKNAME(),lib.getBOOKPRICE(),lib.getBOOKINVEN(),lib.getBOOKTYPE()});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   @SuppressWarnings("unused")
	int row = table.getSelectedRow();
   }
} 
