package com.java.io.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.entity.BorrowBook;
import com.java.service.BorrowBookService;
import com.java.service.LibraryBookService;
import com.java.service.ReglibraryService;
import com.jgoodies.forms.factories.DefaultComponentFactory;



@SuppressWarnings("serial")
public class ReturnBookFrame extends JInternalFrame {
	private JTable table;
	DefaultTableModel dtm = new DefaultTableModel();
	/**
	 *    还书界面
	 * @param rname 
	 */
    public ReturnBookFrame(final String rname){
    	final BorrowBookService bbs = new BorrowBookService();
    	setSize(846,424);
    	setClosable(true);
    	getContentPane().setLayout(null);

    	final JLabel label = new JLabel();
    	label.setForeground(new Color(0, 0, 255));
    	label.setFont(new Font("", Font.BOLD | Font.ITALIC, 22));
    	label.setBackground(SystemColor.text);
    	label.setText("欢迎进入黄金屋图书馆还书系统！");
    	label.setBounds(265, 10, 360, 65);
    	getContentPane().add(label);

    	final JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setOpaque(false);
    	scrollPane.setBackground(SystemColor.text);
    	scrollPane.setBounds(75, 77, 688, 184);
    	getContentPane().add(scrollPane);

    	table = new JTable();
    	scrollPane.setViewportView(table);

    	final JButton button = new JButton();
    	button.setOpaque(false);
    	button.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {//查看自己未还书的信息
    			BorrowBookService bbs = new BorrowBookService();
    			bbs.clear(dtm);
    			try {
    				List<BorrowBook> list = bbs.queryByrnameactuService(rname,table);
    				for (BorrowBook bor : list) {
						dtm.addRow(new Object[]{bor.getOnlyno(),bor.getBookno(),bor.getBookname(),bor.getBookprice(),bor.getLenddate(),bor.getMaxdate(),bor.getActudate(),bor.getFinemoney(),bor.getRentmoney(),bor.getBooktype()});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			JOptionPane.showMessageDialog(null,"已为您显示你未还书的所有信息，请注意应还时间！");
    		}
    	});
    	button.setBackground(new Color(123, 104, 238));
    	button.setText("查看");
    	button.setBounds(181, 316, 90, 28);
    	getContentPane().add(button);

    	final JButton button_1 = new JButton();
    	button_1.setOpaque(false);
    	button_1.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {
    			Date actu = null;
				Date max = null;
				Date lend = null;
				double bookprice = 0;
    			try{	
    				int row = table.getSelectedRow();
    				int controw = table.getSelectedRowCount();
    				bbs.chooseRow(row, controw);
    				
    				//让可借数量减一
    				ReglibraryService rs = new ReglibraryService();
    				rs.updateBorrowedService(rname);
    				//让书本库存加一
    				LibraryBookService lbs = new LibraryBookService();
    				String bookno = (String) table.getValueAt(row, 1);
    				lbs.libookInvenService(bookno);
    				int onlyno = (int) table.getValueAt(row, 0); 
    				bbs.updateByOnly(onlyno);
    				List<BorrowBook> list = bbs.queryContmoney(onlyno);
    				for (BorrowBook bor : list) {//计算是否逾期，计算租金
    					bookprice = bor.getBookprice();
						actu = bor.getActudate();//还书日期
						max = bor.getMaxdate();//最大期限
						lend = bor.getLenddate();//借出日期
						table.setValueAt(actu, row, 6);
                        }
                    long longtimemax = max.getTime();
                    long longtimeactu = actu.getTime();
                    long longtimelend = lend.getTime();
                    bbs.countMoney(bookprice,longtimemax,longtimeactu,longtimelend,onlyno,table,row);
    				JOptionPane.showMessageDialog(null, "还书成功！");
    			}catch(Exception e1){
    				JOptionPane.showMessageDialog(null,e1.getMessage());
    			}
    		}
    	});
    	button_1.setBackground(new Color(123, 104, 238));
    	button_1.setText("还书");
    	button_1.setBounds(403, 316, 90, 28);
    	getContentPane().add(button_1);

    	final JButton button_2 = new JButton();
    	button_2.setOpaque(false);
    	button_2.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {
    			dispose();
    		}
    	});
    	button_2.setBackground(new Color(123, 104, 238));
    	button_2.setText("退出");
    	button_2.setBounds(598, 316, 90, 28);
    	getContentPane().add(button_2);
    	setTitle("还书系统");
    	table.setModel(dtm);

    	final JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("注：还书时请选择要还得书所在的行");
    	label_1.setForeground(new Color(255, 0, 0));
    	label_1.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
    	label_1.setBounds(75, 276, 223, 18);
    	getContentPane().add(label_1);

    	final JPanel panel = new JPanel();
    	panel.setOpaque(false);
    	panel.setBackground(SystemColor.text);
    	panel.setBounds(0, 0, 836, 389);
    	getContentPane().add(panel);
    	setOpaque(false);
    	setBackground(SystemColor.text);
       dtm.addColumn("图书序列");
 	   dtm.addColumn("图书编号");
 	   dtm.addColumn("图书名称");
 	   dtm.addColumn("图书单价");
 	   dtm.addColumn("借出时间");
 	   dtm.addColumn("最大期限");
 	   dtm.addColumn("归还时间");
 	   dtm.addColumn("惩罚罚金");
 	   dtm.addColumn("租赁金额");
 	   dtm.addColumn("图书类型");

    }
}
