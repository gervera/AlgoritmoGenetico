package AG;

public class Converciones {
	
	public Individuo[] convertirIndBinToDec(String [] individuosBin){
		int t = individuosBin.length;
		Individuo [] individuosDec = new Individuo[t];
		for(int i=0;i<t;i++){
			individuosDec[i] = convertirBinDec(individuosBin[i]); 
		}
		return individuosDec;	
	}
	
	public Individuo convertirBinDec(String cromosoma) {
		 int posicion=0;
		 Individuo decimal = new Individuo(4);
	     for(int i = 0;i<4;i++) {
	    	decimal.setGen(i, Integer.parseInt(cromosoma.substring(posicion, posicion+4), 2)); 
	    	posicion = posicion+4;
	     }   
	     return decimal;
	 }
	
	public  String decimalToBin(int[] n) {
		String binario = "";
		for(int i=0;i<n.length;i++) {
			binario = binario + completarBin(Integer.toBinaryString(n[i]));
		}
		//System.out.println(binario);
		return binario;
	}
	
	private  String completarBin(String bin) {
		int tbin = bin.length();
		if(tbin==1) {
			bin = "000"+ bin;
		}else if(tbin==2) {
			bin = "00" + bin; 
		}else if(tbin==3) {
			bin = "0" + bin; 
		}
		return bin;
	}
	
}
