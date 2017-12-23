package com.liubo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.liubo.DButile.DButile;

public class RegLibraryDao {
	/**
	 * Dao层
	 * 此层主要用调用DButile层  用来和数据库打交道
	 * 
	 */
	 DButile db = new DButile();
	/**
	 * 登录方法  
	 * @param name 
	 * @return 
	 * @throws SQLException 
	 */
	public String Login(String name) throws SQLException{
		String sql ="select rpassword from  reglibrary where  rname =?";
		//调用DButile的数据库查看方法  返回一个结果集  拿到密码
		String password = null;
		ResultSet rs = db.executeQueryps(sql, new Object[]{name});
       while(rs.next()){
    	   password = rs.getString("rpassword");
}
       //返回密码
       rs.close();
       return password;
	}
	/**
	 * 判断用户名是否被占用
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean queryByName(String NewName) throws SQLException{
		String  sql = "select * from reglibrary where rname = ?";
		//调用DButile层查看数据库方法 返回结果集rs
		ResultSet rs = db.executeQueryps(sql, new Object[]{NewName});
		//返回一个boolean值 
		rs.close();
		return rs.next();
	}
	/**
	 * 注册方法
	 */
	public void register(String NewName, String psw) {
		// TODO Auto-generated method stub
		String sql = "insert into reglibrary(rname,rpassword) values(?,?) ";
		db.executUpdateps(sql, new Object[]{NewName,psw});
		
	}
	/**
	 * 利用用户输入的用户名和密码   调用DButile 查看对应的数据库中的内容
	 * 返回一个String类型的数据psw变量在service中判断
	 * @return 
	 * @throws SQLException 
	 */
	public String query(String name) throws SQLException{

		String sql = "select rpassword from reglibrary where rname = ?";
		ResultSet rs = db.executeQueryps(sql, new Object[]{name});
		while(rs.next()){
			String psw = rs.getString("rpassword");
			return psw;//返回psw
		}
		rs.close();
		return null;
		
	}
	/**
	 * 修改密码
	 * @param passw
	 * @param password
	 */
	public void changepass(String password,String name) {
		// TODO Auto-generated method stub
		String sql = "update reglibrary set rpassword = ? where rname = ?";
		db.executUpdateps(sql, new Object[]{password,name});	
	}
	

}
