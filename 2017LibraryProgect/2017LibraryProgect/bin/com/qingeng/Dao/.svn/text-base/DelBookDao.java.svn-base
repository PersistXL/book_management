package com.qingeng.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qingeng.Dbutil.DButil;
import com.qingeng.Entity.Book;

	
	/**
	 * 选中行删除，需要先查看表
	 */
	public class DelBookDao {
		DButil db = new DButil();//工具包
		List <Book> list = new ArrayList<Book>();//创建一个数组，查询到的表放在集合里，再放入模型中
		ResultSet rs;
		
		//查看表
		public List <Book> queryBook() throws SQLException{
			String sql = "select * from librarybook";//sql语句
			rs = db.executeQueryPs(sql, null);//执行语句
			
			//取值
			while(rs.next()){
				Book book = new Book();//创建书类对象
				book.setBookno(rs.getString("bookno"));
				book.setBookname(rs.getString("bookname"));
				book.setBookprice(rs.getString("bookprice"));
				book.setBookinven(rs.getString("bookinven"));
				book.setBooktype(rs.getString("booktype"));
				list.add(book);//添加到集合
			}
			return list;
		}
		
		/**
		 * 选中行删除
		 * @return 
		 * @throws SQLException 
		 */
		public void delBook(String  bno) throws SQLException{
			String sql = "delete from librarybook where bookno=?";	
			db.executeUpdatePs(sql,new Object[]{bno});
		}
	}
	
	
	
	/**
	 * 删除图书,输入图书名称删除
	 * @author Administrator
	 *
	 */
//	public class DelBookDao {
//		DButil db = new DButil();
//		ResultSet rs;
//	public void delbook(String delName ) {
//		// TODO Auto-generated method stub		
//		String sql="delete from librarybook where bookname=?";
//		db.executeUpdatePs(sql,new Object[]{delName});
//	}
//	
//	/**
//	 * 查询是否存在该图书
//	 * @throws SQLException 
//	 */
//	public boolean query(String delName) throws SQLException{
//		String sql = "select * from librarybook where bookname=?";
//		rs = db.executeQueryPs(sql, new Object[]{delName});
//		return rs.next();
//	}
//}
