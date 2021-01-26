import java.sql.*;
import java.util.Scanner;

class prog6
{
         public static void main(String args[])
         {
                 Scanner sc=new Scanner(System.in);
                 System.out.println("Enter the old city name ");
                 String old_cname=sc.next();
                 System.out.println("Enter the new city name ");
                 String new_cname=sc.next();
                  try
                 {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                        Statement stmt=conn.createStatement();
                        String sql="update empinfo set city='" + new_cname+"' where city= '"+old_cname+"'";
                         int count=stmt.executeUpdate(sql);
                         
                        if(count==0)
                                 System.out.println("No record found for city "+old_cname);
                         else
                                   System.out.println("Number of records updated  are "+count);
                 
                         stmt.close();
                          conn.close();
                       }
                     
                      catch(Exception e)
                      {
                                 System.out.println(e.getMessage());
                       }
           }
}  