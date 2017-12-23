package com.liubo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.liubo.DButile.DButile;

public class LibraryBookDao {

   DButile db = new DButile();
   ResultSet rs ;
   
   /**
    * ≈≈––∑Ω∑®
 * @return 
 * @throws SQLException 
    */
   public ResultSet among() throws SQLException{
	    String sql = "select bookname,booktype from librarybook order by times desc";
	    rs = db.executeQueryps(sql, null);
	    return rs;
   }
}
