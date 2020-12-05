package AG;

public class Problema {

	public static void main(String[] args) {
		
		Converciones co = new Converciones();
		Poblacion poblacion = new Poblacion(100);
		Aptitud aptitud = new Aptitud(poblacion.getSizePoblacion());
		Ruleta ruleta = new Ruleta(poblacion.getSizePoblacion());
		Cruza cruza = new Cruza(0.8f,poblacion.getSizePoblacion());
		Mutacion muta = new Mutacion(0.01f,poblacion.getSizePoblacion());
		tablaBeneficios beneficio = new tablaBeneficios(poblacion.getSizePoblacion());
		
		poblacion.generarPoblacion();
		imprimir(poblacion.getIndividuos());
		for(int i= 0;i<20;i++){
			System.out.println("\n Generacion " + (i+1));
//			imprimir(poblacion.getIndividuos());
			aptitud.calcularValoresApt(poblacion);
			ruleta.SeleccionaIndividuos(poblacion.getIndividuos(),aptitud.getValoresApt());
			//imprimir(ruleta.getIndividuosSelectos());
			cruza.cruzaIndividuos(ruleta.getIndividuosSelectos());
			//imprimir(cruza.getResultadoCruza());
			muta.mutaIndividuos(cruza.getResultadoCruza());
			//imprimir(muta.getResultadoMutacion());
			poblacion.setIndividuos(co.convertirIndBinToDec(muta.getResultadoMutacion()));
			beneficio.calcularBeneficioInd(poblacion.getIndividuos());
			imprimir(poblacion.getIndividuos());
//			imprimir(beneficio.getBeneficioIndividuos());
		}
	}
	
private static void imprimir(double[] beneficioIndividuos) {
	for(int i=0;i<50;i++) {
		System.out.print("\n"+(i+1)+" - - - " +beneficioIndividuos[i]);
	}
	System.out.print("\n");
		
	}

//	void imprimir(Individuo ind[]){
//		
//	}
	
	static void imprimir(Individuo ind[]){
		int [] num;
		for(int i=0;i<50;i++) {
			num  = ind[i].getGenesCompleto();
			System.out.print("\n"+(i+1)+" - ");
			for(int j=0;j<4;j++) {
				System.out.print(num[j] + " ");
			}
		}
		System.out.print("\n");
	}
	static void imprimir(String ind[]){
		for(int i=0;i<50;i++) {
			System.out.print("\n"+(i+1)+" - - - " +ind[i]);
		}
		System.out.print("\n");
	}
	static void imprimir(Double ind[]){
		for(int i=0;i<50;i++) {
			System.out.print("\n"+(i+1)+" - - - " +ind[i]);
		}
		System.out.print("\n");
	}
	
}


