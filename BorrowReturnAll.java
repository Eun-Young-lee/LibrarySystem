package GUI;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class BorrowReturnAll extends ReaderManagements {
	MyFrame frame5 = new MyFrame();	
	private JTable table;	
	
	public BorrowReturnAll() {
		frame5.setTitle("LendReturn List");
		frame5.setSize(810, 448);
		frame5.setLocation(350, 250);
		frame5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		
		ArrayList<BorrowReturn> BRlist = loadData2(); 
		
		String[] column =  {
			"ID", "Name","BorrowDate","BorrowBook","ReturnDate","ReturnBook" };
		Object[][] ob = new Object[BRlist.size()][6];
		for(int i=0; i<BRlist.size(); i++){
			ob[i][0] = BRlist.get(i).getId();
			ob[i][1] = BRlist.get(i).getName();
			ob[i][2] = BRlist.get(i).getBorrowD();
			ob[i][3] = BRlist.get(i).getBorrowB();
			ob[i][4] = BRlist.get(i).getReturnD();
			ob[i][5] = BRlist.get(i).getReturnB();
			}
		
		table= new JTable(ob,column);
		table.getColumn("ID").setPreferredWidth(40);
		table.getColumn("Name").setPreferredWidth(70);
		table.getColumn("BorrowDate").setPreferredWidth(70);	
		table.getColumn("BorrowBook").setPreferredWidth(190);
		table.getColumn("ReturnDate").setPreferredWidth(70);
		table.getColumn("ReturnBook").setPreferredWidth(190);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		table.setSize(750,300);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setAutoCreateRowSorter(true); //간단하게 정렬하는 법
		scrollPane.setSize(770, 300);	
		scrollPane.setLocation(12, 10);
		scrollPane.setPreferredSize(new Dimension(369, 203));
		frame5.getContentPane().add(scrollPane);			
			
	    frame5.setVisible(true);
	}
}
	