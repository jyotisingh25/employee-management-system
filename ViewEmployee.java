import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewEmployee extends JFrame{

Container c;
JTextArea txtEmployee;
JScrollPane spEmployee;

ViewEmployee(){
super("View Employee");
c= getContentPane();

txtEmployee= new JTextArea(10,10);
txtEmployee.setEditable(false);

spEmployee= new JScrollPane(txtEmployee);
spEmployee.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
spEmployee.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

c.add(spEmployee);

setSize(500,150 );
setResizable(false);
setLocationRelativeTo(null);
setVisible(true);

this.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
HomeFrame h = new HomeFrame();
dispose();
}
});

DatabaseHandler db= new DatabaseHandler();
String data= db.viewEmployee();
txtEmployee.setText(data);


}


}