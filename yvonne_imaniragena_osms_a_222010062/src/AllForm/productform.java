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

import MYALL.product;

public class productform  implements ActionListener{
	JFrame frame;
	JLabel id_lb=new JLabel("id");
	JLabel Name_lb=new JLabel("Name");
	JLabel Description_lb=new JLabel("Description");
	JLabel Price_lb=new JLabel("Price");
	JLabel StockQuantity_lb=new JLabel("stockQuantity");
	JLabel ProductImage_lb=new JLabel("ProductImage");
	JLabel SuppierInformation_lb= new JLabel("suppierInformation");
	
	JTextField id_txf=new JTextField();
	JTextField Name_txf=new JTextField();
	JTextField Description_txf=new JTextField();
	JTextField Price_txf=new JTextField();
	JTextField StockQuantity_txf=new JTextField();
	JTextField ProductImage_txf=new JTextField();
	JTextField SuppierInformation_txf= new JTextField();
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("Read");
	JButton update_btn=new JButton("Update");
	JButton Delete_btn=new JButton("Delete");
	
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int) screensize.getWidth();
	int H=(int) screensize.getHeight();
	
	
	public productform() {
		CreateForm();
		ActionEvent();
		SetLocationandSize();
		SetFontforAll();
		AddComponentToFrame();
	}
	private void AddComponentToFrame() {
		frame.add(id_lb);
		frame.add(Name_lb);
		frame.add(Description_lb);
		frame.add(Price_lb);
		frame.add(StockQuantity_lb);
		frame.add(ProductImage_lb);
		frame.add(SuppierInformation_lb);
		
		
		
		
		frame.add(id_txf);
		frame.add(Name_txf);
		frame.add(Description_txf);
		frame.add(Price_txf);
		frame.add(StockQuantity_txf);
		frame.add(ProductImage_txf);
		frame.add(SuppierInformation_txf);
		
		
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(Delete_btn);
		frame.add(table);
	}
	private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		id_lb.setFont(font);
		Name_lb.setFont(font);
		Description_lb.setFont(font);
		Price_lb.setFont(font);
		StockQuantity_lb.setFont(font);
		ProductImage_lb.setFont(font);
		SuppierInformation_lb.setFont(font);
		
		
		
		id_txf.setFont(font);
		Name_txf.setFont(font);
		Description_txf.setFont(font);
		Price_txf.setFont(font);
		StockQuantity_txf.setFont(font);
		ProductImage_txf.setFont(font);
		SuppierInformation_txf.setFont(font);
		
		
		Font fonti=new Font("Courier new",Font.ITALIC,12);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		Delete_btn.setFont(font);
		
	}
	private void SetLocationandSize() {
		id_lb.setBounds(10,10,150,30);
		Name_lb.setBounds(10,60,150,30);
		Description_lb.setBounds(10,110,150,30);
		Price_lb.setBounds(10,160,150,30);
		StockQuantity_lb.setBounds(10,210,150,30);
		ProductImage_lb.setBounds(10,260,150,30);
		SuppierInformation_lb.setBounds(10,310,150,30);
		
		
		id_txf.setBounds(230,10,150,30);
		Name_txf.setBounds(230,60,150,30);
		Description_txf.setBounds(230,110,150,30);
		Price_txf.setBounds(230,160,150,30);
		StockQuantity_txf.setBounds(230,210,150,30);
		ProductImage_txf.setBounds(230,260,150,30);
		SuppierInformation_txf.setBounds(230,310,150,30);
		
		
		
		insert_btn.setBounds(10,350,120,30);
		Read_btn.setBounds(140,350,120,30);
		update_btn.setBounds(270,350,120,30);
		Delete_btn.setBounds(400,350,120,30);
		 table.setBounds(600,10, 500, 240);}
	
	private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("ProductForm");
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
		product pf=new product();
		if(e.getSource()==insert_btn) {
			pf.setName(Name_txf.getText());
			pf.setDescription(Description_txf.getText());
			pf.setPrice(Price_txf.getText());
			pf.setStockQantity(StockQuantity_txf.getText());
			pf.setProductImage(ProductImage_txf.getText());
			pf.setSuppierInformation(SuppierInformation_txf.getText());
			pf.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("id");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Price");
            model.addColumn("StockQuantity");
            model.addColumn("ProductImage");
            model.addColumn("SuppierInformation");

            ResultSet resultSet = product.ReadData();
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
			int id=Integer.parseInt(id_txf.getText());
			pf.setName(Name_txf.getText());
			pf.setDescription(Description_txf.getText());
			pf.setPrice(Price_txf.getText());
			pf.setStockQantity(StockQuantity_txf.getText());
			pf.setProductImage(ProductImage_txf.getText());
			pf.setSuppierInformation(SuppierInformation_txf.getText());
			pf.update(id);
	    }
	  else {
			int id=Integer.parseInt(id_txf.getText());
			pf.delete(id);}
		}

	  
	 public static void main(String[] args) {
			
		 productform Pf= new productform();
			System.out.println(Pf);
			
	
	}

	
	}



	
	




   