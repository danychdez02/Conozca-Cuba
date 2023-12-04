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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import utils.ComboBoxModel;
import utils.MyButtonModel;
import utils.PropiedadesComboBox;

public class AgregarHotel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	private Color colorAzul = new Color(59, 165, 187);

	private JPanel panelSuperior;
	private JButton btnCerrar;
	private JPanel panelInferior;
	private JTextField txtNombre;
	private JComboBox<String> cbCategoria;
	private JComboBox<String> cbCadena;
	private JComboBox<String> cbProvincia;
	private JTextField txtDireccion;
	private JComboBox<String> cbLocalizacion;
	private JTextField txtTelefono;
	private JTextField txtFax;
	private JTextField txtCorreo;
	private JTextField txtCantPisos;
	private JTextField txtCantHab;
	private JTextField txtDistCiudad;
	private JTextField txtDistAereopuerto;
	private JRadioButton mLunaMiel;
	private JRadioButton mEcoturismo;
	private JRadioButton mHistorico;
	private JRadioButton mGolf;
	private JRadioButton mVerano;
	private JRadioButton mNavidad;
	private JRadioButton mTodoIncluido;
	private JButton btnAgregar;
	
	private AgregarHotel este;
	
	public AgregarHotel(){
		este = this;
		setBounds(pantalla.width/2-501, pantalla.height/2-346, 1002, 642);
		setBackground(Color.darkGray);
		setLayout(null);
		
		panelSuperior = new JPanel(null);
		panelSuperior.setBounds(1, 1, 1000, 30);
		panelSuperior.setBackground(colorAzul);
		add(panelSuperior);

		ImageIcon img = new ImageIcon(getClass().getResource("/visual/imagenes/close.png"));
		Image image = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconCerrar = new ImageIcon(image);

		btnCerrar = new JButton(iconCerrar);
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
		btnCerrar.setBounds(955, 0, 45, 30);
		btnCerrar.setBackground(Color.red);
		btnCerrar.setFocusable(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setModel(new MyButtonModel());
		panelSuperior.add(btnCerrar);
		
		panelInferior = new JPanel(null);
		panelInferior.setBounds(1, 31, 1000, 610);
		panelInferior.setBackground(Color.white);
		add(panelInferior);
		
		img = new ImageIcon(getClass().getResource("/visual/imagenes/hotel.png"));
		image = img.getImage().getScaledInstance(96, 120, Image.SCALE_SMOOTH);
		Icon iconHotel = new ImageIcon(image);
		
		JLabel fotoHotel = new JLabel(iconHotel);
		fotoHotel.setBounds(200, 30, 96, 120);
		panelInferior.add(fotoHotel);
		
		img = new ImageIcon(getClass().getResource("/visual/imagenes/logo cc.png"));
		image = img.getImage().getScaledInstance(400, 122, Image.SCALE_SMOOTH);
		Icon iconLogo = new ImageIcon(image);

		JLabel logo = new JLabel(iconLogo);
		logo.setBounds(520, 30, 400, 122);
		panelInferior.add(logo);
		
		JLabel nombre = new JLabel("Nombre: ");
		nombre.setBounds(50, 180, 70, 30);
		nombre.setForeground(Color.black);
		nombre.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(nombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(120, 180, 370, 30);
		txtNombre.setForeground(Color.black);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNombre.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtNombre);
		
		JLabel categoria = new JLabel("Categor�a: ");
		categoria.setBounds(50, 220, 85, 30);
		categoria.setForeground(Color.black);
		categoria.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(categoria);
		
		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(135, 220, 355, 30);
		cbCategoria.setBackground(Color.white);
		cbCategoria.setFocusable(false);
		cbCategoria.setModel(ComboBoxModel.catHoteleraModel());
		cbCategoria.setFont(new Font("Arial", Font.PLAIN, 16));
		cbCategoria.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		cbCategoria.setUI(PropiedadesComboBox.createUI(getRootPane(), cbCategoria.getBounds()));
		panelInferior.add(cbCategoria);
		
		JLabel cadenaHotelera = new JLabel("Cadena Hotelera: ");
		cadenaHotelera.setBounds(50, 260, 130, 30);
		cadenaHotelera.setForeground(Color.black);
		cadenaHotelera.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(cadenaHotelera);
		
		cbCadena = new JComboBox<String>();
		cbCadena.setBounds(183, 260, 307, 30);
		cbCadena.setBackground(Color.white);
		cbCadena.setFocusable(false);
		cbCadena.setModel(ComboBoxModel.cadenasHotelerasModel());
		cbCadena.setFont(new Font("Arial", Font.PLAIN, 16));
		cbCadena.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		cbCadena.setUI(PropiedadesComboBox.createUI(getRootPane(), cbCadena.getBounds()));
		panelInferior.add(cbCadena);
		
		JLabel provincia = new JLabel("Provincia: ");
		provincia.setBounds(50, 300, 85, 30);
		provincia.setForeground(Color.black);
		provincia.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(provincia);
		
		cbProvincia = new JComboBox<String>();
		cbProvincia.setBounds(130, 300, 360, 30);
		cbProvincia.setBackground(Color.white);
		cbProvincia.setFocusable(false);
		cbProvincia.setModel(ComboBoxModel.provinciasModel());
		cbProvincia.setFont(new Font("Arial", Font.PLAIN, 16));
		cbProvincia.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		cbProvincia.setUI(PropiedadesComboBox.createUI(getRootPane(), cbProvincia.getBounds()));
		panelInferior.add(cbProvincia);
		
		JLabel direccion = new JLabel("Direcci�n: ");
		direccion.setBounds(50, 340, 80, 30);
		direccion.setForeground(Color.black);
		direccion.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(direccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(130, 340, 360, 30);
		txtDireccion.setForeground(Color.black);
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDireccion.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtDireccion);
		
		JLabel localizacion = new JLabel("Localizaci�n: ");
		localizacion.setBounds(50, 380, 100, 30);
		localizacion.setForeground(Color.black);
		localizacion.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(localizacion);
		
		cbLocalizacion = new JComboBox<String>();
		cbLocalizacion.setBounds(150, 380, 340, 30);
		cbLocalizacion.setBackground(Color.white);
		cbLocalizacion.setFocusable(false);
		cbLocalizacion.setModel(ComboBoxModel.localizacionesModel());
		cbLocalizacion.setFont(new Font("Arial", Font.PLAIN, 16));
		cbLocalizacion.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		cbLocalizacion.setUI(PropiedadesComboBox.createUI(getRootPane(), cbLocalizacion.getBounds()));
		panelInferior.add(cbLocalizacion);
		
		JLabel telefono = new JLabel("Tel�fono: ");
		telefono.setBounds(50, 420, 70, 30);
		telefono.setForeground(Color.black);
		telefono.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(telefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(123, 420, 367, 30);
		txtTelefono.setForeground(Color.black);
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTelefono.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtTelefono);
		
		JLabel fax = new JLabel("Fax: ");
		fax.setBounds(50, 460, 40, 30);
		fax.setForeground(Color.black);
		fax.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(fax);
		
		txtFax = new JTextField();
		txtFax.setBounds(90, 460, 400, 30);
		txtFax.setForeground(Color.black);
		txtFax.setFont(new Font("Arial", Font.PLAIN, 16));
		txtFax.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtFax);
		
		JLabel correo = new JLabel("Correo: ");
		correo.setBounds(50, 500, 60, 30);
		correo.setForeground(Color.black);
		correo.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(correo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(110, 500, 380, 30);
		txtCorreo.setForeground(Color.black);
		txtCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCorreo.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtCorreo);
		
		JLabel modalidades = new JLabel("Modalidades: ");
		modalidades.setBounds(550, 180, 100, 30);
		modalidades.setForeground(Color.black);
		modalidades.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(modalidades);
		
		mLunaMiel = new JRadioButton("Luna de Miel");
		mLunaMiel.setBounds(600, 220, 120, 30);
		mLunaMiel.setBackground(Color.white);
		mLunaMiel.setForeground(Color.black);
		mLunaMiel.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(mLunaMiel);
		
		mGolf = new JRadioButton("Golf");
		mGolf.setBounds(800, 220, 120, 30);
		mGolf.setBackground(Color.white);
		mGolf.setForeground(Color.black);
		mGolf.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(mGolf);
		
		mEcoturismo = new JRadioButton("Ecoturismo");
		mEcoturismo.setBounds(600, 260, 120, 30);
		mEcoturismo.setBackground(Color.white);
		mEcoturismo.setForeground(Color.black);
		mEcoturismo.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(mEcoturismo);
		
		mHistorico = new JRadioButton("Hist�rico");
		mHistorico.setBounds(800, 260, 120, 30);
		mHistorico.setBackground(Color.white);
		mHistorico.setForeground(Color.black);
		mHistorico.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(mHistorico);
		
		mVerano = new JRadioButton("Verano");
		mVerano.setBounds(600, 300, 120, 30);
		mVerano.setBackground(Color.white);
		mVerano.setForeground(Color.black);
		mVerano.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(mVerano);
		
		mNavidad = new JRadioButton("Navidad");
		mNavidad.setBounds(800, 300, 120, 30);
		mNavidad.setBackground(Color.white);
		mNavidad.setForeground(Color.black);
		mNavidad.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(mNavidad);
		
		mTodoIncluido = new JRadioButton("Todo Incluido");
		mTodoIncluido.setBounds(685, 340, 120, 30);
		mTodoIncluido.setBackground(Color.white);
		mTodoIncluido.setForeground(Color.black);
		mTodoIncluido.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(mTodoIncluido);
		
		JLabel cantPisos = new JLabel("Catidad de Pisos: ");
		cantPisos.setBounds(550, 380, 130, 30);
		cantPisos.setForeground(Color.black);
		cantPisos.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(cantPisos);
		
		txtCantPisos = new JTextField();
		txtCantPisos.setBounds(680, 380, 270, 30);
		txtCantPisos.setForeground(Color.black);
		txtCantPisos.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCantPisos.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtCantPisos);
		
		JLabel totalHab = new JLabel("Total de habitaciones: ");
		totalHab.setBounds(550, 420, 160, 30);
		totalHab.setForeground(Color.black);
		totalHab.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(totalHab);
		
		txtCantHab = new JTextField();
		txtCantHab.setBounds(710, 420, 240, 30);
		txtCantHab.setForeground(Color.black);
		txtCantHab.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCantHab.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtCantHab);
		
		JLabel distCiudad = new JLabel("Distancia a la ciudad m�s cercana (km): ");
		distCiudad.setBounds(550, 460, 285, 30);
		distCiudad.setForeground(Color.black);
		distCiudad.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(distCiudad);
		
		txtDistCiudad = new JTextField();
		txtDistCiudad.setBounds(835, 460, 115, 30);
		txtDistCiudad.setForeground(Color.black);
		txtDistCiudad.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDistCiudad.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtDistCiudad);
		
		JLabel distAereopuerto = new JLabel("Distancia al aereopuerto (km): ");
		distAereopuerto.setBounds(550, 500, 220, 30);
		distAereopuerto.setForeground(Color.black);
		distAereopuerto.setFont(new Font("Arial", Font.PLAIN, 16));
		panelInferior.add(distAereopuerto);
		
		txtDistAereopuerto = new JTextField();
		txtDistAereopuerto.setBounds(770, 500, 180, 30);
		txtDistAereopuerto.setForeground(Color.black);
		txtDistAereopuerto.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDistAereopuerto.setBorder(new MatteBorder(0, 0, 3, 0, colorAzul));
		panelInferior.add(txtDistAereopuerto);
		
		btnAgregar = new JButton("Agregar Hotel");
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregar.setBackground(new Color(40, 113, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAgregar.setBackground(colorAzul);
			}
		});
		btnAgregar.setBounds(400, 560, 200, 30);
		btnAgregar.setModel(new MyButtonModel());
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 16));
		btnAgregar.setBackground(colorAzul);
		btnAgregar.setForeground(Color.black);
		btnAgregar.setFocusable(false);
		btnAgregar.setBorderPainted(false);
		panelInferior.add(btnAgregar);
	}
}