package GUI;
        
 import GUI.ReaderManagements;

public class Readers implements Comparable <Readers> {
    private String rid;    
    private String name;
    private String email;
    private String phone;    
    
        public Readers(String rid, String name, String email, String phone) {
		super();
		this.rid = rid;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
		public String getRid() {
                return rid;
            }
        public void setRid(String rid) {
                this.rid = rid;
            }     
        public String getName() {
            return name;
            }
        public void setName(String name) {
            this.name = name;
            }       
        public String getEmail() {
            return email;
            }
        public void setEmail(String email) {
            this.email = email;
             }
        public String getPhone() {
            return phone;
             }
         public void setPhone(String phone) {
            this.phone = phone;
             }
         
         @Override
         public int compareTo(Readers r) {
        	return this.getRid().compareTo(r.getRid());	
        	}
         
//       public int compareTo(Readers r) {
//     		return this.getName().compareTo(r.getName());	
//     		}
            
            @Override
            public String toString() {
    	return "Readers [Reader id=" + rid + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
            }         
}
	