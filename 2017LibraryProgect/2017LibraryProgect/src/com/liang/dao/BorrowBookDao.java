package com.liang.dao;

import com.liang.database.utils.DButils_prepared;

public class BorrowBookDao {
	DButils_prepared db=new DButils_prepared();
	/**
	 * 通过用户名修改罚金
	 */
	public void updateFM(String fineMoney,String name){
		String sql="update borrowbook set finemoney=? where rname=?";
		db.executeUpdate(sql, new Object[]{fineMoney,name});
	}

}
