import java.util.*;

class Main{
	
	public static void main(String args[]){
		Random info = new Random();
		
		long inicio, aux, media = 0, total;
		
		Arvore tree = new Arvore(0);
		
		inicio = System.nanoTime();
		
		for(int i = 0; i < 200000; i++){
			aux = System.nanoTime();
			tree.add(info.nextInt(100));
			media += (System.nanoTime() - aux);
		}
		
		media /= 200000;
		System.out.printf("Média de tempo de inserção: %.10f ms\n", media / 10e6);
		media = 0;
		
		tree.graph();
		
		/*
		tree.acha_50(valor);
		tree.delete(encontra(valor));
		 */
		
		for(int i = 0; i < 10000; i++){
			aux = System.nanoTime();
			tree.encontra(info.nextInt(100));
			media += (System.nanoTime() - aux);
		}
		
		total = System.nanoTime() - inicio;
		media /= 10000;
		System.out.printf("Média de tempo de busca: %.10f ms\n", media / 10e6);
		System.out.printf("Tempo total: %.10f ms\n", total / 10e6);
	}
}
