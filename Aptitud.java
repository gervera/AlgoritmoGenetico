package AG;

import java.text.DecimalFormat;
import java.util.Random;

public class Aptitud {
	private float [] valoresApt;

	public Aptitud(int size){
		valoresApt = new float[size];
	}
	
	public void calcularValoresApt(Poblacion p){
		int t = p.getSizePoblacion();
		for(int i = 0; i<t;i++){
			valoresApt[i] = calcularAptitud(p.getIndividuos(i).getGenesCompleto());
		}
	}

	private float calcularAptitud(int [] gen) {
		int suma = 0;
		//se suman los valores de los genes del individuo
		for(int i=0;i<4;i++) {
			suma = suma + gen[i];
		}		
		//se calcula la aptitud de acuerdo a la formula del problema
		float divicion = 500 * Math.abs(suma-10) + 1;
		divicion = suma / divicion;
		return  divicion;
	}

	public float[] getValoresApt() {
		return valoresApt;
	}

	public void setValoresApt(float[] valoresApt) {
		this.valoresApt = valoresApt;
	}
}
