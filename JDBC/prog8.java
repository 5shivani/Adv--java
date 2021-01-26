import java.sql.*;
import java.util.Scanner;

class prog8
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
             
                         String sql="insert into empinfo values(?,?,?,?,?)";
                         
                        PreparedStatement ps=conn.prepareStatement(sql);
                        ps.setInt(1,empid);
                        ps.setString(2,name);
                        ps.setString(3,surname);
                        ps.setString(4,city);
                        ps.setDouble(5,sal);

                        ps.executeUpdate();
                        System.out.println("Record inserted successfully");
                         ps.close();
                         conn.close();
                     }
                       catch(Exception e)
                     {
                           System.out.println(e.getMessage());
                      }
            }
 }
