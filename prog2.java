import java.sql.*;
class prog2
{
        public static void main(String args[])
       {
              try{
                        int no=Integer.parseInt(args[0]);
                       Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                         Statement stmt=conn.createStatement();
                         String sql="select * from empinfo where Empid= "+ no;
                         ResultSet rs=stmt.executeQuery(sql);
     
                           if(rs.next())
                           {
                                       System.out.println("Record found");
                                       System.out.println("Empid\t\tName\t\tSurname\t\tCity\t\tSalary");   
                                       System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getDouble(5));
                           }
                           else
                                          System.out.println("Record with empid "+no+" not found");
                           rs.close();
                           stmt.close();
                           conn.close();
                     }
                      catch(ClassNotFoundException e)
                      {
                                System.out.println(e.getMessage());
                       }
                       catch(SQLException e)
                        {
                                 System.out.println(e.getMessage());
                         }
                      catch(ArrayIndexOutOfBoundsException e)
                       {
                                    System.out.println("Pls enter the empid");
                        }
                        catch(NumberFormatException e)
                        {
                                 System.out.println("Pls enter empid in number format only");
                         }
             }
}