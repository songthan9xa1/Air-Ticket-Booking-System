package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.BookingDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OneWayBooking extends JFrame {
	Border default_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , new Color(240,240,240));
	Border red_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , Color.red);
	private JPanel contentPane;
	private JLabel lbl_transitflight;
	private JLabel lbl_directflight;
	private JPanel transit_pane;
	private JPanel direct_pane;
	private JTable table_direct;
	private JTable table_transit;
	private JScrollPane scrollPane_direct;
	private JScrollPane scrollPane_transit;
	private JLabel lbl_flight_direct;
	private JTextField textField_flight_direct;
	private JTextField textField_carrier_direct;
	private JLabel lbl_date_direct;
	private JTextField textField_date_direct;
	private JLabel lbl_fromto;
	private JTextField textField_fromto_direct;
	private JLabel lbl_time_direct;
	private JTextField textField_time_direct;
	private JTextField textField_price_direct;
	private JTextField textField_duration_direct;
	private JLabel lbl_flight_transit;
	private JTextField textField_flight_transit;
	private JLabel lbl_carrier_transit;
	private JTextField textField_carrier_transit;
	private JTextField textField_date_transit;
	private JTextField textField_fromto_transit1;
	private JTextField textField_time_transit1;
	private JTextField textField_price_transit;
	private JLabel lbl_fromto_transit2;
	private JTextField textField_fomto_transit2;
	private JLabel lbl_time_transit2;
	private JTextField textField_time_transit2;
	private JLabel lbl_duration_transit;
	private JTextField textField_duration_transit;
	private JButton btn_book_transit;
	private JTextField textField_price1;
	private JTextField textField_price2;

	// Data flow MVC
	private List<String[]> tableDataDirect;
	private DefaultTableModel directTableModel;
	//test
	private List<String[]> tableDataTransit;
	private DefaultTableModel transitTableModel;
	private JLabel lbl_flight_transit2;
	private JTextField textField_flight_transit2;
	private JComboBox comboBox;
	private JComboBox comboBox_transit;
	private JButton btn_book_direct;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OneWayBooking frame = new OneWayBooking();
					frame.setVisible(true);
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void start()
	{
		lbl_directflight.setBorder(red_top_border);
		lbl_transitflight.setBorder(default_top_border);
		direct_pane.setVisible(true);
		transit_pane.setVisible(false);
		table_direct.setVisible(true);
		table_transit.setVisible(false);
	}
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
	public OneWayBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titel = new JLabel("Ticket Reservation");
		lbl_titel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_titel.setBounds(266, 10, 150, 24);
		contentPane.add(lbl_titel);
		
		lbl_directflight = new JLabel("Direct Flight");
		lbl_directflight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_directflight.setBorder(red_top_border);
				lbl_transitflight.setBorder(default_top_border);
				direct_pane.setVisible(true);
				transit_pane.setVisible(false);
				table_direct.setVisible(true);
				table_transit.setVisible(false);
			}
		});
		lbl_directflight.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_directflight.setOpaque(true);
		lbl_directflight.setBackground(new Color(175, 238, 238));
		lbl_directflight.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_directflight.setBounds(0, 37, 332, 31);
		contentPane.add(lbl_directflight);
		
		lbl_transitflight = new JLabel("Transit Flight");
		lbl_transitflight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_transitflight.setBorder(red_top_border);
				lbl_directflight.setBorder(default_top_border);
				transit_pane.setVisible(true);
				direct_pane.setVisible(false);
				table_direct.setVisible(false);
				table_transit.setVisible(true);
			}
		});
		lbl_transitflight.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_transitflight.setOpaque(true);
		lbl_transitflight.setBackground(new Color(0, 255, 255));
		lbl_transitflight.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_transitflight.setBounds(331, 37, 363, 31);
		contentPane.add(lbl_transitflight);
		
		direct_pane = new JPanel();
		direct_pane.setBounds(0, 70, 694, 473);
		contentPane.add(direct_pane);
		direct_pane.setLayout(null);
		
		scrollPane_direct = new JScrollPane();
		scrollPane_direct.setBounds(0, 0, 694, 256);
		direct_pane.add(scrollPane_direct);
		table_direct = new JTable();
		scrollPane_direct.setViewportView(table_direct);
		
		
		lbl_flight_direct = new JLabel("Flight");
		lbl_flight_direct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_direct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_direct.setBounds(83, 274, 60, 20);
		direct_pane.add(lbl_flight_direct);
		
		textField_flight_direct = new JTextField();
		textField_flight_direct.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_flight_direct.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_direct.setEditable(false);
		textField_flight_direct.setBounds(153, 274, 111, 20);
		direct_pane.add(textField_flight_direct);
		textField_flight_direct.setColumns(10);
		
		JLabel lbl_carrier_direct = new JLabel("Carrier");
		lbl_carrier_direct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_carrier_direct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_carrier_direct.setBounds(315, 274, 60, 20);
		direct_pane.add(lbl_carrier_direct);
		
		textField_carrier_direct = new JTextField();
		textField_carrier_direct.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_carrier_direct.setHorizontalAlignment(SwingConstants.CENTER);
		textField_carrier_direct.setEditable(false);
		textField_carrier_direct.setBounds(385, 274, 111, 20);
		direct_pane.add(textField_carrier_direct);
		textField_carrier_direct.setColumns(10);
		
		lbl_date_direct = new JLabel("Date");
		lbl_date_direct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date_direct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_date_direct.setBounds(510, 274, 60, 20);
		direct_pane.add(lbl_date_direct);
		
		textField_date_direct = new JTextField();
		textField_date_direct.setHorizontalAlignment(SwingConstants.CENTER);
		textField_date_direct.setEditable(false);
		textField_date_direct.setBounds(575, 274, 111, 20);
		direct_pane.add(textField_date_direct);
		textField_date_direct.setColumns(10);
		
		lbl_fromto = new JLabel("From-To");
		lbl_fromto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto.setBounds(68, 312, 75, 20);
		direct_pane.add(lbl_fromto);
		
		textField_fromto_direct = new JTextField();
		textField_fromto_direct.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_direct.setEditable(false);
		textField_fromto_direct.setBounds(153, 312, 111, 20);
		direct_pane.add(textField_fromto_direct);
		textField_fromto_direct.setColumns(10);
		
		lbl_time_direct = new JLabel("Time");
		lbl_time_direct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_direct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_direct.setBounds(68, 351, 60, 20);
		direct_pane.add(lbl_time_direct);
		
		textField_time_direct = new JTextField();
		textField_time_direct.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_direct.setEditable(false);
		textField_time_direct.setBounds(153, 351, 111, 20);
		direct_pane.add(textField_time_direct);
		textField_time_direct.setColumns(10);
		
		textField_price_direct = new JTextField();
		textField_price_direct.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price_direct.setEditable(false);
		textField_price_direct.setBounds(510, 353, 111, 20);
		direct_pane.add(textField_price_direct);
		textField_price_direct.setColumns(10);
		
		btn_book_direct = new JButton("Book");
		btn_book_direct.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_book_direct.setBounds(303, 415, 105, 36);
		direct_pane.add(btn_book_direct);
		
		JLabel lbl_duration_direct = new JLabel("Duration");
		lbl_duration_direct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_duration_direct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_duration_direct.setBounds(312, 312, 75, 20);
		direct_pane.add(lbl_duration_direct);
		
		textField_duration_direct = new JTextField();
		textField_duration_direct.setHorizontalAlignment(SwingConstants.CENTER);
		textField_duration_direct.setEditable(false);
		textField_duration_direct.setBounds(385, 312, 111, 20);
		direct_pane.add(textField_duration_direct);
		textField_duration_direct.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Premium"}));
		comboBox.setBounds(385, 352, 111, 22);
		direct_pane.add(comboBox);
		
		JLabel lbl_price_direct = new JLabel("Price");
		lbl_price_direct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_price_direct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_price_direct.setBounds(315, 351, 60, 20);
		direct_pane.add(lbl_price_direct);
		
		transit_pane = new JPanel();
		transit_pane.setBounds(0, 70, 694, 473);
		contentPane.add(transit_pane);
		transit_pane.setLayout(null);
		
		scrollPane_transit = new JScrollPane();
		scrollPane_transit.setBackground(Color.WHITE);
		scrollPane_transit.setBounds(0, 0, 694, 256);
		transit_pane.add(scrollPane_transit);
		
		table_transit = new JTable();
		scrollPane_transit.setViewportView(table_transit);
		
		// sua
		table_transit.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Departure","Arrival","Transit","Duration","Price"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class,Object.class
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
		
		lbl_flight_transit2 = new JLabel("Flight(Transit)");
		lbl_flight_transit2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_transit2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_transit2.setBounds(210, 274, 145, 20);
		transit_pane.add(lbl_flight_transit2);
		
		textField_flight_transit2 = new JTextField();
		textField_flight_transit2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_transit2.setEditable(false);
		textField_flight_transit2.setBounds(353, 274, 111, 20);
		transit_pane.add(textField_flight_transit2);
		textField_flight_transit2.setColumns(10);
		
		textField_carrier_transit = new JTextField();
		textField_carrier_transit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_carrier_transit.setEditable(false);
		textField_carrier_transit.setBounds(563, 274, 111, 20);
		transit_pane.add(textField_carrier_transit);
		textField_carrier_transit.setColumns(10);
		
		lbl_flight_transit = new JLabel("Flight");
		lbl_flight_transit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_transit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_transit.setBounds(10, 274, 60, 20);
		transit_pane.add(lbl_flight_transit);
		
		textField_flight_transit = new JTextField();
		textField_flight_transit.setEditable(false);
		textField_flight_transit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_transit.setBounds(80, 274, 111, 20);
		transit_pane.add(textField_flight_transit);
		textField_flight_transit.setColumns(10);
		
		lbl_carrier_transit = new JLabel("Carrier");
		lbl_carrier_transit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_carrier_transit.setBounds(481, 274, 60, 20);
		transit_pane.add(lbl_carrier_transit);
		
		JLabel lbl_date_transit = new JLabel("Date");
		lbl_date_transit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_date_transit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date_transit.setBounds(481, 312, 60, 20);
		transit_pane.add(lbl_date_transit);
		
		textField_date_transit = new JTextField();
		textField_date_transit.setEditable(false);
		textField_date_transit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_date_transit.setBounds(563, 312, 111, 20);
		transit_pane.add(textField_date_transit);
		textField_date_transit.setColumns(10);
		
		JLabel lbl_fromto_transit1 = new JLabel("From-To");
		lbl_fromto_transit1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_transit1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_transit1.setBounds(0, 312, 75, 20);
		transit_pane.add(lbl_fromto_transit1);
		
		textField_fromto_transit1 = new JTextField();
		textField_fromto_transit1.setEditable(false);
		textField_fromto_transit1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_transit1.setBounds(80, 312, 111, 20);
		transit_pane.add(textField_fromto_transit1);
		textField_fromto_transit1.setColumns(10);
		
		JLabel lbl_time_transit1 = new JLabel("Time");
		lbl_time_transit1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_transit1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_transit1.setBounds(10, 351, 60, 20);
		transit_pane.add(lbl_time_transit1);
		
		textField_time_transit1 = new JTextField();
		textField_time_transit1.setEditable(false);
		textField_time_transit1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_transit1.setBounds(80, 351, 111, 20);
		transit_pane.add(textField_time_transit1);
		textField_time_transit1.setColumns(10);
		
		
		textField_price_transit = new JTextField();
		textField_price_transit.setEditable(false);
		textField_price_transit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price_transit.setBounds(563, 389, 111, 20);
		transit_pane.add(textField_price_transit);
		textField_price_transit.setColumns(10);
		
		lbl_fromto_transit2 = new JLabel("From-To(Transit)");
		lbl_fromto_transit2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_transit2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_transit2.setBounds(210, 312, 145, 20);
		transit_pane.add(lbl_fromto_transit2);
		
		textField_fomto_transit2 = new JTextField();
		textField_fomto_transit2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fomto_transit2.setEditable(false);
		textField_fomto_transit2.setBounds(352, 312, 111, 20);
		transit_pane.add(textField_fomto_transit2);
		textField_fomto_transit2.setColumns(10);
		
		lbl_time_transit2 = new JLabel("Time(Transit)");
		lbl_time_transit2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_transit2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_transit2.setBounds(210, 351, 111, 20);
		transit_pane.add(lbl_time_transit2);
		
		textField_time_transit2 = new JTextField();
		textField_time_transit2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_transit2.setEditable(false);
		textField_time_transit2.setBounds(353, 351, 111, 20);
		transit_pane.add(textField_time_transit2);
		textField_time_transit2.setColumns(10);
		
		lbl_duration_transit = new JLabel("Duration");
		lbl_duration_transit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_duration_transit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_duration_transit.setBounds(481, 351, 75, 20);
		transit_pane.add(lbl_duration_transit);
		
		textField_duration_transit = new JTextField();
		textField_duration_transit.setEditable(false);
		textField_duration_transit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_duration_transit.setBounds(563, 351, 111, 20);
		transit_pane.add(textField_duration_transit);
		textField_duration_transit.setColumns(10);
		

		btn_book_transit = new JButton("Book");
		btn_book_transit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_book_transit.setBounds(303, 415, 105, 36);
		transit_pane.add(btn_book_transit);
		
		comboBox_transit = new JComboBox();
		comboBox_transit.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Premium"}));
		comboBox_transit.setBounds(353, 388, 111, 22);
		transit_pane.add(comboBox_transit);
		
		textField_price2 = new JTextField();
		textField_price2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price2.setEditable(false);
		textField_price2.setColumns(10);
		textField_price2.setBounds(578, 389, 96, 20);
		transit_pane.add(textField_price2);
		
		textField_price1 = new JTextField();
		textField_price1.setEditable(false);
		textField_price1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price1.setBounds(481, 389, 96, 20);
		transit_pane.add(textField_price1);
		textField_price1.setColumns(10);
		
	}
	
	public JButton getBtn_book_direct() {
		return btn_book_direct;
	}

	public void setBtn_book_direct(JButton btn_book_direct) {
		this.btn_book_direct = btn_book_direct;
	}

	public void setBtn_book_transit(JButton btn_book_transit) {
		this.btn_book_transit = btn_book_transit;
	}

	public JComboBox getComboBox_transit() {
		return comboBox_transit;
	}

	public void setComboBox_transit(JComboBox comboBox_transit) {
		this.comboBox_transit = comboBox_transit;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public void setDirectTableModel(DefaultTableModel a) {
		this.directTableModel = a;
	}
	// 
	public void setDirectTransitTableModel(DefaultTableModel a)
	{
		this.transitTableModel=a;
	}
	//
	public Border getDefault_top_border() {
		return default_top_border;
	}

	public Border getRed_top_border() {
		return red_top_border;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getTransit_pane() {
		return transit_pane;
	}

	public JPanel getDirect_pane() {
		return direct_pane;
	}

	public JTable getTable_direct() {
		return table_direct;
	}

	public JTable getTable_transit() {
		return table_transit;
	}

	public JScrollPane getScrollPane_direct() {
		return scrollPane_direct;
	}

	public JScrollPane getScrollPane_transit() {
		return scrollPane_transit;
	}

	public JTextField getTextField_flight_direct() {
		return textField_flight_direct;
	}

	public JTextField getTextField_carrier_direct() {
		return textField_carrier_direct;
	}

	public JTextField getTextField_date_direct() {
		return textField_date_direct;
	}

	public JTextField getTextField_fromto_direct() {
		return textField_fromto_direct;
	}

	public JTextField getTextField_time_direct() {
		return textField_time_direct;
	}

	public JTextField getTextField_price_direct() {
		return textField_price_direct;
	}

	public JTextField getTextField_duration_direct() {
		return textField_duration_direct;
	}

	public JTextField getTextField_flight_transit() {
		return textField_flight_transit;
	}
	public JTextField getTextField_flight_transit2() {
		return textField_flight_transit2;
	}

	public JTextField getTextField_carrier_transit() {
		return textField_carrier_transit;
	}

	public JTextField getTextField_date_transit() {
		return textField_date_transit;
	}

	public JTextField getTextField_fromto_transit1() {
		return textField_fromto_transit1;
	}

	public JTextField getTextField_time_transit1() {
		return textField_time_transit1;
	}

	public JTextField getTextField_price_transit() {
		return textField_price_transit;
	}

	public JTextField getTextField_fromto_transit2() {
		return textField_fomto_transit2;
	}

	public JTextField getTextField_time_transit2() {
		return textField_time_transit2;
	}

	public JTextField getTextField_duration_transit() {
		return textField_duration_transit;
	}

	public JButton getBtn_book_transit() {
		return btn_book_transit;
	}

	public List<String[]> getTableDataDirect() {
		return tableDataDirect;
	}

	public DefaultTableModel getDirectTableModel() {
		return directTableModel;
	}

	public void setTableDataDirect(ArrayList<String[]> a) {
		this.tableDataDirect = a; 
	}
	//// Test
	public List<String[]> getTableDataDirectTransit()
	{
		return tableDataTransit;
	}
	public DefaultTableModel getTransitTableModel()
	{
		return transitTableModel;
	}
	public void setTableDataTransit(ArrayList<String[]> a)
	{
		this.tableDataTransit=a;
	}
}

