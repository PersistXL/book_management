package com.erbo.java.dao;
/**
 * ����ͼ����dao��
 */

//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import com.erbo.java.entityclass.EntityBookBow;
import com.erbo.java.jdbd_util.DButil;

public class BookBorrowDao {
	DButil uf = new DButil();
	ResultSet set;
	
	
	/**
	 * ��ѯ�������ϣ����ѽ�ͼ����Ϣ��ͼ���ţ�����������ʱ�䣬Ӧ��ʱ�䣩
	 * @param name
	 * @throws SQLException
	 */
	public ArrayList <EntityBookBow>lookDao(String name) throws SQLException{
		String sql = "select onlyno,bookno,bookname,lenddate,bookprice,booktype,maxdate,actudate,finemoney,rentmoney from borrowbook where rname = ?";
	    set = uf.executeQueryPs(sql, new Object[]{name});
		ArrayList<EntityBookBow> list = new ArrayList<EntityBookBow>();
		while(set.next()){
			EntityBookBow ebb = new EntityBookBow();
			ebb.setOnlyno(set.getInt("onlyno"));
			ebb.setBOOKNO(set.getString("bookno"));
			ebb.setBOOKNAME(set.getString("bookname"));
			
			ebb.setBookprice(set.getDouble("bookprice"));
			ebb.setBooktype(set.getString("booktype"));
			
			ebb.setLENDDATE(set.getDate("lenddate"));
			ebb.setMAXDATE(set.getDate("maxdate"));
			ebb.setACTUDATE(set.getDate("actudate"));
			
			
			ebb.setFINEMONEY(set.getDouble("finemoney"));
			ebb.setRENTMONEY(set.getDouble("rentmoney"));
			
			list.add(ebb);
		
		}
		return list;
		
	}
	
	
	/**
	 * ����Ĳ���
	 * @param name
	 * @param dtm 
	 * @param rowsel 
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public void continueRead(String name, DefaultTableModel dtm, int rowsel) throws SQLException, ParseException{
		
		int onlyno = (Integer) dtm.getValueAt(rowsel, 0);//ȡ���û�������������
		String sql = "select maxdate from borrowbook where onlyno = ?";
		ResultSet rs = uf.executeQueryPs(sql, new Object[]{onlyno});
		Date maxdate = null;
		while(rs.next()){
			maxdate = rs.getDate("maxdate");
		}

		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		long oldtime = maxdate.getTime(); //���ݿ��ó�����ʵ�����ʱ��
		long newtime = oldtime + 7*60*60*24*1000; //ʵ�ʵ���ʱ��
		//�ѵ�ǰ������ת��Ϊ���ڣ�Ȼ��ת��Ϊ�ַ���
		Date newDate = new Date(newtime);
		String source = df.format(newDate);
		String sql1 = "update borrowbook set maxdate =to_date(?,'yyyy-mm-dd hh:mi:ss') where onlyno = ?";
		uf.executeUpdatePs(sql1, new Object[]{source,onlyno});
		dtm.setValueAt(source, rowsel,6 );
	}
		
		
	/**
	 * �ж��û��鼮��״̬�Ƿ�����裬�ж�
	 * @param row 
	 * @throws SQLException 
	 */
	public void chargeState(int onlyno) throws SQLException{
		String sql = "select bookstate,maxdate from borrowbook where onlyno = ?"; //�ж�ѡ�е�onlyno
		ResultSet res = uf.executeQueryPs(sql, new Object[]{onlyno});
		String state = null;
		Date maxdate = null;;
		while(res.next()){
			state = res.getString("bookstate");
			maxdate = res.getDate("maxdate");
		}
		
		if(state.equals("�ѻ�")){
			throw new RuntimeException("�����鼮�Ѿ��黹���뷵�����������½���");
		}
		long maxtime = maxdate.getTime();
		long current = System.currentTimeMillis();
		
		if(maxtime<current){
			throw new RuntimeException("�����鼮�����ڣ���黹��");
		}
		
	}
	
}
