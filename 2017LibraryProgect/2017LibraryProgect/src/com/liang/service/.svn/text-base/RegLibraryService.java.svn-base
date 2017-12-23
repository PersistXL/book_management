package com.liang.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.liang.dao.RegLibraryDao;
import com.liang.entity.RnameSumFinemoney;


public class RegLibraryService {
	RegLibraryDao rd=new RegLibraryDao();
	/**
	 * 通过姓名修改最大借阅量，已借图书量
	 * @param rmax
	 * @param rborrowed
	 * @param name
	 * @throws SQLException
	 */
	public void updateByName(String rmax,String rborrowed,String name) throws SQLException{
		rd.updateByName(rmax, rborrowed, name);
	}
	
	/**
	 * 获取临时表
	 * 内容有 用户名、最大借阅量、已借阅量、罚金总额
	 * @return 
	 * @throws SQLException 
	 */
	public ArrayList<RnameSumFinemoney> queryFM(String name) throws SQLException{
		ArrayList<RnameSumFinemoney> list = rd.queryFM(name);
		return list;
	}

}
