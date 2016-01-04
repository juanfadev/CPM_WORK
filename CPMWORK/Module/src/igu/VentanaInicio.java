package igu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Catalog;
import logic.Cruise;
import logic.Extra;
import logic.Pedido;
import logic.Registro;
import logic.Room;
import logic.Usuario;

import java.awt.GridLayout;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.LoaderHandler;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.awt.event.InputEvent;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Desktop.Action;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.Font;

public class VentanaInicio extends JFrame {

	private JPanel pnPrincipal;
	private JPanel pnPasos;
	private JToggleButton tglbtnHome;
	private JToggleButton tglbtnRooms;
	private JToggleButton tglbtnPersonalData;
	private JToggleButton tglbtnConfirmation;
	private JToggleButton tglbtnPayout;
	private JPanel pnCentral;
	private JToggleButton tglbtnSearch;
	private JPanel pnHome;

	private Catalog catalogo;
	private Pedido pedido;
	private Cruise crucero;
	private Registro register;
	private JPanel pnSearch;
	private JPanel pnRooms;
	private JPanel pnConfirmation;
	private JPanel pnDetails;
	private JPanel pnSearchDet;
	private JPanel pnSearchBut;
	private JLabel lblFrom;
	private JTextField txtDateFrom;
	private JLabel lblTo;
	private JTextField txtDateTo;
	private JLabel lblDestination;
	private JComboBox cbDest;
	private JButton btnSearch;
	private JButton btnDetails;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private JMenuItem menuItem;
	private JCheckBoxMenuItem chckbxmntmTooltips;
	private JMenuItem mntmRestart;
	private JTabbedPane tpDetails;
	private JPanel pnPictures;
	private JPanel pnInfo;
	private Locale localizacion = Locale.getDefault(Locale.Category.FORMAT);
	private JTable tCruises;
	private ModeloNoEditable modeloTabla;
	private JButton btnBook;
	private JScrollPane scCruises;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblPicture;
	private JLabel lblDenominacion;
	private JLabel lblZona;
	private JLabel lblSalida;
	private JLabel lblItinerario;
	private JLabel lblAptoMenores;
	private JLabel lblDuracion;
	private JLabel lblBarco;
	private JLabel lblDate;
	private JTextArea taDescripcion;
	private JPanel pnIn;
	private JScrollPane spRooms;
	private JTable tRooms;
	private ModeloNoEditable modeloRooms;
	private JPanel pnRoomBtn;
	private JButton btnAddRoom;
	private JButton btnRemove;
	private VentanaAddRoom vAR;
	private JPanel pnRecommended;
	private JPanel pnSearchButton;
	private JButton btnSearch_1;
	private JPanel pnPersonalData;
	private JPanel pnPayout;
	private JButton btnPrintReceipt;
	private JPanel pnPersonalButtons;
	private JButton btnRegister;
	private JButton btnNext_1;
	private JPanel pnLogIn;
	private JPanel pnRegister;
	private JLabel lblIdLogin;
	private JTextField txIDLogin;
	private JLabel lblPasswordLogIn;
	private JButton btnLogIn;
	private JPasswordField passwordLogIn;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblId;
	private JLabel lblPhoneNumber;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JTextField txID;
	private JTextField txName;
	private JTextField txSurname;
	private JTextField txEmail;
	private JTextField txPhone;
	private JPasswordField passwordRegister;
	private JButton btnContinueWithoutRegistering;
	private JPanel pnUserInfo;
	private JPanel pnPedidoInfo;
	private JLabel lblName_1;
	private JLabel lblSurname_1;
	private JLabel lblPhone_1;
	private JLabel lblEmail_1;
	private JLabel lblId_1;
	private JButton btnOffer1;
	private JButton btnOffer2;
	private JButton btnConfirm;
	private JButton btnSaveReceipt;
	private JButton btnCancelBooking;
	private JPanel pnPayoutBtns;
	private JLabel lblBookingSucceed;
	private JScrollPane spPedido;
	private JTextPane txpnPedidoInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		catalogo = new Catalog(localizacion);
		pedido = new Pedido();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 380);
		setJMenuBar(getMenuBar_1());
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnPasos(), BorderLayout.NORTH);
		pnPrincipal.add(getPnCentral(), BorderLayout.CENTER);
		restart();
	}

	private JPanel getPnPasos() {
		if (pnPasos == null) {
			pnPasos = new JPanel();
			pnPasos.setLayout(new GridLayout(1, 0, 0, 0));
			pnPasos.add(getTglbtnHome());
			pnPasos.add(getTglbtnSearch());
			pnPasos.add(getTglbtnRooms());
			pnPasos.add(getTglbtnPersonalData());
			pnPasos.add(getTglbtnConfirmation());
			pnPasos.add(getTglbtnPayout());
		}
		return pnPasos;
	}

	private JToggleButton getTglbtnHome() {
		if (tglbtnHome == null) {
			tglbtnHome = new JToggleButton("Home");
			tglbtnHome.setMnemonic('h');
			tglbtnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					toggleAllButtons(tglbtnHome);
					disableAllButtons(tglbtnHome);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelHome");
				}
			});
		}
		return tglbtnHome;
	}

	private JToggleButton getTglbtnRooms() {
		if (tglbtnRooms == null) {
			tglbtnRooms = new JToggleButton("Rooms");
			tglbtnRooms.setEnabled(false);
			tglbtnRooms.setMnemonic('r');
			tglbtnRooms.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					toggleAllButtons(tglbtnRooms);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelRooms");
				}
			});
		}
		return tglbtnRooms;
	}

	private JToggleButton getTglbtnPersonalData() {
		if (tglbtnPersonalData == null) {
			tglbtnPersonalData = new JToggleButton("Personal Data");
			tglbtnPersonalData.setEnabled(false);
			tglbtnPersonalData.setMnemonic('e');
			tglbtnPersonalData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					toggleAllButtons(tglbtnPersonalData);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelPersonalData");
				}
			});
		}
		return tglbtnPersonalData;
	}

	private JToggleButton getTglbtnConfirmation() {
		if (tglbtnConfirmation == null) {
			tglbtnConfirmation = new JToggleButton("Confirmation");
			tglbtnConfirmation.setEnabled(false);
			tglbtnConfirmation.setMnemonic('c');
			tglbtnConfirmation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					toggleAllButtons(tglbtnConfirmation);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelConfirmation");
					getTxpnPedidoInfo().setText(pedido.toString());
					loadConfirmation();
				}
			});
		}
		return tglbtnConfirmation;
	}

	private JToggleButton getTglbtnPayout() {
		if (tglbtnPayout == null) {
			tglbtnPayout = new JToggleButton("Payout");
			tglbtnPayout.setEnabled(false);
			tglbtnPayout.setMnemonic('p');
			tglbtnPayout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					toggleAllButtons(tglbtnPayout);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelPayout");
				}
			});
		}
		return tglbtnPayout;
	}

	private JToggleButton getTglbtnSearch() {
		if (tglbtnSearch == null) {
			tglbtnSearch = new JToggleButton("Search");
			tglbtnSearch.setEnabled(false);
			tglbtnSearch.setMnemonic('s');
			tglbtnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					toggleAllButtons(tglbtnSearch);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelSearch");
				}
			});
		}
		return tglbtnSearch;
	}

	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new CardLayout(0, 0));
			pnCentral.add(getPnHome(), "panelHome");
			pnCentral.add(getPnSearch(), "panelSearch");
			pnCentral.add(getPnDetails(), "panelDetails");
			pnCentral.add(getPnRooms(), "panelRooms");
			pnCentral.add(getPnPersonalData(), "panelPersonalData");
			pnCentral.add(getPnConfirmation(), "panelConfirmation");
			pnCentral.add(getPnPayout(), "panelPayout");
		}
		return pnCentral;
	}

	private JPanel getPnHome() {
		if (pnHome == null) {
			pnHome = new JPanel();
			pnHome.setLayout(new BorderLayout(0, 0));
			pnHome.add(getPnRecommended(), BorderLayout.CENTER);
			pnHome.add(getPnSearchButton(), BorderLayout.EAST);
		}
		return pnHome;
	}

	/*
	 * METHODS METHODS METHODS METHODS METHODS
	 */

	private void restart() {
		setOffers();
		tglbtnHome.doClick();
		catalogo = new Catalog(localizacion);
		pedido = new Pedido();
		modeloRooms.getDataVector().clear();
		modeloTabla.getDataVector().clear();
		clearTextFields(pnCentral);
	}

	private void toggleAllButtons(JToggleButton este) {
		for (Component c : pnPasos.getComponents()) {
			JToggleButton boton = (JToggleButton) c;
			if (este != boton) {
				boton.setSelected(false);
			}
		}
		este.setSelected(true);
	}

	private void disableAllButtons(JToggleButton este) {
		for (Component c : pnPasos.getComponents()) {
			JToggleButton boton = (JToggleButton) c;
			if (este != boton) {
				boton.setEnabled(false);
			}
		}
		este.setEnabled(true);
	}

	private void saveDatabases() {
		register.grabarFichero();
		// register saved
	}

	private void saveReceipt() {
		String nombreFichero = "pedidos/" + pedido.getUsuario().getID() + pedido.getCodigoPedido() + ".txt";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
			fichero.write(pedido.toString());
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "File couldn't be saved");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Input/Output error");
		}
	}

	private void loadDetails(String string) {
		if (crucero.isAptoMenores()) {
			lblAptoMenores.setText("Apto para menores");
		}
		lblBarco.setText("Barco" + ": " + crucero.getBarco().getDenominacion());
		lblDenominacion.setText("Crucero" + ": " + crucero.getDenominacion());
		lblItinerario.setText("Itinerario" + ": " + crucero.getItinerario());
		lblDuracion.setText("Duraci�n" + ": " + ((Integer) crucero.getDuration()).toString());
		lblZona.setText("Zona" + ": " + crucero.getZona());
		lblSalida.setText("Salida desde" + ": " + crucero.getPuertoSalida());
		taDescripcion.setText(crucero.getDescripcion());
		lblDate.setText("Fecha de salida" + ": " + string);

	}

	public void loadRoom(Room room) {
		pedido.addRoom(room);
		if (pedido.personasCorrectas()) {
			vAR.dispose();
			loadTable();
		} else {
			pedido.removeRoom(pedido.getRooms().size() - 1);
			JOptionPane.showMessageDialog(null,
					"There are too much people for this room. Please rearrange it before continue");
		}
	}

	private void loadTable() {
		modeloRooms.getDataVector().clear();
		Object[] nuevaFila = new Object[3];
		for (Room r : pedido.getRooms()) {
			if (r.getCam() == r.camDobInt) {
				nuevaFila[0] = "Double";
				nuevaFila[1] = "Interior";
			} else if (r.getCam() == r.camDobExt) {
				nuevaFila[0] = "Double";
				nuevaFila[1] = "Exterior";
			} else if (r.getCam() == r.camFamExt) {
				nuevaFila[0] = "Family";
				nuevaFila[1] = "Exterior";
			} else if (r.getCam() == r.camFamInt) {
				nuevaFila[0] = "Family";
				nuevaFila[1] = "Interior";
			}
			nuevaFila[2] = r.getExtras();
			modeloRooms.addRow(nuevaFila);
		}
		modeloRooms.fireTableDataChanged();

	}

	private void loadConfirmation() {
		Usuario user = pedido.getUsuario();
		getLblName_1().setText(user.getName());
		getLblSurname_1().setText(user.getSurname());
		getLblId_1().setText(user.getID());
		getLblPhone_1().setText(user.getPhoneNumber());
		getLblEmail_1().setText(user.getEmail());

	}

	private void setOffers() {
		Cruise[] cruceros = catalogo.selectDescuento();
		getBtnOffer1().setIcon(new ImageIcon(VentanaInicio.class.getResource(cruceros[0].getImgRoute())));
		getBtnOffer2().setIcon(new ImageIcon(VentanaInicio.class.getResource(cruceros[1].getImgRoute())));
		getBtnOffer1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crucero = cruceros[0];
				String[] dates = new String[crucero.getFechasSalida().length];
				int i = 0;
				for (java.util.Date d : crucero.getFechasSalida()) {
					dates[i] = DateFormat.getDateInstance(DateFormat.SHORT, localizacion).format(d);
					i++;
				}
				String date = (String) JOptionPane.showInputDialog(null, "Select the Date: ", "Date selection",
						JOptionPane.PLAIN_MESSAGE, null, dates, dates[0]);
				if (date != null) {
					loadDetails(date);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelDetails");
					pedido.setCrucero(crucero);
					pedido.setDate(date);
					getLblPicture().setIcon(new ImageIcon(VentanaInicio.class.getResource(crucero.getImgRoute())));
				}
			}
		});
		;
		getBtnOffer2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				crucero = cruceros[1];
				String[] dates = new String[crucero.getFechasSalida().length];
				int i = 0;
				for (java.util.Date d : crucero.getFechasSalida()) {
					dates[i] = DateFormat.getDateInstance(DateFormat.SHORT, localizacion).format(d);
					i++;
				}
				String date = (String) JOptionPane.showInputDialog(null, "Select the Date: ", "Date selection",
						JOptionPane.PLAIN_MESSAGE, null, dates, dates[0]);
				if (date != null) {
					loadDetails(date);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelDetails");
					pedido.setCrucero(crucero);
					pedido.setDate(date);
					getLblPicture().setIcon(new ImageIcon(VentanaInicio.class.getResource(crucero.getImgRoute())));
				}
			}
		});
		;
	}

	public void clearTextFields(Container container) {
		for (Component c : container.getComponents()) {
			if (c instanceof JTextField) {
				JTextField f = (JTextField) c;
				f.setText("");
			} 
			else if (c instanceof JPasswordField) {
				JPasswordField f=(JPasswordField)c;
				f.setText("");
			}else if (c instanceof Container)
				clearTextFields((Container) c);
		}
	}

	/*
	 * 
	 */
	/*
	 * 
	 * METHODS METHODS METHODS
	 */
	private JPanel getPnSearch() {
		if (pnSearch == null) {
			pnSearch = new JPanel();
			pnSearch.setLayout(new BorderLayout(0, 0));
			pnSearch.add(getPnSearchDet(), BorderLayout.NORTH);
			pnSearch.add(getScCruises(), BorderLayout.CENTER);
			pnSearch.add(getPnSearchBut(), BorderLayout.SOUTH);
		}
		return pnSearch;
	}

	private JPanel getPnRooms() {
		if (pnRooms == null) {
			pnRooms = new JPanel();
			pnRooms.setLayout(new BorderLayout(0, 0));
			pnRooms.add(getSpRooms());
			pnRooms.add(getPnRoomBtn(), BorderLayout.SOUTH);
		}
		return pnRooms;
	}

	private JPanel getPnConfirmation() {
		if (pnConfirmation == null) {
			pnConfirmation = new JPanel();
			pnConfirmation.setLayout(new BorderLayout(0, 0));
			pnConfirmation.add(getPnUserInfo(), BorderLayout.WEST);
			pnConfirmation.add(getPnPedidoInfo(), BorderLayout.CENTER);
			pnConfirmation.add(getBtnConfirm(), BorderLayout.SOUTH);
		}
		return pnConfirmation;
	}

	private JPanel getPnDetails() {
		if (pnDetails == null) {
			pnDetails = new JPanel();
			pnDetails.setLayout(new BorderLayout(0, 0));
			pnDetails.add(getTpDetails());
			pnDetails.add(getBtnBook(), BorderLayout.SOUTH);
		}
		return pnDetails;
	}

	private JPanel getPnSearchDet() {
		if (pnSearchDet == null) {
			pnSearchDet = new JPanel();
			pnSearchDet.add(getLblFrom());
			pnSearchDet.add(getTxtDateFrom());
			pnSearchDet.add(getLblTo());
			pnSearchDet.add(getTxtDateTo());
			pnSearchDet.add(getLblDestination());
			pnSearchDet.add(getCbDest());
			pnSearchDet.add(getBtnSearch());
		}
		return pnSearchDet;
	}

	private JPanel getPnSearchBut() {
		if (pnSearchBut == null) {
			pnSearchBut = new JPanel();
			pnSearchBut.add(getBtnDetails());
		}
		return pnSearchBut;
	}

	private JLabel getLblFrom() {
		if (lblFrom == null) {
			lblFrom = new JLabel("From: ");
		}
		return lblFrom;
	}

	private JTextField getTxtDateFrom() {
		if (txtDateFrom == null) {
			txtDateFrom = new JTextField();
			txtDateFrom.setColumns(10);
		}
		return txtDateFrom;
	}

	private JLabel getLblTo() {
		if (lblTo == null) {
			lblTo = new JLabel("To: ");
		}
		return lblTo;
	}

	private JTextField getTxtDateTo() {
		if (txtDateTo == null) {
			txtDateTo = new JTextField();
			txtDateTo.setColumns(10);
		}
		return txtDateTo;
	}

	private JLabel getLblDestination() {
		if (lblDestination == null) {
			lblDestination = new JLabel("Destination: ");
		}
		return lblDestination;
	}

	private JComboBox getCbDest() {
		if (cbDest == null) {
			cbDest = new JComboBox();
			cbDest.setModel(new DefaultComboBoxModel(catalogo.getZonas().toArray()));
		}
		return cbDest;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						modeloTabla.getDataVector().clear();
						modeloTabla = catalogo.searchZonaDate(getTxtDateFrom().getText(), getTxtDateTo().getText(),
								getCbDest().getSelectedItem().toString(), modeloTabla);
						modeloTabla.fireTableDataChanged();
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			});
		}
		return btnSearch;
	}

	private JButton getBtnDetails() {
		if (btnDetails == null) {
			btnDetails = new JButton("Details");
			btnDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int row = tCruises.getSelectedRow();
					crucero = catalogo
							.getCruise((String) ((Vector) modeloTabla.getDataVector().elementAt(row)).elementAt(0));
					String date = (String) ((Vector) modeloTabla.getDataVector().elementAt(row)).elementAt(4);
					loadDetails(date);
					((CardLayout) pnCentral.getLayout()).show(pnCentral, "panelDetails");
					pedido.setCrucero(crucero);
					pedido.setDate(date);
					getLblPicture().setIcon(new ImageIcon(VentanaInicio.class.getResource(crucero.getImgRoute())));

				}

			});
			btnDetails.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return btnDetails;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnEdit());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('f');
			mnFile.add(getMntmRestart());
		}
		return mnFile;
	}

	private JMenu getMnEdit() {
		if (mnEdit == null) {
			mnEdit = new JMenu("Edit");
			mnEdit.setMnemonic('d');
			mnEdit.add(getChckbxmntmTooltips());
			mnEdit.add(getMenuItem());
		}
		return mnEdit;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('h');
		}
		return mnHelp;
	}

	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("New menu item");
		}
		return menuItem;
	}

	private JCheckBoxMenuItem getChckbxmntmTooltips() {
		if (chckbxmntmTooltips == null) {
			chckbxmntmTooltips = new JCheckBoxMenuItem("Tooltips");
			chckbxmntmTooltips.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if (chckbxmntmTooltips.isSelected()) {
						ToolTipManager.sharedInstance().setEnabled(true);
					} else {
						ToolTipManager.sharedInstance().setEnabled(false);
					}

				}
			});
			chckbxmntmTooltips.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
			chckbxmntmTooltips.setSelected(true);
		}
		return chckbxmntmTooltips;
	}

	private JMenuItem getMntmRestart() {
		if (mntmRestart == null) {
			mntmRestart = new JMenuItem("Restart");
			mntmRestart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					restart();
				}
			});
			mntmRestart.setMnemonic('r');
		}
		return mntmRestart;
	}

	private JTabbedPane getTpDetails() {
		if (tpDetails == null) {
			tpDetails = new JTabbedPane(JTabbedPane.TOP);
			tpDetails.addTab("Pictures", null, getPnPictures(), null);
			tpDetails.addTab("Information", null, getPnInfo(), null);
		}
		return tpDetails;
	}

	private JPanel getPnPictures() {
		if (pnPictures == null) {
			pnPictures = new JPanel();
			pnPictures.setLayout(new BorderLayout(0, 0));
			pnPictures.add(getBtnPrev(), BorderLayout.WEST);
			pnPictures.add(getBtnNext(), BorderLayout.EAST);
			pnPictures.add(getLblPicture(), BorderLayout.CENTER);
		}
		return pnPictures;
	}

	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setLayout(new BorderLayout(0, 0));
			pnInfo.add(getPnIn(), BorderLayout.CENTER);
			pnInfo.add(getTaDescripcion(), BorderLayout.SOUTH);
		}
		return pnInfo;
	}

	private JTable getTCruises() {
		if (tCruises == null) {
			String[] nombreColumnas = { "Name", "Starting Point", "Duration", "Destinations", "Date" };
			modeloTabla = new ModeloNoEditable(nombreColumnas, 0);
			tCruises = new JTable(modeloTabla);
		}
		return tCruises;
	}

	private JButton getBtnBook() {
		if (btnBook == null) {
			btnBook = new JButton("Book Now");
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTglbtnRooms().setEnabled(true);
					getTglbtnRooms().doClick();

				}
			});
		}
		return btnBook;
	}

	private JScrollPane getScCruises() {
		if (scCruises == null) {
			scCruises = new JScrollPane();
			scCruises.setViewportView(getTCruises());
		}
		return scCruises;
	}

	private JButton getBtnPrev() {
		if (btnPrev == null) {
			btnPrev = new JButton("Previous Image");
		}
		return btnPrev;
	}

	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next Image");
		}
		return btnNext;
	}

	private JLabel getLblPicture() {
		if (lblPicture == null) {
			lblPicture = new JLabel("");
		}
		return lblPicture;
	}

	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel("");
			lblDenominacion.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblDenominacion;
	}

	private JLabel getLblZona() {
		if (lblZona == null) {
			lblZona = new JLabel("");
			lblZona.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblZona;
	}

	private JLabel getLblSalida() {
		if (lblSalida == null) {
			lblSalida = new JLabel("");
			lblSalida.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblSalida;
	}

	private JLabel getLblItinerario() {
		if (lblItinerario == null) {
			lblItinerario = new JLabel("");
			lblItinerario.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblItinerario;
	}

	private JLabel getLblAptoMenores() {
		if (lblAptoMenores == null) {
			lblAptoMenores = new JLabel("");
			lblAptoMenores.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblAptoMenores;
	}

	private JLabel getLblDuracion() {
		if (lblDuracion == null) {
			lblDuracion = new JLabel("");
			lblDuracion.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblDuracion;
	}

	private JLabel getLblBarco() {
		if (lblBarco == null) {
			lblBarco = new JLabel("");
			lblBarco.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblBarco;
	}

	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("");
			lblDate.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblDate;
	}

	private JTextArea getTaDescripcion() {
		if (taDescripcion == null) {
			taDescripcion = new JTextArea();
			taDescripcion.setLineWrap(true);
			taDescripcion.setWrapStyleWord(true);
		}
		return taDescripcion;
	}

	private JPanel getPnIn() {
		if (pnIn == null) {
			pnIn = new JPanel();
			pnIn.add(getLblDuracion());
			pnIn.add(getLblBarco());
			pnIn.add(getLblAptoMenores());
			pnIn.add(getLblItinerario());
			pnIn.add(getLblDate());
			pnIn.add(getLblSalida());
			pnIn.add(getLblZona());
			pnIn.add(getLblDenominacion());
		}
		return pnIn;
	}

	private JScrollPane getSpRooms() {
		if (spRooms == null) {
			spRooms = new JScrollPane();
			spRooms.setViewportView(getTRooms());
		}
		return spRooms;
	}

	private JTable getTRooms() {
		if (tRooms == null) {
			String[] nombreColumnas = { "Type of Room", "Location", "Room Extras" };
			modeloRooms = new ModeloNoEditable(nombreColumnas, 0);
			tRooms = new JTable(modeloRooms);
		}
		return tRooms;
	}

	private JPanel getPnRoomBtn() {
		if (pnRoomBtn == null) {
			pnRoomBtn = new JPanel();
			GridBagLayout gbl_pnRoomBtn = new GridBagLayout();
			gbl_pnRoomBtn.columnWidths = new int[] { 198, 79, 71, 67, 0, 0, 0, 0, 0, 0 };
			gbl_pnRoomBtn.rowHeights = new int[] { 23, 0 };
			gbl_pnRoomBtn.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_pnRoomBtn.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			pnRoomBtn.setLayout(gbl_pnRoomBtn);
			GridBagConstraints gbc_btnAddRoom = new GridBagConstraints();
			gbc_btnAddRoom.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnAddRoom.insets = new Insets(0, 0, 0, 5);
			gbc_btnAddRoom.gridx = 1;
			gbc_btnAddRoom.gridy = 0;
			pnRoomBtn.add(getBtnAddRoom(), gbc_btnAddRoom);
			GridBagConstraints gbc_btnRemove = new GridBagConstraints();
			gbc_btnRemove.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
			gbc_btnRemove.gridx = 2;
			gbc_btnRemove.gridy = 0;
			pnRoomBtn.add(getBtnRemove(), gbc_btnRemove);
			GridBagConstraints gbc_btnNext_1 = new GridBagConstraints();
			gbc_btnNext_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnNext_1.gridx = 8;
			gbc_btnNext_1.gridy = 0;
			pnRoomBtn.add(getBtnNext_1(), gbc_btnNext_1);
		}
		return pnRoomBtn;
	}

	private JButton getBtnAddRoom() {
		if (btnAddRoom == null) {
			VentanaInicio vI = this;
			btnAddRoom = new JButton("AddRoom");
			btnAddRoom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vAR = new VentanaAddRoom(vI, crucero);
					vAR.setModal(true);
					vAR.setLocationRelativeTo(vI);
					vAR.setVisible(true);
				}
			});
		}
		return btnAddRoom;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pedido.removeRoom(tRooms.getSelectedRow());
					loadTable();
				}
			});
		}
		return btnRemove;
	}

	public Catalog getCatalogo() {
		return catalogo;
	}

	private JPanel getPnRecommended() {
		if (pnRecommended == null) {
			pnRecommended = new JPanel();
			pnRecommended.setLayout(new GridLayout(1, 0, 0, 0));
			pnRecommended.add(getBtnOffer1());
			pnRecommended.add(getBtnOffer2());
		}
		return pnRecommended;
	}

	private JPanel getPnSearchButton() {
		if (pnSearchButton == null) {
			pnSearchButton = new JPanel();
			GridBagLayout gbl_pnSearchButton = new GridBagLayout();
			gbl_pnSearchButton.columnWidths = new int[] { 65, 0 };
			gbl_pnSearchButton.rowHeights = new int[] { 23, 0, 0, 0, 0, 0 };
			gbl_pnSearchButton.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
			gbl_pnSearchButton.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnSearchButton.setLayout(gbl_pnSearchButton);
			GridBagConstraints gbc_btnSearch_1 = new GridBagConstraints();
			gbc_btnSearch_1.insets = new Insets(0, 0, 5, 0);
			gbc_btnSearch_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnSearch_1.gridx = 0;
			gbc_btnSearch_1.gridy = 3;
			pnSearchButton.add(getBtnSearch_1(), gbc_btnSearch_1);
		}
		return pnSearchButton;
	}

	private JButton getBtnSearch_1() {
		if (btnSearch_1 == null) {
			btnSearch_1 = new JButton("");
			btnSearch_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTglbtnSearch().setEnabled(true);
					getTglbtnSearch().doClick();
				}
			});
			btnSearch_1.setIcon(
					new ImageIcon(VentanaInicio.class.getResource("/img/encontrar-busqueda-zoom-icono-6513-96.png")));
		}
		return btnSearch_1;
	}

	private JPanel getPnPersonalData() {
		if (pnPersonalData == null) {
			pnPersonalData = new JPanel();
			pnPersonalData.setLayout(new BorderLayout(0, 0));
			pnPersonalData.add(getPnPersonalButtons(), BorderLayout.SOUTH);
			pnPersonalData.add(getPnLogIn(), BorderLayout.NORTH);
			pnPersonalData.add(getPnRegister(), BorderLayout.CENTER);
		}
		return pnPersonalData;
	}

	private JPanel getPnPayout() {
		if (pnPayout == null) {
			pnPayout = new JPanel();
			pnPayout.setLayout(new BorderLayout(0, 0));
			pnPayout.add(getPnPayoutBtns(), BorderLayout.SOUTH);
			pnPayout.add(getLblBookingSucceed(), BorderLayout.CENTER);
		}
		return pnPayout;
	}

	private JButton getBtnPrintReceipt() {
		if (btnPrintReceipt == null) {
			btnPrintReceipt = new JButton("Print receipt");
		}
		return btnPrintReceipt;
	}

	private JPanel getPnPersonalButtons() {
		if (pnPersonalButtons == null) {
			pnPersonalButtons = new JPanel();
			GridBagLayout gbl_pnPersonalButtons = new GridBagLayout();
			gbl_pnPersonalButtons.columnWidths = new int[] { 73, 173, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0 };
			gbl_pnPersonalButtons.rowHeights = new int[] { 23, 0 };
			gbl_pnPersonalButtons.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_pnPersonalButtons.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			pnPersonalButtons.setLayout(gbl_pnPersonalButtons);
			GridBagConstraints gbc_btnRegister = new GridBagConstraints();
			gbc_btnRegister.anchor = GridBagConstraints.WEST;
			gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
			gbc_btnRegister.gridx = 7;
			gbc_btnRegister.gridy = 0;
			pnPersonalButtons.add(getBtnRegister(), gbc_btnRegister);
			GridBagConstraints gbc_btnContinueWithoutRegistering = new GridBagConstraints();
			gbc_btnContinueWithoutRegistering.insets = new Insets(0, 0, 0, 5);
			gbc_btnContinueWithoutRegistering.gridx = 12;
			gbc_btnContinueWithoutRegistering.gridy = 0;
			pnPersonalButtons.add(getBtnContinueWithoutRegistering(), gbc_btnContinueWithoutRegistering);
		}
		return pnPersonalButtons;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (getTxID().getText().isEmpty() || getTxName().getText().isEmpty()
							|| getTxSurname().getText().isEmpty() || getTxPhone().getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"User not valid, ID, Name, Surname and Phone are mandatory fields");
					} else {
						register.addUser(
								new Usuario(getTxID().getText(), passwordRegister.getPassword(), getTxName().getText(),
										getTxSurname().getText(), getTxPhone().getText(), getTxEmail().getText()));
						JOptionPane.showMessageDialog(null, "You can now Log In");
					}
				}
			});
		}
		return btnRegister;
	}

	private JButton getBtnNext_1() {
		if (btnNext_1 == null) {
			btnNext_1 = new JButton("Next->");
			btnNext_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (modeloRooms.getRowCount() > 0) {
						getTglbtnPersonalData().setEnabled(true);
						getTglbtnPersonalData().doClick();
						register = new Registro();
					} else {
						JOptionPane.showMessageDialog(null, "Please add some rooms");
					}

				}
			});
		}
		return btnNext_1;
	}

	private JPanel getPnLogIn() {
		if (pnLogIn == null) {
			pnLogIn = new JPanel();
			pnLogIn.add(getLblIdLogin());
			pnLogIn.add(getTxIDLogin());
			pnLogIn.add(getLblPasswordLogIn());
			pnLogIn.add(getPasswordLogIn());
			pnLogIn.add(getBtnLogIn());
		}
		return pnLogIn;
	}

	private JPanel getPnRegister() {
		if (pnRegister == null) {
			pnRegister = new JPanel();
			GridBagLayout gbl_pnRegister = new GridBagLayout();
			gbl_pnRegister.columnWidths = new int[] { 31, 49, 117, 56, 77, 31, 119, 0, 0, 0, 0, 0, 0, 0 };
			gbl_pnRegister.rowHeights = new int[] { 56, 20, 31, 20, 31, 20, 0 };
			gbl_pnRegister.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, Double.MIN_VALUE };
			gbl_pnRegister.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnRegister.setLayout(gbl_pnRegister);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			pnRegister.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_txName = new GridBagConstraints();
			gbc_txName.gridwidth = 2;
			gbc_txName.anchor = GridBagConstraints.NORTH;
			gbc_txName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txName.insets = new Insets(0, 0, 5, 5);
			gbc_txName.gridx = 2;
			gbc_txName.gridy = 1;
			pnRegister.add(getTxName(), gbc_txName);
			GridBagConstraints gbc_lblId = new GridBagConstraints();
			gbc_lblId.anchor = GridBagConstraints.WEST;
			gbc_lblId.insets = new Insets(0, 0, 5, 5);
			gbc_lblId.gridx = 6;
			gbc_lblId.gridy = 1;
			pnRegister.add(getLblId(), gbc_lblId);
			GridBagConstraints gbc_txID = new GridBagConstraints();
			gbc_txID.gridwidth = 4;
			gbc_txID.anchor = GridBagConstraints.NORTH;
			gbc_txID.fill = GridBagConstraints.HORIZONTAL;
			gbc_txID.insets = new Insets(0, 0, 5, 5);
			gbc_txID.gridx = 8;
			gbc_txID.gridy = 1;
			pnRegister.add(getTxID(), gbc_txID);
			GridBagConstraints gbc_lblSurname = new GridBagConstraints();
			gbc_lblSurname.anchor = GridBagConstraints.WEST;
			gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
			gbc_lblSurname.gridx = 1;
			gbc_lblSurname.gridy = 3;
			pnRegister.add(getLblSurname(), gbc_lblSurname);
			GridBagConstraints gbc_txSurname = new GridBagConstraints();
			gbc_txSurname.gridwidth = 2;
			gbc_txSurname.anchor = GridBagConstraints.NORTH;
			gbc_txSurname.fill = GridBagConstraints.HORIZONTAL;
			gbc_txSurname.insets = new Insets(0, 0, 5, 5);
			gbc_txSurname.gridx = 2;
			gbc_txSurname.gridy = 3;
			pnRegister.add(getTxSurname(), gbc_txSurname);
			GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
			gbc_lblPhoneNumber.anchor = GridBagConstraints.WEST;
			gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblPhoneNumber.gridx = 6;
			gbc_lblPhoneNumber.gridy = 3;
			pnRegister.add(getLblPhoneNumber(), gbc_lblPhoneNumber);
			GridBagConstraints gbc_txPhone = new GridBagConstraints();
			gbc_txPhone.gridwidth = 4;
			gbc_txPhone.anchor = GridBagConstraints.NORTH;
			gbc_txPhone.fill = GridBagConstraints.HORIZONTAL;
			gbc_txPhone.insets = new Insets(0, 0, 5, 5);
			gbc_txPhone.gridx = 8;
			gbc_txPhone.gridy = 3;
			pnRegister.add(getTxPhone(), gbc_txPhone);
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.WEST;
			gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
			gbc_lblEmail.gridx = 1;
			gbc_lblEmail.gridy = 5;
			pnRegister.add(getLblEmail(), gbc_lblEmail);
			GridBagConstraints gbc_txEmail = new GridBagConstraints();
			gbc_txEmail.gridwidth = 2;
			gbc_txEmail.anchor = GridBagConstraints.NORTH;
			gbc_txEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_txEmail.insets = new Insets(0, 0, 0, 5);
			gbc_txEmail.gridx = 2;
			gbc_txEmail.gridy = 5;
			pnRegister.add(getTxEmail(), gbc_txEmail);
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.WEST;
			gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
			gbc_lblPassword.gridx = 6;
			gbc_lblPassword.gridy = 5;
			pnRegister.add(getLblPassword(), gbc_lblPassword);
			GridBagConstraints gbc_passwordRegister = new GridBagConstraints();
			gbc_passwordRegister.insets = new Insets(0, 0, 0, 5);
			gbc_passwordRegister.gridwidth = 4;
			gbc_passwordRegister.anchor = GridBagConstraints.NORTH;
			gbc_passwordRegister.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordRegister.gridx = 8;
			gbc_passwordRegister.gridy = 5;
			pnRegister.add(getPasswordRegister(), gbc_passwordRegister);
		}
		return pnRegister;
	}

	private JLabel getLblIdLogin() {
		if (lblIdLogin == null) {
			lblIdLogin = new JLabel("ID: ");
		}
		return lblIdLogin;
	}

	private JTextField getTxIDLogin() {
		if (txIDLogin == null) {
			txIDLogin = new JTextField();
			txIDLogin.setColumns(9);
		}
		return txIDLogin;
	}

	private JLabel getLblPasswordLogIn() {
		if (lblPasswordLogIn == null) {
			lblPasswordLogIn = new JLabel("Password: ");
		}
		return lblPasswordLogIn;
	}

	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log In");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Usuario user = register.getUser(getTxIDLogin().getText(), getPasswordLogIn().getPassword());
					if (user == null) {
						JOptionPane.showMessageDialog(null, "ID and password do not match");
					} else {
						pedido.setUsuario(user);
						getTglbtnConfirmation().setEnabled(true);
						getTglbtnConfirmation().doClick();

					}
				}
			});
		}
		return btnLogIn;
	}

	private JPasswordField getPasswordLogIn() {
		if (passwordLogIn == null) {
			passwordLogIn = new JPasswordField();
			passwordLogIn.setColumns(12);
		}
		return passwordLogIn;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name: ");
		}
		return lblName;
	}

	private JLabel getLblSurname() {
		if (lblSurname == null) {
			lblSurname = new JLabel("Surname: ");
		}
		return lblSurname;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID: ");
		}
		return lblId;
	}

	private JLabel getLblPhoneNumber() {
		if (lblPhoneNumber == null) {
			lblPhoneNumber = new JLabel("Phone Number: ");
		}
		return lblPhoneNumber;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email: ");
		}
		return lblEmail;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password: ");
		}
		return lblPassword;
	}

	private JTextField getTxID() {
		if (txID == null) {
			txID = new JTextField();
			txID.setColumns(10);
		}
		return txID;
	}

	private JTextField getTxName() {
		if (txName == null) {
			txName = new JTextField();
			txName.setColumns(10);
		}
		return txName;
	}

	private JTextField getTxSurname() {
		if (txSurname == null) {
			txSurname = new JTextField();
			txSurname.setColumns(10);
		}
		return txSurname;
	}

	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setToolTipText("Optional field");
			txEmail.setColumns(10);
		}
		return txEmail;
	}

	private JTextField getTxPhone() {
		if (txPhone == null) {
			txPhone = new JTextField();
			txPhone.setColumns(10);
		}
		return txPhone;
	}

	private JPasswordField getPasswordRegister() {
		if (passwordRegister == null) {
			passwordRegister = new JPasswordField();
			passwordRegister.setToolTipText("Optional Field");
		}
		return passwordRegister;
	}

	private JButton getBtnContinueWithoutRegistering() {
		if (btnContinueWithoutRegistering == null) {
			btnContinueWithoutRegistering = new JButton("Continue Without Registering");
			btnContinueWithoutRegistering.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (getTxID().getText().isEmpty() || getTxName().getText().isEmpty()
							|| getTxSurname().getText().isEmpty() || getTxPhone().getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"User not valid, ID, Name, Surname and Phone are mandatory fields");
					} else {
						pedido.setUsuario(new Usuario(getTxID().getText(), getTxName().getText(),
								getTxSurname().getText(), getTxPhone().getText(), getTxEmail().getText()));
						getTglbtnConfirmation().setEnabled(true);
						getTglbtnConfirmation().doClick();
					}
				}
			});
			btnContinueWithoutRegistering.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return btnContinueWithoutRegistering;
	}

	private JPanel getPnUserInfo() {
		if (pnUserInfo == null) {
			pnUserInfo = new JPanel();
			GridBagLayout gbl_pnUserInfo = new GridBagLayout();
			gbl_pnUserInfo.columnWidths = new int[] { 42, 0 };
			gbl_pnUserInfo.rowHeights = new int[] { 30, 14, 0, 35, 14, 35, 14, 35, 14, 35, 0, 14, 0 };
			gbl_pnUserInfo.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
			gbl_pnUserInfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			pnUserInfo.setLayout(gbl_pnUserInfo);
			GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
			gbc_lblName_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblName_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblName_1.gridx = 0;
			gbc_lblName_1.gridy = 2;
			pnUserInfo.add(getLblName_1(), gbc_lblName_1);
			GridBagConstraints gbc_lblSurname_1 = new GridBagConstraints();
			gbc_lblSurname_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblSurname_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblSurname_1.gridx = 0;
			gbc_lblSurname_1.gridy = 3;
			pnUserInfo.add(getLblSurname_1(), gbc_lblSurname_1);
			GridBagConstraints gbc_lblId_1 = new GridBagConstraints();
			gbc_lblId_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblId_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblId_1.gridx = 0;
			gbc_lblId_1.gridy = 5;
			pnUserInfo.add(getLblId_1(), gbc_lblId_1);
			GridBagConstraints gbc_lblPhone_1 = new GridBagConstraints();
			gbc_lblPhone_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblPhone_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblPhone_1.gridx = 0;
			gbc_lblPhone_1.gridy = 7;
			pnUserInfo.add(getLblPhone_1(), gbc_lblPhone_1);
			GridBagConstraints gbc_lblEmail_1 = new GridBagConstraints();
			gbc_lblEmail_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblEmail_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblEmail_1.gridx = 0;
			gbc_lblEmail_1.gridy = 9;
			pnUserInfo.add(getLblEmail_1(), gbc_lblEmail_1);
		}
		return pnUserInfo;
	}

	private JPanel getPnPedidoInfo() {
		if (pnPedidoInfo == null) {
			pnPedidoInfo = new JPanel();
			GridBagLayout gbl_pnPedidoInfo = new GridBagLayout();
			gbl_pnPedidoInfo.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnPedidoInfo.rowHeights = new int[] { 0, 0 };
			gbl_pnPedidoInfo.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
			gbl_pnPedidoInfo.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
			pnPedidoInfo.setLayout(gbl_pnPedidoInfo);
			GridBagConstraints gbc_spPedido = new GridBagConstraints();
			gbc_spPedido.insets = new Insets(0, 0, 0, 5);
			gbc_spPedido.fill = GridBagConstraints.BOTH;
			gbc_spPedido.gridx = 0;
			gbc_spPedido.gridy = 0;
			pnPedidoInfo.add(getSpPedido(), gbc_spPedido);
		}
		return pnPedidoInfo;
	}

	private JLabel getLblName_1() {
		if (lblName_1 == null) {
			lblName_1 = new JLabel("Name");
		}
		return lblName_1;
	}

	private JLabel getLblSurname_1() {
		if (lblSurname_1 == null) {
			lblSurname_1 = new JLabel("Surname");
		}
		return lblSurname_1;
	}

	private JLabel getLblPhone_1() {
		if (lblPhone_1 == null) {
			lblPhone_1 = new JLabel("Phone");
		}
		return lblPhone_1;
	}

	private JLabel getLblEmail_1() {
		if (lblEmail_1 == null) {
			lblEmail_1 = new JLabel("Email");
		}
		return lblEmail_1;
	}

	private JLabel getLblId_1() {
		if (lblId_1 == null) {
			lblId_1 = new JLabel("ID");
		}
		return lblId_1;
	}

	private JButton getBtnOffer1() {
		if (btnOffer1 == null) {
			btnOffer1 = new JButton("");
		}
		return btnOffer1;
	}

	private JButton getBtnOffer2() {
		if (btnOffer2 == null) {
			btnOffer2 = new JButton("");
		}
		return btnOffer2;
	}

	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTglbtnPayout().setEnabled(true);
					getTglbtnPayout().doClick();
				}
			});
		}
		return btnConfirm;
	}

	private JButton getBtnSaveReceipt() {
		if (btnSaveReceipt == null) {
			btnSaveReceipt = new JButton("Save Receipt");
			btnSaveReceipt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveDatabases();
					saveReceipt();
					restart();
				}
			});
		}
		return btnSaveReceipt;
	}

	private JButton getBtnCancelBooking() {
		if (btnCancelBooking == null) {
			btnCancelBooking = new JButton("Cancel Booking");
			btnCancelBooking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					restart();
				}
			});
		}
		return btnCancelBooking;
	}

	private JPanel getPnPayoutBtns() {
		if (pnPayoutBtns == null) {
			pnPayoutBtns = new JPanel();
			pnPayoutBtns.add(getBtnSaveReceipt());
			pnPayoutBtns.add(getBtnCancelBooking());
			pnPayoutBtns.add(getBtnPrintReceipt());
		}
		return pnPayoutBtns;
	}

	private JLabel getLblBookingSucceed() {
		if (lblBookingSucceed == null) {
			lblBookingSucceed = new JLabel("Booking Succeed");
			lblBookingSucceed.setHorizontalAlignment(SwingConstants.CENTER);
			lblBookingSucceed.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblBookingSucceed.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return lblBookingSucceed;
	}

	private JScrollPane getSpPedido() {
		if (spPedido == null) {
			spPedido = new JScrollPane();
			spPedido.setViewportView(getTxpnPedidoInfo());
		}
		return spPedido;
	}

	private JTextPane getTxpnPedidoInfo() {
		if (txpnPedidoInfo == null) {
			txpnPedidoInfo = new JTextPane();
		}
		return txpnPedidoInfo;
	}
}
