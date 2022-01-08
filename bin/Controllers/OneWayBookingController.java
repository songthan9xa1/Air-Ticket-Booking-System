package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import ConnectDB.BookingDAO;
import Models.User;
import Models.UserFindsFlightsModel;
import Ulti.DateUlti;
import Views.OneWayBooking;
import Views.UserFindsFlightsView;

public class OneWayBookingController {
	BookingDAO bookingDAO = new BookingDAO();
	private OneWayBooking view;
	private UserFindsFlightsModel userModel;
	private boolean check = false;
	private int innerIndex = 0;
	
	public OneWayBookingController(OneWayBooking v,UserFindsFlightsModel model) {
		this.view = v;
		this.userModel = model;
		initTableDirect();
		initTableDirectController();
		initTableDirectTransitController();
		initController();
		initViewDirect();
		
	}
	
	private void initViewDirect() {
		
		view.setVisible(true);
		view.start();

		bookingDAO.displayFlightsOneWay(view.getDirectTableModel(),view.getTableDataDirect(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
		
		bookingDAO.displayFlightTransit(view.getTransitTableModel(),view.getTableDataDirectTransit(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
	}

	private void initController() {
		 //data from database will be stored here
		view.setTableDataDirect(new ArrayList<String[]>());
		view.setDirectTableModel((DefaultTableModel)view.getTable_direct().getModel());
		
		view.setTableDataTransit(new ArrayList<String[]>());
		view.setDirectTransitTableModel((DefaultTableModel)view.getTable_transit().getModel());
		
		view.getBtn_book_direct().addActionListener(e->bookDirectFlight());
		view.getBtn_book_transit().addActionListener(e->bookTransitFlight());
		
	}
	

	private void bookTransitFlight() {
		bookingDAO.bookTransitFlight(Integer.parseInt(view.getTextField_flight_transit().getText()), userModel.getUser_id(),
				innerIndex, innerIndex, innerIndex, null);
	}

	private void bookDirectFlight() {
		bookingDAO.bookDirectFlight(Integer.parseInt(view.getTextField_flight_direct().getText()), userModel.getUser_id(),
				Float.parseFloat(view.getTextField_price_direct().getText()), view.getComboBox().getSelectedItem().toString());
		view.dispose();
	}

	@SuppressWarnings("serial")
	private void initTableDirect() {
		// TODO Auto-generated method stub
		view.getTable_direct().setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Departure","Arrival","Duration","Price"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				 @Override
				    public boolean isCellEditable(int row, int column) {
				       return false;
				    }
			});
	}

	private void initTableDirectController() {
		
		view.getTable_direct().setCellSelectionEnabled(true);
		
		
		view.getTable_direct().addMouseListener(new java.awt.event.MouseAdapter() {  
			@Override
			 public void mouseClicked(java.awt.event.MouseEvent evt) {  
				int index = 0;
				int[] row = view.getTable_direct().getSelectedRows();  
				int[] columns = view.getTable_direct().getSelectedColumns();  
				for (int i = 0; i < row.length; i++) {  
					for (int j = 0; j < columns.length; j++) {  
						index = row[i];
						innerIndex = index;
			     } }  
				view.getTextField_flight_direct().setText(view.getTableDataDirect().get(index)[0]);
				view.getTextField_fromto_direct().setText(view.getTableDataDirect().get(index)[1]+ " - "+view.getTableDataDirect().get(index)[2]);
				view.getTextField_duration_direct().setText(view.getTableDataDirect().get(index)[3]+" min ");
				view.getTextField_carrier_direct().setText(view.getTableDataDirect().get(index)[4]);
				view.getTextField_time_direct().setText(view.getTableDataDirect().get(index)[5]+ " - "+view.getTableDataDirect().get(index)[6]);
				view.getTextField_date_direct().setText(view.getTableDataDirect().get(index)[7]);
				view.getTextField_price_direct().setText(view.getTableDataDirect().get(index)[8]);
				
				view.getComboBox().setSelectedItem("Economy");
				view.getComboBox().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(view.getComboBox().getSelectedItem().toString().equals("Premium")) 
							view.getTextField_price_direct().setText(view.getTableDataDirect().get(innerIndex)[9]);
						else
							view.getTextField_price_direct().setText(view.getTableDataDirect().get(innerIndex)[8]);
					}
				});
				
			 }       
			}); 
	}
	
	//sua
	private void initTableDirectTransit() {
		// TODO Auto-generated method stub
		view.getTable_direct().setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Departure","Arrival","Transit","Duration","Price"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class,Object.class, Object.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				 @Override
				    public boolean isCellEditable(int row, int column) {
				       return false;
				    }
			});
	}
	private void initTableDirectTransitController()
	{
		view.getTable_transit().setCellSelectionEnabled(true);
		view.getTable_transit().addMouseListener(new java.awt.event.MouseAdapter() {  
			@Override
			 public void mouseClicked(java.awt.event.MouseEvent evt) {  
				int index = 0;
				int[] row = view.getTable_transit().getSelectedRows();  
				int[] columns = view.getTable_transit().getSelectedColumns();  
				for (int i = 0; i < row.length; i++) {  
					for (int j = 0; j < columns.length; j++) {  
						index = row[i];
						innerIndex = index;
			     } }  
				view.getTextField_flight_transit().setText(view.getTableDataDirectTransit().get(index)[0]);
				view.getTextField_flight_transit2().setText(view.getTableDataDirectTransit().get(index)[1]);
				view.getTextField_fromto_transit1().setText(view.getTableDataDirectTransit().get(index)[2]+ " - "+view.getTableDataDirectTransit().get(index)[3]);
				view.getTextField_fromto_transit2().setText(view.getTableDataDirectTransit().get(index)[3]+ " - "+view.getTableDataDirectTransit().get(index)[4]);
				view.getTextField_duration_transit().setText(view.getTableDataDirectTransit().get(index)[5]+" min ");
				view.getTextField_carrier_transit().setText(view.getTableDataDirectTransit().get(index)[6]);
				view.getTextField_time_transit1().setText(view.getTableDataDirectTransit().get(index)[7]+ " - "+view.getTableDataDirectTransit().get(index)[8]);
				view.getTextField_time_transit2().setText(view.getTableDataDirectTransit().get(index)[9]+ " - "+view.getTableDataDirectTransit().get(index)[10]);
				view.getTextField_date_transit().setText(view.getTableDataDirectTransit().get(index)[11]);
				view.getTextField_price_transit().setText(view.getTableDataDirectTransit().get(index)[12]);
				
				view.getComboBox_transit().setSelectedItem("Economy");
				view.getComboBox_transit().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(view.getComboBox_transit().getSelectedItem().toString().equals("Premium")) 
							view.getTextField_price_transit().setText(view.getTableDataDirectTransit().get(innerIndex)[13]);
						else
							view.getTextField_price_transit().setText(view.getTableDataDirectTransit().get(innerIndex)[12]);
					}
				});
			 }       
			}); 
	}
}
