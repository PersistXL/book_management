package com.liubo.Service;

import java.sql.SQLException;

import com.liang.library.Frame.AdminControlFrame;
import com.liang.library.Frame.ChatFrame;
import com.liang.library.Frame.UserControlFrame;
import com.liubo.Dao.RegLibraryDao;

public class RegLibraryService {
	/**
	 * 登录service层
	 * 此层主要用作接收图形界面的参数，
	 * 判断用户名和密码的合法性，
	 * 传入Dao层，并接收返回值 用作判读
	 */
	 RegLibraryDao dao = new RegLibraryDao();//调用dao层
	/**
	 * 登录方法
	 * @param cf 
	 * @throws SQLException 
	 */
	public void login(ChatFrame cf, String name,String pass) throws Exception{
		//判断用户名和密码的合法性
		if(name==null||name.equals("")){
			throw new RuntimeException("用户名不能为空");
		}
		if(pass==null||pass.equals("")){
			throw new RuntimeException("密码不能为空");
		}
		 //接收返回的密码 
		   String  psw = dao.Login(name);
		   
		   //外层if判断密码的正确性
		   if(psw.equals(pass)){
			   //内层if判断是否为管理员登录
			     if(name.equals("admin")){
				        //管理员登录界面
			    	 new AdminControlFrame(cf).setVisible(true);
			     }else{
				        //普通游客登录界面
			    	 new UserControlFrame(cf, name).setVisible(true);
			    }
		   }else{
			      throw new RuntimeException("密码错误");
		   }   
	}
	/**
	 * 注册方法
	 * @return 
	 * @throws SQLException 
	 */
	public String query(String NewName,String psw) throws SQLException{
		//判断用户输入的合法性
		if(NewName==null||NewName.equals("")){
			throw new RuntimeException("用户名不能为空");
		}
		if(psw==null||psw.equals("")){
			throw new RuntimeException("密码不能为空");
		}
		//用falg接收返回的boolean值
		boolean falg = dao.queryByName(NewName);
		//利用falg的值判断用户名是否被占用
		if(falg){
			throw new RuntimeException("用户名已被占用");
		}else{
			 dao.register(NewName,psw);
			throw new RuntimeException("注册成功");
		}	  
	}
	/**
	 * 修给密码
	 * @throws  
	 */
	public void changePass(String name,String pass,String passw,String password) throws SQLException{
		//判断用户输入的合法性
		if(name==null||name.equals("")){
			throw new RuntimeException("用户名不能为空");
		}
		if(pass==null||pass.equals("")){
			throw new RuntimeException("密码不能为空");
		}
		if(passw==null||passw.equals("")){
			throw new RuntimeException("新密码不能为空");
		}
		if(password==null||password.equals("")){
			throw new RuntimeException("请再次输入新密码");
		}
		if(!passw.equals(password)){
			throw new RuntimeException("两次输入密码不一致，请重新输入");
		}
		//调用dao层查看数据库方法   返回一个String 类型的数据psw  psw是数据库中该用户名对应的密码
		String psw = dao.query(name);
		//如果输入密码和数据库中相同  修改密码 否则提示
		if(psw.equals(pass)){

			dao.changepass(password,name);

			throw new RuntimeException("修改成功");
		}else{
			throw new RuntimeException("用户名或密码错误请重新输入");
		}
		
	}

}
