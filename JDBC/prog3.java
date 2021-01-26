import  java.sql.*;
class prog3
{
      public static void main(String args[])
      {
                try
                    {
                            String cname=args[0];
                             Class.forName("com.mysql.jdbc.Driver");
                               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                                Statement  stmt=conn.createStatement();
                                String sql="select * from  empinfo where City= ' " + cname +" ' ";
                                ResultSet rs=stmt.executeQuery(sql);
                                int count=0;
                                boolean flag=false;
                                
                                 while(rs.next())
                                 {
                                         if(!flag)
                                          {
                                                 System.out.println("Empid\tName\tsurname\tCity\tSalary");
                                                 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5));
                                                  count++;
                                                   flag=true;
                                             }
                                  }
                                  if(!flag)
                                         System.out.println("Record with cityname "+cname+" not found");
                                   else
                                           System.out.println("No records for city"+cname+"are"+count);

                                     rs.close();
                                      stmt.close();
                                      conn.close();
                           }
                            catch(SQLException e)
                             {
                                          System.out.println(e.getMessage());
                               }
                               catch(ArrayIndexOutOfBoundsException e)
                               {
                                           System.out.println("please enter city name");
                                 }
                                catch(ClassNotFoundException e)
                                 {
                                            System.out.println(e.getMessage());
                                  }
                    }
}         