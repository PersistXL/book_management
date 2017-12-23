package com.liubo.Service;

import java.sql.SQLException;

import com.liang.library.Frame.AdminControlFrame;
import com.liang.library.Frame.ChatFrame;
import com.liang.library.Frame.UserControlFrame;
import com.liubo.Dao.RegLibraryDao;

public class RegLibraryService {
	/**
	 * ��¼service��
	 * �˲���Ҫ��������ͼ�ν���Ĳ�����
	 * �ж��û���������ĺϷ��ԣ�
	 * ����Dao�㣬�����շ���ֵ �����ж�
	 */
	 RegLibraryDao dao = new RegLibraryDao();//����dao��
	/**
	 * ��¼����
	 * @param cf 
	 * @throws SQLException 
	 */
	public void login(ChatFrame cf, String name,String pass) throws Exception{
		//�ж��û���������ĺϷ���
		if(name==null||name.equals("")){
			throw new RuntimeException("�û�������Ϊ��");
		}
		if(pass==null||pass.equals("")){
			throw new RuntimeException("���벻��Ϊ��");
		}
		 //���շ��ص����� 
		   String  psw = dao.Login(name);
		   
		   //���if�ж��������ȷ��
		   if(psw.equals(pass)){
			   //�ڲ�if�ж��Ƿ�Ϊ����Ա��¼
			     if(name.equals("admin")){
				        //����Ա��¼����
			    	 new AdminControlFrame(cf).setVisible(true);
			     }else{
				        //��ͨ�ο͵�¼����
			    	 new UserControlFrame(cf, name).setVisible(true);
			    }
		   }else{
			      throw new RuntimeException("�������");
		   }   
	}
	/**
	 * ע�᷽��
	 * @return 
	 * @throws SQLException 
	 */
	public String query(String NewName,String psw) throws SQLException{
		//�ж��û�����ĺϷ���
		if(NewName==null||NewName.equals("")){
			throw new RuntimeException("�û�������Ϊ��");
		}
		if(psw==null||psw.equals("")){
			throw new RuntimeException("���벻��Ϊ��");
		}
		//��falg���շ��ص�booleanֵ
		boolean falg = dao.queryByName(NewName);
		//����falg��ֵ�ж��û����Ƿ�ռ��
		if(falg){
			throw new RuntimeException("�û����ѱ�ռ��");
		}else{
			 dao.register(NewName,psw);
			throw new RuntimeException("ע��ɹ�");
		}	  
	}
	/**
	 * �޸�����
	 * @throws  
	 */
	public void changePass(String name,String pass,String passw,String password) throws SQLException{
		//�ж��û�����ĺϷ���
		if(name==null||name.equals("")){
			throw new RuntimeException("�û�������Ϊ��");
		}
		if(pass==null||pass.equals("")){
			throw new RuntimeException("���벻��Ϊ��");
		}
		if(passw==null||passw.equals("")){
			throw new RuntimeException("�����벻��Ϊ��");
		}
		if(password==null||password.equals("")){
			throw new RuntimeException("���ٴ�����������");
		}
		if(!passw.equals(password)){
			throw new RuntimeException("�����������벻һ�£�����������");
		}
		//����dao��鿴���ݿⷽ��   ����һ��String ���͵�����psw  psw�����ݿ��и��û�����Ӧ������
		String psw = dao.query(name);
		//���������������ݿ�����ͬ  �޸����� ������ʾ
		if(psw.equals(pass)){

			dao.changepass(password,name);

			throw new RuntimeException("�޸ĳɹ�");
		}else{
			throw new RuntimeException("�û����������������������");
		}
		
	}

}