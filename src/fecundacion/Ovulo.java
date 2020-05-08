package fecundacion;
import javax.swing.JLabel;


public class Ovulo{
	
	public String nombre;
	public String esperma;
	
	static boolean fecundado;

	Ovulo(String _nombre){
		
		this.nombre= _nombre;
				
		fecundado=false;

	}
	
	public void fecundar( String _espermatozoide, JLabel este) {
		if(fecundado==false) {
			fecundado=true;
			System.out.println(_espermatozoide+" entro");
			este.setText(_espermatozoide);
			esperma=_espermatozoide;
		}
		else {
			System.out.println(_espermatozoide+" se quedo fuera");
		}

	}
}