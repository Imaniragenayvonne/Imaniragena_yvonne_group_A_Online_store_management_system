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

import MYALL.Orders;
import MYALL.Users;

public class OrdersForm implements ActionListener{
	JFrame frame;
	JLabel Order_id_lb =new JLabel("Order_id");
	JLabel User_id_lb =new JLabel("User_id");
	JLabel OrderDate_lb=new JLabel("OrderDate");
	JLabel OrderStatus_lb=new JLabel("OrderStatus");
	JLabel OrderProduct_lb=new JLabel("OrderProduct");
	JLabel TotolPrice_lb=new JLabel("TotalPrice");
	JLabel PaymentMethod_lb=new JLabel("PaymentMethod");
	
	
	JTextField Order_id_txf=new JTextField();
	JTextField User_id_txf=new JTextField();
	JTextField Orderdate_txf=new JTextField();
	JTextField OrderStatus_txf=new JTextField();
	JTextField OrderProduct_txf=new JTextField();
	JTextField TotalPrice_txf=new JTextField();
	JTextField PaymentMethod_txf=new JTextField();
	
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton update_btn=new JButton("Update");
	JButton Delete_btn=new JButton("Delete");
	
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int) screensize.getWidth();
	int H=(int) screensize.getHeight();
	
	
	public  OrdersForm() {

		CreateForm();
		ActionEvent();
		SetLocationandSize();
		SetFontforAll();
		AddComponentToFrame();
	}
	private void AddComponentToFrame() {
		frame.add(Order_id_lb);
		frame.add(User_id_lb);
		frame.add(OrderDate_lb);
		frame.add(OrderStatus_lb);
		frame.add(OrderProduct_lb);
		frame.add(TotolPrice_lb);
		frame.add(PaymentMethod_lb);
		
		
		
		
		frame.add(Order_id_txf);
		frame.add(User_id_txf);
		frame.add(Orderdate_txf);
		frame.add(OrderStatus_txf);
		frame.add(OrderProduct_txf);
		frame.add(TotalPrice_txf);
		frame.add(PaymentMethod_txf);
		
		
		
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(Delete_btn);
		
		frame.add(table);
	}
	private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		Order_id_lb.setFont(font);
		User_id_lb.setFont(font);
		OrderDate_lb.setFont(font);
		OrderStatus_lb.setFont(font);
		OrderProduct_lb.setFont(font);
		TotolPrice_lb.setFont(font);
		PaymentMethod_lb.setFont(font);
		
		
		
		Order_id_txf.setFont(font);
		User_id_txf.setFont(font);
		Orderdate_txf.setFont(font);
		OrderStatus_lb.setFont(font);
		OrderProduct_txf.setFont(font);
		TotalPrice_txf.setFont(font);
		PaymentMethod_txf.setFont(font);


		
		Font font2=new Font("Courier new",Font.ITALIC,12);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		Delete_btn.setFont(font);
		
	}
	private void SetLocationandSize() {
		Order_id_lb.setBounds(10,10,150,30);
		User_id_lb.setBounds(10,60,150,30);
		OrderDate_lb.setBounds(10,110,150,30);
		OrderStatus_lb.setBounds(10,160,150,30);
		OrderProduct_lb.setBounds(10,210,150,30);
		TotolPrice_lb.setBounds(10,260,150,30);
		PaymentMethod_lb.setBounds(10,310,150,30);
		
		Order_id_txf.setBounds(230,10,90,30);
		User_id_txf.setBounds(230,60,90,30);
		Orderdate_txf.setBounds(230,110,90,30);
		OrderStatus_txf.setBounds(230,160,90,39);
		OrderProduct_txf.setBounds(230,210,90,30);
		TotalPrice_txf.setBounds(230,260,90,30);
		PaymentMethod_txf.setBounds(230,310,90,30);
		
	
		insert_btn.setBounds(10,350,120,30);
		Read_btn.setBounds(140,350,120,30);
		update_btn.setBounds(270,350,120,30);
		Delete_btn.setBounds(400,350,120,30);
		
		 table.setBounds(600, 10, 500, 240);
	}
	
	private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("OrdersForm");
		frame.setBounds(0,0,600,600);
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
		Orders Of=new Orders();
		if(e.getSource()==insert_btn) {
			Of.setUsers_id(User_id_txf.getText());
			Of.setOrderDate(Orderdate_txf.getText());
			Of.setOrderStatus(OrderStatus_txf.getText());
			Of.setOrderProduct(OrderProduct_txf.getText());
			Of.setTotalprice(TotalPrice_txf.getText());
			Of.setPaymentmethod(PaymentMethod_txf.getText());
			Of.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Order_id");
            model.addColumn("User_id");
            model.addColumn("Orderdate");
            model.addColumn("OrderStatus");
            model.addColumn("OrderProduct");
            model.addColumn("TotalPrice");
            model.addColumn("PaymentMethod");

            ResultSet resultSet = Orders.ReadData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                                resultSet.getString(6) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }}

	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(Order_id_txf.getText());
			Of.setUsers_id(User_id_txf.getText());
			Of.setOrderDate(Orderdate_txf.getText());
			Of.setOrderStatus(OrderStatus_txf.getText());
			Of.setOrderProduct(OrderProduct_txf.getText());
			Of.setTotalprice(TotalPrice_txf.getText());
			Of.setPaymentmethod(PaymentMethod_txf.getText());
			
			Of.update(id);
	    }
	  else {
			int id=Integer.parseInt(Order_id_txf.getText());
			Of.delete(id);}
		}

	  
		
	
	public static void main(String[] args) {
	 OrdersForm of=new OrdersForm();
	}
	

}



