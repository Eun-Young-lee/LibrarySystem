package GUI;

import java.awt.Frame;
import javax.swing.*;
import GUI.BorrowReturnAll;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReaderSearch extends ReaderManagements implements ActionListener {
	MyFrame frame5 = new MyFrame();
	JButton rId = new JButton("Reader ID");
	JButton rName = new JButton("Reader Name");
	JButton rAll = new JButton("Reader List");
	JButton rCancel = new JButton("Cancel");
	JTextArea textArea = new JTextArea();
        
	public ReaderSearch(){
		frame5.setTitle("Search Reader");
        frame5.setSize(500, 300);
		frame5.setLocation(550, 350);
		frame5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Search by");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD|Font.ITALIC, 16));
		lblNewLabel.setBounds(375, 3, 125, 32);
		frame5.getContentPane().add(lblNewLabel);
		
		rId.setBounds(357, 40, 115, 32);
		frame5.getContentPane().add(rId);
		
		rName.setBounds(357, 86, 115, 32);
		frame5.getContentPane().add(rName);	
		
		JLabel lblNewLabel1 = new JLabel("**********************");
        lblNewLabel1.setBounds(357, 124, 115, 32);
        frame5.getContentPane().add(lblNewLabel1);
		
		rAll.setBounds(357, 155, 115, 35);
		frame5.getContentPane().add(rAll);
		
		rCancel.setBounds(357, 200, 115, 32);
		frame5.getContentPane().add(rCancel);
		
		textArea.setEditable(false);
		textArea.setBounds(12, 9, 331, 234);
		frame5.getContentPane().add(textArea);
		
		JList list_1 = new JList();
		list_1.setBounds(242, 48, 1, 1);
		frame5.getContentPane().add(list_1);
		
		frame5.setVisible(true);
		
		rAll.addActionListener(this);
		rId.addActionListener(this);
		rName.addActionListener(this);
		rCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int dataCnt=1;
	
		if(e.getSource() == rId){
			String id = JOptionPane.showInputDialog("Search by ID");
			if(id == null){
				return;
			}
			if(Rlist.size() != 0){
				for(int i=0; i<Rlist.size(); i++){
					if(id.equals(Rlist.get(i).getRid())){
						textArea.setText("Reader ID : "+Rlist.get(i).getRid() + 
						"\n\nReader Name : "+Rlist.get(i).getName() + 
						"\n\nReader Email : " + Rlist.get(i).getEmail());
						break;
					}
					dataCnt++;
				}
				if(dataCnt == Rlist.size()+1){
					JOptionPane.showMessageDialog(this, "Not found", "message", JOptionPane.INFORMATION_MESSAGE);
				}	
			}else{
				JOptionPane.showMessageDialog(this, "Not found", "message", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}else if(e.getSource() == rName){
			String name = JOptionPane.showInputDialog("Search by Name");
			if(name == null){
				return;
			}
			if (Rlist.size() != 0) {
				for (int i = 0; i < Rlist.size(); i++) {
					if (name.equalsIgnoreCase(Rlist.get(i).getName())) { // 대소문자 구분없이
						textArea.setText("Reader ID : " + Rlist.get(i).getRid()
						+ "\n\nReader Name : " + Rlist.get(i).getName()
						+ "\n\nReader Email : " + Rlist.get(i).getEmail());
					
						break;
					}
					dataCnt++;
					}
				if(dataCnt == Rlist.size()+1){
				JOptionPane.showMessageDialog(this, "Not found", "message", JOptionPane.INFORMATION_MESSAGE);
				}				
			}
		} else if(e.getSource() == rAll) {
			ReaderAll rAll = new ReaderAll();					
		}else if(e.getSource() == rCancel) {
			frame5.dispose();
			super.MmStart();
		}
	}
}



	
	





	

	
		

		

