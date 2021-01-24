import java.sql.*;

class prog1
{
         public static void main(String args[])
        {
                  try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                            Statement stmt=conn.createStatement();
                            String sql="select * from empinfo"; 
                            ResultSet rs=stmt.executeQuery(sql);
                            System.out.println("Empid\tName\tSurname\tCity\tSalary");
                           while(rs.next())
                            {
                                    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString("City")+"\t"+rs.getDouble("Salary"));
                             }
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
         }
}
                                      