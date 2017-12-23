package com.qingeng.Service;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;

import com.qingeng.Dao.DelBookDao;
import com.qingeng.Entity.Book;
import com.qingeng.Frame.DelBookFrame;

/**
 * ��ѯ ,ɾ��ͼ��service��
 * @author Administrator
 *
 */
public class DelBookService {
	DelBookDao delDao = new DelBookDao();
	List<Book> list = new ArrayList<Book>();
	
	/**
	 * ѡ�в�ѯ���ı����ɾ��
	 * @return 
	 * @throws SQLException 
	 */
	public List<Book> query() throws SQLException{
		 list = delDao.queryBook();
		 return list;
	}
	
	/**
	 * ɾ��
	 * @throws SQLException 
	 */
	public void del(String bno) throws SQLException{
		delDao.delBook(bno);
		throw new RuntimeException("ɾ���ɹ�");
	}


	public void showOnlybbs(JDesktopPane desktopPane, DelBookFrame dbf) {
		// TODO Auto-generated method stub
		boolean flag = false;
	   	Component[]com = desktopPane.getComponents();
			 for (Component component : com) {
				if(component instanceof DelBookFrame){
					flag = true;
					break;
			    }
			}
			 if(flag==false){
				 desktopPane.add(dbf);
				 dbf.setVisible(true);
			 }
	   
	}

	
	
//	/**
//	 * ����ͼ������ɾ��
//	 */
//	DelBookDao delDao = new DelBookDao();	
//	public String delService(String delName) throws SQLException{
//		if(delName==null||"".equals(delName)){
//			throw new RuntimeException("������Ҫɾ����ͼ������");
//		}	
//		
//		/**
//		 * У��
//		 */
//		Boolean result = null;	
//		result = delDao.query(delName);
//		if(result){//����
//			delDao.delbook(delName);
//			throw new RuntimeException("ɾ���ɹ�");
//		}else{
//			throw new RuntimeException("ͼ���������������߸�ͼ�鲻����");
//		}			
//	}

}
