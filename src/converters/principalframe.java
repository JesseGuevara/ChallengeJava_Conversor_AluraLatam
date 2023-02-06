package converters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principalframe extends JFrame {
	
	 private JButton continuar;
	 private JButton salir;
	 private JComboBox<String> opciones;
	 
	 public principalframe() {
		 
		 setTitle("Ventana Principal");
	     setLayout(null);
	     
	     continuar = new JButton("CONTINUAR");
	     continuar.setBounds(20, 200, 140, 30);
	     continuar.setForeground(Color.WHITE);
	     continuar.setBackground(new Color(34, 124, 112));
	     continuar.setFont(new Font("Tahoma", Font.BOLD, 16));
	     add(continuar);
	     
	     salir = new JButton("CERRAR");
	     salir.setBounds(195, 200, 120, 30);
	     salir.setForeground(Color.WHITE);
	     salir.setBackground(new Color(34, 124, 112));
	     salir.setFont(new Font("Tahoma", Font.BOLD, 16));
	     add(salir);
	     
	     
	     String[] items = {"Conversor de Divisas", "Conversor de Temperatura"};
	     opciones = new JComboBox<String>(items);
	     opciones.setBounds(40, 50, 250, 30);
	     opciones.setForeground(Color.WHITE);
	     opciones.setBackground(new Color(34, 124, 112));
	     opciones.setFont(new Font("Tahoma", Font.BOLD, 16));
	     add(opciones);

	     // Agrega un listener al botón CONTINUAR
	     continuar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 
					elegirConversor();
					
				}
		    	 
		     });
	     
	    
	    // Agrega un listener al botón SALIR
	     salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			//Control  del evento de acción del botón SALIR
				
				 try {
					// Muestra un cuadro de diálogo de confirmación antes de salir
	                    int salir = JOptionPane.showConfirmDialog(principalframe.this, "¿Está seguro de salir de la aplicación?", 
	                    		"Exit Confirmation", JOptionPane.YES_NO_OPTION);
	                    if (salir == JOptionPane.YES_OPTION) {
	                    	 // Salir de la aplicación
	                        System.exit(0);
	                    }
	                } catch (Exception ex) {
	                	 // Muestra un cuadro de diálogo de error en caso de una excepción
	                    JOptionPane.showMessageDialog(principalframe.this, "Ha ocurrido un error: " + ex.getMessage(), 
	                    		"Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });

	     
	     setSize(350, 300);
	     setLocationRelativeTo(null);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
	 }
	 

		public void elegirConversor() {
			
			
			try {
				
				// Obtiene el valor seleccionado por el usuario
				String elegir = (String) opciones.getSelectedItem();
			    
				// Verifica si el valor seleccionado es "Conversor de Divisas"
			    if  (elegir.equals("Conversor de Divisas")){
			    
			     // Cierra la ventana actual
			     dispose();
			     
			     // Crea una nueva ventana "conversorDivisas" y la hace visible
			     conversorDivisas conversor1 = new conversorDivisas();
		         conversor1.setVisible(true);
		      
		      // Verifica si el valor seleccionado es "Conversor de Temperatura"
			} else if (elegir.equals("Conversor de Temperatura")){
			    
				 //Cierra la ventana actual
				 dispose();
				 
				// Crea una nueva ventana "conversorTemperatura" y la hace visible
				 conversorTemperatura conversor2 = new conversorTemperatura();
				 conversor2.setVisible(true);
		
			    }
				
			// En caso de error, muestra un mensaje de error en un cuadro de diálogo  
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(principalframe.this, "Ha ocurrido un error: " + ex.getMessage(), 
                 "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	 

	public static void main(String[] args) {
		    principalframe principal = new principalframe();
	        principal.setVisible(true);
	    }

}