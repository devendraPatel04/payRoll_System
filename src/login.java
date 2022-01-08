import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    login(){
        super("Login Page");
        setLayout(new BorderLayout());
        t2 = new JPasswordField(10);
        t1 = new JTextField(10);
        JLabel l = new JLabel(new ImageIcon("src/icon/defaultpic.png"));
        
        b1 = new JButton("Submit",new ImageIcon("src/icon/login.png"));
        b2 = new JButton("Cancel",new ImageIcon("src/icon/Cancel.png"));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        JPanel p2,p3,p4;
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        
        add(l,BorderLayout.WEST);
        
        p2.add(new JLabel("User Name "));
        p2.add(t1);
        p2.add(new JLabel("Password   "));
        p2.add(t2);
        add(p2,BorderLayout.CENTER);
        
        p4.add(b1);
        p4.add(b2);
        
        p3.add(new JLabel("     "));
        
        add(p4,BorderLayout.SOUTH);
        add(p3,BorderLayout.NORTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,250);
        setLocation(450,50);	
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c1 = new conn();
                String u = t1.getText();
                String p = t2.getText();
            
                String q = "select * from login where username='"+u+"' and password='"+p+"';";
            
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new project().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username passeord");
                }
            
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    
    public static void main(String args[]){
        new login().setVisible(true);
    }
}
