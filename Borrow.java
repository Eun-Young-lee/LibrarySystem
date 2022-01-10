package GUI;

import java.awt.Frame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;



public class Borrow extends ReaderManagements implements ActionListener{
	static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	MyFrame frame3 = new MyFrame();
	JButton eId = new JButton("ID");
	JButton eName = new JButton("Name");	
	JButton eborrowD = new JButton("Borrow Date");
	JButton eborrowB = new JButton("<html>Borrowing<br>Book</html>");
	JButton eRetrurnD = new JButton("Return Date");
	JButton eRetrurnB = new JButton("<html>Retuan<br>Book</html>");
	JButton eConfirm = new JButton("Confirm");
	JButton eCancel = new JButton("Cancel");
	
	private JTextField tId;
	private JTextField tName;	
	private JTextField tborrowD;		
	private JTextField tborrowB;
	private JTextField treturnD;
	private JTextField treturnB;
	
	int index ;
	String name=null, id=null, email=null, borrowD=null, borrowB=null , returnD=null, returnB=null;
	
	public Borrow(int index) {
		frame3.getContentPane().setEnabled(false);
		frame3.setTitle("Borrow_Return");
		frame3.setSize(450, 400);
		frame3.setLocation(550, 350);
		frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
		
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		
		this.index = index - 1;
		
		JLabel lblNewLabel = new JLabel("Register Borrow & Return");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 10, 290, 23);
		frame3.getContentPane().add(lblNewLabel);
		
		eId.setBounds(10, 48, 60, 25);
		frame3.getContentPane().add(eId);
		
		eName.setBounds(198, 48, 80, 25);
		frame3.getContentPane().add(eName);
			
		eborrowD.setBounds(10, 90, 125, 25);
		frame3.getContentPane().add(eborrowD);		
		
		eborrowB.setBounds(10, 133, 90, 50);
		frame3.getContentPane().add(eborrowB);
		
		eRetrurnD.setBounds(10, 200, 125, 25);
		frame3.getContentPane().add(eRetrurnD);
		
		eRetrurnB.setBounds(10, 243, 90, 50);
		frame3.getContentPane().add(eRetrurnB);
		
		eConfirm.setBounds(113, 312, 110, 35);
		frame3.getContentPane().add(eConfirm);
		
		eCancel.setBounds(240, 312, 110, 35);
		frame3.getContentPane().add(eCancel);
                
		tId = new JTextField();
		tId.setEditable(false);
		tId.setColumns(10);
		tId.setBounds(75, 48, 117, 25);
		frame3.getContentPane().add(tId);
		
		tName = new JTextField();
		tName.setEditable(false);
		tName.setBounds(287, 48, 127, 25);
		frame3.getContentPane().add(tName);
		tName.setColumns(10);
		
		tborrowD= new JTextField();
		tborrowD.setEditable(false);
		tborrowD.setColumns(10);
		tborrowD.setBounds(147, 90, 270, 25);
		frame3.getContentPane().add(tborrowD);		
		
		tborrowB = new JTextField();
		tborrowB.setEditable(false);
		tborrowB.setColumns(10);
		tborrowB.setBounds(110, 133, 310, 50);
		frame3.getContentPane().add(tborrowB);
		tborrowD.setText(date);	
		
		treturnD = new JTextField();
		treturnD.setEditable(false);
		treturnD.setColumns(10);
		treturnD.setBounds(147, 200, 270, 25);
		frame3.getContentPane().add(treturnD);		
		treturnD.setText(date);	
		
		treturnB = new JTextField();
		treturnB.setEditable(false);
		treturnB.setColumns(10);
		treturnB.setBounds(110, 243, 310, 50);
		frame3.getContentPane().add(treturnB);
		
		tId.setText(BRlist.get(this.index).getId());
		tName.setText(BRlist.get(this.index).getName());		
		tborrowB.setText(null);
		treturnB.setText(null);
	
		frame3.setVisible(true);	
		tborrowB.addActionListener(this);
		eborrowB.addActionListener(this);
		treturnD.addActionListener(this);
		eRetrurnB.addActionListener(this);
		eConfirm.addActionListener(this);
		eCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {			
		if(e.getSource() == eborrowB){			
			if(borrowB == null){
			borrowB = JOptionPane.showInputDialog("Input BookID", null);
			}
				if(tborrowB.getText().equals("")){
					JOptionPane.showMessageDialog(this, "Input valid BookID", "message", JOptionPane.INFORMATION_MESSAGE);
					return;	
			} for (int i = 0; i <Blist.size(); i++) {				
			if(tborrowB.getText().equals(Blist.get(i).getbId()));
				{
				 JOptionPane.showMessageDialog(this, "The Book isn't avaible", "message", JOptionPane.INFORMATION_MESSAGE);
				}				
			}
		
		}else if (e.getSource() == eRetrurnB){						
			if(returnB == null){
				returnB = JOptionPane.showInputDialog("Input BookID", null);
			}
			if(treturnB.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Input vaild BookID", "message", JOptionPane.INFORMATION_MESSAGE);
				return;		
			}for (int i = 0; i < BRlist.size(); i++) {
				if(treturnB.getText().equals(BRlist.get(i).getBorrowB()));
				{
				 JOptionPane.showMessageDialog(this, "Returned", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}		
		
		if(e.getSource() == eConfirm) {			
			if(borrowB != null){
			BRlist.get(this.index).setBorrowB(this.borrowB);			
			}
			else if(returnB != null){
			BRlist.get(this.index).setReturnB(this.returnB);				
			}
			fileSave();
			frame3.dispose();
			ReaderManagements rm = new ReaderManagements();
			rm.MmStart();
       
		}else if (e.getSource() == eCancel){
				frame3.dispose();
				Managements m = new Managements();
			}	
		}
}	
	

	
