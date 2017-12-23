package com.qingeng.Service;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;

import com.qingeng.Dao.DelBookDao;
import com.qingeng.Entity.Book;
import com.qingeng.Frame.DelBookFrame;

/**
 * 查询 ,删除图书service层
 * @author Administrator
 *
 */
public class DelBookService {
	DelBookDao delDao = new DelBookDao();
	List<Book> list = new ArrayList<Book>();
	
	/**
	 * 选中查询到的表的行删除
	 * @return 
	 * @throws SQLException 
	 */
	public List<Book> query() throws SQLException{
		 list = delDao.queryBook();
		 return list;
	}
	
	/**
	 * 删除
	 * @throws SQLException 
	 */
	public void del(String bno) throws SQLException{
		delDao.delBook(bno);
		throw new RuntimeException("删除成功");
	}


	public void showOnlybbs(JDesktopPane desktopPane, DelBookFrame dbf) {
		// TODO Auto-generated method stub
		boolean flag = false;
	   	Component[]com = desktopPane.getComponents();
			 for (Component component : com) {
				if(component instanceof DelBookFrame){
					flag = true;
					break;
			    }
			}
			 if(flag==false){
				 desktopPane.add(dbf);
				 dbf.setVisible(true);
			 }
	   
	}

	
	
//	/**
//	 * 输入图书名称删除
//	 */
//	DelBookDao delDao = new DelBookDao();	
//	public String delService(String delName) throws SQLException{
//		if(delName==null||"".equals(delName)){
//			throw new RuntimeException("请输入要删除的图书名称");
//		}	
//		
//		/**
//		 * 校验
//		 */
//		Boolean result = null;	
//		result = delDao.query(delName);
//		if(result){//存在
//			delDao.delbook(delName);
//			throw new RuntimeException("删除成功");
//		}else{
//			throw new RuntimeException("图书名称输入错误或者该图书不存在");
//		}			
//	}

}
