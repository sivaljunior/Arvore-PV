import java.util.*;

class Main{
	
	public static void main(String args[]){
		Random info = new Random();
		
		long inicio, aux, media = 0, total;
		
		Arvore tree = new Arvore();
		
		inicio = System.nanoTime();
		
		/*for(int i = 0; i < 100; i++){ //inserção randômica
			aux = System.nanoTime();
			int h = info.nextInt(2147483647);
			tree.add(h);
			media += (System.nanoTime() - aux);
		}*/

		for(int i = 0; i < 100; i++){ //inserção sequencial
			aux = System.nanoTime();
			tree.add(i);
			media += (System.nanoTime() - aux);
		}
		
		System.out.printf("Tempo total de inserção: %.10f ms\n", media / 10e6);
		media /= 100;
		System.out.printf("Média de tempo de inserção: %.10f ms\n", media / 10e6);
		media = 0;
		
		//tree.graph();
		
		/*Arvore aux2 = new Arvore(0);
		aux2 = tree.acha_50(45);*/

		//aux2.graph();	
		
		for(int i = 0; i < 10000; i++){
			aux = System.nanoTime();
			tree.encontra(info.nextInt(100));
			media += (System.nanoTime() - aux);
		}

		System.out.printf("Tempo total de busca: %.10f ms\n", media / 10e6);
		media /= 10000;
		System.out.printf("Média de tempo de busca: %.10f ms\n", media / 10e6);
		media = 0;

		for(int i = 0; i < 100; i++){ //deleção sequencial
			aux = System.nanoTime();
			tree.delete(tree.encontra(i));
			media += (System.nanoTime() - aux);
		}
		
		System.out.printf("Tempo total de deleção: %.10f ms\n", media / 10e6);
		media /= 100;
		System.out.printf("Média de tempo de deleção: %.10f ms\n", media / 10e6);			
		
		total = System.nanoTime() - inicio;
		System.out.printf("Tempo total: %.10f ms\n", total / 10e6);
	}
}
