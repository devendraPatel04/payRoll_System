import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class List_Attendence extends JFrame implements ActionListener{
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Date Time","First Half","Second Half"};
    String d[][]=new String[15][4];  
    int i=0,j=0;
    
    List_Attendence(){
        super("Employee Attendence List ");
        setLayout(null);
        setBounds(400,20,800,600);
        try{
            String q = "select * from attendence ;";
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("date_tm");
                d[i][j++]=rs.getString("f_half");
                d[i][j++]=rs.getString("s_half");
                i++;
                j=0;
            }
            j1 = new JTable(d,h);
        }catch(Exception ee){
            ee.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(j1);
        sp.setBounds(10,10,750,500);
        add(sp);
        
        b1 = new JButton("Print");
        b1.setBounds(50,530,150,20);
        add(b1);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            j1.print();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String arsp[]){
        new List_Attendence();
    }
}
