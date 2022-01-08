package Controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import ConnectDB.UserDAO;
import Models.User;
import Models.UserFindsFlightsModel;
import Ulti.DateUlti;
import Views.OneWayBooking;
import Views.ReturnBookingAway;
import Views.UserFindsFlightsView;

public class UserFindsFlightsController {

	private User user;
	UserDAO userDAO = new UserDAO();
	private UserFindsFlightsView view;

	public UserFindsFlightsController(UserFindsFlightsView ui_view, User u) {
		this.view = ui_view;
		this.user = u;
		initView();
	}

	private void initView() {
		view.setVisible(true);
		view.start();
		view.getOwBtnConfirm().addActionListener(e -> owConfirm());
		view.getReBtnConfirm().addActionListener(e->reConfirm());
	}

	private void owConfirm() {

		if (view.getComboBox_ow_from_input().equalsIgnoreCase(view.getComboBox_ow_to_input())) {
			JOptionPane.showMessageDialog(null, "Please check your input");
		} else {
			OneWayBooking OwFrame = new OneWayBooking();
			UserFindsFlightsModel userFindsFlightsModel = new UserFindsFlightsModel(
					DateUlti.ConvertDateToInt(view.getOw_departure_date()), view.getComboBox_ow_from_input(),
					view.getComboBox_ow_to_input(),user.getID());

			new OneWayBookingController(OwFrame, userFindsFlightsModel);
		}

	}
	
	  private void reConfirm() {
	  if(view.getComboBox_return_from_input().equalsIgnoreCase(view.
	  getComboBox_return_to_input())) { JOptionPane.showMessageDialog(null,
	  "Please check your input"); } else
	  if(view.getRe_away_date().equalsIgnoreCase(view.getRe_back_date())) {
	  JOptionPane.showMessageDialog(null, "Please check your input"); } else {
	  ReturnBookingAway ReFrame=new ReturnBookingAway(); UserFindsFlightsModel
	  userModel = new
	  UserFindsFlightsModel(DateUlti.ConvertDateToInt(view.getRe_away_date()) ,
	  DateUlti.ConvertDateToInt(view.getRe_back_date()),
	  view.getComboBox_return_from_input(), view.getComboBox_return_to_input(),user.getID());
	  new ReturnAwayBookingController(ReFrame,userModel); } }
	 

}
