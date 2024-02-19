package MYALL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class product {
	private int Product_id;
	private String Name;
	private String Description;
	private String Price;
	private String StockQantity;
	private String ProductImage;
	private String SuppierInformation;
	
	public product() {} 
	
public product(int Product_id ,String Name,String Description,String Price,String StockQantity,String ProductImage,String SuppierInformation )
{
super();

this.Product_id=Product_id;
this.Name=Name;
this.Description=Description;
this.Price=Price;
this.StockQantity=StockQantity;
this.SuppierInformation=SuppierInformation;
}
	

public int getProduct_id() {
	return Product_id;
}

public void setProduct_id(int product_id) {
	Product_id = product_id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}

public String getPrice() {
	return Price;
}

public void setPrice(String price) {
	Price = price;
}

public String getStockQantity() {
	return StockQantity;
}

public void setStockQantity(String stockQantity) {
	StockQantity = stockQantity;
}

public String getProductImage() {
	return ProductImage;
}

public void setProductImage(String productImage) {
	ProductImage = productImage;
}

public String getSuppierInformation() {
	return SuppierInformation;
}


public void setSuppierInformation(String suppierInformation) {
	SuppierInformation = suppierInformation;
}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
    String user = "222010062";
    String password = "222010062";

    // SQL query to insert data
    String sql = "INSERT INTO Product (Name,Description,Price,StockQuantity,ProductImage,SuppierInformation) VALUES (?,?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.Name);
       preparedStatement.setString(2, this.Description);
       preparedStatement.setString(3, this.Price);
       preparedStatement.setString(4, this.StockQantity);
       preparedStatement.setString(5, this.ProductImage);
       preparedStatement.setString(6, this.SuppierInformation);
       
       
        
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
 
private String name() {
			// TODO Auto-generated method stub
			return null;
		}

public static ResultSet ReadData() {
    String host = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
    String user = "222010062";
    String password = "222010062";

    String sql = "SELECT * FROM product";

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}



public void update(int inputProduct_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
    String user = "222010062";
    String password = "222010062";

    // SQL query to update data
    String sql = "UPDATE Product SET  Name= ?,Description= ?, Price= ?,StockQuantity=?,ProductImage=?,SuppierInformation=?  WHERE Product_id = ?";

    try (    //Name,Description,Price,StockQuantity,ProductImage,SuppierInformation
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  stm.setString(1, this.getName());
          stm.setString(2, this.getDescription());
          stm.setString(3, this.getPrice()); // Assuming there is a column named 'id' for the WHERE clause
          stm.setString(4, this.getStockQantity());
          stm.setString(5, this.getProductImage());
          stm.setString(6, this.getSuppierInformation());
          stm.setInt(7, inputProduct_Id );
       
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
public void delete(int inputProduct_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yvonne_imaniragena_osms";
    String user = "222010062";
    String password = "222010062";

    // SQL query to delete data
    String sql = "DELETE FROM Product WHERE  Product_id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputProduct_Id); // Assuming there is a column named 'id' for the WHERE clause

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




