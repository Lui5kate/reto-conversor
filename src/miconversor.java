import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class miconversor {

	private JFrame frmConversorDeDivisas;
	private JTextField txt;
	private JLabel lbl;
	private JComboBox cmb;
	private JButton btn;
	
	public enum Moneda {
		seleccione_una_opción,
		pesos_dolar,
		pesos_euro,
		pesos_libraesterlina,
		pesos_yenjapones,
		pesos_wonsurcoreano,
		dolar_pesos,
		euro_pesos,
		libraesterlina_pesos,
		yenjapones_pesos,
		wonsurcoreano_pesos
	}
	
	public double dolar = 0.058;
	public double euro = 0.053;
	public double libra_esterlina = 0.046;
	public double yen_japones = 8.46;
	public double won_surcoreano = 77.28;
	
	public double valorInput = 0.00;
	private JButton btnSalir;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miconversor window = new miconversor();
					window.frmConversorDeDivisas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public miconversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeDivisas = new JFrame();
		frmConversorDeDivisas.setTitle("Conversor ONE - Luis Armando Lira");
		frmConversorDeDivisas.setBounds(100, 100, 435, 504);
		frmConversorDeDivisas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeDivisas.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setBounds(107, 145, 202, 20);
		frmConversorDeDivisas.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(127, 202, 168, 20);
		frmConversorDeDivisas.getContentPane().add(cmb);
		
		btn = new JButton("Convertir");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn.setBounds(169, 257, 89, 22);
		frmConversorDeDivisas.getContentPane().add(btn);
		
		lbl = new JLabel("00.00");
		lbl.setForeground(new Color(0, 0, 0));
		lbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(107, 304, 202, 31);
		frmConversorDeDivisas.getContentPane().add(lbl);
		
		JLabel lblNewLabel_1 = new JLabel("©Copyright Conversor - Luis Armando Lira González 2023");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 426, 399, 20);
		frmConversorDeDivisas.getContentPane().add(lblNewLabel_1);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnSalir.setBounds(169, 392, 89, 23);
		frmConversorDeDivisas.getContentPane().add(btnSalir);
		
		lblNewLabel_2 = new JLabel("Conversor de Divisas");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(57, 28, 300, 81);
		frmConversorDeDivisas.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LALG2\\eclipse-workspace\\reto-conversor\\images\\CONVERTIDOR-DE-MONEDAS.jpg"));
		lblNewLabel.setBounds(0, 0, 429, 498);
		frmConversorDeDivisas.getContentPane().add(lblNewLabel);
		
		menuBar = new JMenuBar();
		frmConversorDeDivisas.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tipo de Conversor");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Divisas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Temperatura");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LALG2\\eclipse-workspace\\reto-conversor\\images\\CONVERTIDOR-DE-TEMPERATURA.jpg"));
				lblNewLabel.setBounds(-300, -10, 1000, 460);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}
	
	public void Convertir() {
		// validacion de números
		if(Validar(txt.getText())) {
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch (moneda) {
			case pesos_dolar:
				PesosAMoneda(dolar);
				break;
			case pesos_euro:
				PesosAMoneda(euro);
				break;
			case pesos_libraesterlina:
				PesosAMoneda(libra_esterlina);
				break;
			case pesos_yenjapones:
				PesosAMoneda(yen_japones);
				break;
			case pesos_wonsurcoreano:
				PesosAMoneda(won_surcoreano);
				break;
			case dolar_pesos:
				MonedaAPesos(dolar);
				break;
			case euro_pesos:
				MonedaAPesos(euro);
				break;
			case libraesterlina_pesos:
				MonedaAPesos(libra_esterlina);
				break;
			case yenjapones_pesos:
				MonedaAPesos(yen_japones);
				break;
			case wonsurcoreano_pesos:
				MonedaAPesos(won_surcoreano);
				break;
			default:
				break;
			}
		}
	}
	
	public void PesosAMoneda(double moneda) {
		double resultado = valorInput * moneda;
		DecimalFormat formateado = new DecimalFormat("0.00");
		lbl.setText("" + formateado.format(resultado));
	}
	
	public void MonedaAPesos(double moneda) {
		double resultado = valorInput / moneda;
		DecimalFormat formateado = new DecimalFormat("0.00");
		lbl.setText("" + formateado.format(resultado));
	}
	
	// redondear decimales
		public String Redondear(double valor) {
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.HALF_UP);
			return df.format(valor);
		}
		
		// validar input
		public boolean Validar(String texto) {
			try {
				double x = Double.parseDouble(texto);
				if(x > 0);
				valorInput = x;
				return true;
			}catch(NumberFormatException e) {
				lbl.setText("Solamente números !!");
				return false;
			}
		}
}
