package com.liubo.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.liubo.Dao.LibraryBookDao;

public class LibraryBookService {
	LibraryBookDao dao = new LibraryBookDao();
	/**
	 * �������а�
	 * @return 
	 * @throws SQLException 
	 */
  public ResultSet among() throws SQLException{
	  ResultSet rs = dao.among();
	  
      return rs;
	  
  }
}
