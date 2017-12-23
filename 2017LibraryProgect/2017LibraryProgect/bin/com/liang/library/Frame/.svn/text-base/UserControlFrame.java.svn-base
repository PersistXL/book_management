package com.liang.library.Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import com.erbo.java.borrow.BorrowFrameMasg;
import com.erbo.java.service.BorrowService;
import com.java.Pingjia.Wukexing;
import com.java.io.frame.BorrowFrame;
import com.java.io.frame.BynameFrame;
import com.java.io.frame.FindFrame;
import com.java.io.frame.ReturnBookFrame;
import com.java.io.frame.TypeFrame;
import com.java.service.BorrowBookService;
import com.java.service.LibraryBookService;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.library.Frame.AmongJFrame;
import com.library.Frame.ChangeJFrame;

@SuppressWarnings("serial")
public class UserControlFrame extends JFrame {
	/*public static void main(String[] args) {
		new UserControlFrame().setVisible(true);
	}*/
	public static JLabel lab2= new JLabel();
	public UserControlFrame(final ChatFrame cf, final String rname){
		setSize(1011,678);
		setResizable(false);//设置窗口不可最大化
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;//设置窗口显示的位置
	    int h=Toolkit.getDefaultToolkit().getScreenSize().height;
	    setLocation((w-1010)/2, (h-679)/2);
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);

	    final JPanel panel = new JPanel(){
	    	public void paintComponent(Graphics g){//画图片
			    //super.paintComponent(g);
				ImageIcon icon=new ImageIcon("img\\IMG_1085.JPG");
				Image img =icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
	    };
	    panel.setLayout(null);
	    panel.setBounds(0, 0, 1002, 140);
	    getContentPane().add(panel);
	    
	    final JLabel label = new JLabel();
	    label.setText("当前时间：");
	    label.setBounds(28, 112, 66, 18);
	    panel.add(label);

	    
	    lab2.setBounds(93, 112, 188, 18);//设置lab2的位置
	    panel.add(lab2);

	    final JButton button_5 = new JButton();
	    button_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		new Wukexing().setVisible(true);
	    	}
	    });
	    button_5.setFont(new Font("", Font.BOLD | Font.ITALIC, 14));
	    button_5.setBackground(Color.RED);
	    button_5.setText("请您评价");
	    button_5.setBounds(877, 106, 104, 28);
	    panel.add(button_5);

	    final JPanel panel_1 = new JPanel();
	    panel_1.setLayout(null);
	    panel_1.setBackground(new Color(224, 255, 255));
	    panel_1.setBounds(0, 146, 146, 500);
	    getContentPane().add(panel_1);
	    
	    final JPanel panel_3 = new JPanel(){
	    	public void paintComponent(Graphics g){//画图片
			    //super.paintComponent(g);
				ImageIcon icon=new ImageIcon("img\\IMG_1083.jpg");
				Image img =icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
	    };
	    panel_3.setLayout(null);
	    panel_3.setBounds(152, 146, 853, 500);
	    getContentPane().add(panel_3);

	    final JDesktopPane desktopPane = new JDesktopPane();
	    desktopPane.setOpaque(false);
	    desktopPane.setBounds(4, 42, 839, 448);
	    panel_3.add(desktopPane);

	    final JPanel panel_4 = new JPanel();
	    panel_4.setOpaque(false);
	    panel_4.setLayout(null);
	    panel_4.setBackground(Color.WHITE);
	    panel_4.setBounds(4, 0, 839, 35);
	    panel_3.add(panel_4);

	    final JTextPane textPane = new JTextPane();
	    textPane.setBackground(Color.LIGHT_GRAY);
	    textPane.setBounds(113, 5, 152, 24);
	    panel_4.add(textPane);

	    final JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("请输入书名：");
	    label_1.setFont(new Font("@楷体", Font.BOLD, 12));
	    label_1.setBounds(37, 5, 86, 24);
	    panel_4.add(label_1);

	    final JButton button_1 = new JButton();
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		String name = textPane.getText();
				BynameFrame bf = new BynameFrame(name);//把用户名传给借阅界面
				LibraryBookService lbs = new LibraryBookService();
				lbs.showOnlybf(desktopPane, bf);
	    	}
	    });
	    button_1.setBackground(Color.CYAN);
	    button_1.setText("搜索");
	    button_1.setBounds(271, 5, 67, 24);
	    panel_4.add(button_1);

	    final JLabel label_2 = DefaultComponentFactory.getInstance().createLabel("请输入类型：");
	    label_2.setFont(new Font("@楷体", Font.BOLD, 12));
	    label_2.setBounds(366, 5, 86, 24);
	    panel_4.add(label_2);

	    final JTextPane textPane_1 = new JTextPane();
	    textPane_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
	    textPane_1.setBounds(445, 5, 159, 24);
	    panel_4.add(textPane_1);

	    final JButton button_2 = new JButton();
	    button_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		String type = textPane_1.getText();
    		    TypeFrame tf = new TypeFrame(type);
    		    LibraryBookService lbs = new LibraryBookService();
    		    lbs.showOnlytf(desktopPane, tf);
	    	}
	    });
	    button_2.setBackground(Color.CYAN);
	    button_2.setText("搜索");
	    button_2.setBounds(610, 5, 60, 24);
	    panel_4.add(button_2);

	    final JButton button_4 = new JButton();
	    button_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		AmongJFrame ajf = new AmongJFrame();
	    		desktopPane.add(ajf);
	    		ajf.setVisible(true);
	    	}
	    });
	    button_4.setBackground(new Color(0, 255, 255));
	    button_4.setText("图书排行榜");
	    button_4.setBounds(723, 5, 106, 28);
	    panel_4.add(button_4);

	    final JButton butt1 = new JButton();
	    butt1.setBounds(0, 1, 146, 71);
	    butt1.setForeground(new Color(0, 0, 255));
	    butt1.setFont(new Font("@微软雅黑", Font.BOLD | Font.ITALIC, 18));
	    butt1.setBackground(new Color(224, 255, 255));
	    butt1.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		//new 我的查看方法
//	    		BorrowBookFrame bbf = new BorrowBookFrame("likui");
//    			desktopPane.add(bbf);
//    			bbf.setVisible(true);
	    		LibraryBookService lbs = new LibraryBookService();
	    		FindFrame ff = new FindFrame();
    		    lbs.showOnlyff(desktopPane, ff);
	    	}
	    });
	    butt1.setText("图书检索");
	    
	    panel_1.add(butt1);

	    final JButton butt2 = new JButton();
	    butt2.setBounds(0, 72, 146, 71);
	    butt2.setForeground(new Color(0, 0, 255));
	    butt2.setFont(new Font("", Font.BOLD | Font.ITALIC, 18));
	    butt2.setOpaque(false);
	    butt2.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		BorrowFrameMasg bf = new BorrowFrameMasg(rname);//传递用户名
	    		BorrowService bs = new BorrowService();
				bs.showOnlyff(desktopPane, bf);
	    	}
	    });
	    butt2.setBackground(new Color(224, 255, 255));
	    butt2.setText("借书历史");
	    panel_1.add(butt2);

	    final JButton butt3 = new JButton();
	    butt3.setBounds(0, 143, 146, 71);
	    butt3.setForeground(new Color(0, 0, 255));
	    butt3.setFont(new Font("@微软雅黑", Font.BOLD | Font.ITALIC, 18));
	    butt3.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		LibraryBookService lbs = new LibraryBookService();
	    		BorrowFrame bbff = new BorrowFrame(rname);
    			lbs.showOnlybbff(desktopPane, bbff);
	    	}
	    });
	    butt3.setBackground(new Color(224, 255, 255));
	    butt3.setText("借阅操作");
	    panel_1.add(butt3);

	    final JButton butt4 = new JButton();
	    butt4.setBounds(0, 214, 146, 71);
	    butt4.setForeground(new Color(0, 0, 255));
	    butt4.setFont(new Font("@微软雅黑", Font.BOLD | Font.ITALIC, 18));
	    butt4.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		BorrowBookService bbs = new BorrowBookService();
	    		ReturnBookFrame rbf = new ReturnBookFrame(rname);
    			bbs.showOnlybbff(desktopPane, rbf);
    			rbf.setVisible(true);
	    	}
	    });
	    butt4.setBackground(new Color(224, 255, 255));
	    butt4.setText("归还操作");
	    panel_1.add(butt4);

	    final JButton butt5 = new JButton();
	    butt5.setBounds(0, 356, 146, 71);
	    butt5.setForeground(new Color(0, 0, 255));
	    butt5.setFont(new Font("@微软雅黑", Font.BOLD | Font.ITALIC, 18));
	    butt5.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		dispose();
	    		new LoginFrame(cf).setVisible(true);
	    	}
	    });
	    butt5.setBackground(new Color(224, 255, 255));
	    butt5.setText("重新登录");
	    panel_1.add(butt5);

	    final JPanel panel_2 = new JPanel();
	    panel_2.setBounds(0, 356, 146, 71);
	    panel_2.setBackground(new Color(224, 255, 255));
	    panel_2.setLayout(null);
	    panel_1.add(panel_2);

	    final JButton button = new JButton();
	    button.setBounds(0, 427, 146, 71);
	    panel_1.add(button);
	    button.setFont(new Font("@微软雅黑", Font.BOLD | Font.ITALIC, 18));
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {
	    		cf.setVisible(true);
	    	}
	    });
	    button.setForeground(new Color(0, 51, 102));
	    button.setBackground(new Color(0, 255, 255));
	    button.setText("留言");

	    final JButton button_3 = new JButton();
	    button_3.setBounds(0, 283, 146, 71);
	    panel_1.add(button_3);
	    button_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(final ActionEvent e) {//修改密码按钮
	    		new ChangeJFrame(rname).setVisible(true);
	    		ChangeJFrame.textName.setText(rname);
	    		
	    	}
	    });
	    button_3.setForeground(new Color(0, 0, 255));
	    button_3.setFont(new Font("", Font.BOLD | Font.ITALIC, 18));
	    button_3.setBackground(new Color(224, 255, 255));
	    button_3.setText("修改密码");

	    
	    
  
	   
	    
	}
	/**
	 * 显示InternalFrame
	 */
	/*public void showInternalFrame( Object obj){
		Component[] arr = desktopPane.getComponents();
		boolean flag=true;
		for (Component com : arr) {
			if(com instanceof ){
				flag=false;
			}
			
			
		}
		if(flag){
			//创建InternalFrame对象
			 //desktopPane.add();添加对象
			  //setvisible(true);
		}
	}*/

}
