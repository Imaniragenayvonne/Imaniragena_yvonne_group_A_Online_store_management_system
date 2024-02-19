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
import MYALL.Store;


public class StoreForm implements ActionListener{
	JFrame frame;
	JLabel id_lb =new JLabel("id");
	JLabel Storename_lb=new JLabel("Storename");
	JLabel Storedescription_lb=new JLabel("Storedescription");
	JLabel Contactinformation_lb=new JLabel("Contactinformation");
	
	JTextField id_txf=new JTextField();
	JTextField Storename_txf=new JTextField();
	JTextField Storedescription_txf=new JTextField();
	JTextField Contactinformation_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton update_btn=new JButton("Update");
	JButton Delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int) screensize.getWidth();
	int H=(int) screensize.getHeight();
	
	
	public  StoreForm() {

		CreateForm();
		ActionEvent();
		SetLocation();
		SetFontforAll();
		AddComponentToFrame();
	}
	private void AddComponentToFrame() {
		frame.add(id_lb);
		frame.add(Storename_lb);
		frame.add(Storedescription_lb);
		frame.add(Contactinformation_lb);
	
		
		
		
		frame.add(id_txf);
		frame.add(Storename_txf);
		frame.add(Storedescription_txf);
		frame.add(Contactinformation_txf);
		
		
		
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(Delete_btn);
		
		frame.add(table);
	}
	private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		id_lb.setFont(font);
		Storename_lb.setFont(font);
		Storedescription_lb.setFont(font);
		Contactinformation_lb.setFont(font);
		
		
		
		id_txf.setFont(font);
		Storename_txf.setFont(font);
		Storedescription_txf.setFont(font);
		Contactinformation_txf.setFont(font);
		
		Font font2=new Font("Courier new",Font.ITALIC,12);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		Delete_btn.setFont(font);
		
	}
	private void SetLocation() {
		id_lb.setBounds(10,10,150,30);
		Storename_lb.setBounds(10,60,150,30);
		Storedescription_lb.setBounds(10,110,150,30);
		Contactinformation_lb.setBounds(10,160,150,30);
		
		
		id_txf.setBounds(230,10,90,30);
		Storename_txf.setBounds(230,60,90,30);
		Storedescription_txf.setBounds(230,110,90,30);
		Contactinformation_txf.setBounds(230,160,90,39);
		
		
		
		
		insert_btn.setBounds(50,290,90,30);
		Read_btn.setBounds(150,290,90,30);
		update_btn.setBounds(260,290,90,30);
		Delete_btn.setBounds(360,290,90,30);
		
        table.setBounds(10, 330, 480, 200);
	}
	
	private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("StoreForm");
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
		Store sf=new Store();
		if(e.getSource()==insert_btn) {
			sf.setStorename(Storename_txf.getText());
			sf.setStoredescription(Storedescription_txf.getText());
			sf.setContactInformation(Contactinformation_txf.getText());
			sf.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Store_id");
            model.addColumn("Storename");
            model.addColumn("Storedescription");
            model.addColumn("Contactinformation");
           
            ResultSet resultSet = Store.ReadData();
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
			sf.setStorename(Storename_txf.getText());
			sf.setStoredescription(Storedescription_txf.getText());
			sf.setContactInformation(Contactinformation_txf.getText());
			
			sf.update(id);
			}

	  else {
			int id=Integer.parseInt(id_txf.getText());
			sf.delete(id);
			}
		}

	  
		
	
	 public static void main(String[] args) {
			
		 StoreForm Pf= new StoreForm();
			System.out.println(Pf);
			
	 }}
	



	
	


		
		
		
	


   








