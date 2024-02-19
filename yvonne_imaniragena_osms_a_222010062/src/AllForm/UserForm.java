package AllForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MYALL.Store;
import MYALL.Users;

public class UserForm implements ActionListener{
	JFrame frame;
	JLabel id_lb =new JLabel("id");
	JLabel Username_lb=new JLabel("Username");
	JLabel Password_lb=new JLabel("Password");
	JLabel Email_lb=new JLabel("Email");
	JLabel Phonenumber_lb=new JLabel("Phonenumber");
	
	JTextField id_txf=new JTextField();
	JTextField Username_txf=new JTextField();
	JTextField Password_txf=new JTextField();
	JTextField Email_txf=new JTextField();
	JTextField Phonenumber_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton update_btn=new JButton("Update");
	JButton Delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int) screensize.getWidth();
	int H=(int) screensize.getHeight();
	
	
	public  UserForm() {

		CreateForm();
		ActionEvent();
		SetLocation();
		SetFontforAll();
		AddComponentToFrame();
	}
	private void AddComponentToFrame() {
		frame.add(id_lb);
		frame.add(Username_lb);
		frame.add(Password_lb);
		frame.add(Email_lb);
		frame.add(Phonenumber_lb);
		
		
		
		frame.add(id_txf);
		frame.add(Username_txf);
		frame.add(Password_txf);
		frame.add(Email_txf);
		frame.add(Phonenumber_txf);
		
		
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(Delete_btn);
		
		frame.add(table);
	}
	private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		id_lb.setFont(font);
		Username_lb.setFont(font);
		Password_lb.setFont(font);
		Email_lb.setFont(font);
		Phonenumber_lb.setFont(font);
		
		
		
		id_txf.setFont(font);
		Username_txf.setFont(font);
		Password_lb.setFont(font);
		Email_txf.setFont(font);
		Phonenumber_txf.setFont(font);
		
		Font font2=new Font("Courier new",Font.ITALIC,12);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		Delete_btn.setFont(font);
		
	}
	private void SetLocation() {
		id_lb.setBounds(10,10,150,30);
		Username_lb.setBounds(10,60,150,30);
		Password_lb.setBounds(10,110,150,30);
		Email_lb.setBounds(10,160,150,30);
		Phonenumber_lb.setBounds(10,210,150,30);
		
		id_txf.setBounds(230,10,90,30);
		Username_txf.setBounds(230,60,90,30);
		Password_txf.setBounds(230,110,90,30);
		Email_txf.setBounds(230,160,90,39);
		Phonenumber_txf.setBounds(230,210,90,30);
		
		
		
		
		insert_btn.setBounds(50,290,90,30);
		Read_btn.setBounds(150,290,90,30);
		update_btn.setBounds(260,290,90,30);
		Delete_btn.setBounds(360,290,90,30);
		
		 table.setBounds(10, 330, 480, 200);
	}
	
	private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("UserForm");
		frame.setBounds(0,0,W/2,H/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.pink);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		Delete_btn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Users Uf=new Users();
		if(e.getSource()==insert_btn) {
			Uf.setUserName(Username_txf.getText());
			Uf.setPassword(Password_txf.getText());
			Uf.setEmail(Email_txf.getText());
			Uf.setPhonenumber(Phonenumber_txf.getText());
			Uf.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Users_id");
            model.addColumn("Username");
            model.addColumn("Password");
            model.addColumn("Email");
            model.addColumn("Phonenumber");
           
            ResultSet resultSet = Users.ReadData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }}
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(id_txf.getText());
			Uf.setUserName(Username_txf.getText());
			Uf.setPassword(Password_txf.getText());
			Uf.setEmail(Email_txf.getText());
			Uf.setPhonenumber(Phonenumber_txf.getText());
			
			Uf.update(id);
	    }
	  else {
			int id=Integer.parseInt(id_txf.getText());
			Uf.delete(id);}}

	  
		
	
	 public static void main(String[] args) {
			
		 UserForm Uf= new UserForm();
			System.out.println(Uf);
			
	 }}
	
	

   





