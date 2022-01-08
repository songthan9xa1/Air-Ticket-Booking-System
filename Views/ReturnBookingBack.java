ReturnBookingBack.package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ReturnBookingBack extends JFrame {
	Border default_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , new Color(240,240,240));
	Border red_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , Color.red);
	private JLabel lbl_transitflight_back;
	private JLabel lbl_directflight_back;
	private JPanel transit_pane_back;
	private JPanel direct_pane_back;
	private JTable table_direct_back;
	private JTable table_transit_back;
	private JScrollPane scrollPane_direct_back;
	private JScrollPane scrollPane_transit_back;
	private JLabel lbl_flight_direct_back;
	private JTextField textField_flight_direct_back;
	private JTextField textField_carrier_direct_back;
	private JLabel lbl_date_direct_back;
	private JTextField textField_date_direct_back;
	private JLabel lbl_fromto_back;
	private JTextField textField_fromto_direct_back;
	private JLabel lbl_time_direct_back;
	private JTextField textField_time_direct_back;
	private JLabel lbl_price_direct_back;
	private JTextField textField_price_direct_back;
	private JTextField textField_duration_direct_back;
	private JLabel lbl_flight_transit_back;
	private JTextField textField_flight_transit_back;
	private JLabel lbl_carrier_transit_back;
	private JTextField textField_carrier_transit_back;
	private JTextField textField_date_transit_back;
	private JTextField textField_fromto_transit1_back;
	private JTextField textField_time_transit1_back;
	private JTextField textField_price_transit_back;
	private JLabel lbl_fromto_transit2_back;
	private JLabel lbl_time_transit2_back;
	private JTextField textField_time_transit2_back;
	private JLabel lbl_duration_transit_back;
	private JTextField textField_duration_transit_back;
	private JButton btn_book_transit_back;
	private JPanel contentPane;
	private JLabel lbl_time_transit1_back;
	private JLabel lbl_price_transit_back;
	private JLabel lbl_carrier_direct_back;
	private JButton btn_book_direct_back;
	private JLabel lbl_duration_direct_back;
	private JLabel lbl_flight_transit_back2;
	private JTextField textField_flight_transit_back2;

	private List<String[]> tableDataDirect;
	private DefaultTableModel directTableModel;
	//test
	private List<String[]> tableDataTransit;
	private DefaultTableModel transitTableModel;
	
	private JTextField textField_fromto_transit2_back;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBookingBack frame = new ReturnBookingBack();
					frame.setVisible(true);
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void start()
	{
		lbl_directflight_back.setBorder(red_top_border);
		lbl_transitflight_back.setBorder(default_top_border);
		direct_pane_back.setVisible(true);
		transit_pane_back.setVisible(false);
	}
	/**
	 * Create the frame.
	 */
	public ReturnBookingBack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titel_back = new JLabel("Ticket Reservation(Back)");
		lbl_titel_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_titel_back.setBounds(236, 10, 193, 24);
		contentPane.add(lbl_titel_back);
		
		lbl_directflight_back = new JLabel("Direct Flight");
		lbl_directflight_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_directflight_back.setBorder(red_top_border);
				lbl_transitflight_back.setBorder(default_top_border);
				direct_pane_back.setVisible(true);
				transit_pane_back.setVisible(false);
			}
		});
		lbl_directflight_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_directflight_back.setOpaque(true);
		lbl_directflight_back.setBackground(new Color(175, 238, 238));
		lbl_directflight_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_directflight_back.setBounds(0, 37, 332, 31);
		contentPane.add(lbl_directflight_back);
		
		lbl_transitflight_back = new JLabel("Transit Flight");
		lbl_transitflight_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_transitflight_back.setBorder(red_top_border);
				lbl_directflight_back.setBorder(default_top_border);
				transit_pane_back.setVisible(true);
				direct_pane_back.setVisible(false);
			}
		});
		lbl_transitflight_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_transitflight_back.setOpaque(true);
		lbl_transitflight_back.setBackground(new Color(0, 255, 255));
		lbl_transitflight_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_transitflight_back.setBounds(331, 37, 363, 31);
		contentPane.add(lbl_transitflight_back);
		
		direct_pane_back = new JPanel();
		direct_pane_back.setBounds(0, 70, 694, 473);
		contentPane.add(direct_pane_back);
		direct_pane_back.setLayout(null);
		
		scrollPane_direct_back = new JScrollPane();
		scrollPane_direct_back.setBounds(0, 0, 694, 256);
		direct_pane_back.add(scrollPane_direct_back);
		table_direct_back = new JTable();
		scrollPane_direct_back.setViewportView(table_direct_back);
		table_direct_back.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Departure","Arrival","Duration","Price"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class,Object.class, Object.class, Object.class, Object.class
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
		
		lbl_flight_direct_back = new JLabel("Flight");
		lbl_flight_direct_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_direct_back.setBounds(83, 274, 60, 20);
		direct_pane_back.add(lbl_flight_direct_back);
		
		textField_flight_direct_back = new JTextField();
		textField_flight_direct_back.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_flight_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_direct_back.setEditable(false);
		textField_flight_direct_back.setBounds(153, 274, 111, 20);
		direct_pane_back.add(textField_flight_direct_back);
		textField_flight_direct_back.setColumns(10);
		
		lbl_carrier_direct_back = new JLabel("Carrier");
		lbl_carrier_direct_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_carrier_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_carrier_direct_back.setBounds(315, 274, 60, 20);
		direct_pane_back.add(lbl_carrier_direct_back);
		
		textField_carrier_direct_back = new JTextField();
		textField_carrier_direct_back.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_carrier_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_carrier_direct_back.setEditable(false);
		textField_carrier_direct_back.setBounds(385, 274, 111, 20);
		direct_pane_back.add(textField_carrier_direct_back);
		textField_carrier_direct_back.setColumns(10);
		
		lbl_date_direct_back = new JLabel("Date");
		lbl_date_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date_direct_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_date_direct_back.setBounds(510, 274, 60, 20);
		direct_pane_back.add(lbl_date_direct_back);
		
		textField_date_direct_back = new JTextField();
		textField_date_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_date_direct_back.setEditable(false);
		textField_date_direct_back.setBounds(575, 274, 111, 20);
		direct_pane_back.add(textField_date_direct_back);
		textField_date_direct_back.setColumns(10);
		
		lbl_fromto_back = new JLabel("From-To");
		lbl_fromto_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_back.setBounds(68, 312, 75, 20);
		direct_pane_back.add(lbl_fromto_back);
		
		textField_fromto_direct_back = new JTextField();
		textField_fromto_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_direct_back.setEditable(false);
		textField_fromto_direct_back.setBounds(153, 312, 111, 20);
		direct_pane_back.add(textField_fromto_direct_back);
		textField_fromto_direct_back.setColumns(10);
		
		lbl_time_direct_back = new JLabel("Time");
		lbl_time_direct_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_direct_back.setBounds(68, 351, 60, 20);
		direct_pane_back.add(lbl_time_direct_back);
		
		textField_time_direct_back = new JTextField();
		textField_time_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_direct_back.setEditable(false);
		textField_time_direct_back.setBounds(153, 351, 111, 20);
		direct_pane_back.add(textField_time_direct_back);
		textField_time_direct_back.setColumns(10);
		
		lbl_price_direct_back = new JLabel("Price");
		lbl_price_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_price_direct_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_price_direct_back.setBounds(510, 312, 60, 20);
		direct_pane_back.add(lbl_price_direct_back);
		
		textField_price_direct_back = new JTextField();
		textField_price_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price_direct_back.setEditable(false);
		textField_price_direct_back.setBounds(575, 312, 111, 20);
		direct_pane_back.add(textField_price_direct_back);
		textField_price_direct_back.setColumns(10);
		
		btn_book_direct_back = new JButton("Book");
		btn_book_direct_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_book_direct_back.setBounds(303, 415, 105, 36);
		direct_pane_back.add(btn_book_direct_back);
		
		lbl_duration_direct_back = new JLabel("Duration");
		lbl_duration_direct_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_duration_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_duration_direct_back.setBounds(312, 312, 75, 20);
		direct_pane_back.add(lbl_duration_direct_back);
		
		textField_duration_direct_back = new JTextField();
		textField_duration_direct_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_duration_direct_back.setEditable(false);
		textField_duration_direct_back.setBounds(385, 312, 111, 20);
		direct_pane_back.add(textField_duration_direct_back);
		textField_duration_direct_back.setColumns(10);
		
		transit_pane_back = new JPanel();
		transit_pane_back.setBounds(0, 70, 694, 473);
		contentPane.add(transit_pane_back);
		transit_pane_back.setLayout(null);
		
		scrollPane_transit_back = new JScrollPane();
		scrollPane_transit_back.setBackground(Color.WHITE);
		scrollPane_transit_back.setBounds(0, 0, 694, 256);
		transit_pane_back.add(scrollPane_transit_back);
		
		table_transit_back = new JTable();
		scrollPane_transit_back.setViewportView(table_transit_back);
		table_transit_back.setModel(new DefaultTableModel(
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
		
		textField_carrier_transit_back = new JTextField();
		textField_carrier_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_carrier_transit_back.setEditable(false);
		textField_carrier_transit_back.setBounds(563, 274, 111, 20);
		transit_pane_back.add(textField_carrier_transit_back);
		textField_carrier_transit_back.setColumns(10);
		
		lbl_flight_transit_back = new JLabel("Flight");
		lbl_flight_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_transit_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_transit_back.setBounds(10, 274, 60, 20);
		transit_pane_back.add(lbl_flight_transit_back);
		
		textField_flight_transit_back = new JTextField();
		textField_flight_transit_back.setEditable(false);
		textField_flight_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_transit_back.setBounds(80, 274, 111, 20);
		transit_pane_back.add(textField_flight_transit_back);
		textField_flight_transit_back.setColumns(10);
		
		lbl_carrier_transit_back = new JLabel("Carrier");
		lbl_carrier_transit_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_carrier_transit_back.setBounds(481, 274, 60, 20);
		transit_pane_back.add(lbl_carrier_transit_back);
		
		JLabel lbl_date_transit_back = new JLabel("Date");
		lbl_date_transit_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_date_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date_transit_back.setBounds(481, 312, 60, 20);
		transit_pane_back.add(lbl_date_transit_back);
		
		textField_date_transit_back = new JTextField();
		textField_date_transit_back.setEditable(false);
		textField_date_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_date_transit_back.setBounds(563, 312, 111, 20);
		transit_pane_back.add(textField_date_transit_back);
		textField_date_transit_back.setColumns(10);
		
		JLabel lbl_fromto_transit1_back = new JLabel("From-To");
		lbl_fromto_transit1_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_transit1_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_transit1_back.setBounds(0, 312, 75, 20);
		transit_pane_back.add(lbl_fromto_transit1_back);
		
		textField_fromto_transit1_back = new JTextField();
		textField_fromto_transit1_back.setEditable(false);
		textField_fromto_transit1_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_transit1_back.setBounds(80, 312, 111, 20);
		transit_pane_back.add(textField_fromto_transit1_back);
		textField_fromto_transit1_back.setColumns(10);
		
		lbl_time_transit1_back = new JLabel("Time");
		lbl_time_transit1_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_transit1_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_transit1_back.setBounds(10, 351, 60, 20);
		transit_pane_back.add(lbl_time_transit1_back);
		
		textField_time_transit1_back = new JTextField();
		textField_time_transit1_back.setEditable(false);
		textField_time_transit1_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_transit1_back.setBounds(80, 351, 111, 20);
		transit_pane_back.add(textField_time_transit1_back);
		textField_time_transit1_back.setColumns(10);
		
		lbl_price_transit_back = new JLabel("Price");
		lbl_price_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_price_transit_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_price_transit_back.setBounds(481, 389, 60, 20);
		transit_pane_back.add(lbl_price_transit_back);
		
		textField_price_transit_back = new JTextField();
		textField_price_transit_back.setEditable(false);
		textField_price_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price_transit_back.setBounds(563, 389, 111, 20);
		transit_pane_back.add(textField_price_transit_back);
		textField_price_transit_back.setColumns(10);
		
		lbl_fromto_transit2_back = new JLabel("From-To(Transit)");
		lbl_fromto_transit2_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_transit2_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_transit2_back.setBounds(201, 312, 145, 20);
		transit_pane_back.add(lbl_fromto_transit2_back);
		
		textField_fromto_transit2_back = new JTextField();
		textField_fromto_transit2_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_transit2_back.setEditable(false);
		textField_fromto_transit2_back.setBounds(352, 312, 111, 20);
		transit_pane_back.add(textField_fromto_transit2_back);
		textField_fromto_transit2_back.setColumns(10);
		
		lbl_time_transit2_back = new JLabel("Time(Transit)");
		lbl_time_transit2_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_transit2_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_transit2_back.setBounds(210, 351, 111, 20);
		transit_pane_back.add(lbl_time_transit2_back);
		
		textField_time_transit2_back = new JTextField();
		textField_time_transit2_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_transit2_back.setEditable(false);
		textField_time_transit2_back.setBounds(353, 351, 111, 20);
		transit_pane_back.add(textField_time_transit2_back);
		textField_time_transit2_back.setColumns(10);
		
		lbl_duration_transit_back = new JLabel("Duration");
		lbl_duration_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_duration_transit_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_duration_transit_back.setBounds(481, 351, 75, 20);
		transit_pane_back.add(lbl_duration_transit_back);
		
		textField_duration_transit_back = new JTextField();
		textField_duration_transit_back.setEditable(false);
		textField_duration_transit_back.setHorizontalAlignment(SwingConstants.CENTER);
		textField_duration_transit_back.setBounds(563, 351, 111, 20);
		transit_pane_back.add(textField_duration_transit_back);
		textField_duration_transit_back.setColumns(10);
		
		btn_book_transit_back = new JButton("Book");
		btn_book_transit_back.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_book_transit_back.setBounds(303, 415, 105, 36);
		transit_pane_back.add(btn_book_transit_back);
		
		lbl_flight_transit_back2 = new JLabel("Flight(Transit)");
		lbl_flight_transit_back2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_transit_back2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_transit_back2.setBounds(210, 274, 145, 20);
		transit_pane_back.add(lbl_flight_transit_back2);
		
		textField_flight_transit_back2 = new JTextField();
		textField_flight_transit_back2.setEditable(false);
		textField_flight_transit_back2.setBounds(353, 274, 111, 20);
		transit_pane_back.add(textField_flight_transit_back2);
		textField_flight_transit_back2.setColumns(10);
		
	}
	public Border getDefault_top_border() {
		return default_top_border;
	}

	public Border getRed_top_border() {
		return red_top_border;
	}

	public JPanel getContentPane_1() {
		return contentPane;
	}

	public JLabel getLbl_transitflight_back() {
		return lbl_transitflight_back;
	}

	public JLabel getLbl_directflight_back() {
		return lbl_directflight_back;
	}

	public JPanel getTransit_pane_back() {
		return transit_pane_back;
	}

	public JPanel getDirect_pane_back() {
		return direct_pane_back;
	}

	public JTable getTable_direct_back() {
		return table_direct_back;
	}

	public JTable getTable_transit_back() {
		return table_transit_back;
	}

	public JScrollPane getScrollPane_direct_back() {
		return scrollPane_direct_back;
	}

	public JScrollPane getScrollPane_transit__back() {
		return scrollPane_transit_back;
	}

	public JLabel getLbl_flight_direct_back() {
		return lbl_flight_direct_back;
	}

	public JTextField getTextField_flight_direct_back() {
		return textField_flight_direct_back;
	}

	public JTextField getTextField_carrier_direct_back() {
		return textField_carrier_direct_back;
	}

	public JLabel getLbl_date_direct_back() {
		return lbl_date_direct_back;
	}

	public JTextField getTextField_date_direct_back() {
		return textField_date_direct_back;
	}

	public JLabel getLbl_fromto_back() {
		return lbl_fromto_back;
	}

	public JTextField getTextField_fromto_direct_back() {
		return textField_fromto_direct_back;
	}

	public JLabel getLbl_time_direct_back() {
		return lbl_time_direct_back;
	}

	public JTextField getTextField_time_direct_back() {
		return textField_time_direct_back;
	}

	public JLabel getLbl_price_direct_back() {
		return lbl_price_direct_back;
	}

	public JTextField getTextField_price_direct_back() {
		return textField_price_direct_back;
	}

	public JTextField getTextField_duration_direct_back() {
		return textField_duration_direct_back;
	}

	public JLabel getLbl_flight_transit_back() {
		return lbl_flight_transit_back;
	}

	public JTextField getTextField_flight_transit_back() {
		return textField_flight_transit_back;
	}

	public JLabel getLbl_carrier_transit_back() {
		return lbl_carrier_transit_back;
	}

	public JTextField getTextField_carrier_transit_back() {
		return textField_carrier_transit_back;
	}

	public JTextField getTextField_date_transit_back() {
		return textField_date_transit_back;
	}

	public JTextField getTextField_fromto_transit1_back() {
		return textField_fromto_transit1_back;
	}

	public JTextField getTextField_time_transit1_back() {
		return textField_time_transit1_back;
	}

	public JTextField getTextField_price_transit_back() {
		return textField_price_transit_back;
	}

	public JLabel getLbl_fromto_transit2_back() {
		return lbl_fromto_transit2_back;
	}

	public JTextField getTextField_fromto_transit2_back() {
		return textField_fromto_transit2_back;
	}

	public JLabel getLbl_time_transit2_back() {
		return lbl_time_transit2_back;
	}

	public JTextField getTextField_time_transit2_back() {
		return textField_time_transit2_back;
	}

	public JLabel getLbl_duration_transit_back() {
		return lbl_duration_transit_back;
	}

	public JTextField getTextField_duration_transit_back() {
		return textField_duration_transit_back;
	}

	public JButton getBtn_book_transit_back() {
		return btn_book_transit_back;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getLbl_carrier_direct_back() {
		return lbl_carrier_direct_back;
	}

	public JButton getBtn_book_direct_back() {
		return btn_book_direct_back;
	}

	public JLabel getLbl_duration_direct_back() {
		return lbl_duration_direct_back;
	}

	public JTextField getTextField_flight_transit_back2() {
		return textField_flight_transit_back2;
	}

	public List<String[]> getTableDataDirect() {
		return tableDataDirect;
	}

	public DefaultTableModel getDirectTableModel() {
		return directTableModel;
	}

	public List<String[]> getTableDataTransit() {
		return tableDataTransit;
	}

	public DefaultTableModel getTransitTableModel() {
		return transitTableModel;
	}
	public void setTableDataDirect(ArrayList<String[]> a) {
		this.tableDataDirect = a; 
	}
	public void setTableDataTransit(ArrayList<String[]> a)
	{
		this.tableDataTransit=a;
	}
	public void setDirectTableModel(DefaultTableModel a) {
		this.directTableModel = a;
	}
	public void setTransitTableModel(DefaultTableModel a)
	{
		this.transitTableModel=a;
	}
	
}
