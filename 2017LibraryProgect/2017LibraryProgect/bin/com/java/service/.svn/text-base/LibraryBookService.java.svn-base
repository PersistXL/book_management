package com.java.service;

import java.awt.Component;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JDesktopPane;

import com.java.dao.LibraryBookDao;
import com.java.entity.LibraryBook;
import com.java.io.frame.BorrowFrame;
import com.java.io.frame.BynameFrame;
import com.java.io.frame.FindFrame;
import com.java.io.frame.TypeFrame;

public class LibraryBookService {
	LibraryBookDao lbd = new LibraryBookDao();
	/**
	 * 查看的方法
	 * @return
	 * @throws SQLException
	 */
    public List<LibraryBook> findBook() throws SQLException{
    	List<LibraryBook> list  = lbd.queryBookAll();
		return list;
    }
    /**
     * 通过类型搜索
     * @param type
     * @return
     * @throws SQLException
     */
    public List<LibraryBook> queryType(String type) throws SQLException{
    	List<LibraryBook> list  = lbd.queryType(type);
    	return list;
    }
    /**
     * 通过书名查找
     */
    public List<LibraryBook> queryByname(String name) throws SQLException{
    	List<LibraryBook> list  = lbd.queryByname(name);
    	return list;
    }
    /**
     * 判断容器中的个数是否有现在的
     * @param fbf 
     * @param desktopPane 
     */
    public void showOnlyff(JDesktopPane desktopPane, FindFrame ff){
    	boolean flag = false;
    	Component[]com = desktopPane.getComponents();
		 for (Component component : com) {
			if(component instanceof FindFrame){
				flag = true;
				break;
		    }
		}
		 if(flag==false){
			 desktopPane.add(ff);
			 ff.setVisible(true);
		 }
    }
    public void showOnlybf(JDesktopPane desktopPane, BynameFrame bf){
    	boolean flag = false;
    	Component[]com = desktopPane.getComponents();
		 for (Component component : com) {
			if(component instanceof BynameFrame){
				flag = true;
				break;
		    }
		}
		 if(flag==false){
			 desktopPane.add(bf);
			 bf.setVisible(true);
		 }
    }
    public void showOnlytf(JDesktopPane desktopPane, TypeFrame tf){
    	boolean flag = false;
    	Component[]com = desktopPane.getComponents();
		 for (Component component : com) {
			if(component instanceof TypeFrame){
				flag = true;
				break;
		    }
		}
		 if(flag==false){
			 desktopPane.add(tf);
			 tf.setVisible(true);
		 }
    }
    public void showOnlybbff(JDesktopPane desktopPane, BorrowFrame bbff){
    	boolean flag = false;
    	Component[]com = desktopPane.getComponents();
		 for (Component component : com) {
			if(component instanceof BorrowFrame){
				flag = true;
				break;
		    }
		}
		 if(flag==false){
			 desktopPane.add(bbff);
			 bbff.setVisible(true);
		 }
    }
    /**
	 * 借书是输入编号，查找有没该书
	 */
    public List<LibraryBook> queryBynumber(String number) throws SQLException{
    	List<LibraryBook> list  = lbd.queryBynumber(number);
    	if(number.equals("")){
    		throw new RuntimeException("请输入图书编号!");
    	}
    	if(list.size()==0){
    		throw new RuntimeException("该编号所对应的图书不存在！");
    	}
    	
    	return list;
    }
    /**
	 * 通过图书编号判断图书库存是否大于0
	 * @throws SQLException 
	 */
	LibraryBookDao lb = new LibraryBookDao();
	public void InvenService(String bookno) throws SQLException{
		int bk = lb.InvenDao(bookno);//返回库存
		if(bk==0){
			throw new RuntimeException("您所借的书本已全部借出,请选择其他书籍!");
		}
	}
	public void libookService(String bookno) throws SQLException{
		lb.libookDao(bookno);
	}
	/**
	 * 通过bookno查找到图书名称,单价,库存，类型
	 * @throws SQLException 
	 */
	 public List<LibraryBook> BybooknoService(String bookno) throws SQLException{
		 List<LibraryBook> list  = lbd.BybooknoDao(bookno);
		return list;
	 }
	 /**
	  * 还书时让库存加一
	 * @throws SQLException 
	  */
	 public void libookInvenService(String bookno) throws SQLException{
		 lbd.libookInvenDao(bookno);
	 }
}
