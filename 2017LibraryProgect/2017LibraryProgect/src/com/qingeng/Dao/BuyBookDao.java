package com.qingeng.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qingeng.Dbutil.DButil;

@SuppressWarnings("unused")
public class BuyBookDao {
	DButil db = new DButil();//���߰�
	public void buybook(String buyName, String buyNum, String buyPrice, String buyType) throws SQLException{	
		String sql = "insert into librarybook(bookno,bookname,bookprice,bookinven,booktype) values (libquence.nextval,?,?,?,?)";//����ͼ��sql���
		db.executeUpdatePs(sql,new Object[]{buyName, buyNum, buyPrice, buyType});//ִ��������
	}
	public void chanDao(String buyName) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from librarybook where bookname=?";
		ResultSet rs = db.executeQueryPs(sql, new Object[]{buyName});
		if(rs.next()){
			throw new RuntimeException("������������Ѵ��ڣ�������ѡ��");
		}
	}
}
