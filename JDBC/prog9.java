import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class prog9 extends Frame implements ActionListener
{
        Label l1,l2,lblinfo;
         Button btnlogin,btncancel;
         TextField txtun,txtpwd;
          
         public static void main(String args[])
        {
                new prog9();
        }
        public prog9()
       {
             setTitle("Login screen");
             setFont(new Font("Arial",Font.BOLD,20));
             setBounds(250,125,500,500);
             setLayout(null);
             
             l1=new Label("Username");
             l2=new Label("Password");
             lblinfo=new Label(" ");
       
            txtun=new TextField();
            txtpwd=new TextField();
            txtpwd.setEchoChar('*');
            
            btnlogin=new Button("Login");
            btncancel=new Button("Cancel");
             
            l1.setBounds(50,50,120,30);
             l2.setBounds(50,120,120,30);
             txtun.setBounds(190,50,120,30);
             txtpwd.setBounds(190,120,120,30);

            btnlogin.setBounds(50,170,90,30);
            btncancel.setBounds(160,170,90,30);
            lblinfo.setBounds(50,250,250,30);

            add(l1);
             add(l2);
             add(lblinfo);
             add(txtun);
             add(txtpwd);
             add(btnlogin);
             add(btncancel);
        
              btnlogin.addActionListener(this);
               btncancel.addActionListener(this);
                  
               setVisible(true);
       }
          
     public void actionPerformed(ActionEvent ae)
    {
               if(ae.getSource()==btncancel)
                     System.exit(0);
               else
                 {
                        try
                        {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shivani_info","root","Admin@123");
                                String sql="select * from users where username=? & password=?";
                                PreparedStatement ps=conn.prepareStatement(sql);
                          
                                ps.setString(1,txtun.getText());
                                ps.setString(2,txtpwd.getText());
                                ResultSet rs=ps.executeQuery();
                                if(rs.next())
                                      lblinfo.setText("Login successful");
                                 else
                                       lblinfo.setText("login Unsuccessful");

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
  }
 

 