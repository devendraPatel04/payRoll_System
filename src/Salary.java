import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class Salary extends JFrame implements ActionListener{
    JLabel l1,l3,l4,l5,l6;
    JTextField t1,t3,t4,t5,t6;
    JButton b1,b2;
    Choice c2;
    
    Salary(){
        super("Set Salary");
        setBounds(450,20,450,380);
        getContentPane().setBackground(Color.white);
        getRootPane().setBorder(new EmptyBorder(8,8,8,8));
        setLayout(new GridLayout(7,2,10,20));
        c2 = new Choice();
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            
            while(rs.next()){
                c2.add(rs.getString("id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add(new JLabel("   Selected Employee ID "));
        add(c2);
        
        l1 = new JLabel("          HRA");
        t1 = new JTextField(15);
        add(l1);
        add(t1);
        
        l3 = new JLabel("          DA");
        t3 = new JTextField(15);
        add(l3);
        add(t3);
        
        l4 = new JLabel("          MED");
        t4 = new JTextField(15);
        add(l4);
        add(t4); 
       
        l5 = new JLabel("          PF");
        t5 = new JTextField(15);
        add(l5);
        add(t5);
        
        l6 = new JLabel("          Basic Salary");
        t6 = new JTextField(15);
        add(l6);
        add(t6);
       
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        add(b1);
        add(b2);
       
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){    
            String hra = t1.getText();
            String id = c2.getSelectedItem();
            String da = t3.getText();
            String med = t4.getText();
            String pf = t5.getText();
            String basic = t6.getText();
        
            String qry = "insert into salary values('"+ id +","+hra+","+da+","+med+","+pf+","+basic+");";
    
            try{
                conn c = new conn();
                c.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Salary Updated");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==b2){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new Salary();
    }
}
