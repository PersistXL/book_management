package com.liang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.liang.database.utils.DButils_prepared;
import com.liang.entity.LibraryBookEntity;


public class LibraryBookDao {
	DButils_prepared db=new DButils_prepared();
	
	/**
	 * 通过图书编号修改书名、价格、库存、类型
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public void updateBookNo(String name,int bookinven,String type,double price,String bookno) throws SQLException {
		String sql="update librarybook set bookname=?,bookprice=?,bookinven=?,booktype=? where bookno=?";
		db.executeUpdate(sql, new Object[]{name,price,bookinven,type,bookno});
	}
	/**
	 *通过图书编号查找图书信息
	 * @return 
	 * @throws SQLException 
	 */
	public ArrayList<LibraryBookEntity> queryByNo(String bookno) throws SQLException{
		ArrayList<LibraryBookEntity> list=new ArrayList<LibraryBookEntity>();
		String sql="select * from librarybook where bookno=?";
		ResultSet res = db.executeQuery(sql, new Object[]{bookno});
		while(res.next()){
			LibraryBookEntity lbe=new LibraryBookEntity();
			lbe.setBookno(res.getString("bookno"));
			lbe.setBookname(res.getString("bookname"));
			lbe.setBookprice(res.getString("bookprice"));
			lbe.setBookinven(res.getString("bookinven"));
			lbe.setBooktype(res.getString("booktype"));
			list.add(lbe);
		}
		return list;
	}
	/**
	 * 在数据库中进行检索修改后的书籍是否和数据库本来存在的书籍重名
	 * @param bookname
	 * @param bookno 
	 * @throws SQLException 
	 */
	public void findDao(String bookname, String bookno) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from  librarybook where bookname = ?";
		ResultSet set = db.executeQuery(sql, new Object[]{bookname});
		
		
		while(set.next()){
		if(set.getString("bookno")!=null&&!(set.getString("bookno").equals(bookno)))
			throw new RuntimeException("修改后的书籍已经存在，请重新输入！");
		}
		
	}
	

}
