import java.awt.*;
import javax.swing.*;

public class splash {
    public static void main(String args[]){
        sframe f = new sframe("PayRoll System");
        f.setVisible(true);
        int x=1,i;
        for(i=2;i<600;i=i+4,x+=1){
            f.setLocation(710-((i+x)/2),300-(i/2));
            f.setSize(i+x,i);
            
            try{
                Thread.sleep(10);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
class sframe extends JFrame implements Runnable{
    Thread t1;
    sframe(String s){
        super(s);
        setLayout(new FlowLayout());
        ImageIcon i1 = new ImageIcon("src/icon/payroll_system.jpg");
        Image i2 = i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel l1 = new JLabel(i3);
        add(l1);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(1000);
            this.setVisible(false);
            new login();
            dispose();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
