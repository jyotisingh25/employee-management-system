import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteEmployee extends JFrame{

Container c;
JTextField txtId;
JLabel lblId;
JButton btnDelete;
JPanel p1,p2;



DeleteEmployee(){
super("delete  Employee");
c= getContentPane();
p1= new JPanel();
p1.setLayout(new FlowLayout());
lblId= new JLabel("Id: ");
txtId= new JTextField(4);
p1.add(lblId);
p1.add(txtId);
c.add(p1);
p2= new JPanel();
//setLayout(new FlowLayout());
btnDelete = new JButton("Delete");
p2.add(btnDelete);
c.add("South",p2);

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

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
int id=Integer.parseInt(txtId.getText());
DatabaseHandler db= new DatabaseHandler();
db.deleteEmployee(id);
txtId.setText("");

}


});




}


}