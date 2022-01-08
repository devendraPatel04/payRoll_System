import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class List_Employee extends JFrame implements ActionListener{
    JTable j1;
    JButton b1;
    String h[] = {"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
    String d[][] = new String[20][8];
    int i=0,j=0;
    
    List_Employee(){
        super("View Employee");
        setBounds(100,20,1000,400);
        
        try{
            String q = "select * from employee";
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery(q);
            
            while(rs.next()){
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("name");
                d[i][j++]=rs.getString("gender");
                d[i][j++]=rs.getString("address");
                d[i][j++]=rs.getString("state");
                d[i][j++]=rs.getString("city");
                d[i][j++]=rs.getString("email");
                d[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            j1 = new JTable(d,h);
            
        }catch(Exception ee){
            System.out.println(ee);
        }
        
        b1 = new JButton("Print");
        b1.setBounds(870,330,100,25);
        add(b1);
        
        JScrollPane s1 = new JScrollPane(j1);
        s1.setBounds(20,20,850,280);
        add(s1);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new List_Employee();
    }
}
