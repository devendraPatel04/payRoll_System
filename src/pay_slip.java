import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class pay_slip extends JFrame implements ActionListener{
    Choice c1;
    JTextArea t1;
    JButton b1;
    
    pay_slip(){
        super("Pay Slip");
        setBounds(400,20,800,600);
        setLayout(null);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c1.add(rs.getString("id"));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        JLabel l1 = new JLabel("Select ID");
        l1.setBounds(50,10,100,30);
        c1.setBounds(150,12,100,30);
        add(l1);
        add(c1);
        
        t1 = new JTextArea(30,80);
        JScrollPane jsp = new JScrollPane(t1);
        Font f = new Font("arial",Font.BOLD,20);
        t1.setFont(f);
        jsp.setBounds(10,50,765,470);
        
        b1 = new JButton("Generate Pay Slip");
        b1.addActionListener(this);
        b1.setBounds(150,524,500,30);
        b1.setBackground(new Color(242, 196, 157));
        b1.setForeground(Color.BLACK);
        add(b1);
        add(jsp);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee where id="+c1.getSelectedItem()+";");
            rs.next();
            String name = rs.getString("name");
            rs.close();
            
            rs = c.s.executeQuery("select * from salary where id="+c1.getSelectedItem()+";");
            double gross = 0;
            double net = 0;
            
            java.util.Date d1 = new java.util.Date();
            int month = d1.getMonth();
            int year = d1.getYear();
            t1.setText("---------------- Pay Slip For The Month Of "+month+"  "+year+"------------");
            t1.append("\n");
            
            if(rs.next()){
                t1.append("\n     Employee ID "+rs.getString("id"));
                t1.append("\n     Employee Name "+name);
 
                t1.append("\n----------------------------------------------------------------");
                t1.append("\n");

                double hra = rs.getDouble("hra");
                t1.append("\n                  HRA         : "+hra);
                double da  = rs.getDouble("da");
                t1.append("\n                  DA          : "+da);
                double med  = rs.getDouble("med");
                t1.append("\n                  MED         : "+med);
                double pf  = rs.getDouble("pf");
                t1.append("\n                  PF          : "+pf);
                double basic = rs.getDouble("basic_salary");
                gross = hra+da+med+pf+basic;
                net = gross - pf;
                t1.append("\n                  BASIC SALARY : "+basic);

                t1.append("\n--------------------------------------------------");
                t1.append("\n");
 
                t1.append("\n       GROSS SALARY :"+gross+"    \n       NET SALARY : "+net);
                t1.append("\n       Tax   :   2.1% of gross "+ (gross*2.1/100));   
                t1.append("\n ------------------------------------------------");
                t1.append("\n");
                t1.append("\n");    
                t1.append("\n");
                t1.append("   (  Signature  )      ");

            }
        }catch(Exception eee){
            eee.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new pay_slip();
    }
}
