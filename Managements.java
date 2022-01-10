package GUI;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Managements extends ReaderManagements  implements ActionListener, ItemListener {
	MyFrame frame2 = new MyFrame();
	JButton add = new JButton("Add Reader");
	JButton borrow = new JButton("Borrow Book");
	JButton delete = new JButton("Delete Reader");
	JButton cancel = new JButton("Cancel");
	JComboBox cb = new JComboBox();
	private JLabel select = new JLabel();
	private final JTextArea readerInfo = new JTextArea();
	
	public Managements(){
		frame2.setTitle("Manage Reader List");
		frame2.setSize(500, 270);
		frame2.setLocation(550, 350);
		frame2.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
		cb.setBounds(12, 20, 183, 21);
		cb.addItem("Select Reader");
		for(int i=0; i<BRlist.size(); i++){
			cb.addItem(BRlist.get(i).getId() + ". " + BRlist.get(i).getName());
		}
		frame2.getContentPane().add(cb);
	
		borrow.setBounds(360, 40, 116, 32);
		frame2.getContentPane().add(borrow);
		
		delete.setBounds(360, 82, 116, 32);
		frame2.getContentPane().add(delete);
		
		cancel.setBounds(360, 166, 116, 32);
		frame2.getContentPane().add(cancel);
		
		select.setBounds(12, 14, 57, 15);
		frame2.getContentPane().add(select);
		
		readerInfo.setEditable(false);
		readerInfo.setBounds(12, 50, 330, 152);
		frame2.getContentPane().add(readerInfo);
		
		add.setBounds(360, 124, 116, 32);
		frame2.getContentPane().add(add);
		
		add.addActionListener(this);
		borrow.addActionListener(this);
		delete.addActionListener(this);
		cancel.addActionListener(this);
		cb.addItemListener(this);

		
		frame2.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent ie){
		if(cb.getSelectedIndex()!=0){
			int select = cb.getSelectedIndex()-1;
			readerInfo.setText("Reader ID : "+BRlist.get(select).getId() + "\nReader Name : "+ BRlist.get(select).getName() 
					+ "\nBorrowing Date : "+ BRlist.get(select).getBorrowD()+ "\nBorrowing Book : "+ BRlist.get(select).getBorrowB() + "\nReturn Book : "+ BRlist.get(select).getReturnB() + "\nReturn  : "+ BRlist.get(select).getReturnD());  
		}else{
			readerInfo.setText(null);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == borrow){
			int select = cb.getSelectedIndex();
			Borrow bo = new Borrow(select);
			frame2.dispose();
		}else if(e.getSource() == delete){
			int select = cb.getSelectedIndex()-1;
			BRlist.remove(select);
			cb.removeItemAt(select+1);
		}else if(e.getSource() == add){
			frame2.dispose();
			AddReader mr = new AddReader();
		}else if(e.getSource() == cancel){
			frame2.dispose();
			super.MmStart();
		}
	}
}
