package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import services.PlaceServices;
import services.ServicesLocator;
import utils.MiJPanel;
import utils.MyButtonModel;
import utils.Paneles;
import utils.PlaceTableModel;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import dto.PlaceDTO;

public class ConsultarLugares extends MiJPanel{
	
	private PlaceServices placeServices = ServicesLocator.getPlaceServices();
	private ArrayList<PlaceDTO> listaLugares;

	private static final long serialVersionUID = 1L;
	private Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	private Color colorAzul = new Color(59, 165, 187);

	private JPanel panelSuperior;
	private JButton btnCerrar;
	private JPanel panelInferior;
	private JButton btnAtras;
	private JScrollPane scrollPane;
	private JTable table;
	private PlaceTableModel tableModel;
	
	private Principal padre;
	private MiJPanel anterior;
	private ConsultarLugares este;
	
	public ConsultarLugares(Principal p, MiJPanel a){
		este = this;
		padre = p;
		anterior = a;
		setTipoPanel(Paneles.PANEL_CONSULTAR_LUGARES);
		padre.setPanelAbierto(getTipoPanel());
		padre.setPanelConsultarLugares(este);
		setBounds(pantalla.width/2-301, pantalla.height/2-276, 602, 502);
		setBackground(Color.darkGray);
		setLayout(null);
		
		panelSuperior = new JPanel(null);
		panelSuperior.setBounds(1, 1, 600, 30);
		panelSuperior.setBackground(colorAzul);
		add(panelSuperior);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/visual/imagenes/close.png"));
		Image image = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconCerrar = new ImageIcon(image);

		btnCerrar = new JButton(iconCerrar);
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				padre.getPanelPrincipal().remove(este);
				padre.getPanelPrincipal().repaint();
				padre.setPanelAbierto(0);
			}
		});
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar.setContentAreaFilled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setContentAreaFilled(false);
			}
		});
		btnCerrar.setBounds(555, 0, 45, 30);
		btnCerrar.setBackground(Color.red);
		btnCerrar.setFocusable(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setModel(new MyButtonModel());
		panelSuperior.add(btnCerrar);
		
		panelInferior = new JPanel(null);
		panelInferior.setBounds(1, 31, 600, 470);
		panelInferior.setBackground(Color.white);
		add(panelInferior);
		
		img = new ImageIcon(getClass().getResource("/visual/imagenes/atras.png"));
		image = img.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		Icon iconAtras = new ImageIcon(image);
		
		btnAtras = new JButton(iconAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				padre.getPanelPrincipal().remove(este);
				padre.getPanelPrincipal().add(anterior);
				padre.getPanelPrincipal().repaint();
				padre.setPanelAbierto(anterior.getTipoPanel());
			}
		});
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setContentAreaFilled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setContentAreaFilled(false);
			}
		});
		btnAtras.setBounds(5, 5, 40, 40);
		btnAtras.setBackground(colorAzul);
		btnAtras.setFocusable(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setModel(new MyButtonModel());
		panelInferior.add(btnAtras);
		
		JLabel lblLugares = new JLabel("Lugares");
		lblLugares.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugares.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLugares.setForeground(Color.black);
		lblLugares.setFont(new Font("Arial", Font.BOLD, 22));
		lblLugares.setBounds(250, 0, 100, 50);
		panelInferior.add(lblLugares);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int pos = table.getSelectedRow();
				int code = listaLugares.get(pos).getPlaceCode();
				if(anterior instanceof AgregarEvento)
					((AgregarEvento)anterior).setLugar(code);
				padre.getPanelPrincipal().remove(este);
				padre.getPanelPrincipal().add(anterior);
				padre.getPanelPrincipal().repaint();
				padre.setPanelAbierto(anterior.getTipoPanel());
			}
		});
		table.setFocusable(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(40);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setBackground(Color.WHITE);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.white);
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setBounds(30, 50, 540, 390);
		panelInferior.add(scrollPane);
		
		tableModel = new PlaceTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		table.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		try {
			listaLugares = placeServices.selectAllPlaces();
			for(PlaceDTO l : listaLugares){
				String[] datos = {String.valueOf(l.getPlaceCode()), l.getPlaceName(), l.getTypeOfService(), 
						String.valueOf(l.getCostPerPerson())};
				tableModel.addRow(datos);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
