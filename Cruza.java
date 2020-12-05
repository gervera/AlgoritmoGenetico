package AG;

import java.util.Random;

public class Cruza{
	private String [] individuosBinario;
	private String [] resultadoCruza;
	private float indiceCruza;
	private int numeroCruzas;
	
	public int getNumeroCruzas() {
		return numeroCruzas;
	}

	Random r = new Random();
	Converciones co = new Converciones();
	
	public Cruza(float indiceCruza, int t){
		this.indiceCruza = indiceCruza;
		resultadoCruza = new String[t];
		individuosBinario = new String[t];
		
	}

	public void cruzaIndividuos(Individuo[] ind) {
		numeroCruzas = 0;
		int t = ind.length;
		
		for(int i = 0 ; i < t; i++){
			individuosBinario[i] = co.decimalToBin(ind[i].getGenesCompleto()); //se convierte a binario la poblacion
		}
		
		for (int i = 0; i<t; i+=2){
			if(indiceCruza>(r.nextFloat()*1)){// calcula numero aleatorio para ver si se cruzaran los individuos
				cruzaDosPuntos(i);
				numeroCruzas++;
			}else{//en caso de que no se realice la cruza el individuo pasa directamente al vector de resultadoCruza
				resultadoCruza[i] = individuosBinario[i];
				resultadoCruza[i+1] = individuosBinario[i+1];
			}
		}
	}

	private void cruzaDosPuntos( int posicion) {
		//se optiene los invidivuos a cruzar en binario
		String padre_bin = individuosBinario[posicion],
			   madre_bin = individuosBinario[posicion + 1],
			   aux;
		
		int puntoCorteUno, puntoCorteDos;
		//se genera de manera aleatoria los puntos donde se cortaran las cadenas para la cruza
		do{
			 puntoCorteUno = r.nextInt(14) + 1;
			 puntoCorteDos = r.nextInt(14) + 1;
		}while(puntoCorteUno == puntoCorteDos || puntoCorteUno>puntoCorteDos);
		
		aux = padre_bin;
		//se realiza la cruza,ademas los hijos remplazan a los padres
		padre_bin = padre_bin.substring(0, puntoCorteUno) + 
					madre_bin.substring(puntoCorteUno,puntoCorteDos)+
					padre_bin.substring(puntoCorteDos, padre_bin.length());
		
		 madre_bin = madre_bin.substring(0, puntoCorteUno) + 
					 aux.substring(puntoCorteUno,puntoCorteDos)+
					 madre_bin.substring(puntoCorteDos, padre_bin.length());
		 		 
		 resultadoCruza[posicion]     = padre_bin;
		 resultadoCruza[posicion + 1] = madre_bin;
	}
	
	private String cortarCadena(String p, String m){
		
		int puntoCorteUno, puntoCorteDos;
		//se genera de manera aleatoria los puntos donde se cortaran las cadenas para la cruza
		do{
			 puntoCorteUno = r.nextInt(14) + 1;
			 puntoCorteDos = r.nextInt(14) + 1;
		}while(puntoCorteUno == puntoCorteDos || puntoCorteUno>puntoCorteDos);
		//se realiza el corte y nace el nuevo individuo
		String resultadoCorte = p.substring(0, puntoCorteUno) + 
								m.substring(puntoCorteUno,puntoCorteDos)+
							    p.substring(puntoCorteDos, p.length());
		
		return resultadoCorte;
	}
	
	public String[] getResultadoCruza() {
		return resultadoCruza;
	}

	public void setResultadoCruza(String[] resultadoCruza) {
		this.resultadoCruza = resultadoCruza;
	}

	

}
