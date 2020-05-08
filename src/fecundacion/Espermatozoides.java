package fecundacion;

import java.util.Random;

import javax.swing.JLabel;


public class Espermatozoides extends Thread{
	
	String nombre;
	JLabel estesi;

	Espermatozoides(String nombreEsperma,JLabel este){
		
		this.nombre= nombreEsperma;
		estesi=este;
	}
	
	public String getNombre() {
		return nombre;
	}
	

	
	
	public void run() {
		
		int m = 0; 
        try { 
            while (m <= 10273) { 
                m += 100; 
                Random r = new Random();
        		int sT = r.nextInt(100);
                
                sleep(sT); 
            } 
        } 
        catch (Exception e) { 
        } 
        synchronized(this) {
        	Ovulito.ovulito.fecundar(nombre,estesi);
        }

        

    } 
	

}
