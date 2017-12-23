package com.java.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.java.DButils.DButils;
import com.java.entity.BorrowBook;

public class BorrowBookDao {
	DButils db = new DButils();
	/**
	 * 更新借出书本表的信息
	 */
	public void updateBorrowDao(String rname,String bookno,String bookname,double bookprice,String booktype){
		String sql = "insert into borrowbook(onlyno,rname,bookno,bookname,bookprice,booktype) values(bwbquence.nextval,?,?,?,?,?)";
		db.executeUpdatePS(sql,new Object[]{rname,bookno,bookname,bookprice,booktype});
	}
   /**
    * 通过姓名取数据
 * @throws SQLException 
    */
	public List<BorrowBook> queryByrnameDao(String rname) throws SQLException{
		String sql = "select * from borrowbook where rname=?";
		ResultSet rs = db.executeQueryPS(sql,new Object[]{rname});
		List<BorrowBook> list = new ArrayList<BorrowBook>();
		while(rs.next()){
			BorrowBook bb = new BorrowBook();
			bb.setOnlyno(rs.getInt("onlyno"));
			bb.setBookno(rs.getString("bookno"));
			bb.setBookname(rs.getString("bookname"));
			bb.setBookprice(rs.getDouble("bookprice"));
			bb.setLenddate(rs.getDate("lenddate"));
			bb.setMaxdate(rs.getDate("maxdate"));
			bb.setBooktype(rs.getString("booktype"));
			bb.setActudate(rs.getDate("Actudate"));
			bb.setFinemoney(rs.getDouble("finemoney"));
			bb.setRentmoney(rs.getDouble("rentmoney"));
			list.add(bb);
		}
		return list;
	}
	/**
	 * 通过姓名和状态取没有还得数的数据
	 */
	public List<BorrowBook> queryByrnameactuDao(String rname) throws SQLException{
		String bookstate="未还";
		String sql = "select * from borrowbook where rname=? and bookstate=?";
		ResultSet rs = db.executeQueryPS(sql,new Object[]{rname,bookstate});
		List<BorrowBook> list = new ArrayList<BorrowBook>();
		while(rs.next()){
			BorrowBook bb = new BorrowBook();
			bb.setOnlyno(rs.getInt("onlyno"));
			bb.setBookno(rs.getString("bookno"));
			bb.setBookname(rs.getString("bookname"));
			bb.setBookprice(rs.getDouble("bookprice"));
			bb.setLenddate(rs.getDate("lenddate"));
			bb.setMaxdate(rs.getDate("maxdate"));
			bb.setBooktype(rs.getString("booktype"));
			bb.setActudate(rs.getDate("Actudate"));
			bb.setFinemoney(rs.getDouble("finemoney"));
			bb.setRentmoney(rs.getDouble("rentmoney"));
			list.add(bb);
		}
		return list;
	}
	/**
	 * 还书
	 * @param lenddate 
	 * @param bookno 
	 */
	public void updateByOnlyDao(int onlyno){
		String state = "已还";
		java.util.Calendar juc = java.util.Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String da = sdf.format(juc.getTime());
		String str[] = da.split("-");
		str[0] = 20+str[0];
		String str1 = str[0]+"/"+str[1]+"/"+str[2];
		String str3 []= str1.split(" ");
		String str5=str3[0];
		String sql = "update borrowbook set actudate =to_date(?,'yyyy/mm/dd'),bookstate=? where onlyno=?";
		db.executeUpdatePS(sql, new Object[]{str5,state,onlyno});
	}
	/**
	 * 计算是否逾期，计算还书价格
	 * @throws SQLException 
	 */
	public List<BorrowBook> queryContmoney(int onlyno) throws SQLException{
		String sql = "select * from borrowbook where onlyno=?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{onlyno});
		List<BorrowBook> list = new ArrayList<BorrowBook>();
		while(rs.next()){
			BorrowBook bb = new BorrowBook();
			bb.setOnlyno(rs.getInt("onlyno"));
			bb.setBookno(rs.getString("bookno"));
			bb.setBookname(rs.getString("bookname"));
			bb.setBookprice(rs.getDouble("bookprice"));
			bb.setLenddate(rs.getDate("lenddate"));
			bb.setMaxdate(rs.getDate("maxdate"));
			bb.setBooktype(rs.getString("booktype"));
			bb.setActudate(rs.getDate("Actudate"));
			bb.setFinemoney(rs.getDouble("finemoney"));
			bb.setRentmoney(rs.getDouble("rentmoney"));
			list.add(bb);
		}
		return list;
	}
	/**
	 * 计算价格
	 * @param fajin 
	 * @param zujin 
	 * @param onlyno 
	 */
	public void updateMoney(double zujin, double fajin, int onlyno) {
		// TODO Auto-generated method stub
		String sql = "update borrowbook set rentmoney=?,finemoney=? where onlyno=?";
		db.executeUpdatePS(sql, new Object[]{zujin,fajin,onlyno});
	}
	
}
