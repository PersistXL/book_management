package com.erbo.java.dao;
/**
 * 借阅图书表的dao层
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
	 * 查询个人资料，即已借图书信息（图书编号，书名，借阅时间，应还时间）
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
	 * 续借的操作
	 * @param name
	 * @param dtm 
	 * @param rowsel 
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public void continueRead(String name, DefaultTableModel dtm, int rowsel) throws SQLException, ParseException{
		
		int onlyno = (Integer) dtm.getValueAt(rowsel, 0);//取得用户想续借的书序号
		String sql = "select maxdate from borrowbook where onlyno = ?";
		ResultSet rs = uf.executeQueryPs(sql, new Object[]{onlyno});
		Date maxdate = null;
		while(rs.next()){
			maxdate = rs.getDate("maxdate");
		}

		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		long oldtime = maxdate.getTime(); //数据库拿出来的实际最大时间
		long newtime = oldtime + 7*60*60*24*1000; //实际的新时间
		//把当前毫秒数转化为日期，然后转化为字符串
		Date newDate = new Date(newtime);
		String source = df.format(newDate);
		String sql1 = "update borrowbook set maxdate =to_date(?,'yyyy-mm-dd hh:mi:ss') where onlyno = ?";
		uf.executeUpdatePs(sql1, new Object[]{source,onlyno});
		dtm.setValueAt(source, rowsel,6 );
	}
		
		
	/**
	 * 判断用户书籍的状态是否可续借，判断
	 * @param row 
	 * @throws SQLException 
	 */
	public void chargeState(int onlyno) throws SQLException{
		String sql = "select bookstate,maxdate from borrowbook where onlyno = ?"; //判断选中的onlyno
		ResultSet res = uf.executeQueryPs(sql, new Object[]{onlyno});
		String state = null;
		Date maxdate = null;;
		while(res.next()){
			state = res.getString("bookstate");
			maxdate = res.getDate("maxdate");
		}
		
		if(state.equals("已还")){
			throw new RuntimeException("您的书籍已经归还，请返回主界面重新借阅");
		}
		long maxtime = maxdate.getTime();
		long current = System.currentTimeMillis();
		
		if(maxtime<current){
			throw new RuntimeException("您的书籍已逾期，请归还！");
		}
		
	}
	
}
