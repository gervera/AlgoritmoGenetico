package AG;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JTextPane;

import java.awt.Font;

public class Interfaz extends JFrame {
	private static final String SwingConstans = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static int[]  mejorIndividuo;
	static int generacionMejorIndividuo;
	static double beneficioMejorIndividuo;
	static DecimalFormat f1 = new DecimalFormat("#.00");
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tamañoPantalla = pantalla.getScreenSize();
		int alto = tamañoPantalla.height;
		int ancho = tamañoPantalla.width;
		setTitle("Algoritmo Genetico 1.0");
		setBounds(ancho/8, alto/8, 800, 650);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(800, 800));
		contentPane.setMaximumSize(new Dimension(800, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		JLabel labelPoblacion = new JLabel("Tamaño Población ");
		labelPoblacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(labelPoblacion);
		
		JPanel panel_1 = new JPanel();
		
		JLabel labelGeneraciones = new JLabel("Número de Generaciones");
		labelGeneraciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(labelGeneraciones);
		
		JPanel panel_2 = new JPanel();
		
		JLabel labelCruza = new JLabel("Índice de Cruza");
		labelCruza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(labelCruza);
		
		JPanel panel_3 = new JPanel();
		
		JLabel labelMutacion = new JLabel("Índice de Mutacion");
		labelMutacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(labelMutacion);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Ejecutar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_4 = new JPanel();
		
		JLabel label = new JLabel("Mejor Individuo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_3)
										.addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
										.addComponent(textField_2))))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
							.addGap(140))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"G", "Individuo", "C", "M"
				}
			));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(180);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		DefaultTableModel modelo1 = (DefaultTableModel) table_1.getModel();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(0);
		
		table_1.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table_1.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table_1.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table_1.getColumnModel().getColumn(3).setCellRenderer(tcr);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "Individuo", "Beneficio"
			}
		));

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
//		String [] v= new String [3];
//		for(int i=0;i<50;i++){
//			v[0]=i+1+""; v[1]= "d"; v[2]="2";
//			modelo.addRow(v);
//		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				modelo.setRowCount(0);
				modelo1.setRowCount(0);
				mejorIndividuo = null;
				generacionMejorIndividuo=0;
				beneficioMejorIndividuo=0;
				
				boolean b=validarDatos();
				if(!b){
				try{
					Converciones co = new Converciones();
					Poblacion poblacion = new Poblacion(Integer.parseInt(textField.getText()));
					Aptitud aptitud = new Aptitud(poblacion.getSizePoblacion());
					Ruleta ruleta = new Ruleta(poblacion.getSizePoblacion());
					Cruza cruza = new Cruza(Float.parseFloat(textField_2.getText()),poblacion.getSizePoblacion());
					Mutacion muta = new Mutacion(Float.parseFloat(textField_3.getText()),poblacion.getSizePoblacion());
					tablaBeneficios beneficio = new tablaBeneficios(poblacion.getSizePoblacion());
					
					String [] v1= new String [4];
					poblacion.generarPoblacion();
					//imprimir(poblacion.getIndividuos());
					for(int i= 0;i<Integer.parseInt(textField_1.getText());i++){
						System.out.println("\n Generacion " + (i+1));
						
						beneficio.calcularBeneficioInd(poblacion.getIndividuos());
						aptitud.calcularValoresApt(poblacion);
						ruleta.SeleccionaIndividuos(poblacion.getIndividuos(),aptitud.getValoresApt());
						cruza.cruzaIndividuos(ruleta.getIndividuosSelectos());
						muta.mutaIndividuos(cruza.getResultadoCruza());
						poblacion.setIndividuos(co.convertirIndBinToDec(muta.getResultadoMutacion()));
						poblacion.corregirPoblacion(0);
						poblacion.setIndividuosEspecifico(beneficio.getmIndividuo(),beneficio.getpMejorBen());
						beneficio.calcularBeneficioInd(poblacion.getIndividuos());
						
						imprimir(poblacion.getIndividuos());
//						imprimir(beneficio.getBeneficioIndividuos());
						v1 = encontrarMejor(poblacion.getIndividuos(),beneficio.getBeneficioIndividuos(),cruza.getNumeroCruzas(),muta.getNumeroMutaciones(),i);
						modelo1.addRow(v1);
					}
					
					//Agregar Valores a Tabla
					String [] v= new String [3];
					Individuo [] po = poblacion.getIndividuos();
					double [] be = beneficio.getBeneficioIndividuos();
					for(int i=0;i<po.length;i++){
						v[0]=i+1+""; v[1]="[ "+po[i].getGen(0)+" , "+po[i].getGen(1)+" , "+po[i].getGen(2)+" , "+po[i].getGen(3)+" ]"; v[2]=""+f1.format(be[i]);
						modelo.addRow(v);
					}
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Valores no validos para el correcto funcionamiento del programa.", "Datos Invalidos", JOptionPane.WARNING_MESSAGE);
			}
				
				
		}

			private boolean validarDatos() {
				if(	textField.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_1.getText().equals("")
				   ||Integer.parseInt(textField.getText())<10 || (Integer.parseInt(textField.getText())%2)!=0
				   || Float.parseFloat(textField_2.getText())>1 || Float.parseFloat(textField_2.getText())<0
				   || Float.parseFloat(textField_3.getText())>1 || Float.parseFloat(textField_3.getText())<0
				   || Integer.parseInt(textField_1.getText())<1){
					return true;
				}
				return false;
			}

			private String [] encontrarMejor(Individuo[] ind,
					double[] ben, int nCruzas, int nMutaciones, int i) {
				int [] mejorIndGeneracion = new int [4];
				double beneficioMg =0;
				String [] v = new String[4];
				for(int j=0;j<ind.length;j++){
					if(beneficioMg<ben[j]){
						mejorIndGeneracion = ind[j].getGenesCompleto();
						beneficioMg=ben[j];
					}
					
					if(beneficioMejorIndividuo<ben[j]){
						beneficioMejorIndividuo = ben[j];
						mejorIndividuo = ind[j].getGenesCompleto();
						generacionMejorIndividuo = i+1;
						
						textPane.setText("      [ "+
								mejorIndividuo[0]+" , "+mejorIndividuo[1]+" , "+mejorIndividuo[2]+" , "+
								mejorIndividuo[3]+" ]      Beneficio: "+f1.format(beneficioMejorIndividuo));
						
//						textPane.setText("Generacion: "+generacionMejorIndividuo+" Individuo: [ "+
//								mejorIndividuo[0]+" , "+mejorIndividuo[1]+" , "+mejorIndividuo[2]+" , "+
//								mejorIndividuo[3]+" ], Beneficio: "+f1.format(beneficioMejorIndividuo));
					}
				}
				v[0] = ""+(i+1); v[1] ="[ "+mejorIndGeneracion[0]+" , "+mejorIndGeneracion[1]+" , "+mejorIndGeneracion[2]+" , "+
						mejorIndGeneracion[3]+" ]     "+f1.format(beneficioMg) ;
				v[2] = ""+nCruzas*2; v[3] = ""+nMutaciones;
				return v;
			}
		});
	}
	private static void imprimir(double[] beneficioIndividuos) {
		for(int i=0;i<beneficioIndividuos.length;i++) {
			System.out.print("\n"+(i+1)+" - - - " +beneficioIndividuos[i]);
		}
		System.out.print("\n");
			
		}
	static void imprimir(Individuo ind[]){
		int [] num;
		for(int i=0;i<ind.length;i++) {
			num  = ind[i].getGenesCompleto();
			System.out.print("\n"+(i+1)+" - ");
			for(int j=0;j<4;j++) {
				System.out.print(num[j] + " ");
			}
		}
		System.out.print("\n");
	}
	
}
