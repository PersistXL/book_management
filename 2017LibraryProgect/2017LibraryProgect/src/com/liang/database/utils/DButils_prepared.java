package com.liang.database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DButils_prepared {
	private static String DRIERNAME="oracle.jdbc.driver.OracleDriver";
	private static String URL="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static String USER="scott";
	private static String PASS="tiger";
	static{
		try {
			Class.forName(DRIERNAME);//启动驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *变量
	 */
	private Connection conn;
	
	private PreparedStatement pst;
	private ResultSet res;
	
	
	/**
	 * 查询函数
	 * @throws SQLException 
	 */
	public ResultSet executeQuery(String sql,Object[] arr) {
	try {
		
		 conn=DriverManager.getConnection(URL, USER, PASS);//创建连接
		 pst = conn.prepareStatement(sql);//创建执行对象
		 if(arr!=null){
			 for (int i = 1; i <= arr.length; i++) {
				 pst.setObject(i, arr[i-1]);
			}
		 }
		 res=pst.executeQuery();
		 return res;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		 e.printStackTrace();
	}
	return res;
	    
  }
	/**
	 * @throws SQLException 
	 * 修改，删除，添加
	 * @throws 
	 */
	public void executeUpdate(String sql,Object [] arr)  {
		try {
			conn=DriverManager.getConnection(URL, USER, PASS);//创建连接
			pst = conn.prepareStatement(sql);//创建执行对象
			if(arr!=null){
				for (int i = 1; i <= arr.length; i++) {
					pst.setObject(i, arr[i-1]);
				}
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			
		}finally{
			close();
		}
	}
	/**
	 * 关闭
	 */
	public void close(){
		try {
			if(res!=null){
			res.close();
			}
			if(pst!=null){
				pst.close();
			}
			
			if(conn!=null){
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
