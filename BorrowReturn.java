package GUI;
        
import java.util.Date;

import GUI.ReaderManagements;

public class BorrowReturn {
    private String id;
    private String name;
    private String borrowD ; 
    private String borrowB;
    private String returnD;  
    private String returnB;         
       
	public BorrowReturn(String id, String name, String borrowD, String borrowB,String returnD, String returnB) {
		super();
		this.id = id;
		this.name = name;
		this.borrowD = borrowD;
		this.borrowB = borrowB;
		this.returnD = returnD;
		this.returnB = returnB;		
		
		}
		public String getId() {
	          return id;
          }
       public void setId(String id) {
            this.id = id;
            }
        public String getName() {
            return name;
            }
        public void setName(String name) {
            this.name = name;
            }
        public String getBorrowD() {
			return borrowD;
			}
        public void setBorrowD(String borrowD) {
        	this.borrowD = borrowD;   
		}	 
        public String getBorrowB() {
			return borrowB;
		}
        public void setBorrowB(String borrowD) {
		   this.borrowB = borrowB;   
			}	 
        public String getReturnD() {
        	return returnD;
		}
        public void setReturnD(String returnD) {
			this.returnD = returnD;
		}
        public String getReturnB() {
        	  return returnB;	       
			}          
		public void setReturnB(String returnB) {
				this.returnB = returnB;
			}
		
		@Override
		public String toString() {
			return "BorrowReturn [id=" + id + ", name=" + name + ", borrowD=" + borrowD + ", borrowB=" + borrowB
					+ ", returnD=" + returnD + ", returnB=" + returnB + "]";
		}
		}	

        

	