package com.liang.service;

import com.liang.dao.BorrowBookDao;

public class BorrowBookService {
	BorrowBookDao bbd=new BorrowBookDao();
	/**
	 * �޸ķ���
	 */
	public void upgateFM(String fineMoney,String name){
		bbd.updateFM(fineMoney, name);
	}

}
