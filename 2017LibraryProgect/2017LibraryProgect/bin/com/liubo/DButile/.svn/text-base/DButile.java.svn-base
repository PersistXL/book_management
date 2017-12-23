package com.liubo.DButile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButile {
	
	/**
	 * 私有静态常量
	 */
	 private static final String ACC = "oracle.jdbc.driver.OracleDriver";
	 private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	 private static final String NAME = "scott";
	 private static final String PASSWORD = "tiger";
     
	 /**
	  * 私有变量
	  */
	  private Connection conn;
	  private PreparedStatement ps;
	  private ResultSet rs;
	    /**
		 * 用静态代码块来初始化
		 */
		 static{
			 //加载驱动
			 try {
				Class.forName(ACC);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 /**
			 * 数据库更新操作
			 * @param sql
			 * @param arr
			 */
			 public void executUpdateps(String sql,Object[] arr){
				 try {
					//建立链接
					 conn = DriverManager.getConnection(URL, NAME, PASSWORD);
					//创建可执行对象
					 ps = conn.prepareStatement(sql);
					//数据库操作
					if(arr!=null){//如果数据不为空执行操作
						for(int i = 1;i<=arr.length;i++){
							ps.setObject(i, arr[i-1]);
						}
					}
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						if(ps!=null){
						ps.close();}
						if(conn!=null){
						conn.close();}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				 
			 }
			  /**
			   * 数据库的查看操作
			   * 
			   */
			 public ResultSet executeQueryps(String sql, Object[] arr){
				 try {
					//建立链接
					  conn =  DriverManager.getConnection(URL, NAME, PASSWORD);
					 //创建可执行对象
					  ps = conn.prepareStatement(sql);
					 if(arr!=null){
						 for(int i =1;i<=arr.length;i++){
							 ps.setObject(i, arr[i-1]);
						 }
					 }
					 rs = ps.executeQuery(); 
					 return rs;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				    return null;
			 }

}
