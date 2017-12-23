package com.liang.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.liang.dao.LibraryBookDao;
import com.liang.entity.LibraryBookEntity;


public class LibraryBookService {
	LibraryBookDao lbd=new LibraryBookDao();
	/**
	 * 通过书名查找
	 * 图书信息
	 * @return 
	 * @throws SQLException 
	 */
	public ArrayList<LibraryBookEntity> queryByNo(String bookno) throws SQLException{
		ArrayList<LibraryBookEntity> list = lbd.queryByNo(bookno);
		return list;
	}
	/**
	 * 通过书名修改
	 * 图书信息
	 * @throws SQLException 
	 */
	public void updateByNo(String name,int bookinven,String type,double price,String bookno) throws SQLException{
		if(bookinven<0){
			throw new RuntimeException("库存不能为负！");
		}
		lbd.updateBookNo(name, bookinven, type, price, bookno);
	}
	/**
	 * 在数据库中进行检索修改后的书籍是否和数据库本来存在的书籍重名
	 * @param bookname
	 * @param bookno 
	 * @throws SQLException 
	 */
	public void findName(String bookname, String bookno) throws SQLException {
		// TODO Auto-generated method stub
		lbd.findDao(bookname,bookno);
		
	}
	/**
	 * 判断修改框的值是否为空
	 * @param bookno
	 * @param bookname
	 * @param bookinven
	 * @param bookprice
	 */
	public void chargeNull(String bookno, String bookname, String bookinven, String bookprice) {
		// TODO Auto-generated method stub
		if(bookno.equals("")){
			throw new RuntimeException("图书编号不能为空！");
		}
		if(bookname.equals("")){
			throw new RuntimeException("图书名不能为空！");
		}
		if(bookinven.equals("")){
			throw new RuntimeException("图书库存不能为空！");
		}
		
		if(bookprice.equals("")){
			throw new RuntimeException("图书价格不能为空！");
		}

	}

}
