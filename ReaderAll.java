package GUI;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class ReaderAll extends ReaderManagements {
    MyFrame frame5 = new MyFrame();	
    private JTable table;	

    public ReaderAll() {
            frame5.setTitle("Readers List");
            frame5.setSize(540,400);
            frame5.setLocation(350, 250);
            frame5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame5.getContentPane().setLayout(null);

            ArrayList<Readers> Rlist = loadData1(); 

            String[] column =  {
                    "ID", "Name", "Email", "Phone" };
            Object[][] ob = new Object[Rlist.size()][5];
            for(int i=0; i<Rlist.size(); i++){
                ob[i][0] = Rlist.get(i).getRid();
                ob[i][1] = Rlist.get(i).getName();
                ob[i][2] = Rlist.get(i).getEmail();
                ob[i][3] = Rlist.get(i).getPhone();
                }
		
            table= new JTable(ob,column);
            table.getColumn("ID").setPreferredWidth(50);
            table.getColumn("Name").setPreferredWidth(100);
            table.getColumn("Email").setPreferredWidth(120);
            table.getColumn("Phone").setPreferredWidth(100);	
            

            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.CENTER);
            TableColumnModel tcm = table.getColumnModel();
            for(int i=0; i<tcm.getColumnCount(); i++){
                    tcm.getColumn(i).setCellRenderer(dtcr);
            }

            table.setSize(480,300);

            JScrollPane scrollPane = new JScrollPane(table);
            table.setAutoCreateRowSorter(true); //간단하게 정렬하는 법
            scrollPane.setSize(500, 300);	
            scrollPane.setLocation(12, 10);
            scrollPane.setPreferredSize(new Dimension(369, 203));
            frame5.getContentPane().add(scrollPane);			

            frame5.setVisible(true);
        }
}
	