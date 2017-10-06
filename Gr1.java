package p1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Gr1 extends JFrame{
Container c;
JButton btnGreeting;

Gr1()
{
c= getContentPane();
c.setLayout(new FlowLayout());
btnGreeting= new JButton("Greeting");
c.add(btnGreeting);
btnGreeting.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
JOptionPane.showMessageDialog(c, "Welcome to my First app");

}

 } );
}// end of construtor

public static void main(String args[]){
Gr1 g = new Gr1();
g.setSize(400,400);
g.setTitle("Frame developed by jyoti");
g.setLocationRelativeTo(null);
g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
g.setVisible(true);
}
}// end of class
