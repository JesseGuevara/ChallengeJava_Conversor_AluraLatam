package converters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class conversorTemperatura extends JFrame {
	
	private JTextField temperatura;
	private JComboBox<String> unidadTemperatura, unidad2;
	private JButton convertir, regresar;
	private JLabel resultado;
	
	public conversorTemperatura() {
		
		setTitle("Conversor de Temperatura");
	    setLayout(null);
	    
	    temperatura = new JTextField(10);
	    temperatura.setBounds(160, 20, 150, 30);
	    temperatura.setForeground(Color.WHITE);
	    temperatura.setBackground(new Color(34, 124, 112));
	    temperatura.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(temperatura);
        
        JLabel jlCantidad = new JLabel("Cantidad : ");
        jlCantidad.setBounds(15, 20, 170, 30);
        jlCantidad.setForeground(new Color(34, 124, 112));
        jlCantidad.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(jlCantidad);
        
        String[] items = {"Celsius", "Fahrenheit", "Kelvin"};
        unidadTemperatura = new JComboBox<String>(items);
        unidadTemperatura.setBounds(160, 60, 150, 30);
        unidadTemperatura.setForeground(Color.WHITE);
        unidadTemperatura.setBackground(new Color(34, 124, 112));
        unidadTemperatura.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(unidadTemperatura);
        
        JLabel jlUnidad = new JLabel("Temperatura a : ");
        jlUnidad.setBounds(15, 60, 170, 30);
        jlUnidad.setForeground(new Color(34, 124, 112));
        jlUnidad.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(jlUnidad);
        
        String[] items2 = {"Celsius", "Fahrenheit", "Kelvin"};
        unidad2 = new JComboBox<String>(items2);
        unidad2.setBounds(160, 120, 150, 30);
        unidad2.setForeground(Color.WHITE);
        unidad2.setBackground(new Color(34, 124, 112));
        unidad2.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(unidad2);
        
        JLabel jlCambio = new JLabel("Temperatura de : ");
        jlCambio.setBounds(15, 120, 150, 30);
        jlCambio.setForeground(new Color(34, 124, 112));
        jlCambio.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(jlCambio);
        
        convertir = new JButton("Convertir");
        convertir.setBounds(15, 200, 120, 30);
        convertir.setForeground(Color.WHITE);
        convertir.setBackground(new Color(34, 124, 112));
        convertir.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(convertir);
        
        // Agrega un listener al botón CONVERTIR
        convertir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Obtiene la cantidad a convertir
					double cantidad = Double.parseDouble(temperatura.getText());
					
					// Obtiene las unidades de entrada y salida seleccionadas
					String opcion1 = (String) unidadTemperatura.getSelectedItem();
					String opcion2 = (String) unidad2.getSelectedItem();
					double total = 0;
					
					// Verifica las unidades seleccionadas y realiza la conversión
					if (opcion1.equals("Kelvin") && opcion2.equals("Celsius")) {
						  total = cantidad - 273.15;
						
				       } else if (opcion1.equals("Kelvin") && opcion2.equals("Fahrenheit")) {
				    	  total = (cantidad - 273.15) * 9 / 5 + 32;
							
				       } else if (opcion1.equals("Celsius") && opcion2.equals("Kelvin")) {
				    	  total = cantidad + 273.15;
							
				       } else if (opcion1.equals("Celsius") && opcion2.equals("Fahrenheit")) {
				    	  total = (cantidad * 9 / 5) + 32;
					
				       } else if (opcion1.equals("Fahrenheit") && opcion2.equals("Kelvin")) {
				    	  total = (cantidad - 32) * 5 / 9 + 273.15;
					
				       } else if (opcion1.equals("Fahrenheit") && opcion2.equals("Celsius")) {
				    	  total = (cantidad - 32) * 5 / 9;
					
				   }
					
					// Formatea la cantidad resultante a dos decimales
					DecimalFormat df = new DecimalFormat("#.##");
			        df.format(total);
			        
			        // Muestra el resultado en el componente resultado
			        resultado.setText(cantidad + " " + opcion1 + " = " + total + " " + opcion2);
					
				} catch (NumberFormatException ex) {
					// Muestra un mensaje de error si el valor ingresado no es un número válido
			        resultado.setText("Ingresar un número válido!");
				  }
				
				
			}
        	
        });
        setVisible(true);
        
        regresar = new JButton("Regresar");
        regresar.setBounds(190, 200, 120, 30);
        regresar.setForeground(Color.WHITE);
        regresar.setBackground(new Color(34, 124, 112));
        regresar.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        // Agrega un listener al botón REGRESAR
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
        resultado.setBounds(15, 270, 270, 30);
        resultado.setForeground(new Color(34, 124, 112));
        resultado.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(resultado);

	    setSize(350, 350);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	}
	
	
	public static void main(String[] args) {
		conversorTemperatura conversor2 = new conversorTemperatura();
        conversor2.setVisible(true);
    }

}