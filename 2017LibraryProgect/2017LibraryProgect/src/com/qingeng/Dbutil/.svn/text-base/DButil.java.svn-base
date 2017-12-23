package com.qingeng.Dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
	//4个私有静态变量
		private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
		private static final String NAME = "scott";
		private static final String PASS = "tiger";
	
	
	/**
	 *三个变量 
	 */
		Connection conn;
		Statement st;
		ResultSet rs;
		

	/**
	 * 1个 静态代码块
	 */
		static{
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	/**
	 * 更新
	 * @param sql
	 * @param arr
	 */
	public void executeUpdatePs(String sql,Object [] arr){
		try{
			//2建立链接
				conn = DriverManager.getConnection(URL,NAME,PASS);
			//3创建执行对象
				 PreparedStatement ps = conn.prepareStatement(sql);
				 if(arr!=null){//判断数组是否为空
					 for(int i=1;i<=arr.length;i++){
						 ps.setObject(i,arr[i-1]);
					 }
				 }			 
			//执行
				 ps.executeUpdate();//更新数据
				}catch(SQLException e){	
					e.printStackTrace();
				}
				finally{
					close();
				}
	}
	
	
	/**
	 * 查询方法
	 */
	public ResultSet executeQueryPs(String sql,Object [] arr){
		try {
			//2建立链接
				conn = DriverManager.getConnection(URL,NAME,PASS);
				//3创建执行对象
				PreparedStatement ps= conn.prepareStatement(sql);
				//4CRUD
				if(arr!=null){
					for(int i=1;i<=arr.length;i++){
						ps.setObject(i, arr[i-1]);
					}
				}
				rs = ps.executeQuery();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			 return rs;
	}
	
	/**
	 * 关闭方法
	 */
	public void close(){
		
	try {
		if(rs!=null){
			rs.close();
		}
		if(st!=null){
			st.close();
		}
		if(conn!=null){
			conn.close();
		}
		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
		}
	}
}

