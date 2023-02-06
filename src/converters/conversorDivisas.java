package converters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class conversorDivisas extends JFrame {
	
	  private JTextField monto;
	  private JComboBox<String> fromDivisas;
	  private JComboBox<String> toDivisas;
	  private JButton convertir, regresar;
	  private JLabel resultado;
	
	public conversorDivisas() {
		
	
		setTitle("Conversor de Divisas");
	    setLayout(null);
	    
	    monto = new JTextField(10);
        monto.setBounds(160, 20, 150, 30);
	    monto.setForeground(Color.WHITE);
	    monto.setBackground(new Color(34, 124, 112));
	    monto.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(monto);
        
        JLabel jlMonto = new JLabel("Monto : ");
        jlMonto.setBounds(15, 20, 170, 30);
        jlMonto.setForeground(new Color(34, 124, 112));
        jlMonto.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(jlMonto);
        
        String[] items = {"HNL", "USD", "EUR", "GBP", "JPY", "KRW"};
        fromDivisas = new JComboBox<String>(items);
        fromDivisas.setBounds(160, 60, 150, 30);
        fromDivisas.setForeground(Color.WHITE);
        fromDivisas.setBackground(new Color(34, 124, 112));
        fromDivisas.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(fromDivisas);
        
        JLabel jlBase = new JLabel("Moneda de base : ");
        jlBase.setBounds(15, 60, 170, 30);
        jlBase.setForeground(new Color(34, 124, 112));
        jlBase.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(jlBase);
        
        String[] items2 = {"HNL", "USD", "EUR", "GBP", "JPY", "KRW"};
        toDivisas = new JComboBox<String>(items2);
        toDivisas.setBounds(160, 120, 150, 30);
        toDivisas.setForeground(Color.WHITE);
        toDivisas.setBackground(new Color(34, 124, 112));
        toDivisas.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(toDivisas);
        
        JLabel jlCambio = new JLabel("Cambio a : ");
        jlCambio.setBounds(15, 120, 150, 30);
        jlCambio.setForeground(new Color(34, 124, 112));
        jlCambio.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(jlCambio);
        
        convertir = new JButton("Convertir");
        convertir.setBounds(15, 200, 120, 30);
        convertir.setForeground(Color.WHITE);
        convertir.setBackground(new Color(34, 124, 112));
        convertir.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        // Agrega un listener al botón convertir
        convertir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				convertirDivisas();
        	
			}
			
		});
        add(convertir);
        
        regresar = new JButton("Regresar");
        regresar.setBounds(190, 200, 120, 30);
        regresar.setForeground(Color.WHITE);
        regresar.setBackground(new Color(34, 124, 112));
        regresar.setFont(new Font("Tahoma", Font.BOLD, 16));
        
       // Agrega un listener al botón regresar
        regresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				principalframe principalframe = new principalframe();
				principalframe.setVisible(true);
				
			}
        	
        });
        add(regresar);
        
        resultado = new JLabel(" ");
        resultado.setBounds(50, 270, 250, 30);
        resultado.setForeground(new Color(34, 124, 112));
        resultado.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(resultado);

	    
	    setSize(350, 350);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void convertirDivisas() {
		
		// Este código se encarga de convertir la cantidad ingresada en una divisa a otra divisa.
		 try {
			// obtener la cantidad a convertir del campo monto
		        double cantidad = Double.parseDouble(monto.getText());
		        String de = (String) fromDivisas.getSelectedItem();
		        String para = (String) toDivisas.getSelectedItem();
		        
		        // variable para almacenar el resultado de la conversión
		        double estimado = 0;
		        
		        // if-else statements para establecer el valor de conversión
			    // basado en las divisas seleccionadas
		        if (de.equals("HNL") && para.equals("USD")) {
		            estimado = 0.041;
		        } 
		        else if (de.equals("HNL") && para.equals("EUR")) {
		            estimado = 0.037;
		        } 
		        else if (de.equals("HNL") && para.equals("GBP")) {
		            estimado = 0.033;
		        } 
		        else if (de.equals("HNL") && para.equals("JPY")) {
		            estimado = 5.27;
		        } 
		        else if (de.equals("HNL") && para.equals("KRW")) {
		            estimado = 49.86;
		        } 
		        else if (de.equals("USD") && para.equals("HNL")) {
		            estimado = 24.67;
		        } 
		        else if (de.equals("EUR") && para.equals("HNL")) {
		            estimado = 26.82;
		        } 
		        else if (de.equals("GBP") && para.equals("HNL")) {
		            estimado = 30.54;
		        } 
		        else if (de.equals("JPY") && para.equals("HNL")) {
		            estimado = 0.19;
		        } 
		        else if (de.equals("KRW") && para.equals("HNL")) {
		            estimado = 0.020;
		        } 
		        else if (de.equals("USD") && para.equals("EUR")) {
		            estimado = 0.92;
		        
		        }
		        else if (de.equals("USD") && para.equals("GBP")) {
		            estimado = 0.81;
		        }
		        
		        else if (de.equals("USD") && para.equals("JPY")) {
		            estimado = 129.89;
		        }
		        
		        else if (de.equals("USD") && para.equals("KRW")) {
		            estimado = 1230.05;
		        }
		        
		        else if (de.equals("EUR") && para.equals("USD")) {
		            estimado = 1.09;
		        }
		        
		        else if (de.equals("EUR") && para.equals("GBP")) {
		            estimado = 0.88;
		        }
		        
		        else if (de.equals("EUR") && para.equals("JPY")) {
		            estimado = 141.22;
		        }
		        
		        else if (de.equals("EUR") && para.equals("KRW")) {
		            estimado = 1337.49;
		        }
		        
		        else if (de.equals("GBP") && para.equals("USD")) {
		            estimado = 1.24;
		        } 
		        
		        else if (de.equals("GBP") && para.equals("EUR")) {
		            estimado = 1.14;
		        } 
		        
		        else if (de.equals("GBP") && para.equals("JPY")) {
		            estimado = 160.81;
		        } 
		        
		        else if (de.equals("GBP") && para.equals("KRW")) {
		            estimado = 1522.92;
		        } 
		        
		        else if (de.equals("JPY") && para.equals("USD")) {
		            estimado = 0.0077;
		        } 
		        
		        else if (de.equals("JPY") && para.equals("EUR")) {
		            estimado = 0.0071;
		        } 
		        
		        else if (de.equals("JPY") && para.equals("GBP")) {
		            estimado = 0.0062;
		        } 
		        
		        else if (de.equals("JPY") && para.equals("KRW")) {
		            estimado = 9.47;
		        } 
		        
		        else if (de.equals("KRW") && para.equals("USD")) {
		            estimado = 0.00081;
		        } 
		        
		        else if (de.equals("KRW") && para.equals("EUR")) {
		            estimado = 0.00075;
		        } 
		        
		        else if (de.equals("KRW") && para.equals("GBP")) {
		            estimado = 0.00066;
		        } 
		        
		        else if (de.equals("KRW") && para.equals("JPY")) {
		            estimado = 0.11;
		        } 
		        
		       // mostrar el resultado de la conversión al usuario
		        DecimalFormat df = new DecimalFormat("#.##");
		        String total = df.format(cantidad * estimado);
		        resultado.setText(cantidad + " " + de + " = " + total + " " + para);
		        
		    } catch (NumberFormatException e) {
		    	// manejar excepción en caso de que el usuario no ingrese una cantidad válida
		        JOptionPane.showMessageDialog(this, "Por favor, ingresar un número válido!", 
		        "Error", JOptionPane.ERROR_MESSAGE);
		    }
		
		
	     }
	  
	
	public static void main(String[] args) {
		conversorDivisas conversor1 = new conversorDivisas();
        conversor1.setVisible(true);
    }	

}