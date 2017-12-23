package com.java.DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
	/**
	 * 4����̬����
	 */
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static final String NAME = "scott";
	private static final String PASS = "tiger";
	/**
	 * 3������
	 */
	private ResultSet sr;
	private Statement st;
	private Connection conn;
	/**
	 * ��̬�����
	 */
	static{
		try {
			Class.forName(DRIVER);//��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �鿴�ķ���
	 */
    public ResultSet executeQuery(String sql){
    	    try {
				//2����
				 conn = DriverManager.getConnection(URL, NAME, PASS);
				//3����ִ�ж���
				 st = conn.createStatement();
				//4�鿴
				 sr = st.executeQuery(sql);
				return sr;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
    }
    
    /**
     * ���µķ���
     */
    public void executeUpdate(String sql){
    	try {
			//����
			conn = DriverManager.getConnection(URL,NAME,PASS);
			//����ִ�ж���
			st = conn.createStatement();
			//����
			st.executeUpdate(sql);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			close();
		}
    }
    /**
     * �鿴�ķ������鴫��
     */
    public ResultSet executeQueryPS(String sql,Object [] arr){
	    try {
			//2����
			 conn = DriverManager.getConnection(URL, NAME, PASS);
			//3����ִ�ж���
			 PreparedStatement ps = conn.prepareStatement(sql);
				if(arr!=null){// �޸�ֵ
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
     * ���µķ������鴫��
     * 
     */
    public void executeUpdatePS(String sql,Object [] arr){
    	try {
			//����
			conn = DriverManager.getConnection(URL,NAME,PASS);
			//����ִ�ж���
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
   * �رյķ���  
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
