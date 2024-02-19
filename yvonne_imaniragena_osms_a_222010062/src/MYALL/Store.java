package MYALL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Store {
	private int Store_id;
	private String Storename;
	private String Storedescription;
	private String ContactInformation;
	
	 
	public Store(){
		//constrct
	}
	
	public Store(int Store_id,String Storename,String Storedescription,String ContactInformation) {
		 
		super();
		this.Store_id=Store_id;
		this.Storename=Storename;
		this.Storedescription=Storedescription;
		this.ContactInformation=ContactInformation;
		
	}


public int getStore_id() {
		return Store_id;
	}

	public void setStore_id(int store_id) {
		Store_id = store_id;
	}

	public String getStorename() {
		return Storename;
	}

	public void setStorename(String storename) {
		Storename = storename;
	}

	public String getStoredescription() {
		return Storedescription;
	}

	public void setStoredescription(String storedescription) {
		Storedescription = storedescription;
	}

	public String getContactInformation() {
		return ContactInformation;
	}

	public void setContactInformation(String contactInformation) {
		ContactInformation = contactInformation;
	}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
    String user = "222010062";
    String password = "222010062";

    // SQL query to insert data
    String sql = "INSERT INTO Store (Storename ,Storedescription , ContactInformation) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = (Connection) DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.Storename);
       preparedStatement.setString(2, this.Storedescription);
       preparedStatement.setString(3, this.ContactInformation);
       
        
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

		    String sql = "SELECT * FROM Store";

		    try {
		    	 Connection con =(Connection) DriverManager.getConnection(host, user, password);
		         PreparedStatement preparedStatement = con.prepareStatement(sql);
		         return preparedStatement.executeQuery();
		     } catch (SQLException e) {
		         e.printStackTrace();
		         return null;
		     }
		 }
public void update(int inputStore_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
    String user = "222010062";
    String password = "222010062";

    // SQL query to update data
    String sql = "UPDATE Store SET  Storename = ?,Storedescription= ?,ContactInformation=? WHERE Store_Id = ?";

    try (
        // Establish the con
        Connection con = (Connection) DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  stm.setString(1, this.getStorename());
          stm.setString(2, this.getStoredescription());
          stm.setString(3, this.getContactInformation());// Assuming there is a column named 'id' for the WHERE clause
          
          stm.setInt(4, inputStore_id);
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
    String sql = "DELETE FROM Store WHERE  Store_Id = ?";

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