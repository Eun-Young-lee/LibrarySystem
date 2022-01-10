package GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.security.cert.CollectionCertStoreParameters;
import java.util.Collections;

import javax.swing.*;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class BookSearch extends ReaderManagements implements ActionListener{
        MyFrame frame7 = new MyFrame();
        JButton author = new JButton("Book Author");
        JButton title = new JButton("Book Title");
        JButton bAll = new JButton("Book List");
        JButton bCancel = new JButton("Cancel");
        JTextArea textArea = new JTextArea();
        
	public BookSearch(){
		frame7.setTitle("Search Book");
		frame7.setSize(500, 300);
		frame7.setLocation(550, 350);
		frame7.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
		JLabel lblNewLabel = new JLabel("Search by");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD|Font.ITALIC, 16));
		lblNewLabel.setBounds(375, 3, 125, 32);
		frame7.getContentPane().add(lblNewLabel);
		
		author.setBounds(357, 40, 115, 32);
		frame7.getContentPane().add(author);
		
		title.setBounds(357, 86, 115, 32);
		frame7.getContentPane().add(title);
                
        JLabel lblNewLabel1 = new JLabel("**********************");
        lblNewLabel1.setBounds(357, 124, 115, 32);
        frame7.getContentPane().add(lblNewLabel1);
		
		bAll.setBounds(357, 155, 115, 35);
		frame7.getContentPane().add(bAll);
		
		bCancel.setBounds(357, 200, 115, 32);
		frame7.getContentPane().add(bCancel);
		
		textArea.setEditable(false);
		textArea.setBounds(12, 9, 331, 234);
		frame7.getContentPane().add(textArea);
		
		JList list_2 = new JList();
		list_2.setBounds(242, 48, 1, 1);
		frame7.getContentPane().add(list_2);
		
		frame7.setVisible(true);
		
		author.addActionListener(this);
		title.addActionListener(this);
		bAll.addActionListener(this);
		bCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int dataCnt=1;		
		if(e.getSource() == author) {
			String author = JOptionPane.showInputDialog("Search by Author");
			if(author == null) {
				return;
				}
			if(Blist.size() != 0){
				for(int i=0; i<Blist.size(); i++){
					if((author.equalsIgnoreCase(Blist.get(i).getAuthorF()))||(author.equalsIgnoreCase(Blist.get(i).getAuthorL()))){ 
						textArea.setText("Book Author : "+Blist.get(i).getbId() +
						"\n\nBook Title : "+Blist.get(i).getTitle() + "\n\nAuthor First Name : " + Blist.get(i).getAuthorF()  + "\n\nAuthor Last Name : " + Blist.get(i).getAuthorL()+ "\n\nGenre : " + Blist.get(i).getGenre());
						break;
						}
					dataCnt++;
					}
				if(dataCnt == Blist.size()+1){
					JOptionPane.showMessageDialog(this, "Not found", "message", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Not found", "message", JOptionPane.INFORMATION_MESSAGE);
					}
	}else if(e.getSource() == title){
				
				String title = JOptionPane.showInputDialog("Search by Title");
				if(title == null){
					return;
					}
				if (Blist.size() != 0) {
					for (int i = 0; i < Blist.size(); i++) {
								      		if (title.equalsIgnoreCase(Blist.get(i).getTitle())) {
                                			textArea.setText("Reader ID : " + Blist.get(i).getbId()
                                            + "\n\nBook Author First Name : " + Blist.get(i).getAuthorF()
                                            + "\n\nBook Author Last Name : " + Blist.get(i).getAuthorL()
                                            + "\n\nBook Title : " + Blist.get(i).getTitle()
                                            + "\n\nBook Genre : " + Blist.get(i).getGenre());
                                			break;
                                			}
								      		dataCnt++;
								      		}
							if(dataCnt == Blist.size()+1){
								JOptionPane.showMessageDialog(this, "Not Found", "message", JOptionPane.INFORMATION_MESSAGE);
								}							
					} else {
						JOptionPane.showMessageDialog(this, "Not Found.", "message", JOptionPane.INFORMATION_MESSAGE);
						}
	
	} else if(e.getSource() ==bAll) {
					
		BookAll ba =new BookAll();					
					
	} else if( e.getSource()==bCancel){
	frame7.dispose();
	super.MmStart();
	}
	}
}
