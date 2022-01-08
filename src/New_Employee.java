import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class New_Employee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    
    New_Employee(){
        super("New Employee");
        setBounds(450,20,550,370);
        getRootPane().setBorder(new EmptyBorder(5,5,5,5));
        getContentPane().setBackground(Color.WHITE);
       
        //setLayout(new GridLayout(8,2,10,40));
        
        JPanel p1= new JPanel();
        p1.setBackground(Color.WHITE);
        //setContentPane(p1);
        p1.setLayout(new GridLayout(8,2,10,20));
        
        l1 = new JLabel("                               Name");
        t1 = new JTextField(15);
        p1.add(l1);
        p1.add(t1);
        
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        l2 = new JLabel("                              Gender");
        p1.add(l2);
        p1.add(c1);
        
        l3 = new JLabel("                              Address");
        t3 = new JTextField(15);
        p1.add(l3);
        p1.add(t3);
        
        l4 = new JLabel("                              State");
        t4 = new JTextField(15);
        p1.add(l4);
        p1.add(t4);
        
        l5 = new JLabel("                              City");
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);
        
        l6 = new JLabel("                              Email");
        t6 = new JTextField(15);
        p1.add(l6);
        p1.add(t6);
        
        l7 = new JLabel("                              Phone");
        t7 = new JTextField(15);
        p1.add(l7);
        p1.add(t7);
        
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon("src/icons/new_employee.png")),"West");
        add(p1,"Center");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();
        if(ae.getSource()==b1){
            String qry = "insert into employee values(null,'"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"');";
        
            try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Employee Created");
                setVisible(false);
            }catch(Exception ee){
            System.out.print(ee);
            }
        }
        if(ae.getSource()==b2){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new New_Employee().setVisible(true);
    }
}
