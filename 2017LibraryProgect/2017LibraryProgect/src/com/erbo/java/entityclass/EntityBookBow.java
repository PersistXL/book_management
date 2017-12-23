package com.erbo.java.entityclass;

import java.sql.Date;
/**
 * 借阅图书表实体类
 * @author gouger
 *
 */
public class EntityBookBow{
	private int onlyno; //借书的序列
	private String RNAME; //用户名
	private String BOOKNO;//图书编号
	private String BOOKNAME;//书名
	private Date LENDDATE;//借阅时间
	private Date MAXDATE;//应还时间
	private Date ACTUDATE;//实还时间
	private double bookprice; //图书价格
	private String booktype; //图书类型
	
	
	
	
	public int getOnlyno() {
		return onlyno;
	}
	public void setOnlyno(int onlyno) {
		this.onlyno = onlyno;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	private double FINEMONEY;//租金
	private double RENTMONEY;//罚金
	
	
	
	/**
	 * 访问器
	 * @return
	 */
	public String getRNAME() {
		return RNAME;
	}
	public void setRNAME(String rNAME) {
		RNAME = rNAME;
	}
	public String getBOOKNO() {
		return BOOKNO;
	}
	public void setBOOKNO(String bOOKNO) {
		BOOKNO = bOOKNO;
	}
	public String getBOOKNAME() {
		return BOOKNAME;
	}
	public void setBOOKNAME(String bOOKNAME) {
		BOOKNAME = bOOKNAME;
	}
	public Date getLENDDATE() {
		return LENDDATE;
	}
	public void setLENDDATE(Date lENDDATE) {
		LENDDATE = lENDDATE;
	}
	public Date getMAXDATE() {
		return MAXDATE;
	}
	public void setMAXDATE(Date mAXDATE) {
		MAXDATE = mAXDATE;
	}
	public Date getACTUDATE() {
		return ACTUDATE;
	}
	public void setACTUDATE(Date aCTUDATE) {
		ACTUDATE = aCTUDATE;
	}
	public double getFINEMONEY() {
		return FINEMONEY;
	}
	public void setFINEMONEY(double fINEMONEY) {
		FINEMONEY = fINEMONEY;
	}
	public double getRENTMONEY() {
		return RENTMONEY;
	}
	public void setRENTMONEY(double rENTMONEY) {
		RENTMONEY = rENTMONEY;
	}
	
	
}
