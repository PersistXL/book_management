package com.erbo.java.service;


import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

import com.erbo.java.borrow.BorrowFrameMasg;
import com.erbo.java.dao.BookBorrowDao;
import com.erbo.java.entityclass.EntityBookBow;

public class BorrowService {
	
	BookBorrowDao dao = new BookBorrowDao();
	/**
	 * 查询个人资料
	 * @throws SQLException 
	 */
	public ArrayList<EntityBookBow> lookUp(String name) throws SQLException{
		ArrayList<EntityBookBow> list = dao.lookDao(name);
		
		return list;   //给界面返回一个list，然后在界面对list进行遍历
		
	}
	
	/**
	 * 续借书籍的操作
	 * @param dtm 
	 * @param rowsel 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public void continueService(String name, DefaultTableModel dtm, int rowsel) throws SQLException, ParseException{
		dao.continueRead(name,dtm,rowsel);
	}
	
	/**
	 * 接收用户选中的行，通过行来判断用户选中的书籍是否可续借
	 * @param row
	 * @throws SQLException 
	 */
	public void stateService(int onlyno) throws SQLException{ //接收用户选中的行，通过行来判断用户选中的书籍是否可续借
		dao.chargeState(onlyno);
	}
	
	/**
	 * 抛出提示框
	 * @param rowcount 
	 */
	public void showMessage(int rowcount){
		if(rowcount==0){
			throw new RuntimeException("请选择要续借的书！");
		}else if(rowcount>1){
			throw new RuntimeException( "一次只能续借一本书！");
		}
	}
	
	 /**
     * 判断容器中的个数是否有现在的
     * @param fbf 
     * @param desktopPane 
     */
    public void showOnlyff(JDesktopPane desktopPane, BorrowFrameMasg bf){
    	boolean flag = false;
    	Component[]com = desktopPane.getComponents();
		 for (Component component : com) {
			if(component instanceof BorrowFrameMasg){
				flag = true;
				break;
		    }
		}
		 if(flag==false){
			 desktopPane.add(bf);
			 bf.setVisible(true);
		 }
    }
}
