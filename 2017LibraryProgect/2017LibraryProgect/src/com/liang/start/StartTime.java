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
		String sysTime = DateFormat.getDateTimeInstance().format(time);//ת������ʱ���ʽ
		AdminControlFrame.lab2.setText(sysTime);//����lab2����ʾ����
		UserControlFrame.lab2.setText(sysTime);
		}
		
		
	}

	
}
