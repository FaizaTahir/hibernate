import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserManager {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      UserManager ME = new UserManager();

      /* Add fewUser records in database */
      Integer empID1 = ME.addUser("Mahjabeen", "mahjabeen", "maju.asif94@hotmail.com", "42000-5493968-8"," 03358089998");
     // Integer empID2 = ME.addUser("Daisy", "Das", 5000);
      //Integer empID3 = ME.addUser("John", "Paul", 10000);

      /* List down all theUsers */
      ME.ListUsers();

   }
   /* Method to CREATE anUser in the database */
   public Integer addUser(String username,String passsword,String email, String cnic_number,String contact_number){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer UserID = null;
      try{
         tx = session.beginTransaction();
        User User = new User(username, passsword, email, cnic_number, contact_number);
        UserID = (Integer) session.save(User); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return UserID;
   }
   /* Method to  READ all theUsers */
   public void ListUsers( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List Users = session.createQuery("FROM User").list(); 
         for (Iterator iterator = 
                          Users.iterator(); iterator.hasNext();){
           User User = (User) iterator.next(); 
           System.out.print("User Name: " +User.getusername()); 
            System.out.print("  Password: " +User.getpassword()); 
            System.out.println("  Email: " +User.getemail()); 
            System.out.println("  Cnic: " +User.getcnic_number()); 
            System.out.println("  Email: " +User.getcontact_number()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   
  
}
