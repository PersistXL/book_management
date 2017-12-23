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
	 *    �������
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
    	label.setText("��ӭ����ƽ���ͼ��ݻ���ϵͳ��");
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
    		public void actionPerformed(final ActionEvent e) {//�鿴�Լ�δ�������Ϣ
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
    			JOptionPane.showMessageDialog(null,"��Ϊ����ʾ��δ�����������Ϣ����ע��Ӧ��ʱ�䣡");
    		}
    	});
    	button.setBackground(new Color(123, 104, 238));
    	button.setText("�鿴");
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
    				
    				//�ÿɽ�������һ
    				ReglibraryService rs = new ReglibraryService();
    				rs.updateBorrowedService(rname);
    				//���鱾����һ
    				LibraryBookService lbs = new LibraryBookService();
    				String bookno = (String) table.getValueAt(row, 1);
    				lbs.libookInvenService(bookno);
    				int onlyno = (int) table.getValueAt(row, 0); 
    				bbs.updateByOnly(onlyno);
    				List<BorrowBook> list = bbs.queryContmoney(onlyno);
    				for (BorrowBook bor : list) {//�����Ƿ����ڣ��������
    					bookprice = bor.getBookprice();
						actu = bor.getActudate();//��������
						max = bor.getMaxdate();//�������
						lend = bor.getLenddate();//�������
						table.setValueAt(actu, row, 6);
                        }
                    long longtimemax = max.getTime();
                    long longtimeactu = actu.getTime();
                    long longtimelend = lend.getTime();
                    bbs.countMoney(bookprice,longtimemax,longtimeactu,longtimelend,onlyno,table,row);
    				JOptionPane.showMessageDialog(null, "����ɹ���");
    			}catch(Exception e1){
    				JOptionPane.showMessageDialog(null,e1.getMessage());
    			}
    		}
    	});
    	button_1.setBackground(new Color(123, 104, 238));
    	button_1.setText("����");
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
    	button_2.setText("�˳�");
    	button_2.setBounds(598, 316, 90, 28);
    	getContentPane().add(button_2);
    	setTitle("����ϵͳ");
    	table.setModel(dtm);

    	final JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("ע������ʱ��ѡ��Ҫ���������ڵ���");
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
       dtm.addColumn("ͼ������");
 	   dtm.addColumn("ͼ����");
 	   dtm.addColumn("ͼ������");
 	   dtm.addColumn("ͼ�鵥��");
 	   dtm.addColumn("���ʱ��");
 	   dtm.addColumn("�������");
 	   dtm.addColumn("�黹ʱ��");
 	   dtm.addColumn("�ͷ�����");
 	   dtm.addColumn("���޽��");
 	   dtm.addColumn("ͼ������");

    }
}
