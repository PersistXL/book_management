package com.library.Frame;


import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.liubo.Service.LibraryBookService;

@SuppressWarnings("serial")
public class AmongJFrame extends JInternalFrame {
	private JTable table;
	DefaultTableModel dtm = new DefaultTableModel();
	public AmongJFrame() {
		super();
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(210, 180, 140));
		setClosable(true);
		setResizable(false);
		setTitle("图书借阅排行榜");
		setSize(805,435);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(144, 238, 144));
		scrollPane.setBounds(88, 76, 629, 302);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(dtm);

		final JLabel label = new JLabel();
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("@华文琥珀", Font.BOLD | Font.ITALIC, 42));
		label.setText("风    云    榜");
		label.setBounds(290, 24, 255, 44);
		getContentPane().add(label);
		dtm.addColumn("书名");
		dtm.addColumn("类型");
		dtm.addColumn("排名");
		LibraryBookService ser = new LibraryBookService();

	    try {
	    	int i = 0;
	    	ResultSet rs = ser.among();
			while(rs.next()){
			String name = rs.getString("bookname");
			String type = rs.getString("booktype");
			i++;
			
			dtm.addRow(new Object[]{name,type,i});
			if(i>=10){
				break;
			}
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
