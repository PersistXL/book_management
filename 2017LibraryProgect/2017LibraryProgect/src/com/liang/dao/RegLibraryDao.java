package com.liang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.liang.database.utils.DButils_prepared;
import com.liang.entity.RnameSumFinemoney;


public class RegLibraryDao {
	DButils_prepared db=new DButils_prepared();
	/**
	 * 通过用户名修改最大借阅量，已借阅量
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public void updateByName(String rmax,String rborrowed,String name) throws SQLException {
		String sql="update reglibrary set rmaxborrow=?,rborrowed=? where rname=?";
		db.executeUpdate(sql, new Object[]{rmax,rborrowed,name});
	}

	/**
	 * 通过name查找数据库，返回该name下的密码
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
	public String queryByName(String name) throws SQLException {
		String lpass=null;
		String sql="select * from reglibrary where uname=?";
		ResultSet res = db.executeQuery(sql, new Object[]{name});
		while(res.next()){
			 lpass=res.getString("upassword");
		}
		res.close();
		return lpass;
	}
	
	/**
	 * 通过用户名查找，得到临时表
	 * 用户名、最大借阅量、已借阅量、罚金总额
	 * @return 
	 * @throws SQLException 
	 */
	public ArrayList<RnameSumFinemoney> queryFM(String name) throws SQLException{
		ArrayList<RnameSumFinemoney> list=new ArrayList<RnameSumFinemoney>();
		String sql="select rname,rmaxborrow,rborrowed,sum(finemoney) from (" +
				"select r.rname,r.rmaxborrow,r.rborrowed,b.finemoney from reglibrary r " +
				", borrowbook b where r.rname=b.rname) group by rname,rmaxborrow,rborrowed having rname=?";
		ResultSet res = db.executeQuery(sql, new Object[]{name});
		while(res.next()){
			RnameSumFinemoney rsf=new RnameSumFinemoney();
			rsf.setRname(res.getString("rname"));
			rsf.setRmaxborrow(res.getString("rmaxborrow"));
			rsf.setRborrowed(res.getString("rborrowed"));
			rsf.setSumfinemoney(res.getString("sum(finemoney)"));
			list.add(rsf);
		}
		return list;
	}
}
