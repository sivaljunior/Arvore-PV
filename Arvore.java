class Arvore{

	Nodo raiz;
	
	public Arvore(int k){
		raiz = new Nodo(k);
	}
	
	public void add(int k){
		Nodo aux = raix.busca(k);
		if(K > aux.info) addFix(aux.dir = new Nodo(k, aux));
		if(K < aux.info) addFix(aux.esq = new Nodo(k, aux));
	}
	
	public void left-rotate(Nodo x){
		Nodo y = x.dir;
		x.dir = y.esq;
		if(y.esq != null) y.esq.pai = x;
		y.pai = x.pai;
		if(x.pai == null) raiz = y;
		else if(x = x.pai.esq) x.pai.esq = y;
		else x.pai.dir = y;
		y.esq = x;
		x.pai = y;	
	}
	
	public void right-rotate(Nodo x){
		Nodo y = x.esq;
		x.esq = y.dir;
		if(y.dir != null) y.dir.pai = x;
		y.pai = x.pai;
		if(x.pai == null) raiz = y;
		else if(x = x.pai.dir) x.pai.dir = y;
		else x.pai.esq = y;
		y.dir = x;
		x.pai = y;	
	}

	
	
	
	
	
}
