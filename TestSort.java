package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//	public class TestSort {
//	
//	public static void main(String[] args) {
//		new TestSort();		
//	}
//	
//	public TestSort() {
//			 ArrayList<Books> Blist = new ArrayList<>();
//	     try {
//	           BufferedReader br = new BufferedReader(new FileReader("./src/MOCK_DATA.csv"));
//	           String line = br.readLine();
//		 
//	           String[] data;
//	           String bId;
//	           String authorF;
//	           String authorL;
//	           String title;
//	           String genre;	
//	           
//	           while (line != null) {
//	      		 
//	           	data = line.split(",");
//	           	bId = data[0];
//	           	authorF = data[1];
//	           	authorL = data[2];
//	           	title = data[3];
//	           	genre = data[4];	           
//	               
//	               Blist.add(new Books(bId, authorF, authorL, title, genre));		
//	               line = br.readLine();
//	               
//	               Collections.sort(Blist);
//	           }    System.out.println(Blist);                
//	           
//	                 } catch (IOException ex) {
//	               Logger.getLogger(ReaderManagements.class.getName()).log(Level.SEVERE, null, ex);
//	           }
//		     	  }   		 
//	}
		
	
	
//		 String file = "./src/MOCK_DATA.csv";
//		 BufferedReader reader = null;
//		 String line= "";
//		 ArrayList<Books> Blist = new ArrayList<Books>();
//			
//			try {
//				reader = new BufferedReader(new FileReader(file));
//				while ((line= reader.readLine())!=null) {
//					String [] row = line.split(",");
//				
//					List list = new ArrayList(Arrays.asList(Blist));
//						Collections.sort(list) ;
//							for(String index:row) {
//								System.out.println(list);	
//						}
//					}					
//				}catch (IOException e) {
//				e.printStackTrace();
//			    }
//			finally {
//			try {
//				reader.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			}
//	}
	
	
				
//	public void TestSort() {  bubble sort
//		
//		ArrayList<Books> Blist = new ArrayList<Books>(); 
//		int n = Blist.size();		
//		
//		for(int i=0; i<n;i++) {
//			for(int j=0; j<n-i;j++) {
//				if (Blist.get(j).getbId().compareTo(Blist.get(j+1).getbId())<0) {
//					
//					Books temp = Blist.get(j);
//					Blist.set(j, Blist.get(j+1));
//					Blist.set(j+1, temp);
//				}
//			}					
//		}
//		for (int i = 0; i < Blist.size(); i++) {
//			System.out.println(Blist);
//		}
//	}
//	}

//public TestSort() {
//	public static  ArrayList<Books> Blist = new ArrayList<Books>();
//	 
//	public ArrayList<Books> sortByID(String[] data ) {
//	 
//	 int n=Blist.size();
//	 String bId = Blist.get(n).getbId();
//	 char[] data1 = bId.toCharArray();
//     char temp;
//		
//	  for(int i =0; i < data1.length; i++){
//		  for(int j = 0; j < data1.length - 1; j++) {
//			  if(data1[j] > data1[j + 1]) {
//				
//				  temp = data1[j];
//				   data1[j] = data1[j +1];
//				   data1[j +1] = temp;
//					
//				}	
//		  
//	  }
//		  System.out.println(new String(bId));
//		  
//	 }	 
//	 } 
//}

	

	
//	 public int linearSearch(ArrayList<Books> array, String targetName){
//	        
//	        // Going one by one the elements in the array
//	        for(int i = 0; i < array.size(); i++){
//	            System.out.println("Testing: " + array.get(i).getbId());
//	            // When the element is found, stop the loop and return the index
//	            if(array.get(i).getbId().equals(targetName)){
//	                return i;
//	            }            
//	        }
//	        return -1;
//	    }
//	    
//	}
	
//	String pattern = "dd-MM-yyyy";
//	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//	String date = simpleDateFormat.format(new Date());
//	System.out.println(date);
		 
		 
   