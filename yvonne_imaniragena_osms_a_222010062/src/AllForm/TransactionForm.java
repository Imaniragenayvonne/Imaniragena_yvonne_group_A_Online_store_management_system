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
import MYALL.Transaction;

public class TransactionForm implements ActionListener {
	JFrame frame;
	JLabel transaction_id_lb =new JLabel("Transaction_id");
	JLabel Orders_id_lb=new JLabel("Orders_id");
	JLabel PaymentAmount_lb=new JLabel("PaymentAmount");
	JLabel PaymentDate_lb=new JLabel("PaymentDate");
	JLabel PaymentStatus_lb=new JLabel("PaymentStatus");
	
	JTextField Transaction_id_txf=new JTextField();
	JTextField Orders_id_txf=new JTextField();
	JTextField PaymentAmount_txf=new JTextField();
	JTextField PaymentDate_txf=new JTextField();
	JTextField PaymentStatus_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton update_btn=new JButton("Update");
	JButton Delete_btn=new JButton("Delete");
	
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int) screensize.getWidth();
	int H=(int) screensize.getHeight();
	
	
	public  TransactionForm() {

		CreateForm();
		ActionEvent();
		SetLocation();
		SetFontforAll();
		AddComponentToFrame();
	}
	private void AddComponentToFrame() {
		frame.add(transaction_id_lb);
		frame.add(Orders_id_lb);
		frame.add(PaymentAmount_lb);
		frame.add(PaymentDate_lb);
		frame.add(PaymentStatus_lb);
		
		
		
		frame.add(Transaction_id_txf);
		frame.add(Orders_id_txf);
		frame.add(PaymentAmount_txf);
		frame.add(PaymentDate_txf);
		frame.add(PaymentStatus_txf);
		
		
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(Delete_btn);
		
		frame.add(table);
	}
	private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		transaction_id_lb.setFont(font);
		Orders_id_lb.setFont(font);
		PaymentAmount_lb.setFont(font);
		PaymentDate_lb.setFont(font);
		PaymentStatus_lb.setFont(font);
		
		
		
		Transaction_id_txf.setFont(font);
		Orders_id_txf.setFont(font);
		PaymentAmount_txf.setFont(font);
		PaymentDate_lb.setFont(font);
		PaymentStatus_txf.setFont(font);
		
		Font font2=new Font("Courier new",Font.ITALIC,12);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		Delete_btn.setFont(font);
		
	}
	private void SetLocation() {
		transaction_id_lb.setBounds(10,10,150,30);
		Orders_id_lb.setBounds(10,60,150,30);
		PaymentAmount_lb.setBounds(10,110,150,30);
		PaymentDate_lb.setBounds(10,160,150,30);
		PaymentStatus_lb.setBounds(10,260,150,30);
		
		Transaction_id_txf.setBounds(230,10,90,30);
		Orders_id_txf.setBounds(230,60,90,30);
		PaymentAmount_txf.setBounds(230,110,90,30);
		PaymentDate_txf.setBounds(230,160,90,39);
		PaymentStatus_txf.setBounds(230,260,90,30);
		
		
		
		
		insert_btn.setBounds(10,350,90,30);
		Read_btn.setBounds(140,350,90,30);
		update_btn.setBounds(270,350,90,30);
		Delete_btn.setBounds(400,350,90,30);
		
        table.setBounds(600, 10, 500, 240);


	}
	
	private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("TransactionForm");
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
		Transaction Tf=new Transaction ();
		if(e.getSource()==insert_btn) {
			Tf.setOrders_id(Orders_id_txf.getText());
			Tf.setPaymentAmount(PaymentAmount_txf.getText());
			Tf.setPaymentDate(PaymentDate_txf.getText());
			Tf.setPaymentStatus(PaymentStatus_txf.getText());
			
			Tf.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Transaction_id");
            model.addColumn("Orders_id");
            model.addColumn("PaymentAmount");
            model.addColumn("PaymentDate");
            model.addColumn("PaymentStatus");
           

            ResultSet resultSet = Transaction.ReadData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }}
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(Transaction_id_txf.getText());
			Tf.setOrders_id(Orders_id_txf.getText());
			Tf.setPaymentAmount(PaymentAmount_txf.getText());
			Tf.setPaymentDate(PaymentDate_txf.getText());
			Tf.setPaymentStatus(PaymentStatus_txf.getText());
			
			
			Tf.update(id);
	    }
	  else {
			int id=Integer.parseInt(Transaction_id_txf.getText());
			Tf.delete(id);}
		}

	  
		
	


	public static void main(String[] args) {
	 TransactionForm Trf=new TransactionForm();
	}
	
}
   


