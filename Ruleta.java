package AG;
import java.util.Random;

public class Ruleta {
	
	private Individuo [] individuosSelectos;
	private float valoresEsperados[];
	private float sumatoriaVE; // Suma de los valores esperados, siempre es igual al tamaño de la poblacion.
	private float f = 0; // promedio de las Aptitudes
	

	public Ruleta(int t){
		individuosSelectos = new Individuo[t];
		valoresEsperados = new float[t];
	}
	
	public void SeleccionaIndividuos(Individuo [] individuos, float [] apt){
		calcularAtributos(apt); // calcula F y los valores esperados de acuerdo a la poblacion actual.
		int p1, p2; // posiciones de individuos
		for(int i = 0 ; i<apt.length ; i++){
			do { 
				p1 = calcularPI(); p2 = calcularPI();
			}while(p1==p2);
			// se compara las aptitudes de los individuos selectos de acuerdo a su posicion, y el mejor pasa al vector de cruza
			individuosSelectos[i] = (apt[p1]>apt[p2])?individuos[p1]:individuos[p2];
		}
	}
	
	
	private int calcularPI() {
		Random r = new Random();
		float sumatoriaVe = 0;
		int posicion = 0;
		
		while(sumatoriaVe <= ( Math.round(r.nextFloat() * (sumatoriaVE * 10)) / 10)){
			sumatoriaVe = sumatoriaVe + valoresEsperados[posicion];
			posicion ++ ;
		}
		return posicion;
	}

	private void calcularAtributos(float[] apt) {
		f = calcularF(apt);
		valoresEsperados = calcularValoresEsperados(apt);
	}

	private float calcularF(float [] apt) {
		float p = 0;
		for(int i = 0;i<apt.length;i++){
			p += apt[i];
		}
		return( p / apt.length );
	}

	private float [] calcularValoresEsperados(float [] apt) {
		sumatoriaVE = 0;
		int t = apt.length; 
		float [] nve = new float[t];
		for(int i = 0;i<t;i++){
			//se divide la aptitud de cada individuo entre el promedio de las aptitudes para calcular el valor esperado
			nve[i] = ( apt[i] / f );
			sumatoriaVE += nve[i];
		}
		sumatoriaVE = Math.round(sumatoriaVE);
		return nve;
	}
	
	public Individuo[] getIndividuosSelectos() {
		return individuosSelectos;
	}

	public void setIndividuosSelectos(Individuo[] individuosSelectos) {
		this.individuosSelectos = individuosSelectos;
	}

	public float[] getValoresEsperados() {
		return valoresEsperados;
	}

	public float getSumatoriaVE() {
		return sumatoriaVE;
	}

	public float getF() {
		return f;
	}
}
