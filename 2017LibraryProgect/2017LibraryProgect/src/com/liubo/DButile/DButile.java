package com.liubo.DButile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButile {
	
	/**
	 * ˽�о�̬����
	 */
	 private static final String ACC = "oracle.jdbc.driver.OracleDriver";
	 private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	 private static final String NAME = "scott";
	 private static final String PASSWORD = "tiger";
     
	 /**
	  * ˽�б���
	  */
	  private Connection conn;
	  private PreparedStatement ps;
	  private ResultSet rs;
	    /**
		 * �þ�̬���������ʼ��
		 */
		 static{
			 //��������
			 try {
				Class.forName(ACC);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 /**
			 * ���ݿ���²���
			 * @param sql
			 * @param arr
			 */
			 public void executUpdateps(String sql,Object[] arr){
				 try {
					//��������
					 conn = DriverManager.getConnection(URL, NAME, PASSWORD);
					//������ִ�ж���
					 ps = conn.prepareStatement(sql);
					//���ݿ����
					if(arr!=null){//������ݲ�Ϊ��ִ�в���
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
			   * ���ݿ�Ĳ鿴����
			   * 
			   */
			 public ResultSet executeQueryps(String sql, Object[] arr){
				 try {
					//��������
					  conn =  DriverManager.getConnection(URL, NAME, PASSWORD);
					 //������ִ�ж���
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
