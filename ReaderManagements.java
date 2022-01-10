package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class ReaderManagements extends MyFrame{
	static ArrayList<Readers>Rlist = new ArrayList<Readers>();  
    static ArrayList<BorrowReturn> BRlist = new ArrayList<BorrowReturn>(); 
    static ArrayList<Books> Blist = new ArrayList<Books>();  
    MyFrame frame = new MyFrame();
    
    public ReaderManagements() {	
        JLabel lblNewLabel = new JLabel(new ImageIcon("./src/library.jpg"));
        lblNewLabel.setBounds(50, 10, 450, 213);
        frame.getContentPane().add(lblNewLabel);
        }
	
     public void MmStart(){
        frame.setTitle("LIBRARY SYSTEM");
        frame.setSize(570, 340);
        frame.setLocation(570, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton bt1 = new JButton("LendReturnList");
        bt1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	BorrowReturnAll bor = new BorrowReturnAll();
                    frame.dispose();
                }        
        });
        bt1.setBounds(15, 232, 123, 49);
        frame.getContentPane().add(bt1);

        JButton bt2 = new JButton("Reader");
        bt2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {				
                	fileLoadBR();
                    frame.dispose();
                    Managements mg = new Managements(); }
        });
        bt2.setBounds(150, 232, 120, 49);
        frame.getContentPane().add(bt2);

        JButton bt3 = new JButton("Reader Search");
        bt3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        fileLoadR();
                        frame.dispose();
                        ReaderSearch rs = new ReaderSearch();}
        });
        bt3.setBounds(285, 232, 120, 49);
        frame.getContentPane().add(bt3);

        JButton bt4 = new JButton("Book Search");
        bt4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        fileLoadB();
                        frame.dispose();
                        BookSearch bs = new BookSearch(); }
        });
        bt4.setBounds(420, 232, 120, 49);
        frame.getContentPane().add(bt4);
		
}
     
//    public void fileLoadR(){				
//        String fileName="./src/ReaderList.txt";
//        String str;
//        StringTokenizer st = null;
//        try {
//            BufferedReader br = new  BufferedReader (new FileReader(fileName));
//            while((str = br.readLine())!= null){
//                BorrowReturn r= new BorrowReturn();
//                st = new StringTokenizer(str,",");
//                r.setId(st.nextToken());
//                r.setName(st.nextToken());
//                r.setEmail(st.nextToken());
//                r.setPhone(st.nextToken());
//                Rlist.add(r);	
//            }		
//        }catch(IOException e){
//            e.printStackTrace();	
//        }
//    }	
//       
  public void fileLoadB(){	
        ArrayList<Books> Blist = loadData();
        }
   public ArrayList loadData() {
        try {
           BufferedReader br = new BufferedReader(new FileReader("./src/MOCK_DATA.csv"));
           String line = br.readLine();
           String[] data;
           String bId;
           String authorF;
           String authorL;
           String title;
           String genre;	
           
       while (line != null) {     		 
            data = line.split(",");
            bId = data[0];
            authorF = data[1];
            authorL = data[2];
            title = data[3];
            genre = data[4];	           

           Blist.add(new Books(bId, authorF, authorL, title, genre));		
           line = br.readLine();
           }   
       } catch (IOException ex) {
           Logger.getLogger(ReaderManagements.class.getName()).log(Level.SEVERE, null, ex);
           }
       return Blist; 
       }   
   
   
   public void fileLoadR(){	
	 ArrayList<BorrowReturn> Rlist = loadData1(); 
	}
    public ArrayList loadData1() {
		try {	
		BufferedReader br = new BufferedReader(new FileReader("./src/ReaderList.txt"));
	    String line = br.readLine();
		
	    String[] data;
	      String id;
	      String name;
	      String email;
	      String phone;	
		
	while (line != null) { 		 
     	data = line.split(",");
     	id = data[0];
     	name = data[1];
     	email = data[2];
     	phone = data[3];
     	           
         
     Rlist.add(new Readers(id, name, email, phone));		
     line = br.readLine();
     Collections.sort(Rlist);
     }    System.out.println(Rlist); 
    	             
   } catch (IOException ex) {
 Logger.getLogger(ReaderManagements.class.getName()).log(Level.SEVERE, null, ex);
 }
  return Rlist; 
 }
	 
    public void fileLoadBR(){	
   	 ArrayList<BorrowReturn> BRlist = loadData2(); 
   	}
       public ArrayList loadData2() {
   		try {	
   		BufferedReader br = new BufferedReader(new FileReader("./src/BorrowReturnList.txt"));
   	    String line = br.readLine();
   		
   	     String[] data;
   	     String id;
   	     String name;
    	 String borrowB;
   	     String returnB;
   	     String borrowD; 
   	     String returnD;
   		
   	while (line != null) { 		 
        	data = line.split(",");
        	id = data[0];
        	name = data[1];        	
        	borrowB = data[2];
        	returnB = data[3];	
        	borrowD = data[4];
        	returnD = data[5];
            
        BRlist.add(new BorrowReturn(id, name, borrowB, returnB, borrowD, returnD));		
        line = br.readLine();
        System.out.println(line);
       }
   	             
      } catch (IOException ex) {
    Logger.getLogger(ReaderManagements.class.getName()).log(Level.SEVERE, null, ex);
    }
     return BRlist; 
    }
       
    
 public void fileSave() {			
    try {
    BufferedWriter f = new BufferedWriter(new FileWriter("./src/BorrowReturnList.txt",true));
            for(int i=0; i< BRlist.size(); i++){
                f.write(BRlist.get(i).getId());
                f.write(",");
                f.write(BRlist.get(i).getName());
                f.write(",");
                f.write(BRlist.get(i).getBorrowD());
                f.write(",");
                f.write(BRlist.get(i).getBorrowB());
                f.write(",");
                f.write(BRlist.get(i).getReturnD()); 
                f.write(",");
                f.write(BRlist.get(i).getReturnB());                               
                f.newLine();
            }f.close();         
} catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
       }
  }
 
 public void ReaderFileSave() {			
	    try {
	    BufferedWriter bf = new BufferedWriter(new FileWriter("./src/ReaderList.txt",true));
	            for(int i=0; i< Rlist.size(); i++){
	                bf.write(Rlist.get(i).getRid());
	                bf.write(",");
	                bf.write(Rlist.get(i).getName());
	                bf.write(",");
	                bf.write(Rlist.get(i).getEmail());
	                bf.write(",");
	                bf.write(Rlist.get(i).getPhone());	                              
	                bf.newLine();
	            }bf.close();         
	} catch (IOException e) {
	// TODO Auto-generated catch block
	            e.printStackTrace();
	       }
	  }
 }