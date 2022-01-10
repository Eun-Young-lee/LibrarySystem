package GUI;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AddReader extends ReaderManagements implements ActionListener {
    private JTextField id;
    private JTextField name;	
    private JTextField email;
    private JTextField phone;

    JButton bt1 = new JButton("Add");
    JButton bt2 = new JButton("Candcel");
    MyFrame frame = new MyFrame();
    
    public AddReader(){
        frame.setTitle("Add Reader");
        frame.setSize(470, 300);
        frame.setLocation(500, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JLabel rId = new JLabel("Reader ID :");
        rId.setBounds(27, 19, 100, 30);
        frame.getContentPane().add(rId);

        JLabel rName = new JLabel("Reader Name :");
        rName.setBounds(27, 59, 100, 30);
        frame.getContentPane().add(rName);

        JLabel rEmail = new JLabel("Reader email :");
        rEmail.setBounds(27, 98, 100, 30);
        frame.getContentPane().add(rEmail);

        JLabel rPhone = new JLabel("Reader Phone :");
        rPhone.setBounds(27, 139, 100, 30);
        frame.getContentPane().add(rPhone);
        
        id = new JTextField();
        id.setColumns(10);
        id.setBounds(135, 21, 160, 30);        

        name = new JTextField();
        name.setColumns(10);
        name.setBounds(135, 61, 160, 30);
        frame.getContentPane().add(name);

        email = new JTextField();
        email.setColumns(10);
        email.setBounds(135, 101, 160, 30);
        frame.getContentPane().add(email);

        phone = new JTextField();
        phone.setColumns(10);
        phone.setBounds(135, 141, 160, 30);
        frame.getContentPane().add(phone);

        bt1.setBounds(97, 202, 97, 40);
        frame.getContentPane().add(bt1);

        bt2.setBounds(230, 202, 97, 40);
        frame.getContentPane().add(bt2);
       
        if(Rlist.size() != 0){
                id.setText((Integer.parseInt(Rlist.get(Rlist.size()-1).getRid())+1)+"");
        }else{
                id.setText(1011 + "");
        }
        frame.getContentPane().add(id);

        JLabel label1 = new JLabel("i.e. email@address.com");
        label1.setBounds(303, 103, 160, 18);
        frame.getContentPane().add(label1);

        JLabel label2 = new JLabel("i.e. 0812345678");
        label2.setBounds(303, 142, 160, 18);
        frame.getContentPane().add(label2);				

        frame.setVisible(true);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        boolean  StringCheck = true;
        if(e.getSource() == bt1){
            String rId = id.getText();
            String rName = name.getText();
            String rEmail = email.getText();
            String rPhone = phone.getText();            
           
            if(rId.equals("")){
                    JOptionPane.showMessageDialog(this, "Input Reader ID", "message", JOptionPane.INFORMATION_MESSAGE);
            }else if(rName.equals("")){
                    JOptionPane.showMessageDialog(this, "Input Reader Name", "message", JOptionPane.INFORMATION_MESSAGE);
            }else if(rEmail.equals("")){
                    JOptionPane.showMessageDialog(this, "Input Reader Email", "message", JOptionPane.INFORMATION_MESSAGE);
            }else if(rPhone.equals("")){
                    JOptionPane.showMessageDialog(this, "Input Reader Phone number", "message", JOptionPane.INFORMATION_MESSAGE);

            }else{
                for(int i=0; i<Rlist.size(); i++){
                    if(rId.equals(Rlist.get(i).getRid())){
                        JOptionPane.showMessageDialog(this, "The ID exists", "message", JOptionPane.INFORMATION_MESSAGE);
                        }
                }
                 if(!(rEmail.contains("@") && rEmail.contains(".") )){
                    JOptionPane.showMessageDialog(this, "Email is incorrect", "message", JOptionPane.INFORMATION_MESSAGE);	
                     }else {
                        int check = JOptionPane.showConfirmDialog(this, "Check!\n" + 
                        "Reader ID : "+rId + "\nReader Name : "+rName + "\nReader email : " + rEmail + 
                        "\nReader Phone : " + rPhone,
                        "message", JOptionPane.INFORMATION_MESSAGE );
                        
                        if(check == 0){
                            Readers r = new Readers(rId, rName, rEmail, rPhone);
                            r.setRid(rId);
                            r.setName(rName);
                            r.setEmail(rEmail);
                            r.setPhone(rPhone);
                            Rlist.add(r);
                            ReaderFileSave();
                            JOptionPane.showMessageDialog(this, "Registered", "message", JOptionPane.INFORMATION_MESSAGE);
                            int check2 = JOptionPane.showConfirmDialog(this, "Add more readers?");
                            if(check2 == 0){
                                id.setText(Integer.parseInt(Rlist.get(Rlist.size()-1).getRid()) +1 + "");
                                name.setText(null);
                                phone.setText(null);
                                email.setText(null);			
                        }else if(check2 == 1){
                                frame.setVisible(false);
                                super.MmStart();
                        }
                            }
                        }
                }
            }else if(e.getSource() == bt2) {
                frame.dispose();
                super.MmStart();
            }
    }
  }
