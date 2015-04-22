
public class User {
   private int id;
   private String username; 
   private String password; 
   private String email; 
   private String cnic_number; 
   private String contact_number; 
 

   public User() {}
   public User(String username,String passsword,String email, String cnic_number,String contact_number) {
      this.username = username;
      this.password = password;
      this.email = email;
      this.cnic_number = cnic_number;
      this.contact_number = contact_number;
   }
   public int getId() {
      return id;
   }
   public void setId( int id ) {
      this.id = id;
   }
   public String getusername() {
      return username;
   }
   public void setusername( String first_name ) {
      this.username = first_name;
   }
   public String getpassword() {
      return password;
   }
   public void setpassword( String password ) {
      this.password = password;
   }
   public String getemail() {
      return email;
   }
   public void setemail( String email ) {
      this.email = email;
   }
   public String getcnic_number() {
	      return cnic_number;
   }
	   public void setcnic_number( String cnic_number ) {
	      this.cnic_number = cnic_number;
	      }
	   public String getcontact_number() {
		      return contact_number;
 }
		   public void setcontact_number( String contact_number ) {
		      this.contact_number = contact_number;
	}
		  
}
