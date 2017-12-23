package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.DButils.DButils;
import com.java.entity.Reglibrary;

public class ReglibraryDao {
	DButils db =  new DButils();
	/**
	 * 通过用户名判断可借栏的值
	 * @param rname
	 * @return
	 * @throws SQLException 
	 */
	public List<Reglibrary> RborDao(String rname) throws SQLException{
		String sql = "select RMAXBORROW,RBORROWED from reglibrary where rname=?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{rname});
		List<Reglibrary> list = new ArrayList<Reglibrary>();
		while(rs.next()){
			Reglibrary rl = new Reglibrary();
			rl.setRborrowed(rs.getInt("RBORROWED"));
			rl.setRmaxborrow(rs.getInt("RMAXBORROW"));
			list.add(rl);
		}
		return list;//可借栏的值
	}
	
	public void updateRegDao(String rname) throws SQLException{
		String sql = "select RBORROWED from reglibrary where rname =?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{rname});
		int rbo=0; //用户已借书个数
		while(rs.next()){
			rbo = rs.getInt("RBORROWED");
		}
		int a = rbo+1;
		String sql1 = "update reglibrary set RBORROWED=? where rname =?";
		db.executeUpdatePS(sql1, new Object[]{a,rname});
	}
	/**
	 * 还书后让已借量减1
	 * @throws SQLException 
	 */
	public void updateBorrowedDao(String rname) throws SQLException{
		String sql = "select RBORROWED from reglibrary where rname =?";
		ResultSet rs = db.executeQueryPS(sql, new Object[]{rname});
		int rbo=0; //用户已借书个数
		while(rs.next()){
			rbo = rs.getInt("RBORROWED");
		}
		int a = rbo-1;
		String sql1 = "update reglibrary set RBORROWED=? where rname =?";
		db.executeUpdatePS(sql1, new Object[]{a,rname});
	}
}
