package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.DButils.DButils;
import com.java.entity.LibraryBook;

public class LibraryBookDao {
	DButils db = new DButils();
	/**
	 * 取数据放入集合中的方法
	 * @param list 
	 * @param rs 
	 * @throws SQLException 
	 */
	public void find(ResultSet rs, List<LibraryBook> list) throws SQLException{
		while(rs.next()){
			LibraryBook bb = new LibraryBook();
			bb.setBOOKNO(rs.getString("bookno"));
			bb.setBOOKNAME(rs.getString("bookname"));
			bb.setBOOKPRICE(rs.getDouble("BOOKPRICE"));
			bb.setBOOKINVEN(rs.getInt("BOOKINVEN"));
			bb.setBOOKTYPE(rs.getString("BOOKTYPE"));
			bb.setTimes(rs.getInt("times"));
			list.add(bb);
		}
	}
	/**
	 * 用户查看所有书籍的方法
	 * @return
	 */
	public List<LibraryBook> queryBookAll() throws SQLException{
		String sql = "select * from librarybook";
		ResultSet rs = db.executeQueryPS(sql, null);
		List<LibraryBook> list = new ArrayList<LibraryBook>();
		find(rs,list);
		return list;
	}
	/**
	 * 搜索的功能 通过类型
	 * @throws SQLException 
	 */
	public List<LibraryBook> queryType(String type) throws SQLException{
		String sql = "select * from librarybook where booktype=?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{type});
		List<LibraryBook> list = new ArrayList<LibraryBook>();
		find(rs,list);
		return list;
	}
	/**
	 * 精确查找
	 */
	public List<LibraryBook> queryByname(String name) throws SQLException{
		String sql = "select * from librarybook where bookname=?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{name});
		List<LibraryBook> list = new ArrayList<LibraryBook>();
		find(rs,list);
		return list;
	}
	/**
	 * 借书是输入编号，查找有没该书
	 * @throws SQLException 
	 */
	public List<LibraryBook> queryBynumber(String number) throws SQLException{
		String sql = "select * from librarybook where bookno=?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{number});
		List<LibraryBook> list = new ArrayList<LibraryBook>();
		find(rs,list);
		return list;
	}
	
	public int InvenDao(String bookno) throws SQLException{
		String sql = "select bookinven from librarybook where bookno=?";
		int bi = 0;
		ResultSet rs = db.executeQueryPS(sql,new Object[]{bookno});
		while(rs.next()){
			bi = rs.getInt("bookinven");
		}
		return bi;//图书表可借栏的值
	}
	public void libookDao(String bookno) throws SQLException{
		String sql = "select bookinven,times from librarybook where bookno=?";
		int bi = 0;
		int times=0;//借书次数
		ResultSet rs = db.executeQueryPS(sql,new Object[]{bookno});
		while(rs.next()){
			bi = rs.getInt("bookinven");
			times=rs.getInt("times");
		}
		int b = bi-1;
		int t = times+1;
		String sqll = "update librarybook set bookinven=?,times=? where bookno=?";
		db.executeUpdatePS(sqll, new Object[]{b,t,bookno});
	}
	/**
	 * 通过bookno查找到图书名称,单价,库存，类型
	 * @throws SQLException 
	 */
	public List<LibraryBook> BybooknoDao(String bookno) throws SQLException{
		String sql = "select bookno,bookname,bookprice,BOOKINVEN,BOOKTYPE from librarybook where bookno=?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{bookno});
		List<LibraryBook> list = new ArrayList<LibraryBook>();
		while(rs.next()){
			LibraryBook bb = new LibraryBook();
			bb.setBOOKNO(rs.getString("bookno"));
			bb.setBOOKNAME(rs.getString("bookname"));
			bb.setBOOKPRICE(rs.getDouble("BOOKPRICE"));
			bb.setBOOKINVEN(rs.getInt("BOOKINVEN"));
			bb.setBOOKTYPE(rs.getString("BOOKTYPE"));
			list.add(bb);
		}
		return list;
	}
	/**
	 * 还书时让库存加一
	 */
	public void libookInvenDao(String bookno) throws SQLException{
		String sql = "select bookinven,times from librarybook where bookno=?";
		int bi = 0;
		ResultSet rs = db.executeQueryPS(sql,new Object[]{bookno});
		while(rs.next()){
			bi = rs.getInt("bookinven");
		}
		int b = bi+1;
		String sqll = "update librarybook set bookinven=? where bookno=?";
		db.executeUpdatePS(sqll, new Object[]{b,bookno});
	}
}
