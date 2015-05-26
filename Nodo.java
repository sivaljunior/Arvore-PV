class Nodo{

	int info;
	Nodo pai;
	Nodo esq, dir;
	boolean cor; //true = vermelho, false = preto
	
	public Nodo(int k){
		info = k;
		pai = dir = esq = null;
		cor = false;
	}

	public Nodo(int k, Nodo p){
		this(k);
		pai = p;
		cor = true;
	}
	
	public Nodo minimo(){
		if(esq != null) return esq.minimo();
		return this;
	}
	
	public Nodo busca(int k){
		if(K > info && dir != null) return dir.busca(k);
		if(K < info && esq != null) return esq.busca(k);
		return this;
	}
	
}
