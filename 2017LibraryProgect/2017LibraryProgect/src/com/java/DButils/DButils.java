package com.java.DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
	/**
	 * 4个静态常量
	 */
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static final String NAME = "scott";
	private static final String PASS = "tiger";
	/**
	 * 3个变量
	 */
	private ResultSet sr;
	private Statement st;
	private Connection conn;
	/**
	 * 静态代码块
	 */
	static{
		try {
			Class.forName(DRIVER);//加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查看的方法
	 */
    public ResultSet executeQuery(String sql){
    	    try {
				//2链接
				 conn = DriverManager.getConnection(URL, NAME, PASS);
				//3创建执行对象
				 st = conn.createStatement();
				//4查看
				 sr = st.executeQuery(sql);
				return sr;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
    }
    
    /**
     * 更新的方法
     */
    public void executeUpdate(String sql){
    	try {
			//链接
			conn = DriverManager.getConnection(URL,NAME,PASS);
			//创建执行对象
			st = conn.createStatement();
			//更新
			st.executeUpdate(sql);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			close();
		}
    }
    /**
     * 查看的方法数组传参
     */
    public ResultSet executeQueryPS(String sql,Object [] arr){
	    try {
			//2链接
			 conn = DriverManager.getConnection(URL, NAME, PASS);
			//3创建执行对象
			 PreparedStatement ps = conn.prepareStatement(sql);
				if(arr!=null){// 修改值
	                for(int i =1;i<=arr.length;i++){
	                	ps.setObject(i, arr[i-1]);
	                }				
				}
			 sr = ps.executeQuery();
			return sr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
}
    /**
     * 更新的方法数组传参
     * 
     */
    public void executeUpdatePS(String sql,Object [] arr){
    	try {
			//链接
			conn = DriverManager.getConnection(URL,NAME,PASS);
			//创建执行对象
			PreparedStatement ps = conn.prepareStatement(sql);
			if(arr!=null){
                for(int i =1;i<=arr.length;i++){
                	ps.setObject(i, arr[i-1]);
                }				
			}
			ps.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			close();
		}
    }
    
  /**
   * 关闭的方法  
   */
    public void close(){
    	try {
    		if(sr!=null){
    			sr.close();
    		}
    		if(st!=null){
    			st.close();
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
