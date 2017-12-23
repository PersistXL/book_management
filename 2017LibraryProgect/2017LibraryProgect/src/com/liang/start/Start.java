package com.liang.start;

import com.liang.library.Frame.ChatFrame;

public class Start {
	public static void main(String[] args) {
		StartTime st=new StartTime();
		ChatFrame cf=new ChatFrame();
		StartPrograme sp=new StartPrograme(cf);
		Thread th1=new Thread(st);
		Thread th2=new Thread(cf);
		Thread th3=new Thread(sp);
		th1.start();
		th2.start();
		th3.start();
	}

}
