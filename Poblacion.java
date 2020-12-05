package AG;
import java.util.Random;

public class Poblacion  {
	private int sizePoblacion;
	private Individuo [] individuos;
	
	Random rnd = new Random();
	
	 Poblacion(int sizePoblacion){
		this.sizePoblacion = sizePoblacion;
		individuos = new Individuo [sizePoblacion];
		//generarPoblacion(rnd);
	}
	 
	public void generarPoblacion() {
		Individuo cromosoma;
		int s;
		for(int i=0;i<sizePoblacion;i++) {
			cromosoma = new Individuo(4);
			do{
				s= 0;
				for(int j=0;j<4;j++) {
					//Se genera un Random entre 0-40 y se divide entre 10 para que su valor quede entre 1-4
					cromosoma.setGen(j, (rnd.nextInt(10000) + 1)/1000); 
					s = s + cromosoma.getGen(j);
				}
			}while(s!=10);
			
			individuos[i] = cromosoma;
		}
	}

	public int getSizePoblacion() {
		return sizePoblacion;
	}

	public Individuo[] getIndividuos() {
		return individuos;
	}
	
	public Individuo getIndividuos(int p) {
		return individuos[p];
	}

	public void setIndividuos(Individuo[] individuos) {
		this.individuos = individuos;
	}	
	
	public void setIndividuosEspecifico(Individuo individuo,int posicion) {
		this.individuos[posicion]= individuo;
	}

	public void corregirPoblacion(int ChangeValor) {
		Individuo ind;
		int sumaValores;
		int mayor;
		int valorGen;
		int posicionMayor;
		
		for(int i=0;i<sizePoblacion;i++){
			posicionMayor = 0;
			mayor = 0; 
			sumaValores = 0;
			ind = individuos[i];
			for(byte j=0;j<4;j++){
				valorGen = ind.getGen(j);
				if(valorGen<=ChangeValor){
					ind.setGen(j, rnd.nextInt(4)+1);
				}
			}
			for(byte l=0;l<4;l++){
				valorGen = ind.getGen(l);
				sumaValores = sumaValores + valorGen;
				if(mayor<valorGen){
					mayor = valorGen;
					posicionMayor = l;
				}
			}
			
			if(sumaValores>10){
				mayor = mayor - (sumaValores-10);
				ind.setGen(posicionMayor, (mayor<0)?mayor*-1:mayor);
			}
			individuos[i] = ind;
		}
	}
}
