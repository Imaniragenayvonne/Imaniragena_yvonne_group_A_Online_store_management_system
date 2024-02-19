package MYALL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Orders {
	private int Orders_id;
	private String Users_id;
	private String OrderDate;
	private String OrderStatus;
	private String OrderProduct;
	private String Totalprice;
	private String Paymentmethod;
	
	public Orders() {} 
	
	public Orders (int Orders_id,String Users_id,String OrderDate,String OrderStatus,String OrderedProduct,String Totalprice,String Paymentmethod) {
		
		this.Orders_id=Orders_id;
		this.Users_id=Users_id;
		this.OrderDate=OrderDate;
		this.OrderStatus=OrderStatus;
		this.OrderProduct=OrderedProduct;
		this.Totalprice=Totalprice;
		this.Paymentmethod=Paymentmethod;
		
		
	}

	
	public int getOrders_id() {
		return Orders_id;
	}

	public void setOrders_id(int orders_id) {
		Orders_id = orders_id;
	}

	public String getUsers_id() {
		return Users_id;
	}

	public void setUsers_id(String users_id) {
		Users_id = users_id;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public String getOrderProduct() {
		return OrderProduct;
	}

	public void setOrderProduct(String orderProduct) {
		OrderProduct = orderProduct;
	}

	public String getTotalprice() {
		return Totalprice;
	}

	public void setTotalprice(String totalprice) {
		Totalprice = totalprice;
	}

	public String getPaymentmethod() {
		return Paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		Paymentmethod = paymentmethod;
	}

	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
	    String user = "222010062";
	    String password = "222010062";

	    // SQL query to insert data
	    String sql = "INSERT INTO Orders (Users_id,OrderDate,OrderStatus ,OrderProduct,TotalPrice,PaymentMethod) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = (Connection) DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	    	preparedStatement.setNString(1, this.Users_id);
	       preparedStatement.setString(2, this.OrderDate);
	       preparedStatement.setString(3, this.OrderStatus);
	       preparedStatement.setString(4, this.OrderProduct);
	       preparedStatement.setString(5, this.Totalprice);
	       preparedStatement.setString(6, this.Paymentmethod);
	       
	       
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
			public static ResultSet ReadData() {
			    String host = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
			    String user = "222010062";
			    String password = "222010062";

			    String sql = "SELECT * FROM Orders";

			    try {
			        Connection con = (Connection) DriverManager.getConnection(host,user,password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			        
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}
	public void update(int inputOrders_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
	    String user = "222010062";
	    String password = "222010062";

	    // SQL query to update data
	    String sql = "UPDATE Orders SET Users_id=?,OrderDate = ?,OrderStatus= ?,OrderProduct=?,TotalPrice=?,PaymentMethod =? WHERE Orders_Id = ?";

	    try (
	        // Establish the con
	        Connection con = (Connection) DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	 stm.setString(1, this.getUsers_id());
	    	  stm.setString(2, this.getOrderDate());
	          stm.setString(3, this.getOrderStatus());
	          stm.setString(4, this.getOrderProduct());// Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(5, this.getTotalprice());
	          stm.setString(6, this.getPaymentmethod());
	          
	          stm.setInt(7, inputOrders_id);
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputpid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
	    String user = "222010062";
	    String password = "222010062";

	    // SQL query to delete data
	    String sql = "DELETE FROM Orders WHERE  Orders_Id = ?";

	    try (
	        // Establish the 
	        Connection con= (Connection) DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}

	
}
