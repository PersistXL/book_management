package com.qingeng.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import com.qingeng.Entity.Book;
import com.qingeng.Service.DelBookService;

@SuppressWarnings("serial")
public class DelBookFrame extends JInternalFrame {
	private JTable table;	
	DefaultTableModel tm = new DefaultTableModel();//创建模型
	public DelBookFrame(){
		this.setSize(378, 373);
		setClosable(true);
		setMaximizable(true);
		setTitle("删除图书");

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		getContentPane().add(panel, BorderLayout.NORTH);

		final JButton button = new JButton();
		button.setForeground(new Color(0, 0, 255));
		button.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(new Color(255, 255, 255));
		button.setOpaque(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				/**
				 * 查看图书
				 */
				//防止查询的时候会使数据重复出现
				int rowCount = tm.getRowCount();
				for(int i=0;i<rowCount;i++){
						tm.removeRow(0);
					}
				
				DelBookService delBookService = new DelBookService();//调用service层
				List<Book> list;
				try {
					list = delBookService.query();//调用查询方法					
					//遍历集合，添加到模型中
					for (Book book : list) {
						tm.addRow(new Object[]{book.getBookno(),book.getBookname(),book.getBookprice(),book.getBookinven(),book.getBooktype()});
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setText("查看图书");
		panel.add(button);

		final JLabel label = DefaultComponentFactory.getInstance().createLabel("");
		label.setPreferredSize(new Dimension(40, 0));
		panel.add(label);

		final JButton button_1 = new JButton();
		button_1.setOpaque(false);
		button_1.setForeground(new Color(0, 0, 255));
		button_1.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				DelBookService delBookService = new DelBookService();//调用service层
				//删除,首先获取行的下标
				int rowIndex = table.getSelectedRow();//获取行的下标
				int rowNum = table.getSelectedRowCount();//行的数量
				if(rowIndex == -1){//如果没有选中任何一行,提示请选择要删除的行
					JOptionPane.showConfirmDialog(null, "请选择要删除的行!");
				}else if (rowNum>1){//如果选中多行
					JOptionPane.showConfirmDialog(null, "一次只能删除一行!");
				}else {
					int delNum = JOptionPane.showConfirmDialog(null, "确定要删除该行吗?");
					if(delNum == 0){//删除
						try {
							String bno = (String) table.getValueAt(rowIndex, 0);//通过行列锁定sql中的字段
							delBookService.del(bno);//从数据库中删除													
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						tm.removeRow(rowIndex);//从列表模型中删除
					}
				}
			}
		});
		button_1.setText("删除图书");
		panel.add(button_1);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(224, 255, 255));
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		//添加模型
		table.setModel(tm);
		//添加表头
			tm.addColumn("编号");
			tm.addColumn("书名");
			tm.addColumn("书单价");
			tm.addColumn("库存");
			tm.addColumn("类型");
	}

}
