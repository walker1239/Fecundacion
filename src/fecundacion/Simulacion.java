package fecundacion;

import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.*; 
import javax.swing.*; 

public class Simulacion extends JFrame{
	
	static JFrame frame; 
	static JLabel label;

	static JButton start;
	static JButton run;
	static JTextField field;


	private static Queue<Espermatozoides> queue;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		frame = new JFrame("Carrera de Espermas");
		
		label = new JLabel("Ingrese el Número de Espermas");
		start = new JButton("Start");
		field = new JTextField(15);
		run = new JButton("Run");
	
		
		JPanel tempPanel = new JPanel();
		tempPanel.add(label);
		tempPanel.add(field);
		tempPanel.add(start);
		
		
		queue = new LinkedList<Espermatozoides>();
		
		start.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int max= Integer.parseInt(field.getText());
				
				JPanel espPanel = new JPanel();
				espPanel.setLayout(new GridLayout(0,4));
				
				frame.remove(tempPanel);				
				
				JLabel l1 = new JLabel("Ovulo");
				JLabel l2 = new JLabel("Esperma");
				
				Font font = new Font("Arial Black", Font.BOLD,12);
						
				l1.setFont(font);
				l2.setFont(font);

				l1.setHorizontalAlignment(JLabel.CENTER);
				l2.setHorizontalAlignment(JLabel.CENTER);

				espPanel.add(l1);
				espPanel.add(l2);
				
				
				JLabel Ovul = new JLabel(Ovulito.ovulito.nombre);
				Ovul.setHorizontalAlignment(JLabel.CENTER);
				espPanel.add(Ovul);
				
				JLabel Esperma = new JLabel("null");
				Esperma.setHorizontalAlignment(JLabel.CENTER);
				espPanel.add(Esperma);
				Esperma.setHorizontalAlignment(JLabel.CENTER);
				
				for(int m=0;m < max;m++){
					
					
					String nombre="Espermatozoide "+m;
					
					Espermatozoides esperma = new Espermatozoides(nombre,Esperma);
					queue.add(esperma);
					
						
					
				}
				frame.add(espPanel);
				frame.setSize(700,100+4*20);
				frame.revalidate();
			
				espPanel.add(run);
				frame.add(espPanel);
				
				frame.revalidate();
				
			}          
	      });
		
		run.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				while( !queue.isEmpty() ) {
		            if( !queue.element().isAlive() ) {
		            	queue.element().start();
		            	queue.remove();
		            }
				}
				
			}
		});
		
		frame.add(tempPanel);
		
		frame.setSize(500, 80);
		frame.show();
	}
		
}