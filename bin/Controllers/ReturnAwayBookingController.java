package Controllers;

import Views.OneWayBooking;
import Views.ReturnBookingAway;
import Views.ReturnBookingBack;

import java.util.*;

import javax.swing.table.DefaultTableModel;

import ConnectDB.BookingDAO;
import Models.UserFindsFlightsModel;
import Ulti.DateUlti;

public class ReturnAwayBookingController {
	BookingDAO bookingDAO = new BookingDAO();
	private ReturnBookingAway view;
	private UserFindsFlightsModel userModel;
	public ReturnAwayBookingController(ReturnBookingAway v,UserFindsFlightsModel model)
	{
		this.view = v;
		this.userModel = model;
		initTableDirect();
		initTableDirectController();
		initTableDirectTransitController();
		initController();
		initViewDirect();
		confirm();
	}
	private void confirm()
	{
		view.getBtn_book_direct_away().addActionListener(e->owConfirm());
		view.getBtn_book_transit_away().addActionListener(e->reConfirm());
	}
	private void owConfirm()
	{
		ReturnBookingBack reFrame = new ReturnBookingBack();
		UserFindsFlightsModel userModel1 = new UserFindsFlightsModel(userModel.getReDate(), 
				userModel.getArr(), 
				userModel.getDep(),userModel.getUser_id()); 
		new ReturnBackBookingController(reFrame,userModel1);
		
	}
	private void reConfirm()
	{
		ReturnBookingBack reFrame= new ReturnBookingBack();
		UserFindsFlightsModel userModel1 = new UserFindsFlightsModel(userModel.getReDate(), 
				userModel.getArr(), 
				userModel.getDep(),userModel.getUser_id()); 
		new ReturnBackBookingController(reFrame,userModel1);
	}
	private void initViewDirect() {
		
		view.setVisible(true);
		view.start();

		bookingDAO.displayFlightsOneWay(view.getDirectTableModel(),view.getTableDataDirect(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
		
		bookingDAO.displayFlightTransit(view.getTransitTableModel(),view.getTableDataTransit(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
	}
	private void initController() {
		 //data from database will be stored here
		view.setTableDataDirect(new ArrayList<String[]>());
		view.setDirectTableModel((DefaultTableModel)view.getTable_direct_away().getModel());
		
		view.setTableDataTransit(new ArrayList<String[]>());
		view.setTransitTableModel((DefaultTableModel)view.getTable_transit_away().getModel());
		
	}
	

	@SuppressWarnings("serial")
	private void initTableDirect() {
		// TODO Auto-generated method stub
		view.getTable_direct_away().setModel(new DefaultTableModel(
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
		
		view.getTable_direct_away().setCellSelectionEnabled(true);
		
		
		view.getTable_direct_away().addMouseListener(new java.awt.event.MouseAdapter() {  
			@Override
			 public void mouseClicked(java.awt.event.MouseEvent evt) {  
				int index = 0;
				int[] row = view.getTable_direct_away().getSelectedRows();  
				int[] columns = view.getTable_direct_away().getSelectedColumns();  
				for (int i = 0; i < row.length; i++) {  
					for (int j = 0; j < columns.length; j++) {  
						index = row[i];
			     } }  
				view.getTextField_flight_direct_away().setText(view.getTableDataDirect().get(index)[0]);
				view.getTextField_fromto_direct_away().setText(view.getTableDataDirect().get(index)[1]+ " - "+view.getTableDataDirect().get(index)[2]);
				view.getTextField_duration_direct_away().setText(view.getTableDataDirect().get(index)[3]+" min ");
				view.getTextField_carrier_direct_away().setText(view.getTableDataDirect().get(index)[4]);
				view.getTextField_time_direct_away().setText(view.getTableDataDirect().get(index)[5]+ " - "+view.getTableDataDirect().get(index)[6]);
				view.getTextField_date_direct_away().setText(view.getTableDataDirect().get(index)[7]);
				view.getTextField_price_direct_away().setText(view.getTableDataDirect().get(index)[8]);
			 }       
			}); 
	}
	private void initTableDirectTransit() {
		// TODO Auto-generated method stub
		view.getTable_direct_away().setModel(new DefaultTableModel(
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
		view.getTable_transit_away().setCellSelectionEnabled(true);
		view.getTable_transit_away().addMouseListener(new java.awt.event.MouseAdapter() {  
			@Override
			 public void mouseClicked(java.awt.event.MouseEvent evt) {  
				int index = 0;
				int[] row = view.getTable_transit_away().getSelectedRows();  
				int[] columns = view.getTable_transit_away().getSelectedColumns();  
				for (int i = 0; i < row.length; i++) {  
					for (int j = 0; j < columns.length; j++) {  
						index = row[i];
			     } }  
				view.getTextField_flight_transit_away().setText(view.getTableDataTransit().get(index)[0]);
				view.getTextField_flight_transit_away2().setText(view.getTableDataTransit().get(index)[1]);
				view.getTextField_fromto_transit1_away().setText(view.getTableDataTransit().get(index)[2]+ " - "+view.getTableDataTransit().get(index)[3]);
				view.getTextField_fromto_transit2_away().setText(view.getTableDataTransit().get(index)[3]+ " - "+view.getTableDataTransit().get(index)[4]);
				view.getTextField_duration_transit_away().setText(view.getTableDataTransit().get(index)[5]+" min ");
				view.getTextField_carrier_transit_away().setText(view.getTableDataTransit().get(index)[6]);
				view.getTextField_time_transit1_away().setText(view.getTableDataTransit().get(index)[7]+ " - "+view.getTableDataTransit().get(index)[8]);
				view.getTextField_time_transit2_away().setText(view.getTableDataTransit().get(index)[9]+ " - "+view.getTableDataTransit().get(index)[10]);
				view.getTextField_date_transit_away().setText(view.getTableDataTransit().get(index)[11]);
				view.getTextField_price_transit_away().setText(view.getTableDataTransit().get(index)[12]);
			 }       
			}); 
	}
}
