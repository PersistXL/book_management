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
	DefaultTableModel tm = new DefaultTableModel();//����ģ��
	public DelBookFrame(){
		this.setSize(378, 373);
		setClosable(true);
		setMaximizable(true);
		setTitle("ɾ��ͼ��");

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
				 * �鿴ͼ��
				 */
				//��ֹ��ѯ��ʱ���ʹ�����ظ�����
				int rowCount = tm.getRowCount();
				for(int i=0;i<rowCount;i++){
						tm.removeRow(0);
					}
				
				DelBookService delBookService = new DelBookService();//����service��
				List<Book> list;
				try {
					list = delBookService.query();//���ò�ѯ����					
					//�������ϣ���ӵ�ģ����
					for (Book book : list) {
						tm.addRow(new Object[]{book.getBookno(),book.getBookname(),book.getBookprice(),book.getBookinven(),book.getBooktype()});
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setText("�鿴ͼ��");
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
				DelBookService delBookService = new DelBookService();//����service��
				//ɾ��,���Ȼ�ȡ�е��±�
				int rowIndex = table.getSelectedRow();//��ȡ�е��±�
				int rowNum = table.getSelectedRowCount();//�е�����
				if(rowIndex == -1){//���û��ѡ���κ�һ��,��ʾ��ѡ��Ҫɾ������
					JOptionPane.showConfirmDialog(null, "��ѡ��Ҫɾ������!");
				}else if (rowNum>1){//���ѡ�ж���
					JOptionPane.showConfirmDialog(null, "һ��ֻ��ɾ��һ��!");
				}else {
					int delNum = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������?");
					if(delNum == 0){//ɾ��
						try {
							String bno = (String) table.getValueAt(rowIndex, 0);//ͨ����������sql�е��ֶ�
							delBookService.del(bno);//�����ݿ���ɾ��													
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						tm.removeRow(rowIndex);//���б�ģ����ɾ��
					}
				}
			}
		});
		button_1.setText("ɾ��ͼ��");
		panel.add(button_1);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(224, 255, 255));
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		//���ģ��
		table.setModel(tm);
		//��ӱ�ͷ
			tm.addColumn("���");
			tm.addColumn("����");
			tm.addColumn("�鵥��");
			tm.addColumn("���");
			tm.addColumn("����");
	}

}
