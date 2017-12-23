package com.erbo.java.jdbd_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DButil {
	private static final String Driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static final String user = "scott";
	private static final String password = "tiger";
	
	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet res;
	
	static{
		//1、加载驱动
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * prepared数据的查找
	 * @param sql
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet executeQueryPs(String sql,Object[]params) throws SQLException{
		
		try {
			//2、建立连接
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
			//3、创建可执行对象
			ps = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1,  params[i]);
				}
				
			}
			
			ResultSet res = ps.executeQuery();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
		
	}
	/**
	 * prepared数据的更新
	 * @param sql
	 */
	public void executeUpdatePs(String sql,Object[]params){
		
			try {
				//2、建立连接
				Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");
				//3、创建可执行对象
				ps = conn.prepareStatement(sql);
				if(params!=null){
					for(int i=0;i<params.length;i++){
						ps.setObject(i+1,  params[i]);
					}
					
				}
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	/**
	 * 数据的更新
	 */
	public void executeUpdate(String sql){
		try{
			//2、连接
			conn = DriverManager.getConnection(url, user, password);
			//3、创建可执行对象
			ps = conn.prepareStatement(sql);
			//4
			ps.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	/**
	 * 数据的查找
	 * @param sql
	 * @return
	 */
	
	public ResultSet executeQuery(String sql){
		try {
			//2、连接
			conn = DriverManager.getConnection(url, user, password);
			//3、创建可执行对象
			ps = conn.prepareStatement(sql);
			//4
			res = ps.executeQuery(sql);
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; //查找不进行关闭，因为sta.executeQuery(sql)取到的值要return给调用方法进
					//行下一步操作，如果在工具方法里面就进行关闭的话，则主调用方法不能接收到结果集
		
	}
	
	/**
	 * 关闭的方法
	 */
	public void close() {
		// TODO Auto-generated method stub
		try {
			if(res!=null){
				res.close();
			}
			if(ps!=null){
				ps.close();
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
