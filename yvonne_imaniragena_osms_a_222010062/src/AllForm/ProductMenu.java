package AllForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ProductMenu implements ActionListener{
	JFrame frame;
	JMenu home,  Product, Store, Orders, Transaction,Users,more ;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,ProductDelete,ProductUpdate,ProducttRead;
	JMenuItem StoreDelete,StoreUpdate,StoreRead;
	JMenuItem OrdersDelete,OrdersUpdate,OrdersRead;
	JMenuItem TransactionDelete,TransactionUpdate,TransactionRead;
	JMenuItem UsersDelete,UsersUpdate,UsersRead;
	
	
	
	public ProductMenu (){
		createWindow();
	}
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		Product = new JMenu("Product");
		Store= new JMenu("Store");
		Orders = new JMenu("Orders");
		Transaction=new JMenu("Transaction");
		Users=new JMenu("Users");
		

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		ProducttRead = new JMenuItem("Read");
		ProductUpdate = new JMenuItem("Update");
		ProductDelete = new JMenuItem("Delete");
		Product.add(ProducttRead);
		Product.add(ProductUpdate);
		Product.add(ProductDelete);

		StoreRead =new JMenuItem("Read");
		StoreUpdate =new JMenuItem("Update");
		StoreDelete =new JMenuItem("Delete");
		
		Store.add(StoreRead);
		Store.add(StoreUpdate);
		Store.add(StoreDelete);
		
		OrdersRead =new JMenuItem("Read");
		OrdersUpdate =new JMenuItem("Update");
		OrdersDelete =new JMenuItem("Delete");
		Orders.add(OrdersRead);
		Orders.add(OrdersUpdate);
		Orders.add(OrdersDelete);
		
		TransactionRead =new JMenuItem("Read");
		TransactionUpdate =new JMenuItem("Update");
		TransactionDelete =new JMenuItem("Delete");
		Transaction.add(TransactionRead);
		Transaction.add(TransactionUpdate);
		Transaction.add(TransactionDelete);
		
		UsersRead =new JMenuItem("Read");
		UsersUpdate =new JMenuItem("Update");
		UsersDelete =new JMenuItem("Delete");
		Users.add(UsersRead);
		Users.add(UsersUpdate);
		Users.add(UsersDelete);
		
		
		

		

		mb.add(home);
		mb.add(Product);
		mb.add(Store);
		mb.add(Orders);
		mb.add(Transaction);
		mb.add(Users);
		
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	}
	private void componentsOnFrame() {
		home = new JMenu("Home");
		Product= new JMenu("roduct");
		Store = new JMenu("Store");
		Orders =new JMenu("Orders");
		Transaction =new JMenu("Transaction");
		Users=new JMenu("Users");
		
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		Product.add(i2);
		Product.add(i3);
		Product.add(i4);
		Store.add(i2);
		Store.add(i3);
		Store.add(i4);
		Orders.add(i2);
		Orders.add(i3);
		Orders.add(i4);
		Transaction.add(i2);
		Transaction.add(i3);
		Transaction.add(i4);
		Users.add(i2);
		Users.add(i3);
		Users.add(i4);
		
		addactionEvent();

		
		
	}
	private void addactionEvent() {
		ProducttRead.addActionListener(this);
		StoreRead.addActionListener(this);
		OrdersRead.addActionListener(this);
		TransactionRead.addActionListener(this);
		UsersRead.addActionListener(this);
		
		
		
	}
	public static void main(String[] args) {
		new ProductMenu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ProducttRead) {
			productform pf=new productform();
			frame.dispose();
		}else if (e.getSource()==StoreRead) {
			StoreForm df=new StoreForm();
			frame.dispose();
		}else if (e.getSource()==OrdersRead) {
			OrdersForm nf=new OrdersForm();
			frame.dispose();
		}else if (e.getSource()==TransactionRead) {
			TransactionForm cf=new TransactionForm();
			frame.dispose();
			}else if (e.getSource()==UsersRead) {
				UserForm u=new UserForm();
				frame.dispose();
				
					frame.dispose();
	}

}
	

}


