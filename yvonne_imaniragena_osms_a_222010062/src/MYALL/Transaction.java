package MYALL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Transaction {
	private int transaction_id;
	private String orders_id;
	private String PaymentAmount;
	private String PaymentDate;
	private String PaymentStatus;
	
	 public Transaction() {}
	 
	 public Transaction( int transaction_id,String Orders_id,String PaymentAmount,String PaymentDate,String PaymentStatus) {

		 this.transaction_id=transaction_id;
		 this.orders_id=Orders_id;
		 this.PaymentAmount=PaymentAmount;
		 this.PaymentDate=PaymentDate;
		 this.PaymentStatus=PaymentStatus;
		 	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(String Orders_id) {
		this.orders_id = orders_id;
	}

	public String getPaymentAmount() {
		return PaymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		PaymentAmount = paymentAmount;
	}

	public String getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
	    String user = "222010062";
	    String password = "222010062";

	    // SQL query to insert data
	    String sql = "INSERT INTO Transaction (Orders_id,PaymentAmount,PaymentDate,PaymentStatus) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = (Connection) DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setNString(1,this.orders_id);
	       preparedStatement.setString(2,this.PaymentAmount);
	       preparedStatement.setString(3,this.PaymentDate);
	       preparedStatement.setString(4,this.PaymentStatus);
	       
	       
	       
	        
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

			    String sql = "SELECT * FROM Transaction";

			    try {
			        Connection con = (Connection) DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

	public void update(int inputTransaction_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
	    String user = "222010062";
	    String password = "222010062";

	    // SQL query to update data
	    String sql = "UPDATE Transaction SET Orders_id=?,PaymentAmount =?,PaymentDate=?,PaymentStatus=? WHERE Transaction_Id =?";

	    try (
	        // Establish the con
	        Connection con = (Connection) DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	 stm.setString(1, this.getOrders_id());
	    	  stm.setString(2, this.getPaymentAmount());
	          stm.setString(3, this.getPaymentDate());
	          stm.setString(4, this.getPaymentStatus());// Assuming there is a column named 'id' for the WHERE clause
	          
	          stm.setInt(5, inputTransaction_id);
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
	    String sql = "DELETE FROM Transaction WHERE  Transaction_Id = ?";

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
