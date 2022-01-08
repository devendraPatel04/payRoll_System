import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class TakeAttendence extends JFrame implements ActionListener{
    Choice c1,fh,sh;
    JButton bs,bc;
    
    TakeAttendence(){
        super("Attendence JFrame");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                c1.add(rs.getString("id"));
            }
            rs.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel l1 = new JLabel("Select Employee ID");
        l1.setBounds(50,50,130,25);
        c1.setBounds(200,50,130,25);
        add(l1);
        add(c1);
        
        JLabel l2 = new JLabel("First Half");
        fh = new Choice();
        fh.add("Absent");
        fh.add("Present");
        fh.add("Leave");
        l2.setBounds(50,100,130,25);
        fh.setBounds(200,100,130,25);
        add(l2);
        add(fh);
        
        JLabel l3 = new JLabel("Second Half");
        sh = new Choice();
        sh.add("Absent");
        sh.add("Present");
        sh.add("Leave");
        l3.setBounds(50,150,130,25);
        sh.setBounds(200,150,130,25);
        add(l3);
        add(sh);
        
        bs = new JButton("Submit");
        bs.setForeground(Color.WHITE);
        bs.setBackground(Color.BLACK);
        bs.setBounds(50,200,100,25);
        add(bs);
        
        bc = new JButton("Cancel");
        bc.setBackground(Color.BLACK);
        bc.setForeground(Color.WHITE);
        bc.setBounds(200,200,100,25);
        add(bc);
        
        bc.addActionListener(this);
        bs.addActionListener(this);
        
        setBounds(400,20,400,300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bs){
            String f = fh.getSelectedItem();
            String s = sh.getSelectedItem();
            String dt = new java.util.Date().toString();
            String id = c1.getSelectedItem();
            
            String qry = "insert into attendence values('"+id+"','"+dt+"','"+f+"','"+s+"');";
            try{
                conn c = new conn();
                c.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Attendence Confirmed");
                this.setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(ae.getSource()==bc){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new TakeAttendence();
    }
}
