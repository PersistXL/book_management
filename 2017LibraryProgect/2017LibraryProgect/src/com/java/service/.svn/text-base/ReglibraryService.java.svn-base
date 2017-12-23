package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.ReglibraryDao;
import com.java.entity.Reglibrary;

public class ReglibraryService {
	ReglibraryDao rd = new ReglibraryDao();
	public void RborService(String rname) throws SQLException{
		List<Reglibrary> list = rd.RborDao(rname);
		int a = 0;
		int b = 0;
		for (Reglibrary re : list) {
			a= re.getRmaxborrow();
			b= re.getRborrowed();
		}
		if(a==b){
			throw new RuntimeException("您的借书数额已达到上限，不可再借，请还书后再借！");
		}
	}
	public void updateService(String rname) throws SQLException{
		rd.updateRegDao(rname);
	}
	/**
	 * 还书后让已借量减1
	 */
	public void updateBorrowedService(String rname) throws SQLException{
		rd.updateBorrowedDao(rname);
	}
}
