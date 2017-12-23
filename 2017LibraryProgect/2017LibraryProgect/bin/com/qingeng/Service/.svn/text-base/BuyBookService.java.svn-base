package com.qingeng.Service;

import java.awt.Component;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import com.qingeng.Dao.BuyBookDao;
import com.qingeng.Frame.BuyBookFrame;

public class BuyBookService {
	BuyBookDao buyDao = new BuyBookDao();
	public String buyService(String buyName,String buyNum,String buyPrice,String buyType) throws SQLException{		
		if(buyName==null||"".equals(buyName)){
			throw new RuntimeException("请输入要购买的书的书名");
		}
		if(buyNum==null||"".equals(buyNum)){
			throw new RuntimeException("请输入要购买的书的数量");
		}
		if(buyPrice==null||"".equals(buyPrice)){
			throw new RuntimeException("请输入要购买的书的单价");
		}
		if(buyType==null||"".equals(buyType)){
			throw new RuntimeException("请输入要购买的书的类型");
		}
			buyDao.buybook(buyName, buyNum, buyPrice, buyType);
			throw new RuntimeException("购买成功");
	}
	 /**
	    * 判断容器组件个数
	    */
	   public void showOnlybbf(JDesktopPane desktopPane, BuyBookFrame bbf){
	   	boolean flag = false;
	   	Component[]com = desktopPane.getComponents();
			 for (Component component : com) {
				if(component instanceof BuyBookFrame){
					flag = true;
					break;
			    }
			}
			 if(flag==false){
				 desktopPane.add(bbf);
				 bbf.setVisible(true);
			 }
	   }
	public void showOnlybbs(JDesktopPane desktopPane, BuyBookFrame bbs) {
		// TODO Auto-generated method stub
		boolean flag = false;
	   	Component[]com = desktopPane.getComponents();
			 for (Component component : com) {
				if(component instanceof BuyBookFrame){
					flag = true;
					break;
			    }
			}
			 if(flag==false){
				 desktopPane.add(bbs);
				 bbs.setVisible(true);
			 }
	   
	}
	public void chanService(String buyName) throws SQLException {
		// TODO Auto-generated method stub
		buyDao.chanDao(buyName);
	}
}
