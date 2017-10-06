import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class HomeFrame extends JFrame{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;
HomeFrame(){
super("Home");

c= getContentPane();
c.setLayout(new FlowLayout());
btnAdd= new JButton("Add");
btnView= new JButton("View");
btnUpdate= new JButton("Update");
btnDelete= new JButton("Delete");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);


setSize(500,150 );
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setLocationRelativeTo(null);
setVisible(true);

btnAdd.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
AddEmployee e = new AddEmployee();
dispose();
}


});

btnUpdate.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
UpdateEmployee e = new UpdateEmployee();
dispose();
}


});


btnView.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
ViewEmployee e = new ViewEmployee();
dispose();
}


});


btnDelete.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
DeleteEmployee e = new DeleteEmployee();
dispose();
}


});

}// end of constructor

public static void main(String args[]){
HomeFrame h=new HomeFrame();
}// end of main
}// end of class

class DatabaseHandler{
public static Connection con;
public static void getConn()
{
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Jyoti", "jyoti25");

}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(), "" +e);
}
}

public void addEmployee(int eid,String ename){

try{
getConn();
String s1="insert into emp1 values(?,?)";
PreparedStatement pst= con.prepareStatement(s1);
pst.setInt(1,eid);
pst.setString(2,ename);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(), r + "records inserted");

}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(), "" +e);
}
}
public String viewEmployee(){
StringBuffer sb= new StringBuffer();
try{
getConn();
String q= "select * from emp1 order by eid";
Statement st= con.createStatement();
ResultSet rs= st.executeQuery(q);
sb.append("ID: "+"\t"+"Name:" + "\n");
while(rs.next()){
sb.append(rs.getString(1)+"\t"+rs.getString(2)+"\n");
}//end of while loop
rs.close();

}//end of try
catch( Exception e){
JOptionPane.showMessageDialog(new JDialog(), "" +e);
}// end of catch
return sb.toString();
}


public void deleteEmployee(int eid){
try{
getConn();
String s1 ="delete from emp1 where eid=?";
PreparedStatement pst= con.prepareStatement(s1);
pst.setInt(1,eid);
int r= pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(), r+ "record deleted");


}
catch( Exception e){
JOptionPane.showMessageDialog(new JDialog(), "" +e);
}// end of catch


}




public void updateEmployee(int eid, String ename){
try{
getConn();
String s1 ="update emp1 set ename =? where eid=?";
PreparedStatement pst= con.prepareStatement(s1);
pst.setInt(2,eid);
pst.setString(1,ename);
int r= pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(), r+ "record updated");


}
catch( Exception e){
JOptionPane.showMessageDialog(new JDialog(), "" +e);
}// end of catch


}
}