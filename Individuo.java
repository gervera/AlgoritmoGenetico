package AG;

public class Individuo {
	
	private int genes[];
	
	Individuo(int ti){
		genes = new int [ti];
	}

	public int[] getGenesCompleto() {
		return genes;
	}
	
	public int getGen(int index) {
		return genes[index];
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}
	
	public void setGen( int p,int valor) {
		genes[p] = valor;
	}

	

}
