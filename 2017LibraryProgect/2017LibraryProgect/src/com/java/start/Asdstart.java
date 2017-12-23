package com.java.start;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.java.io.frame.BorrowBookFrame;

@SuppressWarnings("serial")
public class Asdstart extends JFrame {
    public Asdstart(){
    	setSize(741,495);
    	final JDesktopPane desktopPane = new JDesktopPane();

    	final JPanel panel = new JPanel();
    	getContentPane().add(panel, BorderLayout.NORTH);

    	final JButton button = new JButton();
    	button.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent e) {
    			BorrowBookFrame bbf = new BorrowBookFrame("likui");
    			desktopPane.add(bbf);
    			bbf.setVisible(true);
    		}
    	});
    	button.setText("²é¿´");
    	panel.add(button);

    	
    	getContentPane().add(desktopPane, BorderLayout.CENTER);
    }
}
