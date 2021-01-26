import java.sql.*;
import java.util.Scanner;

class prog5
{
         public static void main(String args[])
         {
                 Scanner sc=new Scanner(System.in);
                 System.out.println("Enter city name to delete");
                 String cname=sc.next();

                  try
                 {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                        Statement stmt=conn.createStatement();
                        String sql="delete from empinfo where city='" + cname+"'";
                         int count=stmt.executeUpdate(sql);
                         
                        if(count==0)
                                 System.out.println("No record found for city "+cname);
                         else
                                   System.out.println("Number of records deleted are "+count);
                 
                         stmt.close();
                          conn.close();
                       }
                     
                      catch(Exception e)
                      {
                                 System.out.println(e.getMessage());
                       }
           }
}  