package com.java.service;

import java.awt.Component;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.dao.BorrowBookDao;
import com.java.entity.BorrowBook;
import com.java.io.frame.ReturnBookFrame;

public class BorrowBookService {
	BorrowBookDao bbd = new BorrowBookDao();
   public void borrowService(String rname,String bookno,String bookname,double bookprice,String booktype){
	   bbd.updateBorrowDao(rname, bookno, bookname, bookprice, booktype);
   }
   /**
    * 通过姓名取数据
 * @throws SQLException 
    */
   public List<BorrowBook> queryByrnameService(String rname) throws SQLException{
	   List<BorrowBook> list =bbd.queryByrnameDao(rname);
	return list;
   }
   /**
    * 判断容器组件个数
    */
   public void showOnlybbff(JDesktopPane desktopPane, ReturnBookFrame rbf){
   	boolean flag = false;
   	Component[]com = desktopPane.getComponents();
		 for (Component component : com) {
			if(component instanceof ReturnBookFrame){
				flag = true;
				break;
		    }
		}
		 if(flag==false){
			 desktopPane.add(rbf);
			 rbf.setVisible(true);
		 }
   }
   /**
	 * 通过姓名取没有还得数的数据
 * @param table 
 * @param table 
 * @throws SQLException 
	 */
   public List<BorrowBook> queryByrnameactuService(String rname, JTable table) throws SQLException{
	   List<BorrowBook> list = bbd.queryByrnameactuDao(rname);
	return list;
   }
   /**
    * 判断选中的行
 * @param controw 
 * @param row 
    */
   public void chooseRow(int row, int controw){
	   if(controw==0){
		   throw new RuntimeException("请选择要还的书！");
	   }else if(controw>1){
		   throw new RuntimeException("一次只能还一本！");
	   }
   }
   /**
    * 还书
 * @param lenddate 
 * @param bookno 
    */
   public void updateByOnly(int onlyno){
	   bbd.updateByOnlyDao(onlyno);
   }
   /**
    * 计算价格
 * @throws SQLException 
    */
   public List<BorrowBook> queryContmoney(int onlyno) throws SQLException{
	   List<BorrowBook> list = bbd.queryContmoney(onlyno);
	return list;
   }
   
   
    public void countMoney(double bookprice, long longtimemax, long longtimeactu, long longtimelend, int onlyno, JTable table, int row) {
	    // TODO Auto-generated method stub
    	double fajin = 0;
    	double zujin;
	      if(longtimemax<longtimeactu){
    	       int fadays = (int) ((longtimeactu-longtimemax)/(3600*24*1000));
    	       fajin = fadays*100;
    	       int zudays = (int) ((longtimeactu-longtimelend)/(3600*24*1000));
    	       zujin = zudays*bookprice;
    	       bbd.updateMoney(zujin,fajin,onlyno);
    	       table.setValueAt(fajin, row, 7);
    	       table.setValueAt(zujin, row, 8);
    	       throw new RuntimeException("您已逾期"+fadays+"天！需要缴纳租金："+zujin+"元，罚金"+fajin+"元！");
    	 }else{
    		  int zudays = (int) ((longtimeactu-longtimelend)/(3600*24*1000));
        	  zujin = zudays*bookprice;
        	  table.setValueAt(zujin, row, 8);
        	  bbd.updateMoney(zujin,fajin,onlyno);
        	  throw new RuntimeException("您已租书"+zudays+"天！需要缴纳租金："+zujin+"元！");
    	}
  }
	public void clear(DefaultTableModel dtm) {
		// TODO Auto-generated method stub
		int count = dtm.getRowCount();
		   for(int i=0;i<count;i++){
			   dtm.removeRow(0);
		   }
	}
}
