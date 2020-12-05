package AG;

import java.util.Random;
import java.lang.StringBuilder;

public class Mutacion {
	private float indiceMutacion;
	private String [] resultadoMutacion;
	private int numeroMutaciones;
	
	Random r = new Random();
	
	
	public Mutacion(float indiceMutacion,int t){
		this.indiceMutacion = indiceMutacion;
		resultadoMutacion= new String[t];
	}

	public void mutaIndividuos(String[] resultadoCruza) {
		numeroMutaciones=0;
		for (int i = 0; i<resultadoCruza.length; i++){
			if(indiceMutacion>(r.nextFloat()*1)){// se calcula el random para ver si se mutara
				resultadoMutacion[i] = mutaPunto(resultadoCruza[i]);
				numeroMutaciones++;
			}else{// si el individuo no se muta, su valor pasa directamente al vector de resultadoMutacion
				resultadoMutacion[i] = resultadoCruza[i];
			}
		}
	}

	public int getNumeroMutaciones() {
		return numeroMutaciones;
	}

	public void setNumeroMutaciones(int numeroMutaciones) {
		this.numeroMutaciones = numeroMutaciones;
	}

	private String mutaPunto(String cromosoma) {
		int puntoMutado = r.nextInt(16); // se genera un random entre 0-15 para posteriormente mutarlo.
		String m = cromosoma.substring(puntoMutado,puntoMutado+1); // se agarra el valor de ese punto.
		
		if(cromosoma.substring(puntoMutado, puntoMutado+1).equals("0")){ // si es valor del punto es 0 se remplaza por 1, en caso de ser 1, es remplazado por 0
			cromosoma = new StringBuilder(cromosoma).replace(puntoMutado, puntoMutado+1, "1").toString();
		}else{
			cromosoma = new StringBuilder(cromosoma).replace(puntoMutado, puntoMutado+1, "0").toString();
		}
		return cromosoma;
	}

	public String[] getResultadoMutacion() {
		return resultadoMutacion;
	}

	public void setResultadoMutacion(String[] resultadoMutacion) {
		this.resultadoMutacion = resultadoMutacion;
	}
	
}
