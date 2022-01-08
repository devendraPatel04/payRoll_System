import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Update_Salary extends JFrame implements ActionListener,ItemListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Choice c2;
    
    Update_Salary(){
        super("Update Salary ");
        setLayout(null);
        setBounds(450,20,400,380);
        c2 = new Choice();
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary;");
            while(rs.next()){
                c2.add(rs.getString("id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel emp = new JLabel("Select Employee ID ");
        emp.setBounds(20,20,130,20);
        add(emp);
        
        c2.setBounds(150,20,200,20);
        add(c2);
        
        l1 = new JLabel("Hra");
        t1 = new JTextField(15);
        l1.setBounds(50,60,100,20);
        t1.setBounds(150,60,200,20);
        add(l1);
        add(t1);
       
        l2 = new JLabel("Da");
        t2 = new JTextField(15);
        l2.setBounds(50,100,100,20);
        t2.setBounds(150,100,200,20);
        add(l2);
        add(t2);
       
        l3 = new JLabel("Med");
        t3 = new JTextField(15);
        l3.setBounds(50,140,100,20);
        t3.setBounds(150,140,200,20);
        add(l3);
        add(t3);
       
        l4 = new JLabel("Pf");
        t4 = new JTextField(15);
        l4.setBounds(50,180,100,20);
        t4.setBounds(150,180,200,20);
        add(l4);
        add(t4); 
       
        l5 = new JLabel("basic_salary");
        t5 = new JTextField(15); 
        l5.setBounds(50,220,100,20);
        t5.setBounds(150,220,200,20);
        add(l5);
        add(t5);
       
        b1 =new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.setBounds(40,280,100,20);
        b2.setBounds(200,280,100,20);
        add(b1);
        add(b2);
       
        b1.addActionListener(this);
        b2.addActionListener(this);
        c2.addItemListener(this);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String hra = t1.getText();
            String id = c2.getSelectedItem();
            String da = t2.getText();
            String med = t3.getText();
            String pf = t4.getText();
            String basic = t5.getText();
            
            String qry = "update salary set hra="+hra+",da="+da+",med="+med+",pf="+pf+",basic_salary="+basic+"  where id="+c2.getSelectedItem()+";";
            
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
            try{
                conn c = new conn();
                c.s.executeUpdate("delete from salary where id="+c2.getSelectedItem()+";");
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
                this.setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie){
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary where id="+c2.getSelectedItem()+";");
            if(rs.next()){
                t1.setText(rs.getString("hra"));
                t2.setText(rs.getString("da"));
                t3.setText(rs.getString("med"));
                t4.setText(rs.getString("pf"));
                t5.setText(rs.getString("basic_salary"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new Update_Salary();
    }
}
