package AG;

public class tablaBeneficios {
		private double beneficioIndividuos [];
		private double [][] beneficio = new double[11][5];
		private double mejorBeneficio;
		private Individuo mIndividuo;
		private int pMejorBen;

		tablaBeneficios(int t){
			beneficioIndividuos = new double[t];
			llenarB();
		}
		public void calcularBeneficioInd(Individuo [] Ind){
			mejorBeneficio = 0;
			double beneficio;
			boolean pv = false;
			int sumav;
			//int [] valorIndividuos = new int [4];
			Individuo valorIndividuos;
			for(int i=0;i<Ind.length;i++){
				beneficio = 0;
				sumav = 0;
				valorIndividuos = Ind[i];
				//valorIndividuos = Ind[i].getGenesCompleto();
				for(int k =0;k<4;k++){
					sumav = sumav+valorIndividuos.getGen(k);
					if(valorIndividuos.getGen(k)==0|| valorIndividuos.getGen(k)>10|| sumav>10) pv=true;
				}
				
				if(!pv){
						beneficio = getBeneficioEspecifico(valorIndividuos.getGen(0),1)+
									getBeneficioEspecifico(valorIndividuos.getGen(1),2) +
									getBeneficioEspecifico(valorIndividuos.getGen(2),3) +
									getBeneficioEspecifico(valorIndividuos.getGen(3),4);
				}
				if(mejorBeneficio<beneficio){
					pMejorBen = i;
					mejorBeneficio=beneficio;
					mIndividuo = Ind[i];
				}
				
				beneficioIndividuos[i] = beneficio;
				
				pv=false;
			}
		}
		
		public Individuo getmIndividuo() {
			return mIndividuo;
		}
		public void setmIndividuo(Individuo mIndividuo) {
			this.mIndividuo = mIndividuo;
		}
		public int getpMejorBen() {
			return pMejorBen;
		}
		public void setpMejorBen(int pMejorBen) {
			this.pMejorBen = pMejorBen;
		}
		public double getMejorBeneficio() {
			return mejorBeneficio;
		}
		public void setMejorBeneficio(double mejorBeneficio) {
			this.mejorBeneficio = mejorBeneficio;
		}
		public double[] getBeneficioIndividuos() {
			return beneficioIndividuos;
		}
		public void setBeneficioIndividuos(double[] beneficioIndividuos) {
			this.beneficioIndividuos = beneficioIndividuos;
		}
		private   void llenarB() {
			  
			  setBeneficioEspecifico(0,1,0);
			  setBeneficioEspecifico(0,2,0);
			  setBeneficioEspecifico(0,3,0);
			  setBeneficioEspecifico(0,4,0);
			  
			  setBeneficioEspecifico(1,1,0.28);
			  setBeneficioEspecifico(2,1,0.45);
			  setBeneficioEspecifico(3,1,0.65);
			  setBeneficioEspecifico(4,1,0.78);
			  setBeneficioEspecifico(5,1,0.90);
			  setBeneficioEspecifico(6,1,1.02);
			  setBeneficioEspecifico(7,1,1.13);
			  setBeneficioEspecifico(8,1,1.23);
			  setBeneficioEspecifico(9,1,1.32);
			  setBeneficioEspecifico(10,1,1.38);
			  
			  setBeneficioEspecifico(1,2,0.25);
			  setBeneficioEspecifico(2,2,0.41);
			  setBeneficioEspecifico(3,2,0.55);
			  setBeneficioEspecifico(4,2,0.65);
			  setBeneficioEspecifico(5,2,0.75);
			  setBeneficioEspecifico(6,2,0.80);
			  setBeneficioEspecifico(7,2,0.85);
			  setBeneficioEspecifico(8,2,0.88);
			  setBeneficioEspecifico(9,2,0.90);
			  setBeneficioEspecifico(10,2,0.90);
			  
			  setBeneficioEspecifico(1,3,0.15);
			  setBeneficioEspecifico(2,3,0.25);
			  setBeneficioEspecifico(3,3,0.40);
			  setBeneficioEspecifico(4,3,0.50);
			  setBeneficioEspecifico(5,3,0.62);
			  setBeneficioEspecifico(6,3,0.73);
			  setBeneficioEspecifico(7,3,0.82);
			  setBeneficioEspecifico(8,3,0.90);
			  setBeneficioEspecifico(9,3,0.96);
			  setBeneficioEspecifico(10,3,1);
			  
			  setBeneficioEspecifico(1 ,4 ,0.20);
			  setBeneficioEspecifico(2 ,4 ,0.33);
			  setBeneficioEspecifico(3 ,4 ,0.42);
			  setBeneficioEspecifico(4 ,4 ,0.48);
			  setBeneficioEspecifico(5 ,4 ,0.53);
			  setBeneficioEspecifico(6 ,4 ,0.56);
			  setBeneficioEspecifico(7 ,4 ,0.58);
			  setBeneficioEspecifico(8 ,4 ,0.60);
			  setBeneficioEspecifico(9 ,4 ,0.60);
			  setBeneficioEspecifico(10,4 ,0.60);
		}
		
		private double [][] getBeneficio() {
			return beneficio;
		}
		
		public double getBeneficioEspecifico(int a, int b) {
			if(a<0){
				a = 0;
			}
			return beneficio[a][b];
		}	
		
		public void setBeneficioEspecifico(int a, int b,double v){
			this.beneficio[a][b] = v;
		}
}

