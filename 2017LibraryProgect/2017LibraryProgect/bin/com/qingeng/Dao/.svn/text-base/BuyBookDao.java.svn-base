package com.qingeng.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qingeng.Dbutil.DButil;

@SuppressWarnings("unused")
public class BuyBookDao {
	DButil db = new DButil();//工具包
	public void buybook(String buyName, String buyNum, String buyPrice, String buyType) throws SQLException{	
		String sql = "insert into librarybook(bookno,bookname,bookprice,bookinven,booktype) values (libquence.nextval,?,?,?,?)";//购买图书sql语句
		db.executeUpdatePs(sql,new Object[]{buyName, buyNum, buyPrice, buyType});//执行添加语句
	}
	public void chanDao(String buyName) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from librarybook where bookname=?";
		ResultSet rs = db.executeQueryPs(sql, new Object[]{buyName});
		if(rs.next()){
			throw new RuntimeException("你所购买的书已存在，请重新选择！");
		}
	}
}
