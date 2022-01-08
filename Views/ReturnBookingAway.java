package Views;

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

public class ReturnBookingAway extends JFrame {
	Border default_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , new Color(240,240,240));
	Border red_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , Color.red);
	private JPanel contentPane_1;
	private JLabel lbl_transitflight_away;
	private JLabel lbl_directflight_away;
	private JPanel transit_pane_away;
	private JPanel direct_pane_away;
	private JTable table_direct_away;
	private JTable table_transit_away;
	private JScrollPane scrollPane_direct_away;
	private JScrollPane scrollPane_transit__away;
	private JLabel lbl_flight_direct_away;
	private JTextField textField_flight_direct_away;
	private JTextField textField_carrier_direct_away;
	private JLabel lbl_date_direct_away;
	private JTextField textField_date_direct_away;
	private JLabel lbl_fromto_away;
	private JTextField textField_fromto_direct_away;
	private JLabel lbl_time_direct_away;
	private JTextField textField_time_direct_away;
	private JLabel lbl_price_direct_away;
	private JTextField textField_price_direct_away;
	private JTextField textField_duration_direct_away;
	private JLabel lbl_flight_transit_away;
	private JTextField textField_flight_transit_away;
	private JLabel lbl_carrier_transit_away;
	private JTextField textField_carrier_transit_away;
	private JTextField textField_date_transit_away;
	private JTextField textField_fromto_transit1_away;
	private JTextField textField_time_transit1_away;
	private JTextField textField_price_transit_away;
	private JLabel lbl_fromto_transit2_away;
	private JTextField textField_fromto_transit2_away;
	private JLabel lbl_time_transit2_away;
	private JTextField textField_time_transit2_away;
	private JLabel lbl_duration_transit_away;
	private JTextField textField_duration_transit_away;
	private JButton btn_book_transit_away;
	private JPanel contentPane;
	private JLabel lbl_carrier_direct_away;
	private JButton btn_book_direct_away;
	private JLabel lbl_duration_direct_away;
	private JTextField textField_flight_transit_away2;
	
	private List<String[]> tableDataDirect;
	private DefaultTableModel directTableModel;
	//test
	private List<String[]> tableDataTransit;
	private DefaultTableModel transitTableModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBookingAway frame = new ReturnBookingAway();
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
		lbl_directflight_away.setBorder(red_top_border);
		lbl_transitflight_away.setBorder(default_top_border);
		direct_pane_away.setVisible(true);
		transit_pane_away.setVisible(false);
	}
	public ReturnBookingAway() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titel_away = new JLabel("Ticket Reservation (Away)");
		lbl_titel_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_titel_away.setBounds(240, 10, 203, 24);
		contentPane.add(lbl_titel_away);
		
		lbl_directflight_away = new JLabel("Direct Flight");
		lbl_directflight_away.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_directflight_away.setBorder(red_top_border);
				lbl_transitflight_away.setBorder(default_top_border);
				direct_pane_away.setVisible(true);
				transit_pane_away.setVisible(false);
			}
		});
		lbl_directflight_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_directflight_away.setOpaque(true);
		lbl_directflight_away.setBackground(new Color(175, 238, 238));
		lbl_directflight_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_directflight_away.setBounds(0, 37, 332, 31);
		contentPane.add(lbl_directflight_away);
		
		lbl_transitflight_away = new JLabel("Transit Flight");
		lbl_transitflight_away.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_transitflight_away.setBorder(red_top_border);
				lbl_directflight_away.setBorder(default_top_border);
				transit_pane_away.setVisible(true);
				direct_pane_away.setVisible(false);
			}
		});
		lbl_transitflight_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_transitflight_away.setOpaque(true);
		lbl_transitflight_away.setBackground(new Color(0, 255, 255));
		lbl_transitflight_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_transitflight_away.setBounds(331, 37, 363, 31);
		contentPane.add(lbl_transitflight_away);
		
		direct_pane_away = new JPanel();
		direct_pane_away.setBounds(0, 70, 694, 473);
		contentPane.add(direct_pane_away);
		direct_pane_away.setLayout(null);
		
		scrollPane_direct_away = new JScrollPane();
		scrollPane_direct_away.setBounds(0, 0, 694, 256);
		direct_pane_away.add(scrollPane_direct_away);
		table_direct_away = new JTable();
		scrollPane_direct_away.setViewportView(table_direct_away);
		table_direct_away.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Flight","Departure","Arrival","Duration","Price"
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
		
		lbl_flight_direct_away = new JLabel("Flight");
		lbl_flight_direct_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_direct_away.setBounds(83, 274, 60, 20);
		direct_pane_away.add(lbl_flight_direct_away);
		
		textField_flight_direct_away = new JTextField();
		textField_flight_direct_away.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_flight_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_direct_away.setEditable(false);
		textField_flight_direct_away.setBounds(153, 274, 111, 20);
		direct_pane_away.add(textField_flight_direct_away);
		textField_flight_direct_away.setColumns(10);
		
		lbl_carrier_direct_away = new JLabel("Carrier");
		lbl_carrier_direct_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_carrier_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_carrier_direct_away.setBounds(315, 274, 60, 20);
		direct_pane_away.add(lbl_carrier_direct_away);
		
		textField_carrier_direct_away = new JTextField();
		textField_carrier_direct_away.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_carrier_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_carrier_direct_away.setEditable(false);
		textField_carrier_direct_away.setBounds(385, 274, 111, 20);
		direct_pane_away.add(textField_carrier_direct_away);
		textField_carrier_direct_away.setColumns(10);
		
		lbl_date_direct_away = new JLabel("Date");
		lbl_date_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date_direct_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_date_direct_away.setBounds(510, 274, 60, 20);
		direct_pane_away.add(lbl_date_direct_away);
		
		textField_date_direct_away = new JTextField();
		textField_date_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_date_direct_away.setEditable(false);
		textField_date_direct_away.setBounds(575, 274, 111, 20);
		direct_pane_away.add(textField_date_direct_away);
		textField_date_direct_away.setColumns(10);
		
		lbl_fromto_away = new JLabel("From-To");
		lbl_fromto_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_away.setBounds(68, 312, 75, 20);
		direct_pane_away.add(lbl_fromto_away);
		
		textField_fromto_direct_away = new JTextField();
		textField_fromto_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_direct_away.setEditable(false);
		textField_fromto_direct_away.setBounds(153, 312, 111, 20);
		direct_pane_away.add(textField_fromto_direct_away);
		textField_fromto_direct_away.setColumns(10);
		
		lbl_time_direct_away = new JLabel("Time");
		lbl_time_direct_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_direct_away.setBounds(68, 351, 60, 20);
		direct_pane_away.add(lbl_time_direct_away);
		
		textField_time_direct_away = new JTextField();
		textField_time_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_direct_away.setEditable(false);
		textField_time_direct_away.setBounds(153, 351, 111, 20);
		direct_pane_away.add(textField_time_direct_away);
		textField_time_direct_away.setColumns(10);
		
		lbl_price_direct_away = new JLabel("Price");
		lbl_price_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_price_direct_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_price_direct_away.setBounds(510, 312, 60, 20);
		direct_pane_away.add(lbl_price_direct_away);
		
		textField_price_direct_away = new JTextField();
		textField_price_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price_direct_away.setEditable(false);
		textField_price_direct_away.setBounds(575, 312, 111, 20);
		direct_pane_away.add(textField_price_direct_away);
		textField_price_direct_away.setColumns(10);
		
		btn_book_direct_away = new JButton("Book");
		btn_book_direct_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_book_direct_away.setBounds(303, 415, 105, 36);
		direct_pane_away.add(btn_book_direct_away);
		
		lbl_duration_direct_away = new JLabel("Duration");
		lbl_duration_direct_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_duration_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_duration_direct_away.setBounds(312, 312, 75, 20);
		direct_pane_away.add(lbl_duration_direct_away);
		
		textField_duration_direct_away = new JTextField();
		textField_duration_direct_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_duration_direct_away.setEditable(false);
		textField_duration_direct_away.setBounds(385, 312, 111, 20);
		direct_pane_away.add(textField_duration_direct_away);
		textField_duration_direct_away.setColumns(10);
		
		transit_pane_away = new JPanel();
		transit_pane_away.setBounds(0, 70, 694, 473);
		contentPane.add(transit_pane_away);
		transit_pane_away.setLayout(null);
		
		scrollPane_transit__away = new JScrollPane();
		scrollPane_transit__away.setBackground(Color.WHITE);
		scrollPane_transit__away.setBounds(0, 0, 694, 256);
		transit_pane_away.add(scrollPane_transit__away);
		
		table_transit_away = new JTable();
		scrollPane_transit__away.setViewportView(table_transit_away);
		table_transit_away.setModel(new DefaultTableModel(
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
		
		textField_carrier_transit_away = new JTextField();
		textField_carrier_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_carrier_transit_away.setEditable(false);
		textField_carrier_transit_away.setBounds(563, 274, 111, 20);
		transit_pane_away.add(textField_carrier_transit_away);
		textField_carrier_transit_away.setColumns(10);
		
		lbl_flight_transit_away = new JLabel("Flight");
		lbl_flight_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_transit_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_transit_away.setBounds(10, 274, 60, 20);
		transit_pane_away.add(lbl_flight_transit_away);
		
		textField_flight_transit_away = new JTextField();
		textField_flight_transit_away.setEditable(false);
		textField_flight_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_transit_away.setBounds(80, 274, 111, 20);
		transit_pane_away.add(textField_flight_transit_away);
		textField_flight_transit_away.setColumns(10);
		
		lbl_carrier_transit_away = new JLabel("Carrier");
		lbl_carrier_transit_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_carrier_transit_away.setBounds(481, 274, 60, 20);
		transit_pane_away.add(lbl_carrier_transit_away);
		
		JLabel lbl_date_transit_away = new JLabel("Date");
		lbl_date_transit_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_date_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date_transit_away.setBounds(481, 312, 60, 20);
		transit_pane_away.add(lbl_date_transit_away);
		
		textField_date_transit_away = new JTextField();
		textField_date_transit_away.setEditable(false);
		textField_date_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_date_transit_away.setBounds(563, 312, 111, 20);
		transit_pane_away.add(textField_date_transit_away);
		textField_date_transit_away.setColumns(10);
		
		JLabel lbl_fromto_transit1_away = new JLabel("From-To");
		lbl_fromto_transit1_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_transit1_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_transit1_away.setBounds(0, 312, 75, 20);
		transit_pane_away.add(lbl_fromto_transit1_away);
		
		textField_fromto_transit1_away = new JTextField();
		textField_fromto_transit1_away.setEditable(false);
		textField_fromto_transit1_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_transit1_away.setBounds(80, 312, 111, 20);
		transit_pane_away.add(textField_fromto_transit1_away);
		textField_fromto_transit1_away.setColumns(10);
		
		JLabel lbl_time_transit1_away = new JLabel("Time");
		lbl_time_transit1_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_transit1_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_transit1_away.setBounds(10, 351, 60, 20);
		transit_pane_away.add(lbl_time_transit1_away);
		
		textField_time_transit1_away = new JTextField();
		textField_time_transit1_away.setEditable(false);
		textField_time_transit1_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_transit1_away.setBounds(80, 351, 111, 20);
		transit_pane_away.add(textField_time_transit1_away);
		textField_time_transit1_away.setColumns(10);
		
		JLabel lbl_price_transit_away = new JLabel("Price");
		lbl_price_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_price_transit_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_price_transit_away.setBounds(481, 389, 60, 20);
		transit_pane_away.add(lbl_price_transit_away);
		
		textField_price_transit_away = new JTextField();
		textField_price_transit_away.setEditable(false);
		textField_price_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_price_transit_away.setBounds(563, 389, 111, 20);
		transit_pane_away.add(textField_price_transit_away);
		textField_price_transit_away.setColumns(10);
		
		lbl_fromto_transit2_away = new JLabel("From-To(Transit)");
		lbl_fromto_transit2_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_fromto_transit2_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fromto_transit2_away.setBounds(210, 312, 145, 20);
		transit_pane_away.add(lbl_fromto_transit2_away);
		
		textField_fromto_transit2_away = new JTextField();
		textField_fromto_transit2_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fromto_transit2_away.setEditable(false);
		textField_fromto_transit2_away.setBounds(352, 312, 111, 20);
		transit_pane_away.add(textField_fromto_transit2_away);
		textField_fromto_transit2_away.setColumns(10);
		
		lbl_time_transit2_away = new JLabel("Time(Transit)");
		lbl_time_transit2_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_time_transit2_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time_transit2_away.setBounds(210, 351, 111, 20);
		transit_pane_away.add(lbl_time_transit2_away);
		
		textField_time_transit2_away = new JTextField();
		textField_time_transit2_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_time_transit2_away.setEditable(false);
		textField_time_transit2_away.setBounds(353, 351, 111, 20);
		transit_pane_away.add(textField_time_transit2_away);
		textField_time_transit2_away.setColumns(10);
		
		lbl_duration_transit_away = new JLabel("Duration");
		lbl_duration_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_duration_transit_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_duration_transit_away.setBounds(481, 351, 75, 20);
		transit_pane_away.add(lbl_duration_transit_away);
		
		textField_duration_transit_away = new JTextField();
		textField_duration_transit_away.setEditable(false);
		textField_duration_transit_away.setHorizontalAlignment(SwingConstants.CENTER);
		textField_duration_transit_away.setBounds(563, 351, 111, 20);
		transit_pane_away.add(textField_duration_transit_away);
		textField_duration_transit_away.setColumns(10);
		
		btn_book_transit_away = new JButton("Book");
		btn_book_transit_away.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_book_transit_away.setBounds(303, 415, 105, 36);
		transit_pane_away.add(btn_book_transit_away);
		
		JLabel lbl_flight_transit_away2 = new JLabel("Flight(Transit)");
		lbl_flight_transit_away2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flight_transit_away2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_flight_transit_away2.setBounds(210, 274, 145, 20);
		transit_pane_away.add(lbl_flight_transit_away2);
		
		textField_flight_transit_away2 = new JTextField();
		textField_flight_transit_away2.setEditable(false);
		textField_flight_transit_away2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_flight_transit_away2.setBounds(353, 274, 111, 20);
		transit_pane_away.add(textField_flight_transit_away2);
		textField_flight_transit_away2.setColumns(10);
		
	}

	public Border getDefault_top_border() {
		return default_top_border;
	}

	public Border getRed_top_border() {
		return red_top_border;
	}

	public JPanel getContentPane_1() {
		return contentPane_1;
	}

	public JLabel getLbl_transitflight_away() {
		return lbl_transitflight_away;
	}

	public JLabel getLbl_directflight_away() {
		return lbl_directflight_away;
	}

	public JPanel getTransit_pane_away() {
		return transit_pane_away;
	}

	public JPanel getDirect_pane_away() {
		return direct_pane_away;
	}

	public JTable getTable_direct_away() {
		return table_direct_away;
	}

	public JTable getTable_transit_away() {
		return table_transit_away;
	}

	public JScrollPane getScrollPane_direct_away() {
		return scrollPane_direct_away;
	}

	public JScrollPane getScrollPane_transit__away() {
		return scrollPane_transit__away;
	}

	public JLabel getLbl_flight_direct_away() {
		return lbl_flight_direct_away;
	}

	public JTextField getTextField_flight_direct_away() {
		return textField_flight_direct_away;
	}

	public JTextField getTextField_carrier_direct_away() {
		return textField_carrier_direct_away;
	}

	public JLabel getLbl_date_direct_away() {
		return lbl_date_direct_away;
	}

	public JTextField getTextField_date_direct_away() {
		return textField_date_direct_away;
	}

	public JLabel getLbl_fromto_away() {
		return lbl_fromto_away;
	}

	public JTextField getTextField_fromto_direct_away() {
		return textField_fromto_direct_away;
	}

	public JLabel getLbl_time_direct_away() {
		return lbl_time_direct_away;
	}

	public JTextField getTextField_time_direct_away() {
		return textField_time_direct_away;
	}

	public JLabel getLbl_price_direct_away() {
		return lbl_price_direct_away;
	}

	public JTextField getTextField_price_direct_away() {
		return textField_price_direct_away;
	}

	public JTextField getTextField_duration_direct_away() {
		return textField_duration_direct_away;
	}

	public JLabel getLbl_flight_transit_away() {
		return lbl_flight_transit_away;
	}

	public JTextField getTextField_flight_transit_away() {
		return textField_flight_transit_away;
	}

	public JLabel getLbl_carrier_transit_away() {
		return lbl_carrier_transit_away;
	}

	public JTextField getTextField_carrier_transit_away() {
		return textField_carrier_transit_away;
	}

	public JTextField getTextField_date_transit_away() {
		return textField_date_transit_away;
	}

	public JTextField getTextField_fromto_transit1_away() {
		return textField_fromto_transit1_away;
	}

	public JTextField getTextField_time_transit1_away() {
		return textField_time_transit1_away;
	}

	public JTextField getTextField_price_transit_away() {
		return textField_price_transit_away;
	}

	public JLabel getLbl_fromto_transit2_away() {
		return lbl_fromto_transit2_away;
	}

	public JTextField getTextField_fromto_transit2_away() {
		return textField_fromto_transit2_away;
	}

	public JLabel getLbl_time_transit2_away() {
		return lbl_time_transit2_away;
	}

	public JTextField getTextField_time_transit2_away() {
		return textField_time_transit2_away;
	}

	public JLabel getLbl_duration_transit_away() {
		return lbl_duration_transit_away;
	}

	public JTextField getTextField_duration_transit_away() {
		return textField_duration_transit_away;
	}

	public JButton getBtn_book_transit_away() {
		return btn_book_transit_away;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getLbl_carrier_direct_away() {
		return lbl_carrier_direct_away;
	}

	public JButton getBtn_book_direct_away() {
		return btn_book_direct_away;
	}

	public JLabel getLbl_duration_direct_away() {
		return lbl_duration_direct_away;
	}

	public JTextField getTextField_flight_transit_away2() {
		return textField_flight_transit_away2;
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
	// 
	public void setTransitTableModel(DefaultTableModel a)
	{
		this.transitTableModel=a;
	}
}
