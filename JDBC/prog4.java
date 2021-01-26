import java.sql.*;
import java.util.Scanner;

class prog4
{
        public static void main(String args[])
        {
               Scanner sc=new Scanner(System.in);
               System.out.println("Enter empid= ");
               int empid=sc.nextInt();
                System.out.println("Enter name= ");
                String name=sc.next();
               System.out.println("Enter surname= ");
                String surname=sc.next();
                System.out.println("Enter city= ");
                String city=sc.next();
                System.out.println("Enter salary= ");
                double sal=sc.nextDouble();

                try
                 {
                        Class.forName("com.mysql.jdbc.Driver");
                         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                         Statement stmt=conn.createStatement();
                         String sql="insert into empinfo values(" + empid + " ,' " + name + " ' ,' " + surname + " ' ,' " + city + " ', " + sal + " ) ";
                     
                        int count=stmt.executeUpdate(sql);
                        System.out.println("Record added successfully");
                        stmt.close();
                         conn.close();
                     }
                       catch(Exception e)
                     {
                           System.out.println(e.getMessage());
                      }
            }
 }
