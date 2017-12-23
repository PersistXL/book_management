package com.liang.start;

import java.text.DateFormat;


import com.liang.library.Frame.AdminControlFrame;
import com.liang.library.Frame.UserControlFrame;

public class StartTime implements Runnable{
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long time=System.currentTimeMillis();
		String sysTime = DateFormat.getDateTimeInstance().format(time);//转换日期时间格式
		AdminControlFrame.lab2.setText(sysTime);//设置lab2的显示内容
		UserControlFrame.lab2.setText(sysTime);
		}
		
		
	}

	
}
