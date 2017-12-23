package com.liubo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.liubo.DButile.DButile;

public class RegLibraryDao {
	/**
	 * Dao��
	 * �˲���Ҫ�õ���DButile��  ���������ݿ�򽻵�
	 * 
	 */
	 DButile db = new DButile();
	/**
	 * ��¼����  
	 * @param name 
	 * @return 
	 * @throws SQLException 
	 */
	public String Login(String name) throws SQLException{
		String sql ="select rpassword from  reglibrary where  rname =?";
		//����DButile�����ݿ�鿴����  ����һ�������  �õ�����
		String password = null;
		ResultSet rs = db.executeQueryps(sql, new Object[]{name});
       while(rs.next()){
    	   password = rs.getString("rpassword");
}
       //��������
       rs.close();
       return password;
	}
	/**
	 * �ж��û����Ƿ�ռ��
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean queryByName(String NewName) throws SQLException{
		String  sql = "select * from reglibrary where rname = ?";
		//����DButile��鿴���ݿⷽ�� ���ؽ����rs
		ResultSet rs = db.executeQueryps(sql, new Object[]{NewName});
		//����һ��booleanֵ 
		rs.close();
		return rs.next();
	}
	/**
	 * ע�᷽��
	 */
	public void register(String NewName, String psw) {
		// TODO Auto-generated method stub
		String sql = "insert into reglibrary(rname,rpassword) values(?,?) ";
		db.executUpdateps(sql, new Object[]{NewName,psw});
		
	}
	/**
	 * �����û�������û���������   ����DButile �鿴��Ӧ�����ݿ��е�����
	 * ����һ��String���͵�����psw������service���ж�
	 * @return 
	 * @throws SQLException 
	 */
	public String query(String name) throws SQLException{

		String sql = "select rpassword from reglibrary where rname = ?";
		ResultSet rs = db.executeQueryps(sql, new Object[]{name});
		while(rs.next()){
			String psw = rs.getString("rpassword");
			return psw;//����psw
		}
		rs.close();
		return null;
		
	}
	/**
	 * �޸�����
	 * @param passw
	 * @param password
	 */
	public void changepass(String password,String name) {
		// TODO Auto-generated method stub
		String sql = "update reglibrary set rpassword = ? where rname = ?";
		db.executUpdateps(sql, new Object[]{password,name});	
	}
	

}