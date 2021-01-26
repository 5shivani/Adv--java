import java.sql.*;

class prog7
{
       public static void main(String args[])
       {
                try
                  {
                          int no=Integer.parseInt(args[0]);
                          Class.forName("com.mysql.jdbc.Driver");
                          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                          String sql="select * from empinfo where empid=?";
                          PreparedStatement ps=conn.prepareStatement(sql);

                          ps.setInt(1,no);
                          ResultSet rs=ps.executeQuery();
                          if(rs.next())
                          {
                                   System.out.println("Record found,Details are");
                                   System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getDouble(5));
                          }
                          else
                                 System.out.println("Record with empid"+no+"not found");
                          rs.close();
                          ps.close();
                          conn.close();
                  }
                  catch(Exception e)
                   {
                           System.out.println(e.getMessage());
                   }
         }
 }